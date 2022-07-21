package com.jjambbong.note.controller;

import com.jjambbong.note.entity.Member;
import com.jjambbong.note.service.MemberService;
import com.jjambbong.note.serviceImpl.MemberServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberServiceImpl memberServiceImpl;

    @PostMapping(path = "/api/auth/registration")
    public String registerMember(@RequestBody Member member){
        Long id = memberServiceImpl.registerMember(member);
        return "index";
    }

}
