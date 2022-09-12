package com.jjambbong.note.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.common.ResponseCode;
import com.jjambbong.note.common.error.exception.BusinessException;
import com.jjambbong.note.common.error.exception.block.BlockErrorCode;
import com.jjambbong.note.common.error.exception.block.BlockNotFoundException;
import com.jjambbong.note.dto.BlockDto;
import com.jjambbong.note.entity.Block;
import com.jjambbong.note.repository.BlockRepository;
import com.jjambbong.note.service.BlockService;

import lombok.RequiredArgsConstructor;

@Transactional
@Component
@RequiredArgsConstructor
public class BlockServiceImpl implements BlockService {

	@Autowired
	private final BlockRepository blockRepository;

	@Override
	public ApiResponse<String> createBlock(BlockDto blockDto) {

		if(blockDto.getType() == null)
			throw new BusinessException(BlockErrorCode.MISSDATA);

		Block block = Block.builder()
			.id(blockDto.getId())
			.type(blockDto.getType())
			.order(blockDto.getOrder())
			.lastModifiedTime(LocalDateTime.now()).build();

		return saveBlock(block);
	}

	@Override
	public Block getBlock(String id) {
		return getBlockFromBlockId(id);
	}

	@Override
	public ApiResponse<String> updateBlock(BlockDto blockDto, String id) {

		if(!isVerify(blockDto)) // 타입에 따른 데이터 정합성 체크
			throw new BusinessException(BlockErrorCode.NOTFITDATA);

		Block block = getBlockFromBlockId(id);

		switch (block.getType()){ //타입에 따라 update
			case "page":
				setPageAttribute(blockDto, block);
				break;
			case "text":
				setTextAttribute(blockDto, block);
				break;
			default:
				break;
		}

		//공통 수정 : order, lastModifiedTime
		block.setOrder( (blockDto.getOrder() == null) ? block.getOrder() : blockDto.getOrder());
		block.setLastModifiedTime(LocalDateTime.now());

		return saveBlock(block);
	}

	private boolean isVerify(BlockDto blockDto) {

		System.out.println(blockDto.toString());

		switch (blockDto.getType()){
			case "page":
				if(blockDto.getContent() != null || blockDto.getStyle() != null )
					return false;
				break;
			case "text":
				if(blockDto.getBlockList() != null || blockDto.getTitle() != null )
					return false;
				break;
		}

		return true;
	}

	private void setTextAttribute(BlockDto blockDto, Block block) {
		block.setContent(blockDto.getContent());
		block.setStyle(blockDto.getStyle());
	}

	private void setPageAttribute(BlockDto blockDto, Block block) {
		block.setTitle(blockDto.getTitle());
		block.setBlockList(blockDto.getBlockList());
	}

	@Override
	public ApiResponse<String> deleteBlock(String id) {

		Block block = getBlockFromBlockId(id);
		blockRepository.deleteAllById(block.getBlockList());
		blockRepository.deleteById(id);

		return new ApiResponse<>(ResponseCode.SUCCESS, id);
	}


	private Block getBlockFromBlockId(String id) {
		Optional<Block> blockOptional = blockRepository.findById(id);

		if(blockOptional.isEmpty()){
			throw new BlockNotFoundException(id);
		}

		return blockOptional.get();
	}

	private ApiResponse<String> saveBlock(Block block) {
		try {
			//System.out.println(blockRepository.save(block));
			String blockId = blockRepository.save(block).getId();
			return new ApiResponse<>(ResponseCode.SUCCESS, blockId);
		} catch (Exception e) {
			throw new BusinessException(BlockErrorCode.UNKNOWN, e.getMessage());
		}
	}
}
