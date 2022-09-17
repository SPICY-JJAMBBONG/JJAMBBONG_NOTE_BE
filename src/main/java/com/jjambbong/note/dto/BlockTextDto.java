package com.jjambbong.note.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class BlockTextDto {
	private String id;
	private String type;
	private List<String> style;
	private String content;
	private Double order;
	private int indent;
	private LocalDateTime lastModifiedTime;
}
