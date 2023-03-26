package net.biancheng.c.test;
import net.biancheng.c.impl.scope.PrototypeBean;
import net.biancheng.c.impl.scope.SingletonBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppScope {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("scope.xml");
        //获取名为 employee 的 Bean
        SingletonBean  singletonBean1 = context.getBean("singletonBean", SingletonBean.class);
        SingletonBean  singletonBean2 = context.getBean("singletonBean", SingletonBean.class);
        // 单例模式 结果一样
        System.out.println(singletonBean1);
        System.out.println(singletonBean2);

        System.out.println("\n");

        PrototypeBean prototypeBean = context.getBean("prototypeBean", PrototypeBean.class);
        PrototypeBean prototypeBean2 = context.getBean("prototypeBean", PrototypeBean.class);

        // 两次输出的内容并不相同 Spring 容器创建了两个不同的 prototypeBean 实例。
        System.out.println(prototypeBean);
        System.out.println(prototypeBean2);

        /**
         *
         net.biancheng.c.impl.scope.SingletonBean@6536e911
         net.biancheng.c.impl.scope.SingletonBean@6536e911


         net.biancheng.c.impl.scope.PrototypeBean@18eed359
         net.biancheng.c.impl.scope.PrototypeBean@3e9b1010
         */
    }
}
