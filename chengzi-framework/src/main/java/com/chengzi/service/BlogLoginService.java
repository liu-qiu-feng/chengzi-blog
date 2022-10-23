package com.chengzi.service;

import com.chengzi.domain.ResponseResult;
import com.chengzi.domain.entity.User;

public interface BlogLoginService {

    ResponseResult login(User user);
}
