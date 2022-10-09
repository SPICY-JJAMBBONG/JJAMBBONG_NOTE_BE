package com.jjambbong.note.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BlockImageDto {

    private String id;
    private String type;
    private String url;
    private String altText;
    private Date lastModifiedTime;

}
