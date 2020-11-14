package com.itheima.security.springmvc.mode;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/11/13 14:29
 *
 * 用户身份信息
 */
@Data
@AllArgsConstructor//全参数的构造器
public class UserDto {

    public static final String SESSION_USER_KEY = "_user";

    private String userId;

    private String username;

    private String password;

    private String fullname;

    private String mobile;
    /**
     * 用户权限
     */
    private Set<String> authorities;
}
