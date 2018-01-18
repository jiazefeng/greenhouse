package com.hongfeng.greenhouses.domain.environment.repository;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.environment.model.EnvironmentEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2018/1/14.
 */
public interface EnvironmentRepository {
    List<Object[]> getEnvironmentList(Map map, WebPage webPage);

    void saveOrUpdate(EnvironmentEntity environmentEntity);
}
