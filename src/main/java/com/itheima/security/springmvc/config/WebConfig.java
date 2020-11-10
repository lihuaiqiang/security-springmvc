package com.itheima.security.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author lihuaiqiang
 * @description
 * @date 2020/11/10 17:08
 * @EnableWebMvc 是使用Java注解快捷配置Spring Webmvc的一个注解。
 * 在使用该注解后配置一个继承于WebMvcConfigurerAdapter的配置类即可配置好Spring Webmvc。
 * 即：用来开启Web MVC的配置支持。也就是写Spring MVC时的时候会用到。
 * <p>
 * 这里的扫描就要包括Controller注解标注的类。
 *
 * 这个类就相当于spring-mvc.xml文件
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.itheima.security.springmvc"
        , includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class WebConfig implements WebMvcConfigurer {

    /*@Autowired
    SimpleAuthenticationInterceptor simpleAuthenticationInterceptor;*/

    //视频解析器
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");//设置前缀格式
        viewResolver.setSuffix(".jsp");//设置后缀格式
        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(simpleAuthenticationInterceptor).addPathPatterns("/r/**");
    }*/
}
