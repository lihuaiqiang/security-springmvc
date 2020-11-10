package com.itheima.security.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/11/10 17:08
 * <p>
 * 创建 config目录的目的：本工程是基于 Servlet3.0创建的，之前的如web.xml、applicationContext.xml就不再使用了，
 * 而是通过使用Java类的方式进行配置，配置相关的类都在 config 包下。
 * <p>
 * excludeFilters：排除掉Controller类的扫描
 *
 * 这个类相当于application-context.xml
 */
@Configuration
@ComponentScan(basePackages = "com.itheima.security.springmvc"
        , excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class ApplicationConfig {
    //在此配置除了Controller的其它bean，比如：数据库链接池、事务管理器、业务bean等都会在此进行配置。
}
