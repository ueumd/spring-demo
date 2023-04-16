package com.ueumd;

import com.spring.ScopeEnum;
import com.spring.UeumdApplicationContext;
import com.ueumd.service.UserService;

public class Test {
    public static void main(String[] args) {
        System.out.println(ScopeEnum.singleton);
        UeumdApplicationContext applicationContext = new UeumdApplicationContext(AppConfig.class);
        Object userService = applicationContext.getBean("userService");
        System.out.println(userService);

        // prototype
//        System.out.println(applicationContext.getBean("userService"));
//        System.out.println(applicationContext.getBean("userService"));
//        System.out.println(applicationContext.getBean("userService"));


//        UserService userService = (UserService) applicationContext.getBean("userService");
//        userService.test();
    }
}
