package com.epam.javatrainings.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Length{
    int min();
    int max();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Email{

}
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Adulthood{

}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Min{
    int value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Max{
    int value();
}

