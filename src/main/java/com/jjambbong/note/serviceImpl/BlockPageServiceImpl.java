package com.jjambbong.note.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.common.ResponseCode;
import com.jjambbong.note.common.error.exception.BusinessException;
import com.jjambbong.note.common.error.exception.blockPage.BlockPageErrorCode;
import com.jjambbong.note.common.error.exception.blockPage.BlockPageNotFoundException;
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

	@Transactional
	@Override
	public ApiResponse<String> createBlockPage(BlockPage blockPage) {
		try {
			System.out.println(blockPageRepository.save(blockPage));
			String blockId = blockPageRepository.save(blockPage).getId();
			return new ApiResponse<>(ResponseCode.SUCCESS, blockId);
		} catch (Exception e) {
			throw new BusinessException(BlockPageErrorCode.UNKNOWN, e.getMessage());
		}
	}

	@Override
	public Optional<BlockPage> findById(String blockId) {
		return blockPageRepository.findById(blockId);
	}

	@Override
	public ApiResponse updateBlockPage(BlockPageDto blockPageDto, String blockId) {

		Optional<BlockPage> blockPageList = blockPageRepository.findById(blockId);

		Long order = blockPageDto.getOrder();
		System.out.println("order = " + order);
		System.out.println("blockPageDto = " + blockPageDto);

		if(blockPageList.isEmpty()){
			throw new BlockPageNotFoundException(blockId);
		}else{
			BlockPage blockPage = blockPageList.get();
			blockPage.setBlockList(blockPageDto.getBlock_list());
			// blockPage.setOrder( (blockPageDto.getOrder() == null) ? blockPage.getOrder() : blockPageDto.getOrder());
			blockPage.setOrder(blockPageDto.getOrder());
			blockPage.setTitle(blockPageDto.getTitle());
			blockPage.setLast_modified_time(LocalDateTime.now());
			blockPageRepository.save(blockPage);
		}
		return new ApiResponse<>(ResponseCode.SUCCESS, blockId);
	}

	@Override
	public ApiResponse deleteBlockPage(String blockId) {

		Optional<BlockPage> blockPageList = blockPageRepository.findById(blockId);
		System.out.println("blockPageList = " + blockPageList);

		if(blockPageList.isEmpty()){
			throw new BlockPageNotFoundException(blockId);
		}else{
			BlockPage blockPage = blockPageList.get();
			blockPageRepository.deleteAllById(blockPage.getBlockList());
			blockPageRepository.deleteById(blockId);
		}

		return new ApiResponse<>(ResponseCode.SUCCESS, blockId);
	}
}
