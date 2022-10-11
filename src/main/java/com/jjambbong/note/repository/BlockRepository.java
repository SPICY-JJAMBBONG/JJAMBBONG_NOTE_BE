package com.jjambbong.note.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jjambbong.note.entity.Block;

public interface BlockRepository extends MongoRepository<Block, String> {

}
