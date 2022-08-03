package com.jjambbong.note.common;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BlockJsonParser {
	// JSONParser
	private final JSONParser jsonParser = new JSONParser();

	public ApiResponse stringToJSONParser(String strJson) {

		try {
			Object obj = jsonParser.parse(strJson);
			JSONObject jsonObj = (JSONObject)obj;
			return new ApiResponse(ResponseCode.SUCCESS, String.valueOf(jsonObj.get("block_list")));
		} catch (ParseException e) {
			return new ApiResponse(ResponseCode.UNKNOWN, e.getMessage());
		}

	}
}
