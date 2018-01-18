package com.hongfeng.greenhouses.service.environment.impl;

import com.hongfeng.common.tool.DateUtils;
import com.hongfeng.common.tool.IdGen;
import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.environment.dto.EnvironmentDTO;
import com.hongfeng.greenhouses.domain.environment.model.EnvironmentEntity;
import com.hongfeng.greenhouses.domain.environment.repository.EnvironmentRepository;
import com.hongfeng.greenhouses.service.environment.inf.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.validation.Valid;
import java.util.*;

/**
 * Created by Jiazefeng on 2018/1/14.
 */
@Service
public class EnvironmentServiceImpl implements EnvironmentService {
    @Autowired
    private EnvironmentRepository environmentRepository;

    @Override
    public List<EnvironmentDTO> getEnvironmentList(EnvironmentDTO environmentDTO, WebPage webPage) {
        Map map = new HashMap();
        List<Object[]> list = environmentRepository.getEnvironmentList(map, webPage);
        List<EnvironmentDTO> environmentDTOList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (Object[] obj : list) {
                EnvironmentDTO environmentDTO1 = new EnvironmentDTO();
                environmentDTO1.setGreenhouseName(obj[0] == null ? "" : (String) obj[0]);
                environmentDTO1.setGreenhouseNumber(obj[1] == null ? "" : (String) obj[1]);
                environmentDTO1.setEquipmentName(obj[2] == null ? "" : (String) obj[2]);
                environmentDTO1.setEquipmentNumber(obj[3] == null ? "" : (String) obj[3]);
                environmentDTO1.setEnvironmentId(obj[4] == null ? "" : (String) obj[4]);
                environmentDTO1.setEnvironmentName(obj[5] == null ? "" : (String) obj[5]);
//                if (obj[6] != null) {
//                    if (((String) obj[6]).equals("1")) {
//                        environmentDTO1.setTemperature(obj[7] == null ? "" : (String) obj[7] + "℃");
//                    } else if (((String) obj[6]).equals("2")) {
//                        environmentDTO1.setHumidity(obj[7] == null ? "" : (String) obj[7] + "℃");
//                    } else if (((String) obj[6]).equals("3")) {
//                        environmentDTO1.setIllumination(obj[7] == null ? "" : (String) obj[7] + "Lux");
//                    } else {
//                        environmentDTO1.setCO2(obj[7] == null ? "" : (String) obj[7]);
//                    }
//                }
                environmentDTO1.setMaxThreshold(obj[8] == null ? "" : (String) obj[8]);
                environmentDTO1.setMinThreshold(obj[9] == null ? "" : (String) obj[9]);
                environmentDTO1.setCreateDate(obj[10] == null ? "" : (DateUtils.format((Date) obj[10], DateUtils.FORMAT_LONG)));
                environmentDTO1.setTemperature(obj[11] == null ? "" : (String) obj[11] + "℃");
                environmentDTO1.setHumidity(obj[12] == null ? "" : (String) obj[12] + "℃");
                environmentDTO1.setIllumination(obj[13] == null ? "" : (String) obj[13] + "Lux");
                environmentDTO1.setCO2(obj[14] == null ? "" : (String) obj[14]);
                environmentDTOList.add(environmentDTO1);
            }
        }
        return environmentDTOList;
    }

    @Override
    public void save(EnvironmentDTO environmentDTO) {
        if(environmentDTO != null){
            EnvironmentEntity environmentEntity = new EnvironmentEntity();
            environmentEntity.setEnvironmentId(IdGen.uuid());
            environmentEntity.setEnquipmentId(environmentDTO.getEquipmentId());
            environmentEntity.setCO2(environmentDTO.getCO2());
            environmentEntity.setTemperature(environmentDTO.getTemperature());
            environmentEntity.setHumidity(environmentDTO.getHumidity());
            environmentEntity.setIllumination(environmentDTO.getIllumination());
            environmentEntity.setCurrentThreshold(environmentDTO.getCurrentThreshold());
            environmentEntity.setMaxThreshold(environmentDTO.getMaxThreshold());
            environmentEntity.setMinThreshold(environmentDTO.getMinThreshold());
            environmentEntity.setCreateOn(new Date());

            environmentRepository.saveOrUpdate(environmentEntity);
        }
    }
}
