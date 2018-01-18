package com.hongfeng.greenhouses.domain.environment.repositoryImpl;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.environment.model.EnvironmentEntity;
import com.hongfeng.greenhouses.domain.environment.repository.EnvironmentRepository;
import com.hongfeng.greenhouses.hibernate.BaseRepositoryImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2018/1/14.
 */
@Repository
public class EnvironmentRepositoryImpl extends BaseRepositoryImpl<EnvironmentEntity> implements EnvironmentRepository {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<Object[]> getEnvironmentList(Map map, WebPage webPage) {
        StringBuffer sql = new StringBuffer("SELECT");
        sql.append(" g.G_NAME,g.G_NUMBER,em.E_NAME,em.E_NUMBER,en.ENVIRONMENT_ID,en.ENVIRONMENT_NAME,en.EQUIPMENT_CLASSIFY,en.CURRENT_THRESHOLD,en.MAX_THRESHOLD,en.MIN_THRESHOLD,en.CREATE_ON,en.TEMPERATURE,en.HUMIDITY,en.ILLUMINATION,en.CO2 ");
        sql.append(" FROM environment en");
        sql.append(" LEFT JOIN equipment em ON em.E_ID = en.EQUIPMENT_ID");
        sql.append(" LEFT JOIN greenhouse g ON g.G_ID = em.G_ID");
        Query query = getCurrentSession().createSQLQuery(sql.toString());
        if (webPage != null) {
            query.setFirstResult(webPage.getStartRow());
            query.setMaxResults(webPage.getPageSize());
        }
        return query.list();
    }
}
