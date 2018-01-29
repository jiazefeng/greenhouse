package com.hongfeng.greenhouses.domain.production.repository;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.production.model.ProductionEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2018/1/29.
 */
public interface ProductionRepository {
    List<Object[]> getProductionListByParam(Map map, WebPage webPage);

    ProductionEntity getProductionById(String proId);

    void addOrUpdate(ProductionEntity productionEntity);

    void delete(ProductionEntity productionById);
}
