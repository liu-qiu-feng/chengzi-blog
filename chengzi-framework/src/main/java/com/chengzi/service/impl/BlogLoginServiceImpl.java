package com.chengzi.service.impl;

import com.chengzi.domain.ResponseResult;
import com.chengzi.domain.entity.LoginUser;
import com.chengzi.domain.entity.User;
import com.chengzi.domain.vo.BlogUserLoginVo;
import com.chengzi.domain.vo.UserInfoVo;
import com.chengzi.service.BlogLoginService;
import com.chengzi.utils.BeanCopyUtils;
import com.chengzi.utils.JwtUtil;
import com.chengzi.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BlogLoginServiceImpl implements BlogLoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        //判断是否认证通过
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或者密码错误");
        }

        //认证通过获取user id 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //把用户信息传入redis
        redisCache.setCacheObject("bloglogin:"+userId,loginUser);

        //将user拷贝到userinfovo
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);

        //把token和user info封装返回
        BlogUserLoginVo vo = new BlogUserLoginVo(jwt,userInfoVo);
        return ResponseResult.okResult(vo);
    }
}
