package com.hongfeng.greenhouses.controller;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.environment.dto.EnvironmentDTO;
import com.hongfeng.greenhouses.domain.equipment.dto.EquipmentDTO;
import com.hongfeng.greenhouses.service.environment.inf.EnvironmentService;
import com.hongfeng.greenhouses.service.equipment.inf.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Jiazefeng on 2018/1/14.
 */
@Controller
@RequestMapping(value = "/environment")
public class EnvironmentController {
    @Autowired
    private EnvironmentService environmentService;
    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping(value = "/getEnvironmentList", method = RequestMethod.GET)
    public String getEnvironmentList(Model model, WebPage webPage, @Valid EnvironmentDTO environmentDTO) {
        List<EnvironmentDTO> environmentDTOList = environmentService.getEnvironmentList(environmentDTO, webPage);
        List<EquipmentDTO> equipmentDTOList = equipmentService.getEquipmentById();
        model.addAttribute("environmentDtoList", environmentDTOList);
        model.addAttribute("environmentDto", environmentDTO);
        model.addAttribute("equipmentList", equipmentDTOList);
        return "/environment/EnvironmentManage";
    }

    @RequestMapping(value = "/saveInfo", method = RequestMethod.POST)
    public String addInfo(@Valid EnvironmentDTO environmentDTO) {
        environmentService.save(environmentDTO);
        return "redirect:../environment/getEnvironmentList";
    }
}
