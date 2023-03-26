## BeanFactory 快速入门
上面使用BeanFactory完成了loC思想的实现，下面去实现以下DI依赖注入:
1. 定义UserDao接口及其UserDaolmpl实现类;
2. 修改UserServicelmpl代码，添加一个setUserDao(UserDao userDao)用于接收注入的对象;
3. 修改beans.xml配置文件，在UserDaolmpl的<bean>中嵌入<property>配置注入;
4. 修改测试代码，获得UserService时，setUserService方法执行了注入操作。