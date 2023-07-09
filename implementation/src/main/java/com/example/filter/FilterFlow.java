package com.example.filter;

import com.example.filter.exception.ParameterNoRuleException;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FilterFlow {
    private final Map<String, FilterMap> filterMaps;
    public FilterFlow() {
        this.filterMaps = new HashMap<>();
    }

    public <T> Collection<T> executeFilters(Collection<T> dataSource, MultiValueMap<String, String> rawParameters) {
        Stream<T> stream = dataSource.stream();
        Iterator<String> iterator = rawParameters.keySet().iterator();

        while(iterator.hasNext()) {
            try {
                String clientFilterName = iterator.next();

                //find parameter values by clientFilterName
                List<String> values = rawParameters.get(clientFilterName);
                FilterMap filterMap = filterMaps.get(clientFilterName);

                if(!filterMaps.containsKey(clientFilterName))
                {
                    throw new ParameterNoRuleException();
                }

                stream = filterMap.filterRule.performRule(filterMap.entityFieldName, stream, values);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return stream.collect(Collectors.toList());
    }
}