package com.hongfeng.greenhouses.domain.authority.repository;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.authority.model.AuthorityEntity;
import com.hongfeng.greenhouses.domain.authority.model.RoleEntity;
import com.hongfeng.greenhouses.domain.authority.model.UserAuthorityEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2018/1/15.
 */
public interface AuthorityRepository {
    List<RoleEntity> getRoleList(WebPage webPage, Map map);

    RoleEntity getRoleEntity(String roleId);

    void save(RoleEntity roleEntity);

    void update(RoleEntity roleEntity);

    void deleteAuthority(RoleEntity roleEntity);

    void saveAuthorityEntity(AuthorityEntity authorityEntity);

    List<RoleEntity> getRoleInfoList();

    void addUserAurhority(UserAuthorityEntity userAuthorityEntity);

    List<Object[]> getRoleInfoByUserId(String userId);
}
