package net.biancheng.c.impl.lifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 使用注解实现 生命周期回调方法
 */
public class AnnotationLifeCycleBean {
    //网站名称
    private String webName;
    //网站地址
    private String url;
    public AnnotationLifeCycleBean(String webName, String url) {
        this.webName = webName;
        this.url = url;
    }

    @Override
    public String toString() {
        return "AnnotationLifeCycleBean{" +
                "webName='" + webName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    /**
     * 初始化回调方法
     */
    @PostConstruct
    public void init() {
        System.out.println("通过 @PostConstruct 注解，指定初始化方法：init() 方法");
    }

    /**
     * 销毁回调方法
     */
    @PreDestroy
    public void destroy() {
        System.out.println("通过 @PreDestroy 注解，指定初始化方法：destroy() 方法");
    }

}
