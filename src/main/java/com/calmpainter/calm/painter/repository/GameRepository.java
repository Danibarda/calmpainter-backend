package com.calmpainter.calm.painter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.calmpainter.calm.painter.model.Game;

public interface GameRepository extends MongoRepository<Game,String> {
    
}
