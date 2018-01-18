package com.hongfeng.greenhouses.service.equipment.impl;

import com.hongfeng.common.tool.DateUtils;
import com.hongfeng.common.tool.IdGen;
import com.hongfeng.common.tool.StringUtil;
import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.equipment.dto.EquipmentDTO;
import com.hongfeng.greenhouses.domain.equipment.model.EquipmentEntity;
import com.hongfeng.greenhouses.domain.equipment.repository.EquipmentRepository;
import com.hongfeng.greenhouses.domain.greenhouse.model.GreenhouseEntity;
import com.hongfeng.greenhouses.domain.greenhouse.repository.GreenhouseRepository;
import com.hongfeng.greenhouses.service.equipment.inf.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Jiazefeng on 2017/11/9.
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private GreenhouseRepository greenhouseRepository;

    @Override
    public List<EquipmentDTO> getEquipmentListByParams(EquipmentDTO equipmentDTO, WebPage webPage) {
        List<EquipmentDTO> equipmentDTOList = new ArrayList<>();
        if (equipmentDTO != null) {
            Map map = new HashMap();
            map.put("eName", equipmentDTO.geteName());
            map.put("eNumber", equipmentDTO.geteNumber());
            List<EquipmentEntity> equipmentEntityList = equipmentRepository.getEquipmentList(map, webPage);
            List<GreenhouseEntity> greenhouseEntities = greenhouseRepository.getAllGreenhouse();
            if (equipmentEntityList != null && equipmentEntityList.size() > 0) {
                for (EquipmentEntity equipmentEntity : equipmentEntityList) {
                    equipmentDTOList.add(getInfo(equipmentEntity, greenhouseEntities));
                }
            }
        }
        return equipmentDTOList;
    }

    @Override
    public void addOrUpdateEquipmentInfo(EquipmentDTO equipmentDTO) {
        if (equipmentDTO != null) {
            EquipmentEntity equipmentEntity;
            if (StringUtil.isEmpty(equipmentDTO.geteId())) {//新增操作
                equipmentEntity = new EquipmentEntity();
                equipmentEntity.seteId(IdGen.uuid());
                equipmentEntity.setCreateOn(new Date());
                addOrUpdate(equipmentDTO, equipmentEntity);
            } else {
                equipmentEntity = equipmentRepository.getEquipmentByEId(equipmentDTO.geteId());
                if (equipmentEntity != null) {
                    equipmentEntity.setModifyOn(new Date());
                    addOrUpdate(equipmentDTO, equipmentEntity);
                }
            }
            equipmentRepository.addOrUpdate(equipmentEntity);
        }
    }

    @Override
    public EquipmentDTO getEquipmentById(String eId) {
        if (!StringUtil.isEmpty(eId)) {
            EquipmentEntity equipmentEntity = equipmentRepository.getEquipmentByEId(eId);
            List<GreenhouseEntity> greenhouseEntities = greenhouseRepository.getAllGreenhouse();
            if (equipmentEntity != null) {
                return getInfo(equipmentEntity, greenhouseEntities);
            }
        }
        return null;
    }

    @Override
    public void deleteEquipment(String eId) {
        EquipmentEntity equipmentEntity = equipmentRepository.getEquipmentByEId(eId);
        if (equipmentEntity != null) {
            equipmentEntity.seteState("4");//以卖掉或其他
            equipmentRepository.addOrUpdate(equipmentEntity);
        }
    }

    @Override
    public List<EquipmentDTO> getEquipmentById() {
        List<EquipmentEntity> equipmentEntityList = equipmentRepository.getEquipmentList();
        List<EquipmentDTO> equipmentDTOList = new ArrayList<>();
        if (equipmentEntityList != null && equipmentEntityList.size() > 0) {
            for (EquipmentEntity equipmentEntity : equipmentEntityList) {
                EquipmentDTO equipmentDTO = new EquipmentDTO();
                equipmentDTO.seteId(equipmentEntity.geteId());
                equipmentDTO.seteName(equipmentEntity.geteName());
                equipmentDTOList.add(equipmentDTO);
            }
        }
        return equipmentDTOList;
    }

    protected EquipmentDTO getInfo(EquipmentEntity equipmentEntity, List<GreenhouseEntity> greenhouseEntities) {
        EquipmentDTO equipmentDTO = new EquipmentDTO();
        equipmentDTO.seteId(equipmentEntity.geteId());
        equipmentDTO.seteName(equipmentEntity.geteName());
        equipmentDTO.seteNumber(equipmentEntity.geteNumber());
        equipmentDTO.seteLocation(equipmentEntity.geteLocation());
        equipmentDTO.seteTimeBuying(DateUtils.format(equipmentEntity.geteTimeBuying(), "yyyy-MM-dd"));
        equipmentDTO.seteDescribe(equipmentEntity.geteDescribe());
        equipmentDTO.seteState(equipmentEntity.geteState());
        if (greenhouseEntities != null && greenhouseEntities.size() > 0) {
            for (GreenhouseEntity greenhouseEntity : greenhouseEntities) {
                if (greenhouseEntity.getgId().equals(equipmentEntity.getgId())) {
                    equipmentDTO.setgId(greenhouseEntity.getgId());
                    equipmentDTO.setgName(greenhouseEntity.getgName());
                }
            }
        }
        equipmentDTO.seteClassify(equipmentEntity.geteClassify());
        equipmentDTO.setProductionDate(DateUtils.format(equipmentEntity.getProductionDate(), DateUtils.FORMAT_SHORT));
        equipmentDTO.setUseYears(equipmentEntity.getUseYears());
        equipmentDTO.setMeasurRange(equipmentEntity.getMeasurRange());
        equipmentDTO.setWorkTempRange(equipmentEntity.getWorkTempRange());
        equipmentDTO.setAccuracy(equipmentEntity.getAccuracy());
        equipmentDTO.setPowerVoltage(equipmentEntity.getPowerVoltage());
        equipmentDTO.setPowerWaste(equipmentEntity.getPowerWaste());
        equipmentDTO.setResponseTime(equipmentEntity.getResponseTime());
        equipmentDTO.setWTDstance(equipmentEntity.getWTDstance());
        equipmentDTO.setCommunBand(equipmentEntity.getCommunBand());
        equipmentDTO.setBaudRate(equipmentEntity.getBaudRate());
        return equipmentDTO;
    }

    protected EquipmentEntity addOrUpdate(EquipmentDTO equipmentDTO, EquipmentEntity equipmentEntity) {
        equipmentEntity.seteName(equipmentDTO.geteName());
        equipmentEntity.seteNumber(equipmentDTO.geteNumber());
        equipmentEntity.seteLocation(equipmentDTO.geteLocation());
        equipmentEntity.seteTimeBuying(DateUtils.parse(equipmentDTO.geteTimeBuying(), DateUtils.FORMAT_SHORT));
        equipmentEntity.seteDescribe(equipmentDTO.geteDescribe());
        equipmentEntity.seteState(equipmentDTO.geteState());
        equipmentEntity.setgId(equipmentDTO.getgId());
        equipmentEntity.seteClassify(equipmentDTO.geteClassify());
        equipmentEntity.setProductionDate(DateUtils.parse(equipmentDTO.getProductionDate(), DateUtils.FORMAT_SHORT));
        equipmentEntity.setUseYears(equipmentDTO.getUseYears());
        equipmentEntity.setMeasurRange(equipmentDTO.getMeasurRange());
        equipmentEntity.setWorkTempRange(equipmentDTO.getWorkTempRange());
        equipmentEntity.setAccuracy(equipmentDTO.getAccuracy());
        equipmentEntity.setPowerVoltage(equipmentDTO.getPowerVoltage());
        equipmentEntity.setPowerWaste(equipmentDTO.getPowerWaste());
        equipmentEntity.setResponseTime(equipmentDTO.getResponseTime());
        equipmentEntity.setWTDstance(equipmentDTO.getWTDstance());
        equipmentEntity.setCommunBand(equipmentDTO.getCommunBand());
        equipmentEntity.setBaudRate(equipmentDTO.getBaudRate());
        return equipmentEntity;
    }
}
