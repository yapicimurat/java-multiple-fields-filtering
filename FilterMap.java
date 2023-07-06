package org.example.util.field;

public class FilterMap<T> {
    public final String clientFilterName;
    public final String entityFieldName;
    public final Class<T> entityClass;
    public final ParameterType parameterType;
    public final FilterRule filterRule;

    public FilterMap(String clientFilterName, String entityFieldName, Class<T> entityClass, ParameterType parameterType, FilterRule filterRule) {
        this.clientFilterName = clientFilterName;
        this.entityFieldName = entityFieldName;
        this.entityClass = entityClass;
        this.parameterType = parameterType;
        this.filterRule = filterRule;
    }
}
