package com.hongfeng.greenhouses.controller;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.menu.dto.MenuInfoDTO;
import com.hongfeng.greenhouses.service.menu.inf.MenuService;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Jiazefeng on 2017/10/17.
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 初始化一级菜单列表
     *
     * @return
     */
    @RequestMapping(value = "/menuManage.html", method = RequestMethod.GET)
    public String menuManage(@Valid MenuInfoDTO menuInfoDTO, Model model, WebPage webPage) {
        List<MenuInfoDTO> menuInfoDTOList = menuService.getMenuInfoList(menuInfoDTO, webPage);
        model.addAttribute("menuInfoList", menuInfoDTOList);
        model.addAttribute("menuInfo", menuInfoDTO);
        return "/menu/MenuManage";
    }

    /**
     * 添加一级菜单
     *
     * @param menuInfoDTO
     * @param
     * @return
     */
    @RequestMapping(value = "/addFirMenu", method = RequestMethod.GET)
    public ModelAndView addFirstMenu(@Valid MenuInfoDTO menuInfoDTO) {
        menuService.addFirstMenu(menuInfoDTO);
        return new ModelAndView("redirect:../menu/menuManage.html");
    }

    @RequestMapping(value = "/addSecMenu", method = RequestMethod.GET)
    public ModelAndView addSecMenu(@Valid MenuInfoDTO menuInfoDTO, Model model) {
        menuService.addSecMenu(menuInfoDTO);
        model.addAttribute("parId", menuInfoDTO.getMenuParentId());
        return new ModelAndView("redirect:../menu/getMenuSecManage");
    }

    /**
     * 初始化二级菜单列表
     *
     * @return
     */
    @RequestMapping(value = "/getMenuSecManage", method = RequestMethod.GET)
    public String getMenuSecManage(Model model, @Param String parId, WebPage webPage) {
        List<MenuInfoDTO> roleMenuDTOs = menuService.listSecMenu(parId, webPage);
        model.addAttribute("menuInfoList", roleMenuDTOs);
        model.addAttribute("parId", parId);
        return "/menu/MenuSecManage";
    }
}
