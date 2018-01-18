package com.hongfeng.greenhouses.domain.menu.repositoryImpl;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.menu.model.MenuModel;
import com.hongfeng.greenhouses.domain.menu.repository.MenuRepository;
import com.hongfeng.greenhouses.hibernate.BaseRepository;
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
 * Created by Jiazefeng on 2017/10/18.
 */
@Repository
public class MenuRepositoryImpl extends BaseRepositoryImpl<MenuModel> implements MenuRepository {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public boolean addMenuModel(MenuModel newMenu) {
        if (newMenu != null) {
            this.save(newMenu);
            return true;
        }
        return false;
    }

    @Override
    public List<MenuModel> getMenuEntityList(Map map, WebPage webPage) {
        List<Object> params = new ArrayList<Object>();
        String hql = " from MenuModel mm where 1=1 ";
//        if (map.get("projectId") != null && !"".equals(map.get("projectId").toString())) {
//            hql += " and kp.projectId = '" + map.get("projectId").toString() + "' ";
//        } else {
//            hql += " and (kp.projectId in(" + projectId1s + ") or kp.projectId in(" + projectId2s + ")) ";
//        }
        if (map.get("parId") != null && !"".equals(map.get("parId").toString())) {
            hql += " and mm.parentMenuId = '" + map.get("parId").toString() + "' ";
        }
        if(map.get("menuLevel") != null && !"".equals(map.get("menuLevel").toString())){
            hql += " and mm.menuLevel = '" + map.get("menuLevel").toString() + "' ";
        }

//        if (map.get("startDate") != null && !"".equals(map.get("startDate").toString())) {
//            String startDate = map.get("startDate").toString() + " 00:00:00";
//            hql += " and kp.createOn >= '" + startDate + "' ";
//        }
//        if (map.get("endDate") != null && !"".equals(map.get("endDate").toString())) {
//            String endDate = map.get("endDate").toString() + " 23:59:59";
//            hql += " and kp.createOn <= '" + endDate + "' ";
//        }
        hql += " and mm.menuState = 1 ";
        hql += " order by mm.menuOrder asc ";

        if (webPage != null) {
            return this.findByPage(hql, webPage, params);
        }
        List<MenuModel> menuModelList = (List<MenuModel>) getHibernateTemplate().find(hql, params.toArray());
        return menuModelList;
    }

    @Override
    public List<MenuModel> getMenus() {
        String hql = "from MenuModel mm where 1=1";
        Query query = getCurrentSession().createQuery(hql);
        return (List<MenuModel>) query.list();
    }

    @Override
    public List<Object[]> getMenus(String roleId) {
        String sql = "SELECT m.MENU_ID,m.MENU_NAME FROM menu_info m LEFT JOIN authority a ON a.MENU_ID=m.MENU_ID WHERE a.ROLE_ID='" + roleId + "'";
        Query query = getCurrentSession().createSQLQuery(sql);
        return query.list();
    }
}
