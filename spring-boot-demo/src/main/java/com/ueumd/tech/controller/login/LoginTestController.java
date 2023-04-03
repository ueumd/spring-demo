package com.ueumd.tech.controller.login;

import com.ueumd.tech.common.vo.ResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/login")
public class LoginTestController {

    @GetMapping( "/getSystemDate")
    public ResponseDTO<String> getSystemDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String now = df.format(System.currentTimeMillis());
        return  new ResponseDTO<>(now);
    }
}
