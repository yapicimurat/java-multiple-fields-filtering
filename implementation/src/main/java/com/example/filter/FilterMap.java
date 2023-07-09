package com.example.filter;

public class FilterMap<T> {
    public final String clientFilterName;
    public final String entityFieldName;
    public final Class<T> entityClass;
    public final FilterRule filterRule;

    public FilterMap(String clientFilterName, String entityFieldName, Class<T> entityClass, FilterRule filterRule) {
        this.clientFilterName = clientFilterName;
        this.entityFieldName = entityFieldName;
        this.entityClass = entityClass;
        this.filterRule = filterRule;
    }
}
