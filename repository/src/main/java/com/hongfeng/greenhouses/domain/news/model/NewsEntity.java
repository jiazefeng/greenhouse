package com.hongfeng.greenhouses.domain.news.model;

import com.hongfeng.greenhouses.hibernate.BaseVo;

import javax.persistence.*;

/**
 * Created by Jiazefeng on 2018/1/27.
 */
@Entity
@Table(name = "NEWS")
public class NewsEntity extends BaseVo {
    private String newsId;        //新闻ID
    private String newsTitle;     //新闻标题
    private String newsImgUrl;    //新闻插图
    private String newsContent;   //新闻内容
    private String newsSource;    //来源
    private String slideShow;     //"1"设置为轮播图

    @Id
    @Column(name = "NEWS_ID", unique = true, nullable = false, length = 64)
    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "NEWS_TITLE", length = 100)
    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    @Basic
    @Column(name = "NEWS_IMG_URL", length = 200)
    public String getNewsImgUrl() {
        return newsImgUrl;
    }

    public void setNewsImgUrl(String newsImgUrl) {
        this.newsImgUrl = newsImgUrl;
    }

    @Basic
    @Column(name = "NEWS_CONTENT", length = 16777216)
    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Basic
    @Column(name = "NEWS_SOURCE", length = 100)
    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    @Basic
    @Column(name = "SLIDE_SHOW", length = 50)
    public String getSlideShow() {
        return slideShow;
    }

    public void setSlideShow(String slideShow) {
        this.slideShow = slideShow;
    }
}
