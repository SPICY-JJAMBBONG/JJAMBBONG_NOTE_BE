package com.jjambbong.note.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ApiController {

	@GetMapping(path = "/document")
	public String document(Model model) {
		return "index";
	}

}
