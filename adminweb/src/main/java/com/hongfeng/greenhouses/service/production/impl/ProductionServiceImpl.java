package com.hongfeng.greenhouses.service.production.impl;

import com.hongfeng.common.tool.DateUtils;
import com.hongfeng.common.tool.IdGen;
import com.hongfeng.common.tool.StringUtil;
import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.production.dto.ProductionDTO;
import com.hongfeng.greenhouses.domain.production.model.ProductionEntity;
import com.hongfeng.greenhouses.domain.production.repository.ProductionRepository;
import com.hongfeng.greenhouses.service.production.inf.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Jiazefeng on 2018/1/29.
 */
@Service
public class ProductionServiceImpl implements ProductionService {
    @Autowired
    private ProductionRepository productionRepository;

    @Override
    public List<ProductionDTO> getProductionListByParam(ProductionDTO productionDTO, WebPage webPage) {
        Map map = new HashMap();
        map.put("gId", productionDTO.getGreenhouseId());
        List<Object[]> productionEntities = productionRepository.getProductionListByParam(map, webPage);
        List<ProductionDTO> productionDTOS = new ArrayList<>();
        if (productionEntities != null && productionEntities.size() > 0) {
            productionEntities.forEach(objects -> {
                ProductionDTO productionDTO1 = new ProductionDTO();
                productionDTO1.setProId(objects[0] == null ? "" : (String) objects[0]);
                productionDTO1.setYield(objects[1] == null ? "" : (String) objects[1]);
                productionDTO1.setCreateDate(objects[2] == null ? "" : DateUtils.format((Date) objects[2], DateUtils.FORMAT_LONG));
                productionDTO1.setGreenhouseId(objects[3] == null ? "" : (String) objects[3]);
                productionDTO1.setGreenhouseName(objects[4] == null ? "" : (String) objects[4]);

                productionDTOS.add(productionDTO1);
            });
        }
        return productionDTOS;
    }

    @Override
    public void addOrUpdate(ProductionDTO productionDTO) {
        if (productionDTO != null) {
            ProductionEntity productionEntity = null;
            if (StringUtil.isEmpty(productionDTO.getProId())) {
                productionEntity = new ProductionEntity();
                productionEntity.setProId(IdGen.uuid());
                productionEntity.setYield(productionDTO.getYield());
                productionEntity.setGreenhouseId(productionDTO.getGreenhouseId());
                productionEntity.setCreateOn(new Date());
            } else {
                productionEntity = productionRepository.getProductionById(productionDTO.getProId());
                if (productionEntity != null) {
                    productionEntity.setGreenhouseId(productionDTO.getGreenhouseId());
                    productionEntity.setYield(productionDTO.getYield());
                }
            }
            productionRepository.addOrUpdate(productionEntity);
        }
    }

    @Override
    public void delete(String proId) {
        ProductionEntity productionById = productionRepository.getProductionById(proId);
        if (productionById != null) {
            productionRepository.delete(productionById);
        }
    }

    @Override
    public ProductionDTO getProductionById(String proId) {
        ProductionEntity productionEntity = productionRepository.getProductionById(proId);
        if (productionEntity != null) {
            ProductionDTO productionDTO = new ProductionDTO();
            productionDTO.setProId(productionEntity.getProId());
            productionDTO.setYield(productionEntity.getYield());
            productionDTO.setGreenhouseId(productionEntity.getGreenhouseId());
            productionDTO.setCreateDate(DateUtils.format(productionEntity.getCreateOn(), DateUtils.FORMAT_LONG));
            return productionDTO;
        }
        return null;
    }
}
