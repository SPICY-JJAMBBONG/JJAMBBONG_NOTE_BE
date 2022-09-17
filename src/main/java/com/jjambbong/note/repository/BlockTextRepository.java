package com.jjambbong.note.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jjambbong.note.entity.BlockText;

public interface BlockTextRepository extends MongoRepository<BlockText, String> {

}
