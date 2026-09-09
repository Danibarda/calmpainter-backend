package com.calmpainter.calm.painter.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.calmpainter.calm.painter.model.Game;
import com.calmpainter.calm.painter.model.GameState;

public interface GameRepository extends MongoRepository<Game,String> {
    Optional<Game> findFirstByState(GameState state);
}
