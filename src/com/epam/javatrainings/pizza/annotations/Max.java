package com.epam.javatrainings.pizza.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Max {
    String message() default "The specified value must be maximum 100";
    int value() default 100;
}
