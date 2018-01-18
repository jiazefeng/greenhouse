package com.hongfeng.greenhouses.service.menu.inf;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.menu.dto.MenuInfoDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2017/10/18.
 */
public interface MenuService {
    /**
     * 添加一级菜单
     *
     * @param menuInfoDTO
     */
    void addFirstMenu(MenuInfoDTO menuInfoDTO);

    /**
     * 获取菜单列表
     *
     * @param menuInfoDTO
     * @param webPage
     * @return
     */
    List<MenuInfoDTO> getMenuInfoList(MenuInfoDTO menuInfoDTO, WebPage webPage);

    List<MenuInfoDTO> listSecMenu(String parId, WebPage webPage);

    void addSecMenu(MenuInfoDTO menuInfoDTO);

    Map<String,String> getMenus();
    List<MenuInfoDTO> getMenuInfos();

    List<MenuInfoDTO> getMenuInfos(String roleId);
}
