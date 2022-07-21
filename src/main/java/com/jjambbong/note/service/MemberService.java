package com.jjambbong.note.service;

import com.jjambbong.note.entity.Member;
import org.springframework.stereotype.Service;

@Service
public interface MemberService{

    public Long registerMember(Member member);

    public Member findMember(Long memberId);

    public Member updateMember();

    public Long deleteMember();

}
