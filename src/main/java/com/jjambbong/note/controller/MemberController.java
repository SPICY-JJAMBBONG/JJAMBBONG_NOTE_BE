package com.jjambbong.note.controller;

import com.jjambbong.note.entity.Member;
import com.jjambbong.note.service.MemberService;
import com.jjambbong.note.serviceImpl.MemberServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberServiceImpl memberServiceImpl;

    @PostMapping(path = "/api/auth/registration")
    public RegisterMemberResponse registerMember(@RequestBody @Validated RegisterMemberRequest request){

        Member member = Member.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .name(request.getName())
                .createdDate(request.getCreatedDate())
                .build();
        Long id = memberServiceImpl.registerMember(member);
        return new RegisterMemberResponse(id);
    }

    @Data
    static class RegisterMemberRequest {
        private String email;
        private String password;
        private String name;
        private LocalDate createdDate;
    }

    @Data
    static class RegisterMemberResponse {
        private Long id;

        public RegisterMemberResponse(Long id) {
            this.id = id;
        }
    }

}
