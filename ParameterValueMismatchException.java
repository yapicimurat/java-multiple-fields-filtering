package org.example.util.field;

public class ParameterValueMismatchException extends RuntimeException {
    public static final String ERROR_MESSAGE = "Amount of parameter values is not appropriate for the rule.";

    public ParameterValueMismatchException() {
        super(ERROR_MESSAGE);
    }

}
