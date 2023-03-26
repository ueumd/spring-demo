package com.itheima.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    // 拦截路径
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * POST 请求中参数 中文 乱码处理
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }
}

/**
 * Servlet容器初始化配置类
 * AbstractDispatcherServletInitializer类是SpringMVC提供的快速初始化Web3.0容器的抽象类
 * AbstractDispatcherServletInitializer提供三个接口方法供用户实现
 * createServletApplicationContext()方法，创建Servlet容器时，加载SpringMVC对应的bean并放入WebApplicationContext对象范围中
 * 而WebApplicationContext的作用范围为ServletContext范围，即整个web容器范围
 */
/*
public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
    @Override
    protected WebApplicationContext createServletApplicationContext() {

        // 初始化一个空的容器对象
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        // 加载具体的配置，在配置类里进行扫描 bean对易象
        ctx.register(SpringMvcConfig.class);
        return ctx;
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {

        // 初始化一个空的容器对象
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        // 加载具体的配置，在配置类里进行扫描 bean对易象
        ctx.register(SpringConfig.class);
        return ctx;
    }

    @Override
    protected String[] getServletMappings() {
        // 所有的请求都归spring mvc 处理
        return new String[]{"/"};
    }
}
*/
