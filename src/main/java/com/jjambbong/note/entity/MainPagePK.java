package com.jjambbong.note.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class MainPagePK implements Serializable {

	private Long memberId;

	private String blockId;
}
