package com.jjambbong.note.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jjambbong.note.entity.BlockPage;

public interface BlockPageRepository extends MongoRepository<BlockPage, String> {

}
