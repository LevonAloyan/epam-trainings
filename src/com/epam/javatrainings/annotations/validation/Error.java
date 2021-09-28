package com.epam.javatrainings.annotations.validation;

public class Error {
    private String fieldName;
    private String fieldValue;
    private String errorMessage;

    public Error(String fieldName, String fieldValue, String errorMessage) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.errorMessage = errorMessage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getValidationErrorMessage() {
        return "Field Name: " + this.fieldName + ". Field value: " + this.fieldValue + ". Message: " + this.errorMessage;
    }
}
