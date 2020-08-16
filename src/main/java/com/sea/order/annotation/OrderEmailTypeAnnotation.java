package com.sea.order.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  @description: 发送订单邮件类型注解
 *  @author: Sea
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderEmailTypeAnnotation {
    int type() default 1;
}