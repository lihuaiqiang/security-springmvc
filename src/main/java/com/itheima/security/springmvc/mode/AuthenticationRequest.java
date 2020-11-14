package com.itheima.security.springmvc.mode;

import lombok.Data;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/11/13 14:28
 * <p>
 * 认证的请求参数：用户名、密码
 */
@Data
public class AuthenticationRequest {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
