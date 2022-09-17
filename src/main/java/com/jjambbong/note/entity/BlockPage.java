package com.jjambbong.note.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
@Document(collection = "tb_block")
public class BlockPage {

	@Id
	private String id;

	private String type;

	private Double order;

	private LocalDateTime lastModifiedTime;

	private int indent;

	//page
	@Builder.Default
	private List<String> blockList = new ArrayList<>();

	private String title;


}
