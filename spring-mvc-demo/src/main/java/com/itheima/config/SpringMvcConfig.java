package com.itheima.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
// @ComponentScan("com.itheima.controller")

// com.itheima.config 静态资源 SpringMvcSupport.java
@ComponentScan({"com.itheima.controller","com.itheima.config", "com.itheima.common"})
@EnableWebMvc // 开启转JSON功能
public class SpringMvcConfig {
}
