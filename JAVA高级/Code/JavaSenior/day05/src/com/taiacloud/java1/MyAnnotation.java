package com.taiacloud.java1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author taia
 * @creat 2021-10-19-17:35
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})

@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotation {

    String value() default "hello";
}
