package net.biancheng.c.impl.postProcessor;

public class HelloWorld {
    private String message;
    public void setMessage(String message) {
        this.message = message;
    }
    public void getMessage() {
        System.out.println("Message : " + message);
    }
    public void init() {
        System.out.println("Bean 正在初始化");
    }
    public void destroy() {
        System.out.println("Bean 将要被销毁");
    }
}
