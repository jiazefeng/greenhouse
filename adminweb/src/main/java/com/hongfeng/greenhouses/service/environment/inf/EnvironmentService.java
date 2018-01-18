package com.hongfeng.greenhouses.service.environment.inf;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.environment.dto.EnvironmentDTO;

import java.util.List;

/**
 * Created by Jiazefeng on 2018/1/14.
 */
public interface EnvironmentService {
    List<EnvironmentDTO> getEnvironmentList(EnvironmentDTO environmentDTO, WebPage webPage);

    void save(EnvironmentDTO environmentDTO);
}
