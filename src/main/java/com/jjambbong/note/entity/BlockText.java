package com.jjambbong.note.entity;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
@Document(collection = "tb_block")
public class BlockText {

	@Id
	private String id;

	private String type;

	private Double order;

	private Date lastModifiedTime;

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
