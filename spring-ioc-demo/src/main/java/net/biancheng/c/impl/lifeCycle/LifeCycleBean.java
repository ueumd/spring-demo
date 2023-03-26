package net.biancheng.c.impl.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 相比之下，Spring 中 Bean 的生命周期较复杂，大致可以分为以下 5 个阶段：
 * Bean 的实例化
 * Bean 属性赋值
 * Bean 的初始化
 * Bean 的使用
 * Bean 的销毁
 *
 * Spring 根据 Bean 的作用域来选择 Bean 的管理方式，
 * 对于 singleton 作用域的 Bean 来说，Spring IoC 容器能够精确地控制 Bean 何时被创建、何时初始化完成以及何时被销毁；
 * 对于 prototype 作用域的 Bean 来说，Spring IoC 容器只负责创建，然后就将 Bean 的实例交给客户端代码管理，Spring IoC 容器将不再跟踪其生命周期。
 */
public class LifeCycleBean implements InitializingBean, DisposableBean {
    //网站名称
    private String webName;
    //网站地址
    private String url;
    public void setWebName(String webName) {
        this.webName = webName;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Override
    public String toString() {
        return "LifeCycleBean{" +
                "webName='" + webName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    /**
     * 销毁回调逻辑
     *
     * @throws Exception
     */

    @Override
    public void destroy() throws Exception {
        System.out.println(" 调用接口：DisposableBean，方法：destroy，无参数");
    }

    /**
     * 初始化回调逻辑
     *
     * @throws Exception
     */

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用接口：InitializingBean，方法：afterPropertiesSet，无参数");
    }


    /**
     * 初始化回调方法
     */
    public void initMethod() {
        System.out.println("在 XML 配置中通过 init-method 属性指定初始化方法：init() 方法");
    }
    /**
     * 销毁回调方法
     */
    public void destroyMethod() {
        System.out.println("在 XML 配置中通过 destroy-method 属性指定回调方法：destroy() 方法");
    }

}
