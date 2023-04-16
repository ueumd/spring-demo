package top.jinruida.spring;/**
 * @author ae
 * @date 2022-03-21 20:07
 */

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ae
 * @version 1.0
 * @description: TODO
 * @data 2022/3/21 20:07
 */
public class ZhouyuApplicationContext {

    private Class configClass;

    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ArrayList<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    public ZhouyuApplicationContext(Class configClass) {
        this.configClass = configClass;

        // 扫描
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String path = componentScanAnnotation.value(); // 扫描路径 top.jinruida.service

            // 真正要的是该目录下的Class文件，怎么找过去
            path = path.replace(".", "/"); // 拿到相对路径 top/jinruida/service
            ClassLoader classLoader = ZhouyuApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path); // 拼出来的该包，其中有Class文件
            File file = new File(resource.getFile());
//            System.out.println(file);

            if (file.isDirectory()) { // 该包是一个目录，拿出其中的文件
                File[] files = file.listFiles();
                for (File f : files) {
                    // 筛选出Class文件
                    String fileName = f.getAbsolutePath(); // 包含了名字和文件类型
//                    System.out.println(fileName);

                    if (fileName.endsWith(".class")) {
                        // 筛选出是Bean对象
                        // 先要按照全类名加载类，然后看他有没有被@Component注解，路径转全类名
                        // 生成一个BeanDefinition对象

                        // 路径转成全类名
                        String className = fileName.substring(fileName.indexOf("top"), fileName.indexOf(".class"));
                        className = className.replace("\\", ".");

                        try {
                            Class<?> clazz = classLoader.loadClass(className);

                            if (clazz.isAnnotationPresent(Component.class)) { // 是Bean
                                // 如果该clazz被Component注解了，同时也是BeanPostProcessor
                                if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                    BeanPostProcessor instance = (BeanPostProcessor) clazz.newInstance();
                                    beanPostProcessorList.add(instance);
                                }

                                Component component = clazz.getAnnotation(Component.class);
                                String beanName = component.value();

                                // 在@Component中不写beanName的情况,用bean类名的简单名字的首字母小写
                                if ("".equals(beanName)) {
                                    beanName = Introspector.decapitalize(clazz.getSimpleName());
                                }

                                BeanDefinition beanDefinition = new BeanDefinition();
                                beanDefinition.setType(clazz);

                                // Bean的类型，单例还是多例
                                if (clazz.isAnnotationPresent(Scope.class)) {
                                    Scope scopeAnnotation = clazz.getAnnotation(Scope.class);
                                    beanDefinition.setScope(scopeAnnotation.value());
                                } else {
                                    // 默认单例
                                    beanDefinition.setScope("singleton");
                                }
                                beanDefinitionMap.put(beanName, beanDefinition);
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        // 扫描完成之后把其中的单例bean拿出来创建出来,实例化单例bean
        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

            if (beanDefinition.getScope().equals("singleton")) {
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }
    }

    // Bean的创建过程
    private Object createBean(String beanName, BeanDefinition beanDefinition){

        Class clazz = beanDefinition.getType();

        try {
            // 1. 创建实例
            Object instance = clazz.getConstructor().newInstance();
            // 2. 依赖注入
            for (Field f : clazz.getDeclaredFields()) {
                if (f.isAnnotationPresent(Autowired.class)) {
                    f.setAccessible(true);
                    f.set(instance, getBean(f.getName())); // 给该实例的该字段赋值
                }
            }
            // 3. Aware回调
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName(beanName); // 该实现类对象调用的是自己的方法
            }
            // 5.1 检查初始化前的后置处理
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                instance = beanPostProcessor.postProcessorBeforeInitialization(beanName, instance);
            }

            // 4. Bean初始化
            if (instance instanceof InitializingBean) {
                ((InitializingBean) instance).afterPropertiesSet(); // 向上转型，但是还是调的自己的方法，该Bean的初始化操作
            }
            // 5.1 检查初始化后的后置处理
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                instance = beanPostProcessor.postProcessorAfterInitialization(beanName, instance);
            }

            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Object getBean(String beanName) {

        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        if (beanDefinition == null) {
            throw new NullPointerException();
        } else {
            String scope = beanDefinition.getScope();
            if (scope.equals("singleton")) {
                // 单例
                Object bean = singletonObjects.get(beanName);
                // 这段代码的作用是：当前bean中注入的bean还没有实例化，那么注入的时候使用getBean的时候为null，此处创建
                if (bean == null) {
                    Object o = createBean(beanName, beanDefinition);
                    singletonObjects.put(beanName, o);
                    return o;
                }
                return bean;
            } else {
                // 多例
                return createBean(beanName, beanDefinition);
            }
        }
    }
}
