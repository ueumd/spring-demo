package net.biancheng.c.test;
import net.biancheng.c.impl.lifeCycle.AnnotationLifeCycleBean;
import net.biancheng.c.impl.lifeCycle.LifeCycleBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppLifeCycle {
    public static void main(String[] args) {
        // ApplicationContext context = new ClassPathXmlApplicationContext("lifeCycle.xml");
        ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("lifeCycle.xml");
        // 通过接口实现 生命周期回调方法
        LifeCycleBean lifeCycleBean = context.getBean("lifeCycleBean", LifeCycleBean.class);
        System.out.println(lifeCycleBean);

        System.out.println("\n");


        // 通过 XML 配置指定生命周期回调方法
        LifeCycleBean lifeCycleBean2 = context.getBean("lifeCycleBeanDemo", LifeCycleBean.class);
        System.out.println(lifeCycleBean2);

        System.out.println("\n");

        // 通过 注解 配置指定生命周期回调方法
        AnnotationLifeCycleBean annotationLifeCycleBean = context.getBean("annotationLifeCycleBean", AnnotationLifeCycleBean.class);
        System.out.println(annotationLifeCycleBean);

        // 手动销毁 Bean
         context.close();
    }
}
