package com.hongfeng.greenhouses.domain.news.repository;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.news.model.NewsEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2018/1/27.
 */
public interface NewsRepository {
    List<NewsEntity> getNewsListByParam(Map map, WebPage webPage);

    void saveOrUpdate(NewsEntity newsEntity);

    NewsEntity getNewsEntityById(String newsId);

    void topNews(String newsId, String slideShow);

    void delete(NewsEntity newsEntity);

    List<NewsEntity> getNewsListByParam(String slideShow);
    int getNewsCountByParam(String slideShow);
}
