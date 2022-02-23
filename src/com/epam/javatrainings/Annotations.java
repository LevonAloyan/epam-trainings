package com.epam.javatrainings;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Length{
    int min();
    int max();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Email{
}

@Retention(RetentionPolicy.RUNTIME)
@interface Adulthood {
}

@Retention(RetentionPolicy.RUNTIME)
@interface Min{
    int value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Max{
    int value();
}



