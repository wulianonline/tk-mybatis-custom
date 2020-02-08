package com.wulian.tkmybatis.annotation;

import java.lang.annotation.*;

/**
 * @Description 该注解标识某些数据字段只在dev环境才有
 * @Author xiaolin
 * @Date 2020/2/8 15:59
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DevActive {

}
