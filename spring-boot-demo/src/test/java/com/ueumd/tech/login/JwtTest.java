package com.ueumd.tech.login;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.ueumd.tech.utils.JwtUtil.createJWT;
import static com.ueumd.tech.utils.JwtUtil.parseJWT;

@SpringBootTest
public class JwtTest {
    @Test
    public void test() {
       try {
           String jwt = createJWT("hello");
           System.out.println(jwt);
           // eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwNmZmZTA2ZmUzYzQ0NTEzODJiNjVmYWNmYzczNTc3NSIsInN1YiI6ImhlbGxvIiwiaXNzIjoiaHNkIiwiaWF0IjoxNjgwNTMyMzEyLCJleHAiOjE2ODA1MzU5MTJ9._VLuNEaT4Qwo-n48NceB1rj6llJHr2c2lTfPNIo2COQ
       } catch (Exception e) {
          e.printStackTrace();

       }
    }


    @Test
    public void test2() throws Exception {
        Claims claims = parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwNmZmZTA2ZmUzYzQ0NTEzODJiNjVmYWNmYzczNTc3NSIsInN1YiI6ImhlbGxvIiwiaXNzIjoiaHNkIiwiaWF0IjoxNjgwNTMyMzEyLCJleHAiOjE2ODA1MzU5MTJ9._VLuNEaT4Qwo-n48NceB1rj6llJHr2c2lTfPNIo2COQ");
        String subject = claims.getSubject();
        System.out.println(subject); // hello
        System.out.println(claims); // {jti=06ffe06fe3c4451382b65facfc735775, sub=hello, iss=hsd, iat=1680532312, exp=1680535912}
    }
}
