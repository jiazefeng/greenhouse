package com.hongfeng.greenhouses.domain.authority.model;

import com.hongfeng.greenhouses.hibernate.BaseVo;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

/**
 * Created by Jiazefeng on 2018/1/15.
 */
@Entity
@Table(name = "USER_AUTHORITY")
public class UserAuthorityEntity extends BaseVo {
    private int id;
    private String roleId;
    private String userId;

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
    @Column(name = "ROLE_ID", nullable = false, length = 64)
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "USER_ID", nullable = false, length = 64)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
