package com.epam.javatrainings.annotation.annotation_processors;

import com.epam.javatrainings.annotation.constants.Constants;

import java.time.LocalDate;
import java.time.Period;

public class AdulthoodAnnotationProcessor {
  public static boolean isAdulthoodValid(LocalDate birthDay) {
    if (birthDay != null) {
      return Period.between(birthDay, LocalDate.now()).getYears() < Constants.ADULTHOOD_AGE;
    }
    return false;
  }
}
