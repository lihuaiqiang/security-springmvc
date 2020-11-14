package com.itheima.security.springmvc.init;

import com.itheima.security.springmvc.config.ApplicationConfig;
import com.itheima.security.springmvc.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 加载Spring容器
 *
 * @author lihuaiqiang
 * @description
 * @date 2020/11/10 17:53
 *
 * 这个类就相当于web.xml的配置文件，使用 servlet3.0开发则不需要再定义web.xml
 *
 * 这个类实现了WebApplicationInitializer接口，Spring容器启动的时候就会加载WebApplicationInitializer接口的所有实现类。
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //spring容器，相当于加载 applicationContext.xml
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};//指定rootContext的配置类
    }

    //servletContext，相当于加载springmvc.xml
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};//指定servletContext的配置类
    }

    //url-mapping
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
