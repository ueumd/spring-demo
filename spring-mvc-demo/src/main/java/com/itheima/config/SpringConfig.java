package com.itheima.config;


import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration

/**
 * @ComponentScan({"com.itheima.service","com.itheima.dao"})
 * 设置spring配置类加载bean时的过滤规则，当前要求排除掉表现层对应的bean
 * excludeFilters属性：设置扫描加载bean时，排除的过滤规则
 * type属性：设置排除规则，当前使用按照bean定义时的注解类型进行排除
 * classes属性：设置排除的具体注解类，当前设置排除@Controller定义的bean
 *
 * 过滤掉controller包下面所有类
 */
//@ComponentScan(
//        value = "com.itheima",
//        excludeFilters = @ComponentScan.Filter(
//                type = FilterType.ANNOTATION,
//                classes = Controller.class
//        )
//)

@ComponentScan({"com.itheima.service"})
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, MyBatisConfig.class})
@EnableTransactionManagement
public class SpringConfig {
}
