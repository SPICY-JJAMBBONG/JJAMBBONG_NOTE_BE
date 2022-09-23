package com.jjambbong.note.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public HashMap toHashMap() {
		ObjectMapper objectMapper = new ObjectMapper();
		HashMap<String, Object> map = objectMapper.convertValue(this, HashMap.class);
		return map;
	}
}
