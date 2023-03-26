package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.beans.factory.InitializingBean;

public class UserDaoImpl implements UserDao, InitializingBean {
    public UserDaoImpl() {
        System.out.println("UserDao 创建了...");
    }

   public void init() {
       System.out.println("UserDao 初始化方法...");
   }

    public void destroy() {
        System.out.println("UserDao 销毁方法...");
    }

    /**
     * 生命周期相关
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UserDao afterPropertiesSet执行");
    }
}
