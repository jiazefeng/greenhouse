package com.hongfeng.greenhouses.domain.greenhouse.model;

import com.hongfeng.greenhouses.hibernate.BaseVo;

import javax.persistence.*;

/**
 * Created by Jiazefeng on 2018/1/13.
 */
@Entity
@Table(name = "GREENHOUSE_DETAIL")
public class GreenhouseDetailEntity extends BaseVo {
    private int id;
    private String dId;
    private String gId;
    private String imgUrl;

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "D_ID", nullable = false, length = 64)
    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    @Basic
    @Column(name = "G_ID", nullable = false, length = 64)
    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    @Basic
    @Column(name = "IMG_URL", nullable = true, length = 200)
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
