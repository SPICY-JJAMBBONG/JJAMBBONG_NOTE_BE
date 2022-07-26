package com.jjambbong.note.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

//@Entity
@Builder
@Data
@Document(collection = "tb_block_page")
public class BlockPage {

	@Id
	@Column(name = "block_id")
	private UUID blockId;

	private String type = "page";

	@Column(name = "block_list")
	@NonNull
	private String blockList;

	@Column(name = "page_list")
	@NonNull
	private String pageList;

}
