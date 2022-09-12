package com.jjambbong.note.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class BlockDto{
	private String id;
	private String type;
	private LocalDateTime lastModifiedTime;
	private Long order;

	//page
	private List<String> blockList;
	private String title;

	//text
	private String content;
	private List<String> style;
}
