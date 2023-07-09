package com.example.filter;

import com.example.filter.exception.ParameterValueMismatchException;

import java.util.List;

public final class FilterUtil {

    private FilterUtil() {}

    public static void checkIfParameterHasValues(List<String> values) throws ParameterValueMismatchException {
        if(values.size() == 0)
            return;
        throw new ParameterValueMismatchException();
    }

    public static void checkIfParameterValuesRange(List<String> values) throws ParameterValueMismatchException {
        if(values.size() == 2)
            return;
        throw new ParameterValueMismatchException();
    }

    public static void checkIfParameterValueSingle(List<String> values) {
        if(values.size() == 1)
            return;
        throw new ParameterValueMismatchException();
    }

    public static Integer convertToInt(String value) throws NumberFormatException {
        return Integer.parseInt(value);
    }


}
