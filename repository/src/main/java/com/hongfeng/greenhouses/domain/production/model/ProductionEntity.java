package com.hongfeng.greenhouses.domain.production.model;

import com.hongfeng.greenhouses.hibernate.BaseVo;

import javax.persistence.*;

/**
 * Created by Jiazefeng on 2018/1/29.
 */
@Entity
@Table(name = "PRODUCTION")
public class ProductionEntity extends BaseVo {
    private String proId;
    private String yield;//产量
    private String greenhouseId;//大棚ID

    @Id
    @Column(name = "PRO_ID", unique = true, nullable = false, length = 64)
    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    @Basic
    @Column(name = "YIEID", length = 128)
    public String getYield() {
        return yield;
    }

    public void setYield(String yield) {
        this.yield = yield;
    }

    @Basic
    @Column(name = "GREENHOUSE_ID", length = 64)
    public String getGreenhouseId() {
        return greenhouseId;
    }

    public void setGreenhouseId(String greenhouseId) {
        this.greenhouseId = greenhouseId;
    }
}
