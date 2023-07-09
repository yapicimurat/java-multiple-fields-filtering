package com.example.filter.exception;

public class ParameterValueException extends RuntimeException {
    public static final String ERROR_MESSAGE = "Amount of parameter values is not appropriate for the rule.";

    public ParameterValueException() {
        super(ERROR_MESSAGE);
    }

}
