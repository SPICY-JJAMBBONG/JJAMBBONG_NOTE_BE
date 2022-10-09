package com.jjambbong.note.mapper;

import com.jjambbong.note.dto.BlockDto;
import com.jjambbong.note.dto.BlockImageDto;
import com.jjambbong.note.entity.BlockImage;
import com.jjambbong.note.entity.BlockPage;
import com.jjambbong.note.entity.BlockText;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlockMapper {

    @Autowired
    ModelMapper modelMapper;

    // DTO -> ENTITY
    public BlockPage blockDtoToBlockPage(BlockDto block) {
        return modelMapper.map(block, BlockPage.class);
    }

    public BlockText blockDtoToBlockText(BlockDto block) {
        return modelMapper.map(block, BlockText.class);

    }

    public BlockImage blockDtoToBlockImage(BlockDto block) {
        return modelMapper.map(block, BlockImage.class);
    }

    // BLOCKDTO -> BLOCK<TYPE>DTO
    public BlockImageDto blockDtoToBlockImageDto (BlockDto block) {
        return modelMapper.map(block, BlockImageDto.class);
    }

    // ENTITY -> DTO
    public BlockDto blockPageToBlockDto(BlockPage blockPage) {
        return modelMapper.map(blockPage, BlockDto.class);
    }

    public BlockDto blockTextToBlockDto(BlockText blockText) {
        return modelMapper.map(blockText, BlockDto.class);
    }

    public BlockDto blockImageToBlockDto(BlockImage blockImage) {
        return modelMapper.map(blockImage, BlockDto.class);
    }


}
