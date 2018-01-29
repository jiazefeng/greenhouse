package com.hongfeng.greenhouses.service.production.inf;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.production.dto.ProductionDTO;

import java.util.List;

/**
 * Created by Jiazefeng on 2018/1/29.
 */
public interface ProductionService {
    List<ProductionDTO> getProductionListByParam(ProductionDTO productionDTO, WebPage webPage);

    void addOrUpdate(ProductionDTO productionDTO);

    void delete(String proId);

    ProductionDTO getProductionById(String proId);
}
