package com.chengzi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chengzi.constants.SystemConstants;
import com.chengzi.domain.ResponseResult;
import com.chengzi.domain.entity.Link;
import com.chengzi.domain.vo.LinkVo;
import com.chengzi.mapper.LinkMapper;
import com.chengzi.service.LinkService;
import com.chengzi.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友链(Link)表服务实现类
 *
 * @author makejava
 * @since 2022-10-23 20:45:43
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {
        //查询出审核通过的所以友链
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_ADOPT);
        List<Link> links = list(queryWrapper);
        //封装VO返回
        List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(links, LinkVo.class);
        return ResponseResult.okResult(linkVos);
    }
}
