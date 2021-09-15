package com.epam.javatrainings.annotations.forLength;

import com.epam.javatrainings.annotations.exceptions.InvalidLengthException;
import com.epam.javatrainings.annotations.util.ClassFinder;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class LengthProcessor {
    public void doProcess(String scanPackage, String string) throws IllegalAccessException, IOException,
            ClassNotFoundException, InvocationTargetException, InstantiationException, NoSuchMethodException, InvalidLengthException {
        List<Field> fields = getAnnotatedFields(scanPackage);
        for (Field field : fields) {
            field.setAccessible(true);
            Object obj = field.getDeclaringClass().getDeclaredConstructor().newInstance();
            int min = field.getAnnotation(Length.class).min();
            int max = field.getAnnotation(Length.class).max();
            if (string.length() >= min && string.length() <= max) {
                field.set(obj, string);
            } else throw new InvalidLengthException("Name length have to me range of from " + min  + " to " + max);
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
                if (annotation instanceof Length) {
                    filteredFields.add(field);
                    break;
                }
            }
        }
    }
}
