package com.ly.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//在运行期生效
@Retention(RetentionPolicy.RUNTIME)
//修饰方法 该注解对谁有效
@Target(ElementType.METHOD)
public @interface CacheFind {
    /**
     * //用户可以不写,如果为空串表示自动生成key
     * @return
     */
    String key() default "";

    /**
     * 0表示用户设置该数据不需要超时时间,如果不等于0则说明用户自己定义了超时时间
     * @return
     */
    int seconds() default 0;

}



