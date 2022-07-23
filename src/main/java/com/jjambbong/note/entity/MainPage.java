package com.jjambbong.note.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_main_page")
@IdClass(MainPagePK.class)
public class MainPage {

	@Id
	@Column(name = "member_id")
	private Long memberId;

	@Id
	@Column(name = "block_id")
	private Long blockId;
}
