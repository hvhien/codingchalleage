package com.hienhv.flashcard.service;

import com.hienhv.flashcard.controller.CommentReqDto;
import com.hienhv.flashcard.dto.CreateCardReqDto;
import com.hienhv.flashcard.dto.EditCardReqDto;
import com.hienhv.flashcard.model.Card;
import com.hienhv.flashcard.model.Comment;
import com.hienhv.flashcard.model.User;
import com.hienhv.flashcard.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository<Card> cardRepository;

    public boolean createCard(CreateCardReqDto reqDto) {
        try {
            cardRepository.save(Card.builder()
                    .word(reqDto.getWord())
                    .example(reqDto.getExample())
                    .ipa(reqDto.getIpa())
                    .status(false)
                    .build());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean editCard(EditCardReqDto reqDto) {
        try {
            cardRepository.save(Card.builder()
                    .word(reqDto.getWord())
                    .example(reqDto.getExample())
                    .ipa(reqDto.getIpa())
                    .status(reqDto.isStatus())
                    .build());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public List<Card> getCards(String status) {
        return cardRepository.getAllCardFalse(status);
    }

    public boolean comment(CommentReqDto reqDto) {
        Optional<Card> card = cardRepository.findByWord(reqDto.getWord());
        if (card.isPresent()) {
            card.get().setComments(List.of(Comment.builder()
                    .commenter(new User("random"))
                    .context(reqDto.getContext())
                    .build()));
            cardRepository.save(card.get());
            return true;
        }
        return false;
    }
}
