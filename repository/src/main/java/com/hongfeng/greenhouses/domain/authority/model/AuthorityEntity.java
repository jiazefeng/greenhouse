package com.hongfeng.greenhouses.domain.authority.model;

import com.hongfeng.greenhouses.hibernate.BaseVo;

import javax.persistence.*;

/**
 * Created by Jiazefeng on 2018/1/15.
 */
@Entity
@Table(name = "AUTHORITY")
public class AuthorityEntity extends BaseVo {
    private int id;
    private String aId;
    private String roleId;
    private String menuId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "A_ID", nullable = false, length = 64)
    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    @Basic
    @Column(name = "ROLE_ID", nullable = false, length = 64)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "MENU_ID", nullable = false, length = 64)
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
