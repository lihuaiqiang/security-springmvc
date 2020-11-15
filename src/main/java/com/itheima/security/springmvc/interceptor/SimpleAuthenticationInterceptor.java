package com.itheima.security.springmvc.interceptor;

import com.itheima.security.springmvc.mode.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/11/14 10:54
 *
 * 拦截器，实现授权拦截。相当于在web项目的中的过滤器
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {

    /**
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception 在这个方法内校验用户请求的url是否在用户的权限范围内
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //先取出用户的信息
        HttpSession session = request.getSession();
        Object attribute = session.getAttribute(UserDto.SESSION_USER_KEY);
        if (null == attribute) {
            //用户身份信息没有认证，提示登录认证
            writeResponse(response, "请登录");
        }
        UserDto userDto = (UserDto) attribute;
        //从请求信息中提取请求的url地址
        String requestURI = request.getRequestURI();
        //模拟校验是否有“p1”的权限
        if (userDto.getAuthorities().contains("p1") && requestURI.contains("/r/r1")) {
            return true;
        }
        if (userDto.getAuthorities().contains("p2") && requestURI.contains("/r/r2")) {
            return true;
        }
        writeResponse(response, "没有权限，决绝访问！");
        return false;
    }

    /**
     * @param response
     * @param message
     * @throws IOException 把响应信息返回给客户端
     */
    private void writeResponse(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(message);
        writer.close();
        //清楚response中的缓存
        response.resetBuffer();
    }
}
