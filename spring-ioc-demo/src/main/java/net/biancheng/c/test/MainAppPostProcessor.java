package net.biancheng.c.test;
import net.biancheng.c.impl.postProcessor.HelloWorld;
import net.biancheng.c.impl.scope.PrototypeBean;
import net.biancheng.c.impl.scope.SingletonBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppPostProcessor {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("postProcessor.xml");

        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");

        helloWorld.getMessage();
        context.registerShutdownHook();

    }
}
