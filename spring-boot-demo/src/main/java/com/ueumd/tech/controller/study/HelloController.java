package com.ueumd.tech.controller.study;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @ResponseBody
    @GetMapping("/testHello")
    public String testHello() {
        return "hd! 700";
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
