package com.example.service.impl;

import com.example.dto.ProductDto;
import com.example.filter.FilterFlow;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import com.example.util.EntityUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import java.util.Collection;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final FilterFlow filterFlow;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, FilterFlow filterFlow) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.filterFlow = filterFlow;
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> productList = productRepository.findAll();

        return EntityUtil.listEntityToListDto(modelMapper, productList, ProductDto.class);
    }

    @Override
    public ProductDto getById(Long id) {
        Product product = findById(id);

        return EntityUtil.entityToDto(modelMapper, product, ProductDto.class);
    }

    @Override
    public Collection<ProductDto> filter(MultiValueMap<String, String> parameters) {
        final List<Product> productList = productRepository.findAll();
        final List<Product> filteredProductList = (List)filterFlow.executeFilters(productList, parameters);

        return EntityUtil.listEntityToListDto(modelMapper, filteredProductList, ProductDto.class);
    }

    private Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found exception..."));
    }
}
