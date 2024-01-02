package com.hienhv.product.controller;

import com.hienhv.product.dto.ProductReqDto;
import com.hienhv.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody ProductReqDto reqDto) {

        return productService.createProduct(reqDto)? ResponseEntity.ok("created"): ResponseEntity.ok("not success");
    }

}
