package com.hvhien.springsecurity.topic.sqltransaction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionSameTimeController {
    @PostMapping("/transaction/sametime")
    public ResponseEntity<String> updateSameTime(@RequestBody TransactionSameTimeRequestDto req){
        
    }

}
