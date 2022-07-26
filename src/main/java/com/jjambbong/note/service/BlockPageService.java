package com.jjambbong.note.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jjambbong.note.entity.BlockPage;

@Service
public interface BlockPageService {

	public UUID createBlockPage(BlockPage blockPage, String currentPageId);

	Optional<BlockPage> findById(String id);
}
