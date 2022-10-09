package com.jjambbong.note.mapper;

import com.jjambbong.note.dto.BlockDto;
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
    public BlockPage BlockDtoToBlockPage (BlockDto block) {
        return modelMapper.map(block, BlockPage.class);
    }

    public BlockText BlockDtoToBlockText (BlockDto block) {
        return modelMapper.map(block, BlockText.class);

    }

    public BlockImage BlockDtoToBlockImage (BlockDto block) {
        return modelMapper.map(block, BlockImage.class);
    }


    // ENTITY -> DTO
    public BlockDto BlockPageToBlockDto (BlockPage blockPage) {
        return modelMapper.map(blockPage, BlockDto.class);
    }

    public BlockDto BlockTextToBlockDto (BlockText blockText) {
        return modelMapper.map(blockText, BlockDto.class);
    }

    public BlockDto BlockImageToBlockDto (BlockImage blockImage) {
        return modelMapper.map(blockImage, BlockDto.class);
    }

}
