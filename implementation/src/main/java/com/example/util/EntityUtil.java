package com.example.util;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public final class EntityUtil {
    private EntityUtil() {}

    public static <S, T> List<T> listEntityToListDto(ModelMapper modelMapper, List<S> sourceList, Class<T> targetClass) {
        return sourceList.stream().map(sourceEntity ->
                modelMapper.map(sourceEntity, targetClass)).collect(Collectors.toList());
    }

    public static <S, T> T entityToDto(ModelMapper modelMapper, S sourceEntity, Class<T> targetClass) {
        return modelMapper.map(sourceEntity, targetClass);
    }
}
