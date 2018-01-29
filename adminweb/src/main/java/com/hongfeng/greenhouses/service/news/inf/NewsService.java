package com.hongfeng.greenhouses.service.news.inf;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.news.dto.NewsDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Jiazefeng on 2018/1/27.
 */
public interface NewsService {
    List<NewsDTO> getNewsListByParam(NewsDTO newsDTO, WebPage webPage);

    boolean saveOrUpdate(NewsDTO newsDTO, MultipartFile gUrlFile, String image_server_url);

    NewsDTO getNewsDTOById(String newsId);

    boolean topNews(NewsDTO newsDTO);

    void deleteNews(NewsDTO newsDTO);
}
