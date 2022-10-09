package com.jjambbong.note.repository;

import com.jjambbong.note.entity.BlockImage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlockImageRepository extends MongoRepository<BlockImage, String> {
}
