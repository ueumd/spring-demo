package top.jinruida.spring;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 生效的时期
@Target(ElementType.FIELD) // 写在字段上
public @interface Autowired {

}
