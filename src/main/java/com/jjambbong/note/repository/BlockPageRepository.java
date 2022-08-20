package com.jjambbong.note.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jjambbong.note.dto.BlockPageDto;
import com.jjambbong.note.entity.BlockPage;

public interface BlockPageRepository extends MongoRepository<BlockPage, String> {

}
