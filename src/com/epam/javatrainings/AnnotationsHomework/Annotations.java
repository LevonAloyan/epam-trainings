package com.epam.javatrainings.AnnotationsHomework;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Length{
    int min();
    int max();
}
@Retention(RetentionPolicy.RUNTIME)
@interface Email{
    String regex() default "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
}
@Retention(RetentionPolicy.RUNTIME)
@interface  Adulthood{
    int value() default 18;
}
@Retention(RetentionPolicy.RUNTIME)
@interface Min{
    int value();
}
@Retention(RetentionPolicy.RUNTIME)
@interface Max{
    int value();
}







