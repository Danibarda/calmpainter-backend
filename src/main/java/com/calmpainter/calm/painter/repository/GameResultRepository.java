package com.calmpainter.calm.painter.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.calmpainter.calm.painter.model.GameResult;

public interface GameResultRepository extends MongoRepository<GameResult,String>{
    List<GameResult> findAllByOrderByScoreDescTimeAsc();  
}
