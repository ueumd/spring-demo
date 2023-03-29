package com.ueumd.tech;
import com.ueumd.tech.controller.study.HelloController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.ueumd.tech.mapper.*")
public class SpringBootDemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootDemoApplication.class, args);
        HelloController helloControllerBean = ctx.getBean(HelloController.class);
        System.out.println("bean =====> " + helloControllerBean);
    }

}
