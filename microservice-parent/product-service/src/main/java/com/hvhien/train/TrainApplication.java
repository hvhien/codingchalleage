package com.hvhien.train;

import com.hvhien.train.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
//@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class})
public class TrainApplication {
//    @Autowired
//    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(TrainApplication.class, args);
    }

}
