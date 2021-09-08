package com.epam.javatrainings.annotation.validator;

import com.epam.javatrainings.annotation.annotation_processors.*;
import com.epam.javatrainings.annotation.custom_annotations.*;
import com.epam.javatrainings.annotation.model.CustomerDto;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class AnnotationTypeDetector {
  static Map<String, String> error = new HashMap<>();

  static <T extends CustomerDto> Map<String, String> typeDetect(Field field, T customerDtoT) {
    if (field.isAnnotationPresent(Length.class)) {
      if (!LengthAnnotationProcessor.isLengthValid(
          field.getAnnotation(Length.class), customerDtoT.getName())) {
        error.put(field.getName(), "Length not valid");
      }
    } else if (field.isAnnotationPresent(Max.class)) {
      if (!MaxAnnotationProcessor.isMaxValid(
          field.getAnnotation(Max.class), customerDtoT.getDiscountRate())) {
        error.put(field.getName(), "Field value is greater than maximum value ");
      }
    } else if (field.isAnnotationPresent(Min.class)) {
      if (!MinAnnotationProcessor.isMinValid(
          field.getAnnotation(Min.class), customerDtoT.getDiscountRate())) {
        error.put(field.getName(), "Field value is less than minimum value");
      }
    } else if (field.isAnnotationPresent(Email.class)) {
      if (!EmailAnnotationProcessor.isEmailValid(customerDtoT.getEmail())) {
        error.put(field.getName(), "Email address is incorrect");
      }
    } else if (!field.isAnnotationPresent(Adulthood.class)) {
      if (!AdulthoodAnnotationProcessor.isAdulthoodValid(customerDtoT.getBirthDay())) {
        error.put(field.getName(), "Invalid Adult");
      }
    }
    return error;
  }
}
