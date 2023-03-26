package com.itheima.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @ResponseBody
    @RequestMapping("/save")
    public String save(){
        System.out.println("user save ...");
        return "{'info':'springmvc'}";
    }

    /**
     * get 方式可以直接接收 普通参数
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public String login(String name, String id) {
        System.out.println("普通参数: " + name);
        System.out.println("普通参数: " + id);
        return "login";
    }
}
