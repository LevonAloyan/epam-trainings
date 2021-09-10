package com.epam.javatrainings.validation.validator.registry;

import com.epam.javatrainings.validation.annotations.*;
import com.epam.javatrainings.validation.validator.*;

import java.lang.annotation.Annotation;
import java.util.Map;

public class Registry {
    private final  Map<Class<? extends Annotation>, Validator> map;
    private static Registry instance;

    public static Registry getInstance() {
        if(instance == null) {
            instance = new Registry();
        }
        return instance;
    }

    private Registry() {
        map = Map.of(
                Length.class, new LengthValidator(),
                Max.class, new MaxValidator(),
                Min.class, new MinValidator(),
                Email.class, new EmailValidator(),
                Adulthood.class, new AdulthoodValidator()
        );
    }

    public Validator getValidator(Class<? extends Annotation> clazz) {
        return map.get(clazz);
    }
}
