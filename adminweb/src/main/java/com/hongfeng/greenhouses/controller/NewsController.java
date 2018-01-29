package com.hongfeng.greenhouses.controller;

import com.hongfeng.common.tool.WebPage;
import com.hongfeng.greenhouses.domain.news.dto.NewsDTO;
import com.hongfeng.greenhouses.service.news.inf.NewsService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiazefeng on 2018/1/27.
 */
@Controller
@RequestMapping(value = "/news")
public class NewsController {
    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/getNewsList", method = RequestMethod.GET)
    public String getNewsList(Model model, @Valid NewsDTO newsDTO, WebPage webPage) {
        List<NewsDTO> newsDTOList = newsService.getNewsListByParam(newsDTO, webPage);
        model.addAttribute("newsList", newsDTOList);
        model.addAttribute("newsDto", newsDTO);
        return "/news/NewsManage";
    }

    @RequestMapping(value = "/toAddOrUpdate", method = RequestMethod.GET)
    public String toAddOrUpdate(String newsId, Model model) {
        NewsDTO newsDTO = newsService.getNewsDTOById(newsId);
        model.addAttribute("newsDTO", newsDTO);
        return "/news/NewsAddManage";
    }

    @RequestMapping(value = "/addOrUpdateNews", method = RequestMethod.POST)
    public String addOrUpdateNews(@Valid NewsDTO newsDTO, MultipartFile gUrlFile) {
        boolean f = newsService.saveOrUpdate(newsDTO, gUrlFile, IMAGE_SERVER_URL);
        return "redirect:../news/getNewsList";
    }

    /**
     * 置顶新闻
     * Created by yuanyn on 2017/6/14.
     */
    @RequestMapping(value = "/toTopNews")
    public Map<String, Object> toTopNews(NewsDTO newsDTO) {
        Map<String, Object> resultMap = new HashedMap();
        boolean flag = newsService.topNews(newsDTO);
        if (flag) {
            resultMap.put("error", 0);
        } else {
            resultMap.put("error", -1);
        }
        return resultMap;
    }

    /**
     * 删除新闻
     * Created by yuanyn on 2017-06-14
     */
    @ResponseBody
    @RequestMapping(value = "/toDeleteNews")
    public Map<String, Object> toDeleteNews(NewsDTO newsDTO) {
        Map<String, Object> resultMap = new HashedMap();
        try {
            newsService.deleteNews(newsDTO);
            resultMap.put("error", 0);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("error", -1);
        }
        return resultMap;
    }
}
