package com.epam.javatrainings.annotations.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private Validator() {

    }

    public static List<String> validate(CustomerDto customer) throws IllegalAccessException {
        List<String> errors = new ArrayList<String>();

        // Get Class object corresponding to customer object
        Class<?> customerClass = customer.getClass();

        // Get fields of the customer class
        Field [] fields = customerClass.getDeclaredFields();
        for (Field field : fields) {
            errors.addAll(validateField(field, customer));
        }

        return errors;
    }

    private static List<String> validateField(Field field, CustomerDto customer) throws IllegalAccessException {
        List<String> fieldErrors = new ArrayList<String>();

        // If the field is declared as private change its accessibility in order to read field's value
        field.setAccessible(true);

        Annotation[] annotations = field.getAnnotations();
        for (Annotation annotation : annotations) {
            String valMessage = null;
            Object fieldValue = field.get(customer);

            if (annotation instanceof Length) {
                valMessage = validateLength((Length) annotation, (String) fieldValue);
            } else if (annotation instanceof Min) {
                valMessage = validateMin((Min) annotation, (int) fieldValue);
            } else if (annotation instanceof Max) {
                valMessage = validateMax((Max) annotation, (int) fieldValue);
            } else if (annotation instanceof Email) {
                valMessage = validateEmail((Email) annotation, (String) fieldValue);
            } else if (annotation instanceof Adulthood) {
                valMessage = validateAdulthood((Adulthood) annotation, (LocalDate) fieldValue);
            }

            if (valMessage != null) {
                fieldErrors.add("Field Name: " + field.getName() + ". Field value: " + fieldValue + ". Message: " + valMessage);
            }

        }

        return fieldErrors;
    }

    private static String validateAdulthood(Adulthood annotation, LocalDate fieldValue) {
        Period period = Period.between(fieldValue, LocalDate.now());
        int age = period.getYears();

        if (age < 18) {
            return "The client has not reached the age of majority. The age is "  + age + " years.";
        }

        return null;
    }

    private static String validateEmail(Email annotation, String fieldValue) {
        // TO DO - check if regexp works, see https://www.freeformatter.com/java-regex-tester.html#ad-output
        final String emailRegex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$ ";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(fieldValue);

        if (!matcher.matches()) {
            return "Field value is not matching to the predefined regular expression.";
        }

        return null;
    }

    private static String validateMax(Max annotation, int fieldValue) {
        int max = annotation.val();

        if (fieldValue > max) {
            return "Field value is greater than maximum value "  + max + ".";
        }

        return null;
    }

    private static String validateMin(Min annotation, int fieldValue) {
        int min = annotation.val();

        if (fieldValue < min) {
            return "Field value is less than minimum value "  + min + ".";
        }

        return null;
    }

    private static String validateLength(Length annotation, String name) {
        int nameLength = name.length();
        int min = annotation.min();
        int max = annotation.max();

        if (nameLength < min || nameLength > max) {
            return "The length of the field value is out of the range [" + min + ", " + max + "].";
        }

        return null;
    }
}
