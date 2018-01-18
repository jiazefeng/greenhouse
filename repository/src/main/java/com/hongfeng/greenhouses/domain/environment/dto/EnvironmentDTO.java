package com.hongfeng.greenhouses.domain.environment.dto;

/**
 * Created by Jiazefeng on 2018/1/14.
 */
public class EnvironmentDTO {
    private int id;//z自增ID
    private String environmentId;//环境因子ID
    private String environmentName;//环境因子名称
    private String maxThreshold;//最大阈值
    private String minThreshold;//最小阈值
    private String currentThreshold;//当前阀值
    private String greenhouseId;//大棚Id
    private String greenhouseName;//大棚名称
    private String equipmentName;//设备名称
    private String greenhouseNumber;//大棚编号
    private String equipmentNumber;//设备编号
    private String temperature;//温度
    private String humidity;//湿度
    private String illumination;//光照
    private String CO2;
    private String createDate;
    private String equipmentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(String environmentId) {
        this.environmentId = environmentId;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public String getMaxThreshold() {
        return maxThreshold;
    }

    public void setMaxThreshold(String maxThreshold) {
        this.maxThreshold = maxThreshold;
    }

    public String getMinThreshold() {
        return minThreshold;
    }

    public void setMinThreshold(String minThreshold) {
        this.minThreshold = minThreshold;
    }

    public String getCurrentThreshold() {
        return currentThreshold;
    }

    public void setCurrentThreshold(String currentThreshold) {
        this.currentThreshold = currentThreshold;
    }

    public String getGreenhouseId() {
        return greenhouseId;
    }

    public void setGreenhouseId(String greenhouseId) {
        this.greenhouseId = greenhouseId;
    }

    public String getGreenhouseName() {
        return greenhouseName;
    }

    public void setGreenhouseName(String greenhouseName) {
        this.greenhouseName = greenhouseName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getGreenhouseNumber() {
        return greenhouseNumber;
    }

    public void setGreenhouseNumber(String greenhouseNumber) {
        this.greenhouseNumber = greenhouseNumber;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getIllumination() {
        return illumination;
    }

    public void setIllumination(String illumination) {
        this.illumination = illumination;
    }

    public String getCO2() {
        return CO2;
    }

    public void setCO2(String CO2) {
        this.CO2 = CO2;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }
}
