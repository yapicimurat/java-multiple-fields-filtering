package org.example.util.field;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum FilterRule {
    NUMBER_SINGLE_EQUALS{
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) throws Exception {
            if(values.size() > 0) {
                int number = Integer.parseInt(values.get(0));

                return stream.filter(entity -> {
                    Field field = null;
                    try {
                        field = entity.getClass().getDeclaredField(fieldName);

                        return field.getInt(entity) == number;
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            }
            //if values parameter does not have any value throw exception
            throw new Exception();
        }
    },//x = 5
    NUMBER_SINGLE_GREATER_OR_EQUALS {
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) throws Exception {
            if(values.size() > 0) {
                int number = Integer.parseInt(values.get(0));

                return stream.filter(entity -> {
                    Field field = null;
                    try {
                        field = entity.getClass().getDeclaredField(fieldName);

                        return field.getInt(entity) >= number;
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            }
            //if values parameter does not have any value throw exception
            throw new Exception();
        }
    },//x >= 5
    NUMBER_SINGLE_GREATER{
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) throws Exception {
            if(values.size() > 0) {
                int number = Integer.parseInt(values.get(0));

                return stream.filter(entity -> {
                    Field field = null;
                    try {
                        field = entity.getClass().getDeclaredField(fieldName);

                        return field.getInt(entity) > number;
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            }
            //if values parameter does not have any value throw exception
            throw new Exception();
        }
    },//x > 5
    NUMBER_SINGLE_LESS_OR_EQUALS{
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) throws Exception {
            if(values.size() > 0) {
                int number = Integer.parseInt(values.get(0));

                return stream.filter(entity -> {
                    Field field = null;
                    try {
                        field = entity.getClass().getDeclaredField(fieldName);

                        return field.getInt(entity) <= number;
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            }
            //if values parameter does not have any value throw exception
            throw new Exception();
        }
    },//x <= 5
    NUMBER_SINGLE_LESS{
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) throws Exception {
            if(values.size() > 0) {
                int number = Integer.parseInt(values.get(0));

                return stream.filter(entity -> {
                    Field field = null;
                    try {
                        field = entity.getClass().getDeclaredField(fieldName);

                        return field.getInt(entity) < number;
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            }
            //if values parameter does not have any value throw exception
            throw new Exception();
        }
    },//x < 5
    NUMBER_MULTIPLE_EQUALS{
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) throws Exception {
            if(values.size() > 0) {
                List<Integer> numbers = values.stream()
                        .map(str -> Integer.parseInt(str))
                        .collect(Collectors.toList());

                return stream.filter(entity -> {
                    Field field = null;
                    try {
                        field = entity.getClass().getDeclaredField(fieldName);

                        return numbers.contains(field.getInt(entity));
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            }
            //if values parameter does not have any value throw exception
            throw new Exception();
        }
    },//x == 5 or x == 6...,
    NUMBER_RANGE{
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) throws Exception {
            if(values.size() == 2) {
                int min = Integer.parseInt(values.get(0));
                int max = Integer.parseInt(values.get(1));

                return stream.filter(entity -> {
                    Field field = null;
                    try {
                        field = entity.getClass().getDeclaredField(fieldName);

                        return field.getInt(entity) >= min && field.getInt(entity) <= max;
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            }
            //if values parameter does not have any value throw exception
            throw new Exception();
        }
    },//x >= 5 && x <= 10
    STRING_SINGLE_EQUALS{
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) throws Exception {
            if(values.size() > 0) {

                return stream.filter(entity -> {
                    Field field = null;
                    try {
                        field = entity.getClass().getDeclaredField(fieldName);
                        String str = (String) field.get(entity);

                        return str.equals(values.get(0));
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            }
            //if values parameter does not have any value throw exception
            throw new Exception();
        }
    },//name == "murat",
    STRING_MULTIPLE_EQUALS {
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) throws Exception {
            if(values.size() > 0) {
                return stream.filter(entity -> {
                    Field field = null;
                    try {
                        field = entity.getClass().getDeclaredField(fieldName);
                        String str = (String) field.get(entity);

                        return values.stream().anyMatch(val -> val.equals(str));
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                });
            }
            //if values parameter does not have any value throw exception
            throw new Exception();
        }
    };//name == "xxx" or name == "yyy"

    public abstract <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) throws Exception;

}
