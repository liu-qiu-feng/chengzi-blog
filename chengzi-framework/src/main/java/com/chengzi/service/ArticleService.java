package com.chengzi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chengzi.domain.ResponseResult;
import com.chengzi.domain.entity.Article;

public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);
}
