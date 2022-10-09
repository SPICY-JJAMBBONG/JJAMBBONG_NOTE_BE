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
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tb_block")
public class BlockPage implements Block{

	@Id
	private String id;

	private String type;

	private Date lastModifiedTime;

	private Double order;

	private int indent;

	//page
	@Builder.Default
	private List<String> blockList = new ArrayList<>();

	private String title;

//	public HashMap toMap() {
//		ObjectMapper objectMapper = new ObjectMapper();
//		// Date Format 설정
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
//		objectMapper.setDateFormat(dateFormat);
//		return objectMapper.convertValue(this, HashMap.class);
//	}
}
