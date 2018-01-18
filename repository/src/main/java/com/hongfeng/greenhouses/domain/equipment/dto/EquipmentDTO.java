package com.hongfeng.greenhouses.domain.equipment.dto;

/**
 * Created by Jiazefeng on 2017/11/9.
 */
public class EquipmentDTO {
    private String eId;//设备ID
    private String eName;//设备名称
    private String eNumber;//设备编号
    private String eLocation;//设备产地
    private String eTimeBuying;//设备购买时间
    private String eDescribe;//设备描述
    private String eState;//设备状态
    private String gId;//大棚ID
    private String gName;//大棚名称
    private String eClassify;//设备分类 1:控制设备 2：传感器设备 3：智能设备
    private String productionDate;//生产日期
    private String useYears;//使用年限
    private String measurRange;//测量范围
    private String workTempRange;//工作温度范围
    private String accuracy;//准 确 度
    private String powerVoltage;//供电电压
    private String powerWaste;//功耗
    private String responseTime;//响应时间
    private String WTDstance;//无线传输距离
    private String communBand;//通讯频段
    private String baudRate;//接口波特率

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteNumber() {
        return eNumber;
    }

    public void seteNumber(String eNumber) {
        this.eNumber = eNumber;
    }

    public String geteLocation() {
        return eLocation;
    }

    public void seteLocation(String eLocation) {
        this.eLocation = eLocation;
    }

    public String geteTimeBuying() {
        return eTimeBuying;
    }

    public void seteTimeBuying(String eTimeBuying) {
        this.eTimeBuying = eTimeBuying;
    }

    public String geteDescribe() {
        return eDescribe;
    }

    public void seteDescribe(String eDescribe) {
        this.eDescribe = eDescribe;
    }

    public String geteState() {
        return eState;
    }

    public void seteState(String eState) {
        this.eState = eState;
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String geteClassify() {
        return eClassify;
    }

    public void seteClassify(String eClassify) {
        this.eClassify = eClassify;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getUseYears() {
        return useYears;
    }

    public void setUseYears(String useYears) {
        this.useYears = useYears;
    }

    public String getMeasurRange() {
        return measurRange;
    }

    public void setMeasurRange(String measurRange) {
        this.measurRange = measurRange;
    }

    public String getWorkTempRange() {
        return workTempRange;
    }

    public void setWorkTempRange(String workTempRange) {
        this.workTempRange = workTempRange;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getPowerVoltage() {
        return powerVoltage;
    }

    public void setPowerVoltage(String powerVoltage) {
        this.powerVoltage = powerVoltage;
    }

    public String getPowerWaste() {
        return powerWaste;
    }

    public void setPowerWaste(String powerWaste) {
        this.powerWaste = powerWaste;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getWTDstance() {
        return WTDstance;
    }

    public void setWTDstance(String WTDstance) {
        this.WTDstance = WTDstance;
    }

    public String getCommunBand() {
        return communBand;
    }

    public void setCommunBand(String communBand) {
        this.communBand = communBand;
    }

    public String getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(String baudRate) {
        this.baudRate = baudRate;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }
}
