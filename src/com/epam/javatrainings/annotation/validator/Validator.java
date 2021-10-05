package com.epam.javatrainings.annotation.validator;

import com.epam.javatrainings.annotation.model.CustomerDto;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Validator {

  public <T extends CustomerDto> Map<String, String> validate(T customerDto) {
    final Map<String, String> error = new HashMap<>();
    Class<?> dto = customerDto.getClass();
    Field[] fields = dto.getDeclaredFields();
    for (Field field : fields) {
      error.putAll(new AnnotationTypeDetector().typeDetect(field, customerDto));
    }
    return error;
  }
}
