package com.jjambbong.note;

import org.json.simple.JSONObject;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JSONParser {
	// JSONParser
	private final JSONParser jsonParser = new JSONParser();

	public void stringToJSONParser(String strJson) {
		//3. To Object
		Object obj = jsonParser.parse(strJson);

		//4. To JsonObject
		JSONObject jsonObj = (JSONObject)obj;

		//print
		System.out.println(jsonObj.get("userId")); //sim
	}
}
