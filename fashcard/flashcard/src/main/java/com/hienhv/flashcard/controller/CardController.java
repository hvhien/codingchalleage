package com.hienhv.flashcard.controller;

import com.hienhv.flashcard.dto.CreateCardReqDto;
import com.hienhv.flashcard.model.Card;
import com.hienhv.flashcard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CardController {
    @Autowired
    private CardService cardService;
    @GetMapping("/")
    public ResponseEntity<List<Card>> getCards(@RequestParam String status){
        return ResponseEntity.ok(cardService.getCards(status));
    }

    @PostMapping("/create")
    public ResponseEntity<String> insertCard(@RequestBody CreateCardReqDto reqDto){
        cardService.createCard(reqDto);
        return ResponseEntity.ok("created");
    }

    @PostMapping("/comment")
    public ResponseEntity<String> comment(@RequestBody CommentReqDto reqDto){
        cardService.comment(reqDto);
        return ResponseEntity.ok("commented");
    }
}
