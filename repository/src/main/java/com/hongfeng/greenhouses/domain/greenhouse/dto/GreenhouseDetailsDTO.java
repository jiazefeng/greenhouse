package com.hongfeng.greenhouses.domain.greenhouse.dto;

import java.util.List;

/**
 * Created by Jiazefeng on 2018/1/13.
 */
public class GreenhouseDetailsDTO {
    private String gName;
    private List<GreenhouseDetailDTO> greenhouseDetailDTOList;

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public List<GreenhouseDetailDTO> getGreenhouseDetailDTOList() {
        return greenhouseDetailDTOList;
    }

    public void setGreenhouseDetailDTOList(List<GreenhouseDetailDTO> greenhouseDetailDTOList) {
        this.greenhouseDetailDTOList = greenhouseDetailDTOList;
    }
}
