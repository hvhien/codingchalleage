package com.hienhv.flashcard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCardReqDto {
    private String word;
    private String example;
    private String ipa;
}
