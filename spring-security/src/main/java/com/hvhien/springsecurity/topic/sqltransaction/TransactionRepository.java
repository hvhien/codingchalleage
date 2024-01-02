package com.hvhien.springsecurity.topic.sqltransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Product,Long> {

    Product findBySkuCode(String skuCode);
}
