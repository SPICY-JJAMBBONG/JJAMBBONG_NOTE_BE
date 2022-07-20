package com.jjambbong.note.serviceImpl;

import com.jjambbong.note.dto.MemberDto;
import com.jjambbong.note.entity.Member;
import com.jjambbong.note.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl {

    @Autowired
    private MemberDto memberDto;

    public Long registerMember(Member member) {
        validateDuplicateMember(member);
        memberDto.save(member);
        return member.getMemberId();
    }

    @Transactional(readOnly = true)
    public Member findMember(Long memberId) {
        return memberDto.findOne(memberId);
    }

    public void validateDuplicateMember(Member member) {
        Member findMember = memberDto.findByEmail(member.getEmail());

        if (findMember != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }
}
