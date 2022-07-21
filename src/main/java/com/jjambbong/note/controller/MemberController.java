package com.jjambbong.note.controller;

import com.jjambbong.note.dto.MemberDto;
import com.jjambbong.note.entity.Member;
import com.jjambbong.note.service.MemberService;
import com.jjambbong.note.serviceImpl.MemberServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
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

    private final MemberService memberService;

    @PostMapping(path = "/api/auth/registration")
    public RegisterMemberResponse registerMember(MemberDto memberDto){

        Member member = Member.builder()
                .email(memberDto.getEmail())
                .password(memberDto.getPassword())
                .name(memberDto.getName())
                .createdDate(LocalDate.now())
                .build();

        Long id = memberService.registerMember(member);
        return new RegisterMemberResponse(id);
    };

//    @GetMapping(path = "/api/auth/user/{userId}")
//    public
//
//    @PutMapping(path = "/api/auth/user/{userId}")
//
//    @DeleteMapping(path = "/api/auth/user/{userId}")


    @Data
    static class RegisterMemberResponse {
        private Long id;

        public RegisterMemberResponse(Long id) {
            this.id = id;
        }
    }

}
