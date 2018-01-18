package com.hongfeng.greenhouses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jiazefeng on 2018/1/12.
 */
@Controller
@RequestMapping(value = "/dataAnalysis")
public class DataController {
    @RequestMapping(value = "/getDataIndex")
    public String getDataIndex(){
        return "/dataAnalysis/DataAnalysisIndex";
    }
}
