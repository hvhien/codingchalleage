package com.hienhv.flashcard.repository;

import com.hienhv.flashcard.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CardRepositoryImpl<S> implements CardRepository<S> {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(S entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public List<Card> getAllCardFalse(String status) {
        boolean isDone=false;
        if (status.equalsIgnoreCase("1")){
            isDone=true;
        }
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is(isDone));
        List<Card> cards = mongoTemplate.find(query, Card.class);
        return cards;
    }

    @Override
    public Optional<Card> findByWord(String word) {
        Query query=new Query();
        query.addCriteria(Criteria.where("word").is(word));
        return Optional.of(mongoTemplate.findOne(query,Card.class));
    }


}
