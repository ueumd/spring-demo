package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 响应体 如JSON
    @ResponseBody

    // 请求路径
    @RequestMapping("/hello")
    public String index(){
        System.out.println("hello world");
        return "hello";
    }

    /**
     * 响应JSP页面
     * @return
     */
    @RequestMapping("/toJumePage")
    public String toJumePage(){
        return "page.jsp";
    }
}
