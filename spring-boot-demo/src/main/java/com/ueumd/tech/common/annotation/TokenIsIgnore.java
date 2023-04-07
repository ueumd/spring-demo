package com.ueumd.tech.common.annotation;

import java.lang.annotation.*;

/**
 * ========================
 * token 验证是否忽略注解(有token校验，无token不校验)
 * Date：2020/06/08 18:00
 * ========================
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenIsIgnore {
}
