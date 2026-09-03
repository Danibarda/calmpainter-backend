package com.calmpainter.calm.painter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.calmpainter.calm.painter.model.TargetPainting;

public interface TargetPaintingRepository extends MongoRepository<TargetPainting,String> {
    
}

