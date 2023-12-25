package com.hvhien.train.service;

import com.hvhien.train.dto.CreateProductReqDto;
import com.hvhien.train.dto.ProductResDto;
import com.hvhien.train.model.Product;
import com.hvhien.train.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(CreateProductReqDto request) {
        return productRepository.save(Product.builder()
                .id(UUID.randomUUID().toString())
                .name(request.getName())
                .price(request.getPrice())
                .build());
    }

    public List<ProductResDto> listAllProducts(){
        return productRepository.findAll().stream().map(product -> productMapToResponse(product)).toList();
    }

    private ProductResDto productMapToResponse(Product product) {
        return ProductResDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
