package com.jjambbong.note.serviceImpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.common.ResponseCode;
import com.jjambbong.note.dto.BlockPageDto;
import com.jjambbong.note.entity.BlockPage;
import com.jjambbong.note.repository.BlockPageRepository;
import com.jjambbong.note.service.BlockPageService;

import lombok.RequiredArgsConstructor;

@Transactional
@Component
@RequiredArgsConstructor
public class BlockPageServiceImpl implements BlockPageService {

	@Autowired
	private final BlockPageRepository blockPageRepository;

	@Override
	public ApiResponse<String> createBlockPage(BlockPageDto blockPageDto) {

		if(blockPageDto.getType() == "page") //type 잘못된 값이면 block 생성x
			throw new RuntimeException("Type data is not correct");

		if(!blockPageRepository.findById(blockPageDto.getId()).isEmpty())
			throw new RuntimeException("The Page ID already exists");

		BlockPage blockPage = BlockPage.builder() // id/type/order 정보로 새로운 BlockPage 생성
			.id(blockPageDto.getId())
			.type(blockPageDto.getType())
			.order(blockPageDto.getOrder())
			.indent(blockPageDto.getIndent())
			.lastModifiedTime(new Date()).build();

		return saveBlockPage(blockPage);
	}

	@Override
	public BlockPage getBlockPage(String id) {
		return getBlockPageFromId(id);
	}

	@Override
	public ApiResponse<String> updateBlockPage(BlockPageDto blockPageDto, String id) {

		BlockPage blockPage = getBlockPageFromId(id);

		blockPage.setTitle(blockPageDto.getTitle());
		blockPage.setBlockList(blockPageDto.getBlockList());

		//공통 수정 : order, indent, lastModifiedTime
		blockPage.setOrder( (blockPageDto.getOrder() == null) ? blockPage.getOrder() : blockPageDto.getOrder());
		blockPage.setIndent(blockPage.getIndent());
		blockPage.setLastModifiedTime(new Date());

		//System.out.println(blockPage.toString());

		return saveBlockPage(blockPage);
	}


	@Override
	public ApiResponse<String> deleteBlockPage(String id) {

		BlockPage blockPage = getBlockPageFromId(id); //현재 블럭 정보가져오기

		for(String blockId : blockPage.getBlockList()){
			if(blockId.contains("page")) //blockList에 page가 있다면
				deleteBlockPage(blockId); //그 하위 blockList도 제거해야함
		}

		blockPageRepository.deleteAllById(blockPage.getBlockList()); //하위의 blockList 제거

		blockPageRepository.deleteById(id);

		return new ApiResponse<>(ResponseCode.SUCCESS, id);
	}


	private BlockPage getBlockPageFromId(String id) {
		Optional<BlockPage> blockPageOptional = blockPageRepository.findById(id);

		if(blockPageOptional.isEmpty()){ // 해당 id를 가진 BlockPage이 없다면 error!
			throw new RuntimeException(id+"is not found");
		}

		return blockPageOptional.get(); // BlockPage 객체 리턴
	}

	private ApiResponse<String> saveBlockPage(BlockPage blockPage) {
		try {
			//System.out.println(BlockPageRepository.save(blockPage));
			String blockPageId = blockPageRepository.save(blockPage).getId();
			return new ApiResponse<>(ResponseCode.SUCCESS, blockPageId);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
