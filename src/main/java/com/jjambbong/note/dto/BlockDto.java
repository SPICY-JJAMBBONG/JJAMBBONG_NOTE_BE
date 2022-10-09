package com.jjambbong.note.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class BlockDto {
    private String id;
    private String type;
    private List<String> blockList;
    private String title;
    private Double order;
    private int indent;
    private LocalDateTime lastModifiedTime;
    private List<String> style;
    private String content;
    private String url;
    private String altText;
}
