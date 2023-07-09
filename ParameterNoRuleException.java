package org.example.util.field;

public class ParameterNoRuleException extends RuntimeException{
    public static final String ERROR_MESSAGE = "Could not find any rule for specified parameter.";

    public ParameterNoRuleException() {
        super(ERROR_MESSAGE);
    }
}
