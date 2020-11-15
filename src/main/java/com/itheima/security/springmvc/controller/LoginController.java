package com.itheima.security.springmvc.controller;

import com.itheima.security.springmvc.mode.AuthenticationRequest;
import com.itheima.security.springmvc.mode.UserDto;
import com.itheima.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/11/14 11:03
 */
@RestController
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping(value = "/login", produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest authenticationRequest, HttpSession session) {
        UserDto userDto = authenticationService.authentication(authenticationRequest);
        //将用户信息放入到 session 中
        session.setAttribute(UserDto.SESSION_USER_KEY, userDto);
        return userDto.getUsername() + "登陆成功";
    }

    @GetMapping(value = "/logout", produces = "text/plain;charset=utf-8")
    public String logout(HttpSession session) {
        //用户退出登录状态后，清空session中的用户信息
        session.invalidate();
        return "用户退出";
    }

    @GetMapping(value = "/r/r1", produces = {"text/plain;charset=utf-8"})
    public String r1(HttpSession session) {
        String fullname = null;
        Object attribute = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (null != attribute) {
            fullname = ((UserDto) attribute).getFullname();
        } else {
            fullname = "匿名";
        }
        return fullname + "：访问资源1";
    }

    /**
     * @param session
     * @return
     *
     * 给用户分配权限模拟测试
     */
    @GetMapping(value = "/r/r2", produces = {"text/plain;charset=UTF-8"})
    public String r2(HttpSession session) {
        String fullname = null;
        Object userObj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (userObj != null) {
            fullname = ((UserDto) userObj).getFullname();
        } else {
            fullname = "匿名";
        }
        return fullname + "：访问资源2";
    }
}
