package com.hongfeng.greenhouses.service.authority.impl;

import com.hongfeng.common.tool.DateUtils;
import com.hongfeng.common.tool.IdGen;
import com.hongfeng.common.tool.StringUtil;
import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.authority.dto.RoleDTO;
import com.hongfeng.greenhouses.domain.authority.model.AuthorityEntity;
import com.hongfeng.greenhouses.domain.authority.model.RoleEntity;
import com.hongfeng.greenhouses.domain.authority.repository.AuthorityRepository;
import com.hongfeng.greenhouses.service.authority.inf.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Jiazefeng on 2018/1/15.
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public List<RoleDTO> getRoleList(WebPage webPage, RoleDTO roleDTO1) {
        Map map = new HashMap();
        map.put("roleName", roleDTO1.getRoleName());
        List<RoleEntity> roleEntityList = authorityRepository.getRoleList(webPage, map);
        List<RoleDTO> roleDTOList = new ArrayList<>();
        if (roleEntityList != null && roleEntityList.size() > 0) {
            for (RoleEntity roleEntity : roleEntityList) {
                RoleDTO roleDTO = new RoleDTO();
                roleDTO.setRoleId(roleEntity.getRoleId());
                roleDTO.setRoleName(roleEntity.getRoleName());
                roleDTO.setCreateDate(DateUtils.format(roleEntity.getCreateOn(), DateUtils.FORMAT_LONG));
                roleDTOList.add(roleDTO);
            }
        }
        return roleDTOList;
    }

    @Override
    public RoleDTO getRoleInfoById(String roleId) {
        RoleEntity roleEntity = authorityRepository.getRoleEntity(roleId);
        if (roleEntity != null) {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setRoleId(roleEntity.getRoleId());
            roleDTO.setRoleName(roleEntity.getRoleName());
            return roleDTO;
        }
        return null;
    }

    @Override
    public void save(RoleDTO roleDTO) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(IdGen.uuid());
        roleEntity.setRoleName(roleDTO.getRoleName());
        roleEntity.setRoleState("1");
        roleEntity.setRoleDescription(roleDTO.getRoleDes());
        roleEntity.setCreateOn(new Date());
        authorityRepository.save(roleEntity);
    }

    @Override
    public void saveAuthority(RoleDTO roleDTO) {
        RoleEntity roleEntity = authorityRepository.getRoleEntity(roleDTO.getRoleId());
        if (roleEntity != null) {
            roleEntity.setRoleName(roleDTO.getRoleName());
            roleEntity.setModifyOn(new Date());
            authorityRepository.update(roleEntity);
            authorityRepository.deleteAuthority(roleEntity);
            if (!StringUtil.isEmpty(roleDTO.getMenuIds())) {
                String[] ids = roleDTO.getMenuIds().split(",");
                for (int i = 0; i < ids.length; i++) {
                    AuthorityEntity authorityEntity = new AuthorityEntity();
                    authorityEntity.setaId(IdGen.uuid());
                    authorityEntity.setRoleId(roleEntity.getRoleId());
                    authorityEntity.setMenuId(ids[i]);
                    authorityEntity.setCreateOn(new Date());
                    authorityRepository.saveAuthorityEntity(authorityEntity);
                }
            }
        }
    }

    @Override
    public List<RoleDTO> getRoleInfoList() {
        List<RoleEntity> roleEntityList = authorityRepository.getRoleInfoList();
        List<RoleDTO> roleDTOList = new ArrayList<>();
        if (roleEntityList != null && roleEntityList.size() > 0) {
            for (RoleEntity roleEntity : roleEntityList) {
                RoleDTO roleDTO = new RoleDTO();
                roleDTO.setRoleId(roleEntity.getRoleId());
                roleDTO.setRoleName(roleEntity.getRoleName());
                roleDTOList.add(roleDTO);
            }
        }
        return roleDTOList;
    }

    @Override
    public List<RoleDTO> getRoleInfoByUserId(String userId) {
        List<Object[]> list = authorityRepository.getRoleInfoByUserId(userId);
        List<RoleDTO> roleDTOList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (Object[] obj : list) {
                RoleDTO roleDTO = new RoleDTO();
                roleDTO.setRoleId(obj[0] == null ? "" : (String) obj[0]);
                roleDTO.setRoleName(obj[1] == null ? "" : (String) obj[1]);
                roleDTOList.add(roleDTO);
            }
        }
        return roleDTOList;
    }
}
