package com.jjambbong.note.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BlockPageDto {
	private String id;
	private String type;
	private List<String> blockList;
	private String title;
	private Double order;
	private int indent;
	private Date lastModifiedTime;
}
