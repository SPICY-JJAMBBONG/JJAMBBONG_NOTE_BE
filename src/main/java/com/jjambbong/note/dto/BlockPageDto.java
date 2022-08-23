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
	private Long order;
	private LocalDateTime lastModifiedTime;
}
