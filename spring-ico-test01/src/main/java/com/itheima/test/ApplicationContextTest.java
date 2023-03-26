package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ApplicationContext快速入门
 * ApplicationContext 称为Spring容器，内部封装了BeanFactory，比BeanFactory功能更丰富更强大，
 * 使用ApplicationContext 进行开发时，xml配置文件的名称习惯写成applicationContext.xml
 *
 *
 * 只在Spring基础环境下，常用的三个ApplicationContext作用如下:
 * 实现类如下：
 * ClassPathXmlApplicationContext       加载类路径下的xml配置的ApplicationContext
 * FileSystemXmlApplicationContext      加载磁盘路径下的xml配置的ApplicationContext
 * AnnotationConfigApplicationContext   加载注解配置类的ApplicationContext
 *
 *
 */
public class ApplicationContextTest {
    public static void main(String[] args) {
        // 加载类路径下的xml配置的ApplicationContext
        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 根据ID获取Bean实例对象
        UserService userService = (UserService) applicationContext.getBean("helloUserService");
        System.out.println(userService);


        UserDao userDao = (UserDao) applicationContext.getBean("helloUserDao");
        System.out.println(userDao);


        UserDao userDao1 = (UserDao) applicationContext.getBean("userDao1");
        System.out.println("userDao1: " + userDao1);



        // 容器关闭 销毁方法
        applicationContext.close();
    }
}
