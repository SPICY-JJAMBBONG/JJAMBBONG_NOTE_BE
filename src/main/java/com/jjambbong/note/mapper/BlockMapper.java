package com.jjambbong.note.mapper;

import com.jjambbong.note.dto.BlockDto;
import com.jjambbong.note.dto.BlockTextDto;
import com.jjambbong.note.entity.BlockPage;
import com.jjambbong.note.dto.BlockPageDto;
import com.jjambbong.note.entity.BlockText;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlockMapper {

    @Autowired
    ModelMapper modelMapper;

    public BlockPage BlockDtoToBlockPage (BlockDto block) {
        Class<BlockPage> blockPageClass = BlockPage.class;
        BlockPage blockPage = modelMapper.map(block, BlockPage.class);
        return modelMapper.map(block, BlockPage.class);
    }

    public BlockText BlockDtoToBlockText (BlockDto block) {
        return modelMapper.map(block, BlockText.class);

    }

    public BlockDto BlockPageToBlockDto (BlockPage blockPage) {
        return modelMapper.map(blockPage, BlockDto.class);
    }

    public BlockDto BlockTextToBlockDto (BlockText blockText) { return modelMapper.map(blockText, BlockDto.class); }

    public BlockPageDto BlockDtoToBlockPageDto (BlockDto blockDto) { return modelMapper.map(blockDto, BlockPageDto.class); }

    public BlockTextDto BlockDtoToBlockTextDto (BlockDto blockDto) { return modelMapper.map(blockDto, BlockTextDto.class); }
}
