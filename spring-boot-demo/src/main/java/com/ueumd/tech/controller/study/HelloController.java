package com.ueumd.tech.controller.study;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 读取yml配置
    @Value("${spring.application.name}")
    private String name;

    @ResponseBody
    @GetMapping("/getProjectName")
    public String getProjectName() {
        return name;
    }

    @ResponseBody
    @GetMapping("/testHello2")
    public String testHello2() {
        return "hd0";
    }

    @ResponseBody
    @GetMapping("/testHello3")
    public String testHello3() {
        return "d!";
    }
}
