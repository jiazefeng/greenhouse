package com.hongfeng.greenhouses.domain.greenhouse.repositoryImpl;

import com.hongfeng.common.tool.IdGen;
import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.greenhouse.model.GreenhouseEntity;
import com.hongfeng.greenhouses.domain.greenhouse.repository.GreenhouseRepository;
import com.hongfeng.greenhouses.hibernate.BaseRepositoryImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2018/1/12.
 */
@Repository
public class GreenhouseRepositoryImpl extends BaseRepositoryImpl<GreenhouseEntity> implements GreenhouseRepository {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<GreenhouseEntity> getGreenhouseDtoList(Map map, WebPage webPage) {
        List<Object> params = new ArrayList<Object>();
        String hql = " from GreenhouseEntity g where 1=1 ";
        hql += " order by g.modifyOn desc";
//        if (map.get("gName") != null && !"".equals(map.get("gName").toString())) {
//            hql += " and g.eName like '%" + map.get("gName").toString() + "% '";
//        }
//        if (map.get("eNumber") != null && !"".equals(map.get("eNumber").toString())) {
//            hql += " and ee.eNumber like '%" + map.get("eNumber").toString() + "%' ";
//        }
        if (webPage != null) {
            return this.findByPage(hql, webPage, params);
        }
        List<GreenhouseEntity> greenhouseEntities = (List<GreenhouseEntity>) getHibernateTemplate().find(hql, params);
        return greenhouseEntities;
    }

    @Override
    public GreenhouseEntity getGreenhouseById(String s) {
        String hql = " FROM GreenhouseEntity WHERE gId = '" + s + "'";
        Query query = getCurrentSession().createQuery(hql);
        return (GreenhouseEntity) query.uniqueResult();
    }

    @Override
    public boolean addOrUpdate(GreenhouseEntity greenhouseEntity) {
        this.saveOrUpdate(greenhouseEntity);
        return true;
    }

    @Override
    public List<Object[]> getGreenhouseDetailDTOById(String gId) {
        String sql = "SELECT g.G_NAME,d.CREATE_ON,d.IMG_URL FROM greenhouse g LEFT JOIN greenhouse_detail d ON d.G_ID = g.G_ID WHERE g.G_ID='" + gId + "' ORDER BY d.CREATE_ON";
        Query query = getCurrentSession().createSQLQuery(sql);
        List<Object[]> list = query.list();
        return list;
    }

    @Override
    public List<GreenhouseEntity> getAllGreenhouse() {
        String hql = "FROM GreenhouseEntity WHERE 1=1";
        Query query = getCurrentSession().createQuery(hql);
        List<GreenhouseEntity> greenhouseEntities = query.list();
        return greenhouseEntities;
    }

}
