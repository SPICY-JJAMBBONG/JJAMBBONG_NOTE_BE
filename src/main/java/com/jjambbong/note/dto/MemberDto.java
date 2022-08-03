package com.jjambbong.note.dto;

import lombok.Data;

@Data
public class MemberDto {
	private String email;
	private String password;
	private String name;
	private String role;
}
