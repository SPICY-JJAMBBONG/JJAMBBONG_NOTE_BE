package com.jjambbong.note.service;

import com.jjambbong.note.dto.MemberDto;
import com.jjambbong.note.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface MemberService{

    public Long registerMember();

    public Member findMember();

    public Member updateMember();

    public Long deleteMember();

}
