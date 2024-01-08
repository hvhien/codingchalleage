package com.hienhv.flashcard.repository;

import com.hienhv.flashcard.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CardRepository<S> {
    void save(S entity);
    List<Card> getAllCardFalse(String status);
    Optional<Card> findByWord(String word);
}
