package com.epam.javatrainings.annotation.annotation_processors;

import com.epam.javatrainings.annotation.custom_annotations.Length;

public class LengthAnnotationProcessor {

  public static boolean isLengthValid(Length length, String name) {
    if (name == null) {
      return false;
    } else return name.length() >= length.min() && name.length() <= length.max();
  }
}
