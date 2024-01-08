package com.hienhv.flashcard.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    private User commenter;
    private String context;
}
