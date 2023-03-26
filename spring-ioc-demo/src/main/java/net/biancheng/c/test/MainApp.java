package net.biancheng.c.test;

import net.biancheng.c.impl.HelloWorld;
import net.biancheng.c.impl.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
        helloWorld.getMessage();


        Student student = (Student) context.getBean("student");

        student.toString();
    }
}
