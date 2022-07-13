package com.jjambbong.note.controller;

import com.jjambbong.note.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//@AllArgsConstructor
public class MemberController {

//    private final MemberService memberService;

    @PostMapping(path = "/api/auth/registration")
    public String registerMember(Model model, HttpRequestHandler req) {
        System.out.println("memberId = " + model.getAttribute("memberId"));
        System.out.println("email = " + model.getAttribute("email"));
        return "index";
    }

}
