package com.hongfeng.greenhouses.domain.authority.repositoryImpl;

import com.hongfeng.common.tool.DateUtils;
import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.authority.model.AuthorityEntity;
import com.hongfeng.greenhouses.domain.authority.model.RoleEntity;
import com.hongfeng.greenhouses.domain.authority.model.UserAuthorityEntity;
import com.hongfeng.greenhouses.domain.authority.repository.AuthorityRepository;
import com.hongfeng.greenhouses.hibernate.BaseRepositoryImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2018/1/15.
 */
@Repository
public class AuthorityRepositoryImpl extends BaseRepositoryImpl<RoleEntity> implements AuthorityRepository {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<RoleEntity> getRoleList(WebPage webPage, Map map) {
        List<Object> params = new ArrayList<Object>();
        String hql = " from RoleEntity r where 1=1 ";
        if (map.get("roleName") != null && !"".equals(map.get("roleName").toString())) {
            hql += " and r.roleName like '%" + map.get("roleName").toString() + "%' ";
        }
//        hql += " order by r.modifyOn desc";
        if (webPage != null) {
            return this.findByPage(hql, webPage, params);
        }
        List<RoleEntity> roleEntityList = (List<RoleEntity>) getHibernateTemplate().find(hql, params);
        return roleEntityList;
    }

    @Override
    public RoleEntity getRoleEntity(String roleId) {
        String hql = "from RoleEntity r where 1=1 and roleId ='" + roleId + "'";
        Query query = getCurrentSession().createQuery(hql);
        return (RoleEntity) query.uniqueResult();
    }

    @Override
    public void deleteAuthority(RoleEntity roleEntity) {
        String hql = "delete from AuthorityEntity where roleId =:roleId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("roleId", roleEntity.getRoleId());
        query.executeUpdate();
    }

    @Override
    public void saveAuthorityEntity(AuthorityEntity authorityEntity) {
        String sql1 = "INSERT INTO authority(A_ID,ROLE_ID,MENU_ID,CREATE_ON) VALUES(?,?,?,?)";
        Query query1 = getCurrentSession().createSQLQuery(sql1);
        query1.setString(0, authorityEntity.getaId());
        query1.setString(1, authorityEntity.getRoleId());
        query1.setString(2, authorityEntity.getMenuId());
        query1.setString(3, DateUtils.format(authorityEntity.getCreateOn()));
        query1.executeUpdate();
    }

    @Override
    public List<RoleEntity> getRoleInfoList() {
        String hql = "FROM RoleEntity WHERE 1=1";
        Query query = getCurrentSession().createQuery(hql);
        return (List<RoleEntity>) query.list();
    }

    @Override
    public void addUserAurhority(UserAuthorityEntity userAuthorityEntity) {
        String sql1 = "INSERT INTO USER_AUTHORITY(ROLE_ID,USER_ID,CREATE_ON) VALUES(?,?,?)";
        Query query1 = getCurrentSession().createSQLQuery(sql1);
        query1.setString(0, userAuthorityEntity.getRoleId());
        query1.setString(1, userAuthorityEntity.getUserId());
        query1.setString(2, DateUtils.format(userAuthorityEntity.getCreateOn()));
        query1.executeUpdate();
    }

    @Override
    public List<Object[]> getRoleInfoByUserId(String userId) {
        String sql = "SELECT rr.ROLE_ID,rr.ROLE_NAME FROM user_authority ua LEFT JOIN role_role rr ON rr.ROLE_ID=ua.ROLE_ID WHERE ua.USER_ID='" + userId + "'";
        Query query = getCurrentSession().createSQLQuery(sql);
        return (List<Object[]>) query.list();
    }
}
