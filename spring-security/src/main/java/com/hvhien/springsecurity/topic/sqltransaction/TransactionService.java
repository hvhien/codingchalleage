package com.hvhien.springsecurity.topic.sqltransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    public boolean updateQuality(String skuCode,int numberBought){
        Product product = transactionRepository.findBySkuCode(skuCode);
        if (null!=product && numberBought<product.getQuality()){
            int currentQty=product.getQuality();
            int newQty=numberBought-currentQty;
            product.setQuality(newQty);
            transactionRepository.save(product);
            return true;
        }
        return false;
    }
}
