package com.hongfeng.greenhouses.service.menu.impl;

import com.hongfeng.common.tool.IdGen;
import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.menu.dto.MenuInfoDTO;
import com.hongfeng.greenhouses.domain.menu.model.MenuModel;
import com.hongfeng.greenhouses.domain.menu.repository.MenuRepository;
import com.hongfeng.greenhouses.service.menu.inf.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Jiazefeng on 2017/10/18.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public void addFirstMenu(MenuInfoDTO menuInfoDTO) {

        MenuModel newMenu = new MenuModel();
        newMenu.setMenuId(IdGen.uuid());//菜单ID
        newMenu.setMenuName(menuInfoDTO.getMenuName());//菜单名称
        newMenu.setChildFlag(0);//是否有子菜单
        newMenu.setMenuDescription(menuInfoDTO.getMenuDesc());//菜单描述
        newMenu.setMenuState(1);//菜单状态
        newMenu.setMenuLevel(1);//菜单级别
        newMenu.setMenuOrder(Integer.parseInt(menuInfoDTO.getMenuOrder()));//菜单排序
        newMenu.setOwner("property");//所属系统
        newMenu.setCreateOn(new Date());
        newMenu.setModifyOn(new Date());
        menuRepository.addMenuModel(newMenu);
    }

    @Override
    public List<MenuInfoDTO> getMenuInfoList(MenuInfoDTO menuInfoDTO, WebPage webPage) {
        Map map = new HashMap();
        map.put("menuLevel", 1);
        List<MenuModel> menuModelList = menuRepository.getMenuEntityList(map, webPage);
        List<MenuInfoDTO> menuInfoDTOList = new ArrayList<MenuInfoDTO>();
        if (menuModelList != null && menuModelList.size() > 0) {
            for (MenuModel menuModel : menuModelList) {
                MenuInfoDTO menuInfoDTO1 = new MenuInfoDTO();
                menuInfoDTO1.setMenuId(menuModel.getMenuId());//菜单ID
                menuInfoDTO1.setMenuName(menuModel.getMenuName());//菜单名称
                menuInfoDTO1.setMenuLevel(menuModel.getMenuLevel() + "");//菜单级别
                menuInfoDTO1.setMenuDesc(menuModel.getMenuDescription());//菜单描述
                menuInfoDTO1.setMenuUrl(menuModel.getMenuUrl());//菜单URL
                menuInfoDTOList.add(menuInfoDTO1);
            }
        }
        return menuInfoDTOList;
    }

    @Override
    public List<MenuInfoDTO> listSecMenu(String parId, WebPage webPage) {
        Map map = new HashMap();
        map.put("menuLevel", 2);
        map.put("parId", parId);
        List<MenuModel> menuModelList = menuRepository.getMenuEntityList(map, webPage);
        List<MenuInfoDTO> menuInfoDTOList = new ArrayList<MenuInfoDTO>();
        if (menuModelList != null && menuModelList.size() > 0) {
            for (MenuModel menuModel : menuModelList) {
                MenuInfoDTO menuInfoDTO1 = new MenuInfoDTO();
                menuInfoDTO1.setMenuId(menuModel.getMenuId());//菜单ID
                menuInfoDTO1.setMenuName(menuModel.getMenuName());//菜单名称
                menuInfoDTO1.setMenuLevel(menuModel.getMenuLevel() + "");//菜单级别
                menuInfoDTO1.setMenuDesc(menuModel.getMenuDescription());//菜单描述
                menuInfoDTO1.setMenuUrl(menuModel.getMenuUrl());//菜单URL
                menuInfoDTOList.add(menuInfoDTO1);
            }
        }
        return menuInfoDTOList;
    }

    @Override
    public void addSecMenu(MenuInfoDTO menuInfoDTO) {
        MenuModel newMenu = new MenuModel();
        newMenu.setMenuId(IdGen.uuid());//菜单ID
        newMenu.setMenuName(menuInfoDTO.getMenuName());//菜单名称
        newMenu.setChildFlag(1);//是否有子菜单
        newMenu.setMenuDescription(menuInfoDTO.getMenuDesc());//菜单描述
        newMenu.setMenuState(1);//菜单状态
        newMenu.setMenuLevel(2);//菜单级别
        newMenu.setMenuOrder(Integer.parseInt(menuInfoDTO.getMenuOrder()));//菜单排序
        newMenu.setOwner("property");//所属系统
        newMenu.setMenuUrl(menuInfoDTO.getMenuUrl());
        newMenu.setParentMenuId(menuInfoDTO.getMenuParentId());
        newMenu.setCreateOn(new Date());
        newMenu.setModifyOn(new Date());
        menuRepository.addMenuModel(newMenu);
    }

    @Override
    public Map<String, String> getMenus() {
        List<MenuModel> menuModelList = menuRepository.getMenus();
        Map<String, String> roleList = new LinkedHashMap<>();
        roleList.put("", "请选择");
        if (menuModelList.size() > 0) {
            for (MenuModel menuModel : menuModelList) {
                roleList.put(menuModel.getMenuId(), menuModel.getMenuName());
            }
        }
        return roleList;
    }

    @Override
    public List<MenuInfoDTO> getMenuInfos() {
        List<MenuModel> menuModelList = menuRepository.getMenus();
        List<MenuInfoDTO> menuInfoDTOList = new ArrayList<>();
        if (menuModelList != null && menuModelList.size() > 0) {
            for (MenuModel menuModel : menuModelList) {
                MenuInfoDTO menuInfoDTO = new MenuInfoDTO();
                menuInfoDTO.setMenuId(menuModel.getMenuId());
                menuInfoDTO.setMenuName(menuModel.getMenuName());
                menuInfoDTOList.add(menuInfoDTO);
            }
        }
        return menuInfoDTOList;
    }

    @Override
    public List<MenuInfoDTO> getMenuInfos(String roleId) {
        List<Object[]> list = menuRepository.getMenus(roleId);
        List<MenuInfoDTO> menuInfoDTOList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (Object[] menuModel : list) {
                MenuInfoDTO menuInfoDTO = new MenuInfoDTO();
                menuInfoDTO.setMenuId((String) menuModel[0]);
                menuInfoDTO.setMenuName((String) menuModel[1]);
                menuInfoDTOList.add(menuInfoDTO);
            }
        }
        return menuInfoDTOList;
    }

}
