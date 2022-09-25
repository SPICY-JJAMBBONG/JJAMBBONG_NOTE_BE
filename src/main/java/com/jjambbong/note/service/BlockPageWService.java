package com.jjambbong.note.service;

import com.jjambbong.note.dto.BlockDto;
import com.jjambbong.note.dto.BlockPageDto;
import com.jjambbong.note.dto.BlockTextDto;
import com.jjambbong.note.entity.Block;

public interface BlockPageWService {
    public void transferBlockToMap(BlockDto blockDto);
}
