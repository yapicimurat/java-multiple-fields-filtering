package org.example.util;

import org.example.model.BaseModel;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Field<T> {
    private final String name;
    private final String targetFieldName;
    private final Predicate<T> condition;
    private final List<Object> values;

    public Field(String name, String targetFieldName, List<Object> values, Predicate<T> condition) {
        this.name = name;
        this.targetFieldName = targetFieldName;
        this.values = values;
        this.condition = condition;
    }

    public Stream<T> perform(Stream<T> input) {
        return input.filter(condition);
    }


}
