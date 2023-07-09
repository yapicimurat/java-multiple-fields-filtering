package com.example.filter;

import org.springframework.util.MultiValueMap;

import java.util.Collection;

public interface Filterable<T> {
    Collection<T> filter(MultiValueMap<String, String> parameters);
}
