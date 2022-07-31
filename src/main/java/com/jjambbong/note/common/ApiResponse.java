package com.jjambbong.note.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
	private ResponseCode code;
	private String message;

	public ApiResponse(Exception e) {
		code = ResponseCode.UNKNOWN;
		message = ResponseCode.UNKNOWN.getMessage();
	}
}
