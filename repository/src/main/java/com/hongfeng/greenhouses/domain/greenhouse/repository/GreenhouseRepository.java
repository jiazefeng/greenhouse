package com.hongfeng.greenhouses.domain.greenhouse.repository;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.greenhouse.model.GreenhouseDetailEntity;
import com.hongfeng.greenhouses.domain.greenhouse.model.GreenhouseEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2018/1/12.
 */
public interface GreenhouseRepository {
    /**
     *
     * @param map
     * @param webPage
     * @return
     */
    List<GreenhouseEntity> getGreenhouseDtoList(Map map, WebPage webPage);

    GreenhouseEntity getGreenhouseById(String s);

    boolean addOrUpdate(GreenhouseEntity greenhouseEntity);

    List<Object[]> getGreenhouseDetailDTOById(String gId);

    List<GreenhouseEntity> getAllGreenhouse();

    void saveDeatil(GreenhouseDetailEntity greenhouseDetailEntity);
}
