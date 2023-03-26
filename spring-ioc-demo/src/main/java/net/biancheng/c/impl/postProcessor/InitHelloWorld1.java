package net.biancheng.c.impl.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class InitHelloWorld1 implements BeanPostProcessor, Ordered {
    @Override
    public int getOrder() {
        return 5;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("InitHelloWorld1 A Before : " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
        System.out.println("InitHelloWorld1 A After : " + beanName);
        return bean;
    }
}
