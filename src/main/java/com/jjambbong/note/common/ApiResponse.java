package com.jjambbong.note.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {
	private ResponseCode code;
	private T message;

	public ApiResponse(Exception e) {
		code = ResponseCode.UNKNOWN;
		message = (T) ResponseCode.UNKNOWN.getMessage();
	}
}
