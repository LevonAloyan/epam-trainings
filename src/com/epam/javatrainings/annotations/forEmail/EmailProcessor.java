package com.epam.javatrainings.annotations.forEmail;

import com.epam.javatrainings.annotations.exceptions.InvalidEmailException;
import com.epam.javatrainings.annotations.forLength.Length;
import com.epam.javatrainings.annotations.util.ClassFinder;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailProcessor {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$",
            Pattern.CASE_INSENSITIVE);

    public void doProcess(String scanPackage, String string) throws IllegalAccessException, IOException,
            ClassNotFoundException, InvocationTargetException, InstantiationException, NoSuchMethodException, InvalidEmailException {
        List<Field> fields = getAnnotatedFields(scanPackage);
        for (Field field : fields) {
            field.setAccessible(true);
            Object obj = field.getDeclaringClass().getDeclaredConstructor().newInstance();
            Matcher matcher = EMAIL_PATTERN.matcher(string);
            if (matcher.matches()) {
                field.set(obj, string);
            } else throw new InvalidEmailException("Please write correct mail.");
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
                if (annotation instanceof Email) {
                    filteredFields.add(field);
                    break;
                }
            }
        }
    }
}
