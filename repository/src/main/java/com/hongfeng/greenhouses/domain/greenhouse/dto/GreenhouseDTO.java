package com.hongfeng.greenhouses.domain.greenhouse.dto;

/**
 * Created by Jiazefeng on 2018/1/12.
 */
public class GreenhouseDTO {
    private int id;//自增ID
    private String gId;//大棚ID
    private String gName;//大棚名称
    private String gNumber;//大棚编号
    private String gDescribe;//大棚描述
    private String gUrl;//大棚图片
    private String state;//大棚状态
    private String creatDate;//创建时间
    private String modifyDate;//修改时间
    private String gCategory;//大棚类别 1、普通大棚 2、温室大棚 3、智能大棚
    private String plantCategory;//种植种类
    private String areaCovered;//占地面积
    private String controlEquipment;//控制设备
    private String sensingEquipment;//传感设备
    private String intelligentEquipment;//智能设备

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgNumber() {
        return gNumber;
    }

    public void setgNumber(String gNumber) {
        this.gNumber = gNumber;
    }

    public String getgDescribe() {
        return gDescribe;
    }

    public void setgDescribe(String gDescribe) {
        this.gDescribe = gDescribe;
    }

    public String getgUrl() {
        return gUrl;
    }

    public void setgUrl(String gUrl) {
        this.gUrl = gUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(String creatDate) {
        this.creatDate = creatDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getgCategory() {
        return gCategory;
    }

    public void setgCategory(String gCategory) {
        this.gCategory = gCategory;
    }

    public String getPlantCategory() {
        return plantCategory;
    }

    public void setPlantCategory(String plantCategory) {
        this.plantCategory = plantCategory;
    }

    public String getAreaCovered() {
        return areaCovered;
    }

    public void setAreaCovered(String areaCovered) {
        this.areaCovered = areaCovered;
    }

    public String getControlEquipment() {
        return controlEquipment;
    }

    public void setControlEquipment(String controlEquipment) {
        this.controlEquipment = controlEquipment;
    }

    public String getSensingEquipment() {
        return sensingEquipment;
    }

    public void setSensingEquipment(String sensingEquipment) {
        this.sensingEquipment = sensingEquipment;
    }

    public String getIntelligentEquipment() {
        return intelligentEquipment;
    }

    public void setIntelligentEquipment(String intelligentEquipment) {
        this.intelligentEquipment = intelligentEquipment;
    }
}
