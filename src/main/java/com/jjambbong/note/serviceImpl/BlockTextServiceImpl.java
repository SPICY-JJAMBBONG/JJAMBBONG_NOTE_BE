package com.jjambbong.note.serviceImpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.common.ResponseCode;
import com.jjambbong.note.dto.BlockTextDto;
import com.jjambbong.note.entity.BlockText;
import com.jjambbong.note.repository.BlockTextRepository;
import com.jjambbong.note.service.BlockTextService;

import lombok.RequiredArgsConstructor;

@Transactional
@Component
@RequiredArgsConstructor
public class BlockTextServiceImpl implements BlockTextService {

	@Autowired
	private final BlockTextRepository blockTextRepository;

	@Override
	public ApiResponse<String> createBlockText(BlockTextDto blockTextDto) {

		if(blockTextDto.getType() == "text") //type 잘못된 값이면 block 생성x
			throw new RuntimeException("Type data is not correct");

		if(!blockTextRepository.findById(blockTextDto.getId()).isEmpty())
			throw new RuntimeException("The Text ID already exists");

		BlockText blockText = BlockText.builder() // id/type/order 정보로 새로운 BlockText 생성
			.id(blockTextDto.getId())
			.type(blockTextDto.getType())
			.order(blockTextDto.getOrder())
			.indent(blockTextDto.getIndent())
			.lastModifiedTime(new Date()).build();

		return saveBlockText(blockText);
	}

	@Override
	public BlockText getBlockText(String id) {
		return getBlockTextFromId(id);
	}

	@Override
	public ApiResponse<String> updateBlockText(BlockTextDto blockTextDto, String id) {

		BlockText blockText = getBlockTextFromId(id);

		blockText.setContent(blockTextDto.getContent());
		blockText.setStyle(blockTextDto.getStyle());

		//공통 수정 : order, indent,lastModifiedTime
		blockText.setOrder( (blockTextDto.getOrder() == null) ? blockText.getOrder() : blockTextDto.getOrder());
		blockText.setIndent(blockText.getIndent());
		blockText.setLastModifiedTime(new Date());

		return saveBlockText(blockText);
	}


	@Override
	public ApiResponse<String> deleteBlockText(String id) {

		BlockText blockText = getBlockTextFromId(id); //현재 블럭 정보가져오기

		blockTextRepository.deleteById(id);

		return new ApiResponse<>(ResponseCode.SUCCESS, id);
	}


	private BlockText getBlockTextFromId(String id) {
		Optional<BlockText> blockTextOptional = blockTextRepository.findById(id);

		if(blockTextOptional.isEmpty()){ // 해당 id를 가진 BlockText이 없다면 error!
			throw new RuntimeException(id+"is not found");
		}

		return blockTextOptional.get(); // BlockText 객체 리턴
	}

	private ApiResponse<String> saveBlockText(BlockText blockText) {
		try {
			//System.out.println(BlockTextRepository.save(blockText));
			String blockTextId = blockTextRepository.save(blockText).getId();
			return new ApiResponse<>(ResponseCode.SUCCESS, blockTextId);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
