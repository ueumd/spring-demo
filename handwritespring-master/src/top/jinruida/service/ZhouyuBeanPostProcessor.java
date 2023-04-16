package top.jinruida.service;

import top.jinruida.spring.BeanPostProcessor;
import top.jinruida.spring.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class ZhouyuBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessorBeforeInitialization(String beanName, Object bean) {
        if ("userService".equals(beanName)){
            System.out.println("userService的初始化前后置处理器使用");
        }
        return bean;
    }

    @Override
    public Object postProcessorAfterInitialization(String beanName, Object bean) {
        if ("userService".equals(beanName)){
            System.out.println("userService的初始化后后置处理器使用");
            Object proxyInstance = Proxy.newProxyInstance(ZhouyuBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("切面代理逻辑");
                    return method.invoke(bean, args); // 调用的是接口中test方法
                }
            });
            return proxyInstance;
        }
        return bean;
    }
}
