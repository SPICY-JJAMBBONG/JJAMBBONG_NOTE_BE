package com.jjambbong.note.entity;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.ObjectMapper;

@Builder
@Data
@ToString
@Document(collection = "tb_block")
public class BlockText implements Block{

	@Id
	private String id;

	private String type;

	private Date lastModifiedTime;

	private Double order;

	private int indent;

	//text
	private String content;

	@Builder.Default
	private List<String> style = new ArrayList<>();

	public HashMap toMap() {
		ObjectMapper objectMapper = new ObjectMapper();
		// Date Format 설정
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		objectMapper.setDateFormat(dateFormat);
		return objectMapper.convertValue(this, HashMap.class);
	}
}
