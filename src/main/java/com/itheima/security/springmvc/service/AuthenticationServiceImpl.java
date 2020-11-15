package com.itheima.security.springmvc.service;

import com.itheima.security.springmvc.mode.AuthenticationRequest;
import com.itheima.security.springmvc.mode.UserDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/11/13 14:27
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    /**
     * @param authenticationRequest 用户认证请求，账号和密码
     * @return 
     *
     * 用户认证：验证用户的身份信息是否合法
     */
    @Override
    public UserDto authentication(AuthenticationRequest authenticationRequest) {
        //验证入参
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        if (null == authenticationRequest || null == username || password == null) {
            throw new RuntimeException("账号和密码");
        }

        //根据账号去查询数据库
        UserDto userDto = getUserDto(username);
        //判断用户信息是否为空
        if (null == userDto) {
            throw new RuntimeException("查询不到用户信息");
        }
        //验证用户密码是否正确
        if (!password.equals(userDto.getPassword())) {
            throw new RuntimeException("用户密码不正确");
        }
        //认证通过，返回用户的信息
        return userDto;
    }

    /**
     * 根据用户名查询用户的详细信息
     *
     * @param username
     * @return
     */
    private UserDto getUserDto(String username) {
        UserDto userDto = userMap.get(username);
        return userDto;
    }

    //用户信息
    private Map<String, UserDto> userMap = new HashMap<>();

    //代码块，实现填入用户信息
    {
        //用户1的访问权限
        Set<String> authorities1 = new HashSet<>();
        //这个p1我们人为让它和/r/r1对应，p1权限标识符
        authorities1.add("p1");
        //用户2的访问权限
        Set<String> authorities2 = new HashSet<>();
        //这个p2我们人为让它和/r/r2对应
        authorities2.add("p2");
        userMap.put("zhangsan", new UserDto("1010", "zhangsan", "123", "张三", "133443", authorities1));
        userMap.put("lisi", new UserDto("1011", "lisi", "456", "李四", "144553", authorities2));
    }
}
