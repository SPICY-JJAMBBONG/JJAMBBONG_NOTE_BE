package com.jjambbong.note.controller;


import com.jjambbong.note.service.BlockImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BlockImageController {

    @Autowired
    private final BlockImageService blockImageService;


}
