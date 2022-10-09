package com.jjambbong.note.serviceImpl;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.common.ResponseCode;
import com.jjambbong.note.dto.BlockDto;
import com.jjambbong.note.entity.BlockImage;
import com.jjambbong.note.mapper.BlockMapper;
import com.jjambbong.note.repository.BlockImageRepository;
import com.jjambbong.note.service.BlockImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class BlockImageServiceImpl implements BlockImageService {

    @Autowired
    BlockMapper blockMapper;

    @Autowired
    private final BlockImageRepository blockImageRepository;


    @Override
    public ApiResponse<String> updateBlockImage(BlockDto blockDto, String id) {
        Optional<BlockImage> blockImageOptional = blockImageRepository.findById(id);

        if (blockImageOptional.isEmpty()) {
            return createBlockImage(blockDto);
        } else {
            BlockImage blockImage = blockImageOptional.get();
            blockImage.setUrl(blockDto.getUrl());
            blockImage.setAltText(blockDto.getAltText());
            blockImage.setLastModifiedTime(new Date());
            return saveBlockImage(blockImage);
        }
    }

    @Override
    public ApiResponse<String> createBlockImage(BlockDto blockDto) {
        if (blockDto.getType() != "image")
            throw new RuntimeException("Type data is not correct");

        if(!blockImageRepository.findById(blockDto.getId()).isEmpty())
            throw new RuntimeException("The Page ID already exists");

        BlockImage blockImage = blockMapper.blockDtoToBlockImage(blockDto);
        return saveBlockImage(blockImage);
    }

    private ApiResponse<String> saveBlockImage (BlockImage blockImage) {
        try {
            String blockPageId = blockImageRepository.save(blockImage).getId();
            return new ApiResponse<>(ResponseCode.SUCCESS, blockPageId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ApiResponse<String> deleteBlockImage(String id) {
        try {
            blockImageRepository.deleteById(id);
            return new ApiResponse<>(ResponseCode.SUCCESS, id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public BlockImage getBlockImage(String id) {
        Optional<BlockImage> blockImage = blockImageRepository.findById(id);

        if (blockImage.isEmpty()) {
            throw new RuntimeException(id + " is not found");
        }
        return blockImage.get();
    }


}
