package com.hongfeng.greenhouses.domain.news.repositoryImpl;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.news.model.NewsEntity;
import com.hongfeng.greenhouses.domain.news.repository.NewsRepository;
import com.hongfeng.greenhouses.hibernate.BaseRepositoryImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2018/1/27.
 */
@Repository
public class NewsRepositoryImpl extends BaseRepositoryImpl<NewsEntity> implements NewsRepository {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<NewsEntity> getNewsListByParam(Map map, WebPage webPage) {
        List<Object> param = new ArrayList<>();
        String hql = "from NewsEntity n where 1=1 ";
        if (map.get("newsTitle") != null && !"".equals(map.get("newsTitle").toString())) {
            hql += " and n.newsTitle like '%" + map.get("newsTitle").toString() + "%' ";
        }
        if (webPage != null) {
            return this.findByPage(hql, webPage, param);
        }
        return (List<NewsEntity>) getHibernateTemplate().find(hql, param);
    }

    @Override
    public NewsEntity getNewsEntityById(String newsId) {
        String hql = "from NewsEntity n where 1=1 and newsId='" + newsId + "'";
        Query query = getCurrentSession().createQuery(hql);
        return (NewsEntity) query.uniqueResult();
    }

    @Override
    public void topNews(String newsId, String slideShow) {
        StringBuilder hql = new StringBuilder("UPDATE NewsEntity ne SET ne.slideShow = ? ");
        hql.append(" WHERE ne.newsId = ? ");
        Session session = getCurrentSession();
        Query query = session.createQuery(hql.toString());
        query.setParameter(0, slideShow);
        query.setParameter(1, newsId);
        query.executeUpdate();
        session.flush();
        session.close();
    }

    @Override
    public void delete(NewsEntity newsEntity) {
        Session session = this.getCurrentSession();
        session.delete(newsEntity);
        session.flush();
        session.close();
    }

    @Override
    public List<NewsEntity> getNewsListByParam(String slideShow) {
        String hql = " from NewsEntity where slideShow='" + slideShow + "'";
        Query query = getCurrentSession().createQuery(hql);
        return (List<NewsEntity>) query.list();
    }

    @Override
    public int getNewsCountByParam(String slideShow) {
        String sql = "SELECT count(1) FROM news n WHERE 1 = 1 AND n.SLIDE_SHOW = '" + slideShow + "'";
        Query query = getCurrentSession().createSQLQuery(sql);
        BigInteger count = (BigInteger) query.uniqueResult();
        if (count.intValue() > 0) {
            return count.intValue();
        } else {
            return 0;
        }
    }
}
