package com.chengzi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chengzi.domain.ResponseResult;
import com.chengzi.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-10-23 20:45:43
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}

