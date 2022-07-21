package com.jjambbong.note.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberDto {
    private String email;
    private String password;
    private String name;
    private LocalDate createdDate;
}
