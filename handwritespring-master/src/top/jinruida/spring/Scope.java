package top.jinruida.spring;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 生效的时期
@Target(ElementType.TYPE) // 只能在类上
public @interface Scope {
    String value() default "";
}
