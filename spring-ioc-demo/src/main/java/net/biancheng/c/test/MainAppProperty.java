package net.biancheng.c.test;

import net.biancheng.c.impl.Employee;
import net.biancheng.c.impl.HelloWorld;
import net.biancheng.c.impl.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppProperty {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-property.xml");

        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
        helloWorld.getMessage();


        Student student = (Student) context.getBean("student");

        String stu = student.toString();
        System.out.println(stu);


        //获取名为 employee 的 Bean
        Employee employee = context.getBean("employee", Employee.class);
        //通过日志打印员工信息
        String str1 = employee.toString();
        System.out.println(str1);

    }
}
