package com.hongfeng.greenhouses.domain.authority.model;

import com.hongfeng.greenhouses.hibernate.BaseVo;
import org.omg.CORBA.TRANSACTION_MODE;

import javax.persistence.*;

/**
 * Created by Jiazefeng on 2018/1/15.
 */
@Entity
@Table(name = "ROLE_ROLE")
public class RoleEntity extends BaseVo {
    private int id;
    private String roleId;
    private String roleName;
    private String roleState;
    private String roleDescription;

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
    @Column(name = "ROLE_NAME", nullable = false, length = 64)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "ROLE_STATE", nullable = true, length = 64)
    public String getRoleState() {
        return roleState;
    }

    public void setRoleState(String roleState) {
        this.roleState = roleState;
    }

    @Basic
    @Column(name = "ROLE_DEC", nullable = true, length = 200)
    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
