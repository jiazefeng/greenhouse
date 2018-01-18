package com.hongfeng.greenhouses.controller;

import com.hongfeng.common.result.ApiResult;
import com.hongfeng.common.result.SuccessApiResult;
import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.equipment.dto.EquipmentDTO;
import com.hongfeng.greenhouses.service.equipment.inf.EquipmentService;
import com.hongfeng.greenhouses.service.greenhouse.inf.GreenhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2017/11/9.
 */
@Controller
@RequestMapping(value = "/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private GreenhouseService greenhouseService;

    /**
     * 初始化设备列表信息
     *
     * @param model
     * @param equipmentDTO
     * @param webPage
     * @return
     */
    @RequestMapping(value = "/getEquipmentList", method = RequestMethod.GET)
    public String getEquipmentList(Model model, @Valid EquipmentDTO equipmentDTO, WebPage webPage) {
        List<EquipmentDTO> equipmentDTOList = equipmentService.getEquipmentListByParams(equipmentDTO, webPage);
        model.addAttribute("equipmentList", equipmentDTOList);
        model.addAttribute("equipmentDTO", equipmentDTO);
        return "/equipment/EquipmentManage";
    }

    /**
     * 新增、编辑信息
     *
     * @param equipmentDTO
     * @return
     */
    @RequestMapping(value = "/addOrUpdateEquipmentInfo", method = RequestMethod.GET)
    public String addOrUpdateEquipmentInfo(@Valid EquipmentDTO equipmentDTO) {
        equipmentService.addOrUpdateEquipmentInfo(equipmentDTO);
        return "redirect:../equipment/getEquipmentList";
    }

    /**
     * 根据ID获取对应的信息
     *
     * @param eId
     * @return
     */
    @RequestMapping(value = "/getEquipmentById", method = RequestMethod.GET)
    public ApiResult getEquipmentById(@RequestParam String eId) {
        EquipmentDTO equipmentDTO = equipmentService.getEquipmentById(eId);
        return new SuccessApiResult(equipmentDTO);
    }

    @RequestMapping(value = "/deleteEquipment", method = RequestMethod.GET)
    public String deleteEquipment(@RequestParam String eId) {
        equipmentService.deleteEquipment(eId);
        return "redirect:../equipment/getEquipmentList";
    }

    @RequestMapping(value = "/getAllGreenhouse", method = RequestMethod.GET)
    public ApiResult getAllGreenhouse() {
        Map<String, String> greenhouses = greenhouseService.getAllGreenhouse();
        return new SuccessApiResult(greenhouses);
    }
}
