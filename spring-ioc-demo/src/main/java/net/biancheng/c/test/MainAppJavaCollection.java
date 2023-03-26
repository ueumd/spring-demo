package net.biancheng.c.test;

import net.biancheng.c.impl.JavaCollection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppJavaCollection {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("javaCollection.xml");
        //获取名为 employee 的 Bean
        JavaCollection javaCollection = context.getBean("javaCollection", JavaCollection.class);
        //通过日志打印员工信息
        String str1 = javaCollection.toString();
        System.out.println(str1);

    }
}
