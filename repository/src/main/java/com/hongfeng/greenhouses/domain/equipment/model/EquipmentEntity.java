package com.hongfeng.greenhouses.domain.equipment.model;

import com.hongfeng.greenhouses.hibernate.BaseVo;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.Date;

/**
 * 设备信息
 * Created by Jiazefeng on 2017/11/9.
 */
@Entity
@Table(name = "EQUIPMENT")
public class EquipmentEntity extends BaseVo {
    private int id;//自增ID
    private String eId;//设备ID
    private String eName;//设备名称
    private String eNumber;//设备编号
    private String eLocation;//设备产地
    private Date eTimeBuying;//设备购买时间
    private String eDescribe;//设备描述
    private String eState;//设备状态
    private String gId;//大棚ID
    private String eClassify;//设备分类 1:控制设备 2：传感器设备 3：智能设备
    private Date productionDate;//生产日期
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
    @Column(name = "E_ID", nullable = false, length = 64)
    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    @Basic
    @Column(name = "E_NAME", nullable = false, length = 64)
    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Basic
    @Column(name = "E_NUMBER", nullable = true, length = 64)
    public String geteNumber() {
        return eNumber;
    }

    public void seteNumber(String eNumber) {
        this.eNumber = eNumber;
    }

    @Basic
    @Column(name = "E_LOCATION", nullable = true, length = 128)
    public String geteLocation() {
        return eLocation;
    }

    public void seteLocation(String eLocation) {
        this.eLocation = eLocation;
    }

    @Basic
    @Column(name = "E_TIMEBUYING", nullable = true)
    public Date geteTimeBuying() {
        return eTimeBuying;
    }

    public void seteTimeBuying(Date eTimeBuying) {
        this.eTimeBuying = eTimeBuying;
    }

    @Basic
    @Column(name = "E_DESCRIBE", nullable = true, length = 200)
    public String geteDescribe() {
        return eDescribe;
    }

    public void seteDescribe(String eDescribe) {
        this.eDescribe = eDescribe;
    }

    @Basic
    @Column(name = "ESTATE", nullable = true, length = 6)
    public String geteState() {
        return eState;
    }

    public void seteState(String eState) {
        this.eState = eState;
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
    @Column(name = "E_CLASSIFY", nullable = true, length = 32)
    public String geteClassify() {
        return eClassify;
    }

    public void seteClassify(String eClassify) {
        this.eClassify = eClassify;
    }

    @Basic
    @Column(name = "PORDUCTION_DATE", nullable = true)
    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Basic
    @Column(name = "USE_YEARS", nullable = true, length = 32)
    public String getUseYears() {
        return useYears;
    }

    public void setUseYears(String useYears) {
        this.useYears = useYears;
    }

    @Basic
    @Column(name = "MEASUR_RANGE", nullable = true, length = 32)
    public String getMeasurRange() {
        return measurRange;
    }

    public void setMeasurRange(String measurRange) {
        this.measurRange = measurRange;
    }

    @Basic
    @Column(name = "WORKTEMP_RANGE", nullable = true, length = 32)
    public String getWorkTempRange() {
        return workTempRange;
    }

    public void setWorkTempRange(String workTempRange) {
        this.workTempRange = workTempRange;
    }

    @Basic
    @Column(name = "E_ACCURACY", nullable = true, length = 32)
    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    @Basic
    @Column(name = "POWER_VOLTAGE", nullable = true, length = 32)
    public String getPowerVoltage() {
        return powerVoltage;
    }

    public void setPowerVoltage(String powerVoltage) {
        this.powerVoltage = powerVoltage;
    }

    @Basic
    @Column(name = "POWER_WASTE", nullable = true, length = 32)
    public String getPowerWaste() {
        return powerWaste;
    }

    public void setPowerWaste(String powerWaste) {
        this.powerWaste = powerWaste;
    }

    @Basic
    @Column(name = "RESPONSE_TIME", nullable = true, length = 32)
    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    @Basic
    @Column(name = "WTD_STANCE", nullable = true, length = 32)
    public String getWTDstance() {
        return WTDstance;
    }

    public void setWTDstance(String WTDstance) {
        this.WTDstance = WTDstance;
    }

    @Basic
    @Column(name = "COMMUN_BAND", nullable = true, length = 32)
    public String getCommunBand() {
        return communBand;
    }

    public void setCommunBand(String communBand) {
        this.communBand = communBand;
    }

    @Basic
    @Column(name = "BAUD_RATE", nullable = true, length = 32)
    public String getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(String baudRate) {
        this.baudRate = baudRate;
    }
}
