package com.example.service;

import com.example.dto.ProductDto;
import com.example.filter.Filterable;
import com.example.model.Product;

import java.util.List;

public interface ProductService extends Filterable<ProductDto> {
    List<ProductDto> getAll();
    ProductDto getById(Long id);
}
