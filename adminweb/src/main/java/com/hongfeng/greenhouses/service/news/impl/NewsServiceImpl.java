package com.hongfeng.greenhouses.service.news.impl;

import com.hongfeng.common.result.ApiResult;
import com.hongfeng.common.result.SuccessApiResult;
import com.hongfeng.common.tool.*;
import com.hongfeng.greenhouses.domain.news.dto.NewsDTO;
import com.hongfeng.greenhouses.domain.news.model.NewsEntity;
import com.hongfeng.greenhouses.domain.news.repository.NewsRepository;
import com.hongfeng.greenhouses.service.news.inf.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * Created by Jiazefeng on 2018/1/27.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<NewsDTO> getNewsListByParam(NewsDTO newsDTO, WebPage webPage) {
        Map map = new HashMap();
        map.put("newsTitle", newsDTO.getNewsTitle());
        List<NewsEntity> newsEntities = newsRepository.getNewsListByParam(map, webPage);
        List<NewsDTO> newsDTOList = new ArrayList<>();
        if (newsEntities != null && newsEntities.size() > 0) {
            newsEntities.forEach(newsEntity ->
                    {
                        NewsDTO newsDTO1 = new NewsDTO();
                        newsDTO1.setNewsId(newsEntity.getNewsId());
                        newsDTO1.setNewsTitle(newsEntity.getNewsTitle());
                        newsDTO1.setNewsContent(newsEntity.getNewsContent());
                        newsDTO1.setNewsImgUrl(newsEntity.getNewsImgUrl());
                        newsDTO1.setNewsSource(newsEntity.getNewsSource());
                        newsDTO1.setSlideShow(newsEntity.getSlideShow());
                        newsDTO1.setCreateBy(newsEntity.getCreateByName());
                        newsDTO1.setCreateDate(DateUtils.format(newsEntity.getCreateOn(), DateUtils.FORMAT_LONG));
                        newsDTOList.add(newsDTO1);
                    }
            );
        }
        return newsDTOList;
    }

    @Override
    public boolean saveOrUpdate(NewsDTO newsDTO, MultipartFile gUrlFile, String image_server_url) {
        if (newsDTO != null) {
            NewsEntity newsEntity = null;
            if (StringUtil.isEmpty(newsDTO.getNewsId())) {
                newsEntity = new NewsEntity();
                newsEntity.setNewsId(IdGen.uuid());
                newsEntity.setNewsTitle(newsDTO.getNewsTitle());
                newsEntity.setNewsSource(newsDTO.getNewsSource());
                newsEntity.setNewsContent(newsDTO.getNewsContent());
                newsEntity.setSlideShow("0");
                if (gUrlFile != null && gUrlFile.getSize() > 0) {
                    String imgUrl = UploadFile.imgUpload(gUrlFile, image_server_url);
                    if (imgUrl != null) {
                        newsEntity.setNewsImgUrl(imgUrl);
                    }
                }
                newsEntity.setCreateByName(newsDTO.getCreateBy());
                newsEntity.setCreateOn(new Date());
                newsRepository.saveOrUpdate(newsEntity);
            } else {
                newsEntity = newsRepository.getNewsEntityById(newsDTO.getNewsId());
                newsEntity.setNewsTitle(newsDTO.getNewsTitle());
                newsEntity.setNewsSource(newsDTO.getNewsSource());
                newsEntity.setNewsContent(newsDTO.getNewsContent());
                if (gUrlFile != null && gUrlFile.getSize() > 0) {
                    String imgUrl = UploadFile.imgUpload(gUrlFile, image_server_url);
                    if (imgUrl != null) {
                        newsEntity.setNewsImgUrl(imgUrl);
                    }
                }
                newsEntity.setModifyOn(new Date());
                newsRepository.saveOrUpdate(newsEntity);
            }
        }
        return true;
    }

    @Override
    public NewsDTO getNewsDTOById(String newsId) {
        if (!StringUtil.isEmpty(newsId)) {
            NewsEntity newsEntity = newsRepository.getNewsEntityById(newsId);
            if (newsEntity != null) {
                NewsDTO newsDTO = new NewsDTO();
                newsDTO.setNewsId(newsEntity.getNewsId());
                newsDTO.setNewsTitle(newsEntity.getNewsTitle());
                newsDTO.setNewsSource(newsEntity.getNewsSource());
                newsDTO.setNewsImgUrl(newsEntity.getNewsImgUrl());
                newsDTO.setNewsContent(newsEntity.getNewsContent());
                newsDTO.setSlideShow(newsEntity.getSlideShow());
                newsDTO.setCreateBy(newsEntity.getCreateByName());
                newsDTO.setCreateDate(DateUtils.format(newsEntity.getCreateOn(), DateUtils.FORMAT_LONG));

                return newsDTO;
            }
        }
        return null;
    }

    @Override
    public boolean topNews(NewsDTO newsDTO) {
        NewsEntity newsEntity = newsRepository.getNewsEntityById(newsDTO.getNewsId());
        if (null != newsEntity) {
            if ("0".equals(newsEntity.getSlideShow())) {
                if (newsRepository.getNewsCountByParam("1") >= 4) {
                    return false;
                } else {
                    newsDTO.setSlideShow("1");
                    newsRepository.topNews(newsDTO.getNewsId(), newsDTO.getSlideShow());
                    return true;
                }
            } else {
                newsDTO.setSlideShow("0");
                newsRepository.topNews(newsDTO.getNewsId(), newsDTO.getSlideShow());
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteNews(NewsDTO newsDTO) {
        NewsEntity newsEntity = newsRepository.getNewsEntityById(newsDTO.getNewsId());
        if (null != newsEntity) {
            newsRepository.delete(newsEntity);
        }
    }

    @Override
    public ApiResult getCarousel(WebPage webPage) {
        ModelMap modelMap = new ModelMap();
        List<NewsEntity> newsCarouselList = newsRepository.getNewsListByParam("1");
        List<NewsEntity> newsList = newsRepository.getNewsListByParam("0");
        List<NewsDTO> carouselList = new ArrayList<>();
        List<NewsDTO> newsDTOList = new ArrayList<>();
        if (newsCarouselList != null && newsCarouselList.size() > 0) {
            newsCarouselList.forEach(newsEntity -> {
                NewsDTO newsDTO = new NewsDTO();
                newsDTO.setNewsId(newsEntity.getNewsId());
                newsDTO.setNewsTitle(newsEntity.getNewsTitle());
                newsDTO.setNewsImgUrl(newsEntity.getNewsImgUrl());
                carouselList.add(newsDTO);
            });
        }
        if (newsList != null && newsList.size() > 0) {
            newsList.forEach(newsEntity -> {
                NewsDTO newsDTO = new NewsDTO();
                newsDTO.setNewsId(newsEntity.getNewsId());
                newsDTO.setNewsTitle(newsEntity.getNewsTitle());
                newsDTO.setNewsImgUrl(newsEntity.getNewsImgUrl());
                newsDTOList.add(newsDTO);
            });
        }
        modelMap.addAttribute("carouselList", carouselList);
        modelMap.addAttribute("newsDTOList", newsDTOList);
        return new SuccessApiResult(modelMap);
    }

    @Override
    public ApiResult getNewsDetails(String newsId) {
        ModelMap modelMap = new ModelMap();
        if (!StringUtil.isEmpty(newsId)) {
            NewsEntity newsEntity = newsRepository.getNewsEntityById(newsId);
            if (newsEntity != null) {
                NewsDTO newsDTO = new NewsDTO();
                newsDTO.setNewsId(newsEntity.getNewsId());
                newsDTO.setNewsTitle(newsEntity.getNewsTitle());
                newsDTO.setNewsSource(newsEntity.getNewsSource());
                newsDTO.setNewsImgUrl(newsEntity.getNewsImgUrl());
                newsDTO.setNewsContent(newsEntity.getNewsContent());
                newsDTO.setSlideShow(newsEntity.getSlideShow());
                newsDTO.setCreateBy(newsEntity.getCreateByName());
                newsDTO.setCreateDate(DateUtils.format(newsEntity.getCreateOn(), DateUtils.FORMAT_LONG));
                modelMap.addAttribute("newsDetails", newsDTO);
            }
        }
        return new SuccessApiResult(modelMap);
    }
}
