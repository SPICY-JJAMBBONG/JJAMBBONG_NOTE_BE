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

	@NonNull
	@Builder.Default
	private List<String> blockList = new ArrayList<>();

	private String title;

	private long order;

	private LocalDateTime lastModifiedTime;

}
