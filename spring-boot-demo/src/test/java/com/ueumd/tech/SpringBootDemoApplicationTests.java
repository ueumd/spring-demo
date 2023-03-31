package com.ueumd.tech;

import com.ueumd.tech.service.study.IHelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDemoApplicationTests {

    @Autowired
    private IHelloService helloService;

    @Test
    void contextLoads() {
        System.out.println("test");

    }

    @Test
    void testHello() {
        helloService.save();
    }


}
