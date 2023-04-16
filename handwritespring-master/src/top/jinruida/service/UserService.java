package top.jinruida.service;/**
 * @author ae
 * @date 2022-03-21 20:14
 */

import top.jinruida.spring.*;

/**
 * @description: TODO
 * @author ae
 * @data 2022/3/21 20:14
 * @version 1.0
 */

@Component
@Scope("prototype")
public class UserService implements BeanNameAware, InitializingBean, UserInterface {

    @Autowired
    private OrderService orderService;

    private String beanName; // 通过回调机制，得到spring内部的属性

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void test(){
        System.out.println(orderService);
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public void afterPropertiesSet() {
        // 该Bean的相应初始化操作
        System.out.println("UserServiceBean初始化");
    }
}
