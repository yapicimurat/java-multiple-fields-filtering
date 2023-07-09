package com.example.controller;

import com.example.dto.ProductDto;
import com.example.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAll() {

        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ProductDto>> filter(@RequestParam MultiValueMap<String, String> parameters) {
        return ResponseEntity.ok((List)productService.filter(parameters));
    }

}
