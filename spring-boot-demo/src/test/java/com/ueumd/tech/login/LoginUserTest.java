package com.ueumd.tech.login;

import com.ueumd.tech.domain.login.User;
import com.ueumd.tech.mapper.login.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Objects;

@SpringBootTest
public class LoginUserTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Test
    public void testQueryList(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void TestPasswordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String encode = passwordEncoder.encode("1234");
        String encode2 = passwordEncoder.encode("1234");

        System.out.println(encode); // $2a$10$5OzqL.PnPFSZquNyUH8Sj.H/v6VmqpYlb5R2ChDqH9SWHeHFiOloO
        System.out.println(encode2); // $2a$10$rE9OGOexfa0PSsruWBFoyO0TogyDzBW76W8EK5eKhD.FW0AMe6/v.

        System.out.println(passwordEncoder.matches("1234", "$2a$10$5OzqL.PnPFSZquNyUH8Sj.H/v6VmqpYlb5R2ChDqH9SWHeHFiOloO"));

    }

    @Test
    public void test() {
        User user = new User();
        user.setUserName("ueumd");
        user.setPassword("1234");
        //AuthenticationManager authenticate进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //如果认证没通过，给出对应的提示
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败");
        }
    }

}
