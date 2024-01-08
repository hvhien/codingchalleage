package com.hienhv.flashcard.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "card")
public class Card {
    @Id
    private String id;
    private String word;
    private String example;
    private List<Comment> comments;
    private boolean status;
    private String ipa;
}
