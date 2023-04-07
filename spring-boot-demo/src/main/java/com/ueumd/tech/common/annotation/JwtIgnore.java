package com.ueumd.tech.common.annotation;

import java.lang.annotation.*;

/**
 * ========================
 * JWT验证忽略注解
 * Date：2020/06/08 18:00
 * ========================
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtIgnore {
}
