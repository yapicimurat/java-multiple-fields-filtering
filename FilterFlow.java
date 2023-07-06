package org.example.util.field;

import org.springframework.util.MultiValueMap;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterFlow<T> {
    private final List<FilterMap> filterMaps;
    //requestParameters anlık olarak fonksiyona tahsis edilecek...
    //public Set<RequestParameter> requestParameters;
    public FilterFlow(List<FilterMap> filterMaps) {
        this.filterMaps = filterMaps;
    }

    public Collection<T> executeFilters(MultiValueMap<String, String> rawParameters) {

        /*
         * 1-Gelen istek parametrelerini dolaş
         * price, price, color ...
         * bir tanesinden birden fazla da olabilir
         * 2-İstek parametrelerini dolaştırken hangi çeşit kurala sahip olduğunu bul
         *   bulduğun kurala göre belki gruplama yapman gerekebilir
         *
         *
        */
        Collection<T> data = Collections.EMPTY_LIST;
        Stream<T> stream = data.stream();
        Iterator<String> iterator = rawParameters.keySet().iterator();

        while(iterator.hasNext()) {
            try {
                String clientFilterName = iterator.next();

                //find parameter values by clientFilterName
                List<String> values = rawParameters.get(clientFilterName);
                FilterMap filterMap = filterMaps.stream()
                        .filter(map -> map.clientFilterName.equals(clientFilterName))
                        .findFirst().orElseThrow(() -> new RuntimeException());

                stream = filterMap.filterRule.performRule(filterMap.entityFieldName, stream, values);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return stream.collect(Collectors.toList());
    }
}