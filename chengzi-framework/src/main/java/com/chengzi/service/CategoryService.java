package com.chengzi.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.chengzi.domain.ResponseResult;
import com.chengzi.domain.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-10-23 16:34:10
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}

