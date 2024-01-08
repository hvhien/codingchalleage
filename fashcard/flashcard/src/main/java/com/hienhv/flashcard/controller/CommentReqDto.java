package com.hienhv.flashcard.controller;

import com.hienhv.flashcard.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentReqDto {
    private String word;
    private User user;
    private String context;
}
