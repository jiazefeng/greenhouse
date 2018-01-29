package com.hongfeng.greenhouses.controller;

import com.hongfeng.common.result.ApiResult;
import com.hongfeng.common.result.SuccessApiResult;
import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.production.dto.ProductionDTO;
import com.hongfeng.greenhouses.service.greenhouse.inf.GreenhouseService;
import com.hongfeng.greenhouses.service.production.inf.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2018/1/29.
 */
@Controller
@RequestMapping(value = "/production")
public class ProductionController {
    @Autowired
    private ProductionService productionService;
    @Autowired
    private GreenhouseService greenhouseService;

    @RequestMapping(value = "/getProductionList", method = RequestMethod.GET)
    public String getProductionList(Model model, WebPage webPage, @Valid ProductionDTO productionDTO) {
        List<ProductionDTO> productionDTOS = productionService.getProductionListByParam(productionDTO, webPage);
        Map<String, String> greenhouses = greenhouseService.getAllGreenhouse();
        model.addAttribute("productionList", productionDTOS);
        model.addAttribute("productionDTO", productionDTO);
        model.addAttribute("greenhouses", greenhouses);
        return "/production/productionManage";
    }

    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    public String addOrUpdate(@Valid ProductionDTO productionDTO) {
        productionService.addOrUpdate(productionDTO);
        return "redirect:../production/getProductionList";
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public ApiResult toUpdate(String proId) {
        ProductionDTO productionDTO = productionService.getProductionById(proId);
        return new SuccessApiResult(productionDTO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(String proId) {
        productionService.delete(proId);
        return "redirect:../production/getProductionList";
    }
}
