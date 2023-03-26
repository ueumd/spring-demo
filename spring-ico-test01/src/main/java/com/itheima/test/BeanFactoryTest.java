package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Arrays;

/**
 * ## BeanFactory 快速入门
 * 上面使用BeanFactory完成了loC思想的实现，下面去实现以下DI依赖注入:
 * 1. 定义UserDao接口及其UserDaolmpl实现类;
 * 2. 修改UserServicelmpl代码，添加一个setUserDao(UserDao userDao)用于接收注入的对象;
 * 3. 修改beans.xml配置文件，在UserDaolmpl的<bean>中嵌入<property>配置注入;
 * 4. 修改测试代码，获得UserService时，setUserService方法执行了注入操作。
 *
 * 开始中基本不使用BeanFactory
 */

public class BeanFactoryTest {
    public static void main(String[] args) {
        // 创建工厂对象
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 创建一个读取器 xml文件
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        // 读取配置文件给工厂
        reader.loadBeanDefinitions("beans.xml");

        // 根据ID获取Bean实例对象
        UserService userService = (UserService) beanFactory.getBean("helloUserService");
        System.out.println(userService);

        UserDao userDao = (UserDao) beanFactory.getBean("helloUserDao");
        System.out.println(userDao);
    }
}
