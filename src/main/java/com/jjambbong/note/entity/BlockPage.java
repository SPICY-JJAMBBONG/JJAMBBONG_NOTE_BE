package com.jjambbong.note.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

//@Entity
@Builder
@Data
@Document(collection = "tb_block")
public class BlockPage {

	@Id
	private String id;

	@Builder.Default
	private String type = "page";

	@Column(name = "block_list")
	@NonNull
	@Builder.Default
	private List<String> blockList = new ArrayList<>();

	@Column(name = "title")
	private String title;

	@Column(name = "order")
	private long order;

	@Column(name = "last_modified_time")
	private LocalDateTime last_modified_time;

}
