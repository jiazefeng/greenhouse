package com.hongfeng.greenhouses.service.authority.inf;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.authority.dto.RoleDTO;

import java.util.List;

/**
 * Created by Jiazefeng on 2018/1/15.
 */
public interface AuthorityService {
    List<RoleDTO> getRoleList(WebPage webPage, RoleDTO roleDTO);

    RoleDTO getRoleInfoById(String roleId);

    void save(RoleDTO roleDTO);

    void saveAuthority(RoleDTO roleDTO);

    List<RoleDTO> getRoleInfoList();

    List<RoleDTO> getRoleInfoByUserId(String userId);
}
