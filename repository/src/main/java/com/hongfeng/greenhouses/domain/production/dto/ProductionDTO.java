package com.hongfeng.greenhouses.domain.production.dto;

/**
 * Created by Jiazefeng on 2018/1/29.
 */
public class ProductionDTO {
    private String proId;
    private String yield;//产量
    private String greenhouseId;//大棚ID
    private String greenhouseName;//大棚ID
    private String createDate;

    public String getGreenhouseName() {
        return greenhouseName;
    }

    public void setGreenhouseName(String greenhouseName) {
        this.greenhouseName = greenhouseName;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getYield() {
        return yield;
    }

    public void setYield(String yield) {
        this.yield = yield;
    }

    public String getGreenhouseId() {
        return greenhouseId;
    }

    public void setGreenhouseId(String greenhouseId) {
        this.greenhouseId = greenhouseId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
