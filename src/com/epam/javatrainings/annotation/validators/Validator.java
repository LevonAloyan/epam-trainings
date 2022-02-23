package com.epam.javatrainings.annotation.validators;

import com.epam.javatrainings.annotation.CustomerDto;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

public class Validator {
  static HashMap<String, String> errors = new HashMap<>();

  public static void validate(CustomerDto customer) throws NoSuchMethodException {
    Field[] fields = customer.getClass().getDeclaredFields();
    for (Field field : fields) {
      field.setAccessible(true);
      if (field.getDeclaredAnnotations().length > 0) {
        Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
        System.out.println("Field Name: " + field.getName() + "\n Annotations: ");
        for (Annotation annot : fieldAnnotations) {
          Class<? extends Annotation> clas = annot.getClass();
          Annotation annotation = field.getAnnotation(annot.getClass());
          Method method = clas.getDeclaredMethod(clas.getName());
          String message = (String) method.getDefaultValue();
          System.out.println(message);
        }

      } else {
        System.out.println("\"" + field.getName() + "\" has no annotations.\n");
      }
    }
  }
}
