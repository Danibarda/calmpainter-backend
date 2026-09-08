package com.calmpainter.calm.painter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.calmpainter.calm.painter.model.GameResult;

public interface GameResultRepository extends MongoRepository<GameResult,String>{
    
}
