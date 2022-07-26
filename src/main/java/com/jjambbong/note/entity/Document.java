package com.jjambbong.note.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Document {

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private String content;
}
