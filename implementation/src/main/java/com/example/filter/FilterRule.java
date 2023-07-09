package com.example.filter;

import com.example.filter.exception.ParameterValueMismatchException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum FilterRule {
    NUMBER_SINGLE_EQUALS{
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) {
            Stream<T> result = Stream.empty();

            try {
                FilterUtil.checkIfParameterHasValues(values);
                int number = FilterUtil.convertToInt(values.get(0));

                return stream.filter(entity -> {
                    boolean prediction = false;
                    Field field = null;

                    try {
                        field = entity.getClass().getDeclaredField(fieldName);

                        return field.getInt(entity) == number;
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        System.out.println(ex.getMessage());
                    }

                    return prediction;
                });

            } catch (NumberFormatException | ParameterValueMismatchException ex){
                System.out.println(ex.getMessage());
            }

            return result;
        }
    },//x = 5
    NUMBER_SINGLE_GREATER_OR_EQUALS {
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) {
            Stream<T> result = Stream.empty();

            try {
                FilterUtil.checkIfParameterHasValues(values);
                int number = FilterUtil.convertToInt(values.get(0));

                return stream.filter(entity -> {
                    boolean prediction = false;
                    Field field = null;

                    try {
                        field = entity.getClass().getDeclaredField(fieldName);

                        return field.getInt(entity) >= number;
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        System.out.println(ex.getMessage());
                    }

                    return prediction;
                });

            } catch (NumberFormatException | ParameterValueMismatchException ex){
                System.out.println(ex.getMessage());
            }

            return result;
        }
    },//x >= 5
    NUMBER_SINGLE_GREATER{
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) {
            Stream<T> result = Stream.empty();

            try {
                FilterUtil.checkIfParameterHasValues(values);
                int number = FilterUtil.convertToInt(values.get(0));

                return stream.filter(entity -> {
                    boolean prediction = false;
                    Field field = null;

                    try {
                        field = entity.getClass().getDeclaredField(fieldName);

                        return field.getInt(entity) > number;
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        System.out.println(ex.getMessage());
                    }

                    return prediction;
                });

            } catch (NumberFormatException | ParameterValueMismatchException ex){
                System.out.println(ex.getMessage());
            }

            return result;
        }
    },//x > 5
    NUMBER_SINGLE_LESS_OR_EQUALS{
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) {
            Stream<T> result = Stream.empty();

            try {
                FilterUtil.checkIfParameterHasValues(values);
                int number = FilterUtil.convertToInt(values.get(0));

                return stream.filter(entity -> {
                    boolean prediction = false;
                    Field field = null;

                    try {
                        field = entity.getClass().getDeclaredField(fieldName);

                        return field.getInt(entity) <= number;
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        System.out.println(ex.getMessage());
                    }

                    return prediction;
                });

            } catch (NumberFormatException | ParameterValueMismatchException ex){
                System.out.println(ex.getMessage());
            }

            return result;
        }
    },//x <= 5
    NUMBER_SINGLE_LESS{
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) {
            Stream<T> result = Stream.empty();

            try {
                FilterUtil.checkIfParameterHasValues(values);
                int number = FilterUtil.convertToInt(values.get(0));

                return stream.filter(entity -> {
                    boolean prediction = false;
                    Field field = null;

                    try {
                        field = entity.getClass().getDeclaredField(fieldName);

                        return field.getInt(entity) < number;
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        System.out.println(ex.getMessage());
                    }

                    return prediction;
                });

            } catch (NumberFormatException | ParameterValueMismatchException ex){
                System.out.println(ex.getMessage());
            }

            return result;
        }
    },//x < 5
    NUMBER_MULTIPLE_EQUALS{
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) {
            Stream<T> result = Stream.empty();

            try {
                FilterUtil.checkIfParameterHasValues(values);
                List<Integer> numbers = values.stream()
                        .map(FilterUtil::convertToInt)
                        .collect(Collectors.toList());

                return stream.filter(entity -> {
                    boolean prediction = false;
                    Field field = null;

                    try {
                        field = entity.getClass().getDeclaredField(fieldName);

                        return numbers.contains(field.getInt(entity));
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        System.out.println(ex.getMessage());
                    }

                    return prediction;
                });

            } catch (NumberFormatException | ParameterValueMismatchException ex){
                System.out.println(ex.getMessage());
            }

            return result;
        }
    },//x == 5 or x == 6...,
    NUMBER_RANGE{
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) {
            Stream<T> result = Stream.empty();

            try {
                FilterUtil.checkIfParameterValuesRange(values);

                int min = Integer.parseInt(values.get(0));
                int max = Integer.parseInt(values.get(1));

                return stream.filter(entity -> {
                    boolean prediction = false;

                    Field field = null;
                    try {
                        field = entity.getClass().getDeclaredField(fieldName);

                        return field.getInt(entity) >= min && field.getInt(entity) <= max;
                    } catch (NoSuchFieldException | IllegalAccessException ex) {
                        System.out.println(ex.getMessage());
                    }

                    return prediction;
                });
            }catch (NumberFormatException | ParameterValueMismatchException ex){
                System.out.println(ex.getMessage());
            }

            return result;
        }
    },//x >= 5 && x <= 10
    STRING_SINGLE_EQUALS{
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) {
            Stream<T> result = Stream.empty();

            try {
                FilterUtil.checkIfParameterValueSingle(values);

                return stream.filter(entity -> {
                    boolean prediction = false;

                    Field field = null;
                    try {
                        field = entity.getClass().getDeclaredField(fieldName);
                        String str = (String) field.get(entity);

                        return str.equals(values.get(0));
                    } catch (NoSuchFieldException | IllegalAccessException | SecurityException ex) {
                        System.out.println(ex.getMessage());
                    }

                    return prediction;
                });

            }catch (ParameterValueMismatchException ex) {
                System.out.println(ex.getMessage());

            }

            return result;
        }
    },//name == "murat",
    STRING_MULTIPLE_EQUALS {
        @Override
        public <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values) {
            Stream<T> result = Stream.empty();
            try {
                FilterUtil.checkIfParameterHasValues(values);

                if(values.size() > 0) {
                    return stream.filter(entity -> {
                        boolean prediction = false;

                        Field field = null;
                        try {
                            field = entity.getClass().getDeclaredField(fieldName);
                            String str = (String) field.get(entity);

                            return values.stream().anyMatch(val -> val.equals(str));
                        } catch (NoSuchFieldException | IllegalAccessException ex) {
                            System.out.println(ex.getMessage());
                        }

                        return prediction;
                    });
                }
            }catch (ParameterValueMismatchException ex) {
                System.out.println(ex.getMessage());
            }

            return result;
        }
    };//name == "xxx" or name == "yyy"

    public abstract <T> Stream<T> performRule(String fieldName, Stream<T> stream, List<String> values);

}
