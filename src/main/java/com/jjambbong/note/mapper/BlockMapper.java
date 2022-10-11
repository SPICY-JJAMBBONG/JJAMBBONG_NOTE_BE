package com.jjambbong.note.mapper;

import com.jjambbong.note.dto.BlockDto;
import com.jjambbong.note.entity.Block;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BlockMapper {

    @Autowired
    ModelMapper modelMapper;

    // DTO -> ENTITY
    public Block blockDtoToBlock(BlockDto blockDto) {
        return modelMapper.map(blockDto, Block.class);
    }
}
