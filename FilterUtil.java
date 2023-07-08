package org.example.util.field;

import java.util.List;

public final class FilterUtil {

    private FilterUtil() {}

    public static void checkIfParameterHasValues(List<String> values) throws ParameterValueException {
        if(values.size() == 0)
            return;
        throw new ParameterValueException();
    }

    public static void checkIfParameterValuesRange(List<String> values) throws ParameterValueException {
        if(values.size() == 2)
            return;
        throw new ParameterValueException();
    }

    public static void checkIfParameterValueSingle(List<String> values) {
        if(values.size() == 1)
            return;
        throw new ParameterValueException();
    }

    public static Integer convertToInt(String value) throws NumberFormatException {
        return Integer.parseInt(value);
    }


}
