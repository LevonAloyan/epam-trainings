package com.epam.javatrainings.annotation.validator;

import com.epam.javatrainings.annotation.model.CustomerDto;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Validator {
  private final Map<String, String> error;

  public Validator() {
    this.error = new HashMap<>();
  }

  public <T extends CustomerDto> Map<String, String> validate(T customerDto) {
    Class<?> dto = customerDto.getClass();
    Field[] fields = dto.getDeclaredFields();
    for (Field field : fields) {
      error.putAll(new AnnotationTypeDetector().typeDetect(field, customerDto));
    }
    return error;
  }
}
