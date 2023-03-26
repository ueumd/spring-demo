package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(){
        System.out.println("UserServiceImpl实例化");
    }

    public UserServiceImpl(String name, String age) {
        System.out.println(name);
        System.out.println(age);
    }


    public void init() {
        System.out.println("初始化方法...");
    }

    public void destroy() {
        System.out.println("销毁方法...");
    }

    public void  setUserDao(UserDao userDao) {
        System.out.println("BeanFactory 去调用该方法获得useDao设置到此处："+ userDao);
        this.userDao = userDao;
    }

}
