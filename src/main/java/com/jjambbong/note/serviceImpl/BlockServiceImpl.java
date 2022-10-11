package com.jjambbong.note.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.common.ResponseCode;
import com.jjambbong.note.dto.BlockDto;
import com.jjambbong.note.entity.Block;
import com.jjambbong.note.mapper.BlockMapper;
import com.jjambbong.note.repository.BlockRepository;
import com.jjambbong.note.service.BlockService;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class BlockServiceImpl implements BlockService {

	@Autowired
	private final BlockRepository blockRepository;

	@Autowired
	BlockMapper blockMapper;

	private Block getBlockFromId(String id) {
		Optional<Block> blockOptional = blockRepository.findById(id);

		if(blockOptional.isEmpty()){ // 해당 id를 가진 Block이 없다면 error!
			throw new RuntimeException(id+"is not found");
		}

		return blockOptional.get(); // Block 객체 리턴
	}

	private ApiResponse<String> saveBlockPage(BlockDto blockDto) {
		try {
			Block block = blockMapper.blockDtoToBlock(blockDto);
			String blockPageId = blockRepository.save(block).getId();
			return new ApiResponse<>(ResponseCode.SUCCESS, blockPageId);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public ApiResponse<String> createBlock(BlockDto blockDto) {

		if(!blockRepository.findById(blockDto.getId()).isEmpty())
			throw new RuntimeException("The ID already exists");

		return saveBlockPage(blockDto);
	}

	@Override
	public Block getBlock(String id) {
		return getBlockFromId(id);
	}

	@Override
	public ApiResponse<String> updateBlock(BlockDto blockDto, String id) {

		//유효성 맞지않다 -> 제거 대상?
		if(!isCorrectType(blockDto))
			//throw new RuntimeException("The type data is not correct");
			return deleteBlock(id);
		//신규id면 create
		else if(blockRepository.findById(blockDto.getId()).isEmpty())
			return createBlock(blockDto);
		else{
			//그 외 update
			Block block = getBlockFromId(id);
			//공통 수정 : order
			block.setOrder( (blockDto.getOrder() == null) ? block.getOrder() : blockDto.getOrder());
			return saveBlockPage(blockDto);
		}
	}

	@Override
	public ApiResponse<String> deleteBlock(String id) {
		Block block = getBlockFromId(id); //현재 블럭 정보가져오기

		for(String blockId : block.getBlockList()){
			if(blockId.contains("page")) //blockList에 page가 있다면
				deleteBlock(blockId); //그 하위 blockList도 제거해야함
		}

		blockRepository.deleteAllById(block.getBlockList()); //하위의 blockList 제거

		blockRepository.deleteById(id);

		return new ApiResponse<>(ResponseCode.SUCCESS, id);
	}

	public Boolean isCorrectType (BlockDto blockDto) {
		switch (blockDto.getType()){
			case "page":
				if(blockDto.getBlockList() == null && blockDto.getTitle() == null)
					return false;
				break;
			case "text":
				if(blockDto.getContent() == null)
					return false;
				break;
			case "image":
				if(blockDto.getUrl() == null && blockDto.getAltText() == null)
					return false;
				break;
		}

		return true;
	}
}
