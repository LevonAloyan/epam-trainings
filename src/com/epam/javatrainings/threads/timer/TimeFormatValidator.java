package com.epam.javatrainings.threads.timer;

import java.util.regex.Pattern;

public class TimeFormatValidator {
    public static final String timeSeparator = ":";
    private static final Pattern pattern = Pattern.compile("^([0-9]|[1-5][0-9]|)" + timeSeparator + "([0-9]|[1-5][0-9]|)$");

    private TimeFormatValidator() {
        throw new IllegalStateException("No instances");
    }

    static boolean isValid(String time) {
        return pattern.matcher(time).matches();
    }
}
