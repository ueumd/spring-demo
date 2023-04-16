package com.spring;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UeumdApplicationContext {
    private Class configClass;

    /**
     * 单例池
     */
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();

    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    public UeumdApplicationContext(Class configClass) {
        this.configClass = configClass;

        //解析配置类
        //ComponentScan 注解-- -> 扫描路径 ---> 扫描 --> beanDefinition ---> beanDefinitionMap
        scan(configClass);

        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();

            // 单例 bean
            if (beanDefinition.getScope().equals(ScopeEnum.singleton)) {
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }


    }

    public Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();
        try {


            // 实例化
            Constructor declaredConstructor = beanClass.getDeclaredConstructor();
            Object instance = declaredConstructor.newInstance();

            // 填充属性
            Field[] fields = beanClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    String fieldName = field.getName();
                    Object bean = getBean(fieldName);

                    field.setAccessible(true);
                    field.set(instance, bean);
                }
            }

            // Aware回调
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware)instance).setBeanName(beanName);
            }

            // 初始化
            if (instance instanceof InitializingBean) {
                ((InitializingBean)instance).afterPropertiesSet();
            }

            for (BeanPostProcessor beanPostProcessor: beanPostProcessorList) {
                beanPostProcessor.postProcessAfterInitialization(beanName, instance);
            }

            return instance;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private void scan(Class configClass) {
        //解析配置类
        //ComponentScan 注解 -》 扫描路径 -> 扫描

        ComponentScan componentScanAnnotation = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);

        String path = componentScanAnnotation.value();
        System.out.println(path); // com.ueumd.service

        // 扫描
        // 类加载器
        // BootStrap -----> jre/lib
        // Ext -----------> jre/ext/lib
        // App -----------> classpath ----->

        ClassLoader classLoader = UeumdApplicationContext.class.getClassLoader(); // app
        URL resource = classLoader.getResource("com/ueumd/service");
        File file = new File(resource.getFile());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {

                // E:\\coding\\spring-demo\\spring-code\\target\\classes\\com\\ueumd\\service\\UserService.class
                // System.out.println(f.getAbsolutePath());


                /**
                 *  E:\\coding\\spring-demo\\spring-code\\target\\classes\\com\\ueumd\\service\\UserService.class
                 *  转成如下
                 *  com.ueumd.service.UserService
                 */

                String fileName = f.getAbsolutePath();
                String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
                className = className.replace("\\", ".");
                System.out.println(className);

                try {
                    Class<?> clazz = classLoader.loadClass(className);
                    if (clazz.isAnnotationPresent(Component.class)) {
                        // 有Component注解， 表示当前类是一个bean
                        // 解析类 判断当前是bean是 singleton 还是 prototype

                        Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);

                        String beanName = componentAnnotation.value();

                        BeanDefinition beanDefinition = new BeanDefinition();
                        beanDefinition.setBeanClass(clazz);

                        // 是否有scope注解
                        if (clazz.isAnnotationPresent(Scope.class)) {
                            Scope scope = (Scope) clazz.getAnnotation(Scope.class);
                            String scopeValue = scope.value();

                            if (ScopeEnum.singleton.name().equals(scopeValue)) {
                                beanDefinition.setScope(ScopeEnum.singleton);
                            } else {
                                beanDefinition.setScope(ScopeEnum.prototype);
                            }

                        } else {
                            beanDefinition.setScope(ScopeEnum.singleton);
                        }

                        // 存入
                        beanDefinitionMap.put(beanName, beanDefinition);


                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Object getBean(String beanName) {
        if (beanDefinitionMap.containsKey(beanName)) {

            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

            if (beanDefinition.getScope().equals(ScopeEnum.singleton)) {
                Object o = singletonObjects.get(beanName);
                return o;
            } else {
                // prototype
                // create bean object
                Object bean = createBean(beanName, beanDefinition);
                return bean;

            }

        } else {
            throw  new NullPointerException();
        }
    }
}
