package com.hongfeng.greenhouses.controller;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.authority.dto.RoleDTO;
import com.hongfeng.greenhouses.domain.menu.dto.MenuInfoDTO;
import com.hongfeng.greenhouses.service.authority.inf.AuthorityService;
import com.hongfeng.greenhouses.service.menu.inf.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2018/1/15.
 */
@Controller
@RequestMapping(value = "/authority")
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/getRoleList")
    public String getRoleList(Model model, WebPage webPage, @Valid RoleDTO roleDTO) {
        List<RoleDTO> roleDTOList = authorityService.getRoleList(webPage, roleDTO);
        model.addAttribute("roleList", roleDTOList);
        return "/authority/AuthorityManage";
    }

    @RequestMapping(value = "/addRoleInfo")
    public String addRoleInfo(@Valid RoleDTO roleDTO) {
        authorityService.save(roleDTO);
        return "redirect:../authority/getRoleList";
    }

    @RequestMapping(value = "/gotoSetRole")
    public String setRoleInfo(Model model, @RequestParam String roleId) {
        RoleDTO roleDTO = authorityService.getRoleInfoById(roleId);
        List<MenuInfoDTO> menuInfoDTOList = menuService.getMenuInfos();
        List<MenuInfoDTO> menuInfoDTOs = menuService.getMenuInfos(roleId);
        model.addAttribute("menuInfoList", menuInfoDTOList);
        model.addAttribute("menuInfos", menuInfoDTOs);
        model.addAttribute("roleInfo", roleDTO);
        return "/authority/SetRoleInfo";
    }
    @RequestMapping(value = "/addAuthority")
    public String addAuthority(@Valid RoleDTO roleDTO) {
        authorityService.saveAuthority(roleDTO);
        return "redirect:../authority/getRoleList";
    }
}
