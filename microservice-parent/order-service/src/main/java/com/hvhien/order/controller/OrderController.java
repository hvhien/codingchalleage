package com.hvhien.order.controller;

import com.hvhien.order.dto.OrderRequestDto;
import com.hvhien.order.model.OrderItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/apis/v1/order")
public class OrderController {
    @PostMapping("")
    public ResponseEntity<String> getAllOrder(@RequestBody OrderRequestDto request){
        return ResponseEntity.ok("Successfull order");
    }
}
