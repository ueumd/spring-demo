package com.itheima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody

@RestController // 包含了上面两个注解
@RequestMapping("/dev")
public class DevController {
    @GetMapping("/getId")
    public String getId() {
        return "book controller";
    }

    @PostMapping("/save")
    public String save() {
        return "book controller";
    }
}
