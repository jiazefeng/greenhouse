package com.hongfeng.greenhouses.domain.production.repositoryImpl;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.production.model.ProductionEntity;
import com.hongfeng.greenhouses.domain.production.repository.ProductionRepository;
import com.hongfeng.greenhouses.hibernate.BaseRepositoryImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2018/1/29.
 */
@Repository
public class ProductionRepositoryImpl extends BaseRepositoryImpl<ProductionEntity> implements ProductionRepository {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<Object[]> getProductionListByParam(Map map, WebPage webPage) {
        StringBuffer sql = new StringBuffer(" SELECT ");
        sql.append("p.PRO_ID,p.YIEID,p.CREATE_ON,g.G_ID,g.G_NAME");
        sql.append(" FROM production p LEFT JOIN greenhouse g ON g.G_ID = p.GREENHOUSE_ID ");
        if (map.get("gId") != null && !"".equals(map.get("gId").toString())) {
            sql.append(" where p.GREENHOUSE_ID = '" + map.get("gId").toString() + "'");
        }
        Query query = getCurrentSession().createSQLQuery(sql.toString());
        if (webPage != null) {
            query.setFirstResult(webPage.getStartRow());
            query.setMaxResults(webPage.getPageSize());
        }
        return query.list();
    }

    @Override
    public ProductionEntity getProductionById(String proId) {
        String hql = "from ProductionEntity where 1=1 and proId='" + proId + "'";
        Query query = getCurrentSession().createQuery(hql);
        return (ProductionEntity) query.uniqueResult();
    }

    @Override
    public void addOrUpdate(ProductionEntity productionEntity) {
        Session session = getCurrentSession();
        session.saveOrUpdate(productionEntity);
        session.flush();
        session.close();
    }

    @Override
    public void delete(ProductionEntity productionById) {
        Session session = getCurrentSession();
        session.delete(productionById);
        session.flush();
        session.close();
    }
}
