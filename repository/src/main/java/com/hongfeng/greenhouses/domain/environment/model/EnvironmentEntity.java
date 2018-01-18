package com.hongfeng.greenhouses.domain.environment.model;

import com.hongfeng.greenhouses.hibernate.BaseVo;
import org.springframework.stereotype.Controller;

import javax.persistence.*;

/**
 * 环境因子管理
 * Created by Jiazefeng on 2018/1/14.
 */
@Table(name = "ENVIRONMENT")
@Entity
public class EnvironmentEntity extends BaseVo {
    private int id;//z自增ID
    private String environmentId;//环境因子ID
    private String environmentName;//环境因子名称
    private String environmentClassify;//环境因子类别 1：温度 2：湿度 3：光照 4：二氧化碳CO2
    private String maxThreshold;//最大阈值
    private String minThreshold;//最小阈值
    private String currentThreshold;//当前阀值
    private String greenhouseId;//大棚Id
    private String enquipmentId;//设备ID
    private String temperature;//温度
    private String humidity;//湿度
    private String illumination;//光照
    private String CO2;

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
    @Column(name = "ENVIRONMENT_ID", nullable = false, length = 64)
    public String getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(String environmentId) {
        this.environmentId = environmentId;
    }

    @Basic
    @Column(name = "ENVIRONMENT_NAME", nullable = true, length = 64)
    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    @Basic
    @Column(name = "MAX_THRESHOLD", nullable = true, length = 64)
    public String getMaxThreshold() {
        return maxThreshold;
    }

    public void setMaxThreshold(String maxThreshold) {
        this.maxThreshold = maxThreshold;
    }

    @Basic
    @Column(name = "MIN_THRESHOLD", nullable = true, length = 64)
    public String getMinThreshold() {
        return minThreshold;
    }

    public void setMinThreshold(String minThreshold) {
        this.minThreshold = minThreshold;
    }

    @Basic
    @Column(name = "CURRENT_THRESHOLD", nullable = true, length = 64)
    public String getCurrentThreshold() {
        return currentThreshold;
    }

    public void setCurrentThreshold(String currentThreshold) {
        this.currentThreshold = currentThreshold;
    }

    @Basic
    @Column(name = "GREENHOUSE_ID", nullable = true, length = 64)
    public String getGreenhouseId() {
        return greenhouseId;
    }

    public void setGreenhouseId(String greenhouseId) {
        this.greenhouseId = greenhouseId;
    }

    @Basic
    @Column(name = "EQUIPMENT_ID", nullable = false, length = 64)
    public String getEnquipmentId() {
        return enquipmentId;
    }

    public void setEnquipmentId(String enquipmentId) {
        this.enquipmentId = enquipmentId;
    }

    @Basic
    @Column(name = "EQUIPMENT_CLASSIFY", nullable = true, length = 64)
    public String getEnvironmentClassify() {
        return environmentClassify;
    }

    public void setEnvironmentClassify(String environmentClassify) {
        this.environmentClassify = environmentClassify;
    }

    @Basic
    @Column(name = "TEMPERATURE", nullable = true, length = 64)
    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Basic
    @Column(name = "HUMIDITY", nullable = true, length = 64)
    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @Basic
    @Column(name = "ILLUMINATION", nullable = true, length = 64)
    public String getIllumination() {
        return illumination;
    }

    public void setIllumination(String illumination) {
        this.illumination = illumination;
    }

    @Basic
    @Column(name = "CO2", nullable = true, length = 64)
    public String getCO2() {
        return CO2;
    }

    public void setCO2(String CO2) {
        this.CO2 = CO2;
    }
}
