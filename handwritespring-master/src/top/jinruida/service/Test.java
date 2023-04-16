package top.jinruida.service;/**
 * @author ae
 * @date 2022-03-21 20:03
 */

import top.jinruida.spring.ZhouyuApplicationContext;

/**
 * @description: 测试自己手写的Spring的功能
 * @author ae
 * @data 2022/3/21 20:03
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        ZhouyuApplicationContext applicationContext = new ZhouyuApplicationContext(AppConfig.class);

        UserInterface userService = (UserInterface) applicationContext.getBean("userService");
        userService.test();
    }
}
