package org.example.util;

import org.example.model.BaseModel;
import org.springframework.util.MultiValueMap;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterFlow<T extends BaseModel> {
    private final Collection<T> dataSource;
    private final Class<T> entityClass;
    private final MultiValueMap<String, Object> requestParameters;
    private List<Field<T>> fieldList = new ArrayList<>();
    private final Map<String, String> fieldMapper;

    public FilterFlow(Collection<T> dataSource,
                      Class<T> entityClass,
                      MultiValueMap<String, Object> requestParameters,
                      Map<String, String> fieldMapper) {
        this.entityClass = entityClass;
        this.dataSource = dataSource;
        this.requestParameters = requestParameters;
        this.fieldMapper = fieldMapper;
    }

    public void resolveParameters() {
        java.lang.reflect.Field[] entityFields = entityClass.getDeclaredFields();

        requestParameters.forEach((key, values) -> {
            java.lang.reflect.Field entityField = Arrays.stream(entityFields)
                    .filter(field -> field.getName() == key).findFirst().get();

            if(values.size() == 1) {
                //single...
                fieldList.add(new Field<T>(key, fieldMapper.get(key), values, createSingleConditionPredicate(entityField, values)));
            } else{
                //multiple...
                //it is still missing.. there should be multiple and condition...
                fieldList.add(new Field<T>(key, fieldMapper.get(key), values, createMultipleConditionsPredicate(entityField, values)));
            }
        });
    }

    private Predicate<T> createSingleConditionPredicate(java.lang.reflect.Field entityField, List<Object> values) {
        return (entity) -> {
            try {
                return entityField.get(entity).equals(values.get(0));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        };
    }
    private Predicate<T> createMultipleConditionsPredicate(java.lang.reflect.Field entityField, List<Object> values) {
        return (entity) -> {
            try {
                return values.contains(entityField.get(entity));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public Collection<T> terminateAsList(Stream<T> input) {
        return input.collect(Collectors.toList());
    }


}
