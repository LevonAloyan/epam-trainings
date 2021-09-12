package com.epam.javatrainings.dtovalidation.annotationprocessor;

import com.epam.javatrainings.dtovalidation.exception.AnnotationProcessorFailedException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

public final class AnnotationProcessorResolver {
  private static final String SUFFIX = "AnnotationProcessor";
  private final Field field;
  private final Object dto;
  private final Class<? extends Annotation> annotationType;

  public AnnotationProcessorResolver(Annotation annotation, Field field, Object dto) {
    this.field = field;
    this.dto = dto;
    annotationType = annotation.annotationType();
  }

  public Method provideProcess() {
    Class<?> processorInstance = provideInstance();
    Method method;
    try {
      method =
          processorInstance.getDeclaredMethod(
              "validate", Object.class, String.class, Annotation.class);
      method.setAccessible(true);
    } catch (NoSuchMethodException e) {
      throw new AnnotationProcessorFailedException(
          "Failed to find a corresponding method", e.getCause());
    }
    return method;
  }

  private Class<?> provideInstance() {
    String processorName = getAnnotationProcessorName();
    return createInstance(processorName);
  }

  private String getDirPath() {
    Class<?> aClass = this.getClass();
    String name = aClass.getName();
    return name.substring(0, name.lastIndexOf('.'));
  }

  private String getAnnotationProcessorName() {
    int startIndex = annotationType.getName().lastIndexOf(".");
    String simpleName = annotationType.getName().substring(startIndex);
    return getDirPath().concat(simpleName).concat(SUFFIX);
  }

  private Class<?> createInstance(String processorName) {
    Class<?> processorInstance;
    try {
      processorInstance = Class.forName(processorName);
    } catch (ClassNotFoundException e) {
      throw new AnnotationProcessorFailedException(
          "Failed to instantiate AnnotationProcessor class with the given class name",
          e.getCause());
    }
    return processorInstance;
  }

  public Object getFieldValue() {
    field.setAccessible(true);
    Object value;
    try {
      value = field.get(dto);
    } catch (IllegalAccessException e) {
      throw new AnnotationProcessorFailedException("Failed to obtain FIELD VALUE", e.getCause());
    } finally {
      field.setAccessible(false);
    }
    return value;
  }
}
