package com.epam.javatrainings.dtovalidation;

import com.epam.javatrainings.dtovalidation.error.FieldError;
import com.epam.javatrainings.dtovalidation.error.ValidationError;
import com.epam.javatrainings.dtovalidation.annotation.Validation;
import com.epam.javatrainings.dtovalidation.exception.ValidatorFailedException;
import com.epam.javatrainings.dtovalidation.annotationprocessor.AnnotationProcessorResolver;

import java.util.Optional;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

public class Validator {

  public Optional<ValidationError> validate(Object dto) {

    Optional<ValidationError> validationError = Optional.of(new ValidationError());

    for (Field field : dto.getClass().getDeclaredFields()) {
      for (Annotation a : field.getDeclaredAnnotations()) {
        if (a.annotationType().isAnnotationPresent(Validation.class)) {
          // this field has to be validated
          AnnotationProcessorResolver resolver = new AnnotationProcessorResolver(a, field, dto);
          Method process = resolver.provideProcess();
          Optional<FieldError> fieldError;
          try {
            fieldError =
                (Optional<FieldError>)
                    process.invoke(a, resolver.getFieldValue(), field.getName(), a);
          } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ValidatorFailedException(
                "Something weird happened during PROCESS execution", e.getCause());
          }
          if (!fieldError.isEmpty()) {
            validationError.get().addFieldError(new FieldError(fieldError.get()));
          }
        }
      }
    }

    return validationError.get().getErrorCount() > 0 ? validationError : Optional.empty();
  }
}
