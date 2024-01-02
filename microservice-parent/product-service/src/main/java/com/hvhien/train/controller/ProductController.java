package com.hvhien.train.controller;

import com.hvhien.train.dto.CreateProductReqDto;
import com.hvhien.train.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@Validated @RequestBody CreateProductReqDto request){
        productService.createProduct(request);
        return ResponseEntity.ok("created");
    }
}
