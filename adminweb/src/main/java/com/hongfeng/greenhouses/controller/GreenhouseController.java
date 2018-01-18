package com.hongfeng.greenhouses.controller;

import com.hongfeng.common.result.ApiResult;
import com.hongfeng.common.result.SuccessApiResult;
import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.greenhouse.dto.GreenhouseDTO;
import com.hongfeng.greenhouses.domain.greenhouse.dto.GreenhouseDetailDTO;
import com.hongfeng.greenhouses.domain.greenhouse.dto.GreenhouseDetailsDTO;
import com.hongfeng.greenhouses.service.greenhouse.inf.GreenhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Jiazefeng on 2018/1/12.
 */
@Controller
@RequestMapping(value = "/greenhouse")
public class GreenhouseController {
    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;
    @Autowired
    private GreenhouseService greenhouseService;

    @RequestMapping(value = "/getGreenhouseList", method = RequestMethod.GET)
    public String getGreenhouseList(Model model, @Valid GreenhouseDTO greenhouseDTO, WebPage webPage) {
        List<GreenhouseDTO> greenhouseDTOS = greenhouseService.getGreenhouseDtoList(greenhouseDTO, webPage);
        model.addAttribute("greenhouseDtos", greenhouseDTOS);
        model.addAttribute("greenhouse", greenhouseDTO);
        return "/greenhouse/GreenhouseManage";
    }

    @RequestMapping(value = "/addOrUpdateGreenhouse", method = RequestMethod.POST)
    public String addOrUpdateGreenhouse(@Valid GreenhouseDTO greenhouseDTO, MultipartFile gUrlFile) {
        boolean f = greenhouseService.saveOrUpdate(greenhouseDTO, gUrlFile, IMAGE_SERVER_URL);
        return "redirect:../greenhouse/getGreenhouseList";
    }

    @RequestMapping(value = "/getGreenhouseById", method = RequestMethod.GET)
    public ApiResult getGreenhouseById(@RequestParam String gId) {
        GreenhouseDTO greenhouseDTO = greenhouseService.getGreenhouseDTOById(gId);
        return new SuccessApiResult(greenhouseDTO);
    }

    @RequestMapping(value = "/deleteGreenhouseById", method = RequestMethod.GET)
    public String deleteGreenhouseById(@RequestParam String gId) {
        boolean f = greenhouseService.deleteGreenhouseById(gId);
        return "redirect:../greenhouse/getGreenhouseList";
    }

    @RequestMapping(value = "/getCheckDetailes", method = RequestMethod.GET)
    public String getCheckDetailes(@RequestParam String gId, Model model) {
        GreenhouseDetailsDTO greenhouseDetailsDTO = greenhouseService.getGreenhouseDetailDTOById(gId);
        model.addAttribute("greenhouseDetail", greenhouseDetailsDTO);
        return "/greenhouse/GreenhouseDetailManage";
    }
}
