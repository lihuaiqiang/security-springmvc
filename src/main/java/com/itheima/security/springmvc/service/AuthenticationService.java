package com.itheima.security.springmvc.service;

import com.itheima.security.springmvc.mode.AuthenticationRequest;
import com.itheima.security.springmvc.mode.UserDto;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/11/13 14:27
 */
public interface AuthenticationService {

    /**
     * 用户认证
     *
     * @param authenticationRequest 用户认证请求，账号和密码
     * @return 认证成功的用户信息
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
