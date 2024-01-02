package com.hienhv.product.service;

import com.hienhv.product.dto.ProductReqDto;
import com.hienhv.product.model.Product;
import com.hienhv.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public boolean createProduct(ProductReqDto reqDto) {
        try {
            productRepository.save(Product.builder()
                    .name(reqDto.getName())
                    .qtyNo(reqDto.getQtyNumber())
                    .price(reqDto.getPrice())
                    .skuCode(reqDto.getSkuCode())
                    .build());
            return true;
        } catch (Exception ex) {
            return false;
        }

    }
}
