package com.ueumd.tech;

import com.ueumd.tech.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //1.创建IoC容器对象，加载spring核心配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("BookServiceImpl.xml");

        //2 从IOC容器中获取Bean对象(BookService对象) 这里service对应的是xml id中的属性名
        BookService bookService= (BookService)ctx.getBean("bookService");

        //3 调用Bean对象(BookService对象)的方法
        bookService.save();

    }
}