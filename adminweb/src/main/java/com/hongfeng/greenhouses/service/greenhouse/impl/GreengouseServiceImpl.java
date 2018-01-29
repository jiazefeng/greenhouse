package com.hongfeng.greenhouses.service.greenhouse.impl;

import com.hongfeng.common.tool.*;
import com.hongfeng.greenhouses.domain.greenhouse.dto.GreenhouseDTO;
import com.hongfeng.greenhouses.domain.greenhouse.dto.GreenhouseDetailDTO;
import com.hongfeng.greenhouses.domain.greenhouse.dto.GreenhouseDetailsDTO;
import com.hongfeng.greenhouses.domain.greenhouse.model.GreenhouseDetailEntity;
import com.hongfeng.greenhouses.domain.greenhouse.model.GreenhouseEntity;
import com.hongfeng.greenhouses.domain.greenhouse.repository.GreenhouseRepository;
import com.hongfeng.greenhouses.service.greenhouse.inf.GreenhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Jiazefeng on 2018/1/12.
 */
@Service
public class GreengouseServiceImpl implements GreenhouseService {
    @Autowired
    private GreenhouseRepository greenhouseRepository;

    @Override
    public List<GreenhouseDTO> getGreenhouseDtoList(GreenhouseDTO greenhouseDTO, WebPage webPage) {
        Map map = new HashMap();
        List<GreenhouseEntity> greenhouseEntities = greenhouseRepository.getGreenhouseDtoList(map, webPage);
        List<GreenhouseDTO> greenhouseDTOS = new ArrayList<>();
        if (greenhouseEntities != null && greenhouseEntities.size() > 0) {
            for (GreenhouseEntity greenhouseEntity : greenhouseEntities) {
                GreenhouseDTO greenhouseDTO1 = new GreenhouseDTO();
                greenhouseDTO1.setgId(greenhouseEntity.getgId());
                greenhouseDTO1.setgName(greenhouseEntity.getgName());
                greenhouseDTO1.setgNumber(greenhouseEntity.getgNumber());
                greenhouseDTO1.setgDescribe(greenhouseEntity.getgDescribe());
                greenhouseDTO1.setgUrl(greenhouseEntity.getgUrl());
                greenhouseDTO1.setCreatDate(DateUtils.format(greenhouseEntity.getCreateOn()));
                greenhouseDTO1.setModifyDate(DateUtils.format(greenhouseEntity.getModifyOn()));
                greenhouseDTO1.setState(greenhouseEntity.getState());
                greenhouseDTO1.setgCategory(greenhouseEntity.getgCategory());
                greenhouseDTO1.setAreaCovered(greenhouseEntity.getAreaCovered());
                greenhouseDTO1.setPlantCategory(greenhouseEntity.getPlantCategory() == null ? "" : greenhouseEntity.getPlantCategory() + "");

                greenhouseDTOS.add(greenhouseDTO1);
            }
        }
        return greenhouseDTOS;
    }

    @Override
    public boolean saveOrUpdate(GreenhouseDTO greenhouseDTO, MultipartFile gUrlFile, String IMAGE_SERVER_URL) {
        if (greenhouseDTO != null) {
            GreenhouseEntity greenhouseEntity;
            if (StringUtil.isEmpty(greenhouseDTO.getgId())) {
                greenhouseEntity = new GreenhouseEntity();
                greenhouseEntity.setgId(IdGen.uuid());
                greenhouseEntity.setgName(greenhouseDTO.getgName());
                greenhouseEntity.setgNumber(greenhouseDTO.getgNumber());
                greenhouseEntity.setgCategory(greenhouseDTO.getgCategory());
                greenhouseEntity.setPlantCategory(greenhouseDTO.getPlantCategory());
                if (gUrlFile != null && gUrlFile.getSize() > 0) {
                    String imgUrl = UploadFile.imgUpload(gUrlFile, IMAGE_SERVER_URL);
                    if (imgUrl != null) {
                        greenhouseEntity.setgUrl(imgUrl);
                    }
                }
                greenhouseEntity.setAreaCovered(greenhouseDTO.getAreaCovered());
                greenhouseEntity.setgDescribe(greenhouseDTO.getgDescribe());
                greenhouseEntity.setState("1");
                greenhouseEntity.setCreateOn(new Date());
                greenhouseEntity.setModifyOn(new Date());
            } else {
                greenhouseEntity = greenhouseRepository.getGreenhouseById(greenhouseDTO.getgId());
                greenhouseEntity.setgName(greenhouseDTO.getgName());
                greenhouseEntity.setgNumber(greenhouseDTO.getgNumber());
                greenhouseEntity.setgCategory(greenhouseDTO.getgCategory());
                greenhouseEntity.setPlantCategory(greenhouseDTO.getPlantCategory());
                if (gUrlFile != null && gUrlFile.getSize() > 0) {
                    String imgUrl = UploadFile.imgUpload(gUrlFile, IMAGE_SERVER_URL);
                    if (imgUrl != null) {
                        greenhouseEntity.setgUrl(imgUrl);
                    }
                }
                greenhouseEntity.setAreaCovered(greenhouseDTO.getAreaCovered());
                greenhouseEntity.setgDescribe(greenhouseDTO.getgDescribe());
                greenhouseEntity.setModifyOn(new Date());
            }
            boolean f = greenhouseRepository.addOrUpdate(greenhouseEntity);
            if (f) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public GreenhouseDTO getGreenhouseDTOById(String gId) {
        if (!StringUtil.isEmpty(gId)) {
            GreenhouseEntity greenhouseEntity = greenhouseRepository.getGreenhouseById(gId);
            if (greenhouseEntity != null) {
                GreenhouseDTO greenhouseDTO = new GreenhouseDTO();
                greenhouseDTO.setgId(greenhouseEntity.getgId());
                greenhouseDTO.setgName(greenhouseEntity.getgName());
                greenhouseDTO.setgNumber(greenhouseEntity.getgNumber());
                greenhouseDTO.setgDescribe(greenhouseEntity.getgDescribe());
                greenhouseDTO.setgUrl(greenhouseEntity.getgUrl());
                greenhouseDTO.setCreatDate(DateUtils.format(greenhouseEntity.getCreateOn()));
                greenhouseDTO.setModifyDate(DateUtils.format(greenhouseEntity.getModifyOn()));
                greenhouseDTO.setState(greenhouseEntity.getState());
                greenhouseDTO.setgCategory(greenhouseEntity.getgCategory());
                greenhouseDTO.setAreaCovered(greenhouseEntity.getAreaCovered());
                greenhouseDTO.setPlantCategory(greenhouseEntity.getPlantCategory());

                return greenhouseDTO;
            }
        }
        return null;
    }

    @Override
    public boolean deleteGreenhouseById(String gId) {
        GreenhouseEntity greenhouseEntity = greenhouseRepository.getGreenhouseById(gId);
        if (greenhouseEntity != null) {
            greenhouseEntity.setState("3");
            greenhouseRepository.addOrUpdate(greenhouseEntity);
            return true;
        }
        return false;
    }

    @Override
    public GreenhouseDetailsDTO getGreenhouseDetailDTOById(String gId) {
        GreenhouseEntity greenhouseEntity = greenhouseRepository.getGreenhouseById(gId);
        GreenhouseDetailsDTO greenhouseDetailsDTO = new GreenhouseDetailsDTO();
        if (greenhouseEntity != null) {
            greenhouseDetailsDTO.setgName(greenhouseEntity.getgName());
            List<Object[]> list = greenhouseRepository.getGreenhouseDetailDTOById(gId);
            List<GreenhouseDetailDTO> greenhouseDetailDTOList = new ArrayList<>();
            if (list != null && list.size() > 0) {
                for (Object[] obj : list) {
                    GreenhouseDetailDTO greenhouseDetailDTO = new GreenhouseDetailDTO();
                    greenhouseDetailDTO.setCreateDate(obj[1] == null ? "" : DateUtils.format((Date) obj[1], DateUtils.FORMAT_LONG));
                    greenhouseDetailDTO.setImgUrl(obj[2] == null ? "" : (String) obj[2]);
                    greenhouseDetailDTOList.add(greenhouseDetailDTO);
                }
            }
            greenhouseDetailsDTO.setGreenhouseDetailDTOList(greenhouseDetailDTOList);
        }
        return greenhouseDetailsDTO;
    }

    @Override
    public Map<String, String> getAllGreenhouse() {
        List<GreenhouseEntity> greenhouseEntities = greenhouseRepository.getAllGreenhouse();
        Map<String, String> units = new LinkedHashMap<>();
        units.put("", "请选择");
        if (greenhouseEntities != null && greenhouseEntities.size() > 0) {
            for (GreenhouseEntity greenhouseEntity : greenhouseEntities) {
                units.put(greenhouseEntity.getgId(), greenhouseEntity.getgName());
            }
        }
        return units;
    }


    @Override
    public boolean fileUpload(HttpServletRequest request, String greenhouseId, String IMAGE_SERVER_URL) {
        LinkedList<MultipartFile> upfileMap = (LinkedList<MultipartFile>) ((DefaultMultipartHttpServletRequest) request).getMultiFileMap().get("file");
        for (MultipartFile multipartFile : upfileMap) {
//            if (multipartFile != null && multipartFile.getSize() > 0) {
            GreenhouseDetailEntity greenhouseDetailEntity = new GreenhouseDetailEntity();
            greenhouseDetailEntity.setdId(IdGen.uuid());
            greenhouseDetailEntity.setgId(greenhouseId);
            greenhouseDetailEntity.setCreateOn(new Date());
            String imgUrl = UploadFile.imgUpload(multipartFile, IMAGE_SERVER_URL);
            if (imgUrl != null) {
                greenhouseDetailEntity.setImgUrl(imgUrl);
            }
            greenhouseRepository.saveDeatil(greenhouseDetailEntity);
//            }
        }
        return true;
    }
}
