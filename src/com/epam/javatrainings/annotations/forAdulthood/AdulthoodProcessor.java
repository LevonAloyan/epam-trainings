package com.epam.javatrainings.annotations.forAdulthood;

import com.epam.javatrainings.annotations.exceptions.NotAdulthoodException;
import com.epam.javatrainings.annotations.util.ClassFinder;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdulthoodProcessor {
    public void doProcess(String scanPackage, LocalDate localDate) throws IllegalAccessException, IOException,
            ClassNotFoundException, InvocationTargetException, InstantiationException, NoSuchMethodException, NotAdulthoodException {
        List<Field> fields = getAnnotatedFields(scanPackage);
        for (Field field : fields) {
            field.setAccessible(true);
            Object obj = field.getDeclaringClass().getDeclaredConstructor().newInstance();
            if (LocalDate.now().getYear() - localDate.getYear() > 18) {
                field.set(obj, localDate);
            } else throw new NotAdulthoodException("You are not greater than 18");
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
                if (annotation instanceof Adulthood) {
                    filteredFields.add(field);
                    break;
                }
            }
        }
    }
}
