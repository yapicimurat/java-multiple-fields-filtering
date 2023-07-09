package com.example.filter;

public class ParameterConvertException extends RuntimeException {
    public static final String ERROR_MESSAGE = "Parameter cannot be converted to the required type.";

    public ParameterConvertException() {
        super(ERROR_MESSAGE);
    }
}
