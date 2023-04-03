package com.ueumd.tech.login;

import com.ueumd.tech.utils.RedisCache;
import com.ueumd.tech.domain.login.LoginUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisCache redisCache;


    @Test
    public void test(){
        /*
        * 高版本 fastjson 解析时有问题 使用 1.2.33
        * */
        String redisKey = "login:" + 2;
        LoginUser loginUser = redisCache.getCacheObject(redisKey);

        System.out.println(loginUser);
    }
}
