package com.epam.javatrainings.annotation.annotation_processors;

import com.epam.javatrainings.annotation.constants.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAnnotationProcessor {
  private static final Pattern EMAIL_ADDRESS =
      Pattern.compile(Constants.EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

  public static boolean isEmailValid(String email) {
    Matcher matcher = EMAIL_ADDRESS.matcher(email);
    return matcher.find();
  }
}
