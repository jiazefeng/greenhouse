package com.hongfeng.greenhouses.domain.greenhouse.model;

import com.hongfeng.greenhouses.hibernate.BaseVo;

import javax.persistence.*;

/**
 * 大棚信息
 * Created by Jiazefeng on 2018/1/12.
 */
@Entity
@Table(name = "GREENHOUSE")
public class GreenhouseEntity extends BaseVo {
    private int id;//自增ID
    private String gId;//大棚ID
    private String gName;//大棚名称
    private String gNumber;//大棚编号
    private String gDescribe;//大棚描述
    private String gUrl;//大棚图片
    private String state;//大棚状态
    private String gCategory;//大棚类别 1、普通大棚 2、温室大棚 3、智能大棚
    private String plantCategory;//种植种类
    private String areaCovered;//占地面积
    private String controlEquipment;//控制设备
    private String sensingEquipment;//传感设备
    private String intelligentEquipment;//智能设备

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
    @Column(name = "G_ID", nullable = true, length = 64)
    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    @Basic
    @Column(name = "G_NAME", nullable = true, length = 64)
    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    @Basic
    @Column(name = "G_NUMBER", nullable = true, length = 64)
    public String getgNumber() {
        return gNumber;
    }

    public void setgNumber(String gNumber) {
        this.gNumber = gNumber;
    }

    @Basic
    @Column(name = "G_DESCRIBE", nullable = true, length = 500)
    public String getgDescribe() {
        return gDescribe;
    }

    public void setgDescribe(String gDescribe) {
        this.gDescribe = gDescribe;
    }

    @Basic
    @Column(name = "G_URL", nullable = true, length = 200)
    public String getgUrl() {
        return gUrl;
    }

    public void setgUrl(String gUrl) {
        this.gUrl = gUrl;
    }

    @Basic
    @Column(name = "G_STATE", nullable = true, length = 64)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "G_CATEGORY", nullable = true, length = 64)
    public String getgCategory() {
        return gCategory;
    }

    public void setgCategory(String gCategory) {
        this.gCategory = gCategory;
    }

    @Basic
    @Column(name = "PLANT_CATEGORY", nullable = true, length = 64)
    public String getPlantCategory() {
        return plantCategory;
    }

    public void setPlantCategory(String plantCategory) {
        this.plantCategory = plantCategory;
    }

    @Basic
    @Column(name = "AREA_COVERED", nullable = true, length = 64)
    public String getAreaCovered() {
        return areaCovered;
    }

    public void setAreaCovered(String areaCovered) {
        this.areaCovered = areaCovered;
    }

    @Basic
    @Column(name = "CONTROL_EQUIPMENT", nullable = true, length = 64)
    public String getControlEquipment() {
        return controlEquipment;
    }

    public void setControlEquipment(String controlEquipment) {
        this.controlEquipment = controlEquipment;
    }

    @Basic
    @Column(name = "SENSING_EQUIPMENT", nullable = true, length = 64)
    public String getSensingEquipment() {
        return sensingEquipment;
    }

    public void setSensingEquipment(String sensingEquipment) {
        this.sensingEquipment = sensingEquipment;
    }

    @Basic
    @Column(name = "INTELLIGENT_EQUIPMENT", nullable = true, length = 64)
    public String getIntelligentEquipment() {
        return intelligentEquipment;
    }

    public void setIntelligentEquipment(String intelligentEquipment) {
        this.intelligentEquipment = intelligentEquipment;
    }
}
