package com.hongfeng.greenhouses.service.greenhouse.inf;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.greenhouse.dto.GreenhouseDTO;
import com.hongfeng.greenhouses.domain.greenhouse.dto.GreenhouseDetailsDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2018/1/12.
 */
public interface GreenhouseService {
    /**
     * 获取大棚列表
     *
     * @param greenhouseDTO
     * @param webPage
     * @return
     */
    List<GreenhouseDTO> getGreenhouseDtoList(GreenhouseDTO greenhouseDTO, WebPage webPage);

    boolean saveOrUpdate(GreenhouseDTO greenhouseDTO, MultipartFile gUrlFile, String IMAGE_SERVER_URL);

    GreenhouseDTO getGreenhouseDTOById(String gId);

    boolean deleteGreenhouseById(String gId);

    GreenhouseDetailsDTO getGreenhouseDetailDTOById(String gId);

    Map<String,String> getAllGreenhouse();

    boolean fileUpload(HttpServletRequest request, String greenhouseId, String IMAGE_SERVER_URL);
}
