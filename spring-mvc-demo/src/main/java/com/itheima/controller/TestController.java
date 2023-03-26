package com.itheima.controller;
import com.itheima.domain.Address;
import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
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
    @RequestMapping("/getName")
    public String login(String name, String id) {
        System.out.println("普通参数: " + name);
        System.out.println("普通参数: " + id);
        return "login";
    }

    /**
     * url参数名称和接收参数名称不一样
     * diffName?name=黑马程序员&id=1
     * RequestParam("name") => userName 建立映射关系
     * @param userName
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/diffName")
    public String diffName(@RequestParam("name") String userName, String id) {
        System.out.println("普通参数: " + userName);
        System.out.println("普通参数: " + id);
        return "login";
    }

    @ResponseBody
    @RequestMapping("/userLogin")
    public String userLogin(User user) {
        System.out.println("user: " + user);
        return user.toString();
    }


    @ResponseBody
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] likes) {
        System.out.println("数组参数传递: " + Arrays.toString(likes));
        String str =  Arrays.toString(likes);
        return str;
    }



    @ResponseBody
    @RequestMapping("/listParam")
    public List<String> listParam(@RequestParam List<String> likes) {
        System.out.println("集合参数传递: " + likes);
        return likes;
    }

    /**
     * JSON 请求 并返回JSON格式
     * @param likes
     * @return
     */
    @ResponseBody
    @RequestMapping("/listParamJson")
    public String listParamJson(@RequestBody List<String> likes) {
        System.out.println("集合参数传递: " + likes);
        return likes.toString();
    }

    @ResponseBody
    @RequestMapping("/hello")
    public List<String> hello() {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Go");
        return list;
    }

    @ResponseBody
    @RequestMapping("/userLogin2")
    public User userLogin2(User user) {
        System.out.println("user: " + user);
        return user;
    }

    @ResponseBody
    @RequestMapping("/userLoginJson")
    public String userLoginJson(@RequestBody User user) {
        System.out.println("user: " + user);
        return user.toString();
    }

    /**
     * REST 风格
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Integer getUserID(@PathVariable Integer id) {
        return id;
    }


}
