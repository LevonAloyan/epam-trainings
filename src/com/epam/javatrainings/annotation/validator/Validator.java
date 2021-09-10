package com.epam.javatrainings.annotation.validator;

import com.epam.javatrainings.annotation.model.CustomerDto;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Validator {
  static Map<String, String> error = new HashMap<>();

  public static <T extends CustomerDto> Map<String, String> validate(T customerDto) {
    error.clear();
    Class<?> dto = customerDto.getClass();
    Field[] fields = dto.getDeclaredFields();
    for (Field field : fields) {
      error.putAll(AnnotationTypeDetector.typeDetect(field, customerDto));
    }
    return error;
  }
}
