package com.epam.javatrainings.annotations.forDiscountMinMax;

import com.epam.javatrainings.annotations.exceptions.InvalidNumberException;
import com.epam.javatrainings.annotations.util.ClassFinder;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxProcessor {
    public void doProcess(String scanPackage, Integer myValue) throws IllegalAccessException, IOException,
            ClassNotFoundException, InvocationTargetException, InstantiationException, NoSuchMethodException, InvalidNumberException {
        List<Field> fields = getAnnotatedFields(scanPackage);
        for (Field field : fields) {
            field.setAccessible(true);
            Object obj = field.getDeclaringClass().getDeclaredConstructor().newInstance();
            int max = field.getAnnotation(Max.class).value();
            if (myValue < max) {
                field.set(obj, myValue);
            } else throw new InvalidNumberException("Your number don't support about discount");
            System.out.print(field.getName() + ": ");
            System.out.println(field.get(obj).toString());
        }

    }

    private List<Field> getAnnotatedFields(String packageName) throws IOException, ClassNotFoundException {
        ArrayList<Class<?>> classes = ClassFinder.getClass(packageName);
        List<Field> filteredFields = new LinkedList<>();
        for (Class<?> _class : classes) {
            Field[] fields = _class.getDeclaredFields();
            filterAnnotatedFields(filteredFields, fields);
        }
        return filteredFields;
    }

    private void filterAnnotatedFields(List<Field> filteredFields, Field[] fields) {
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Max) {
                    filteredFields.add(field);
                    break;
                }
            }
        }
    }
}
