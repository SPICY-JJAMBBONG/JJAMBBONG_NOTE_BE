package com.jjambbong.note.serviceImpl;

import com.jjambbong.note.dto.MemberDto;
import com.jjambbong.note.entity.Member;
import com.jjambbong.note.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl {

    private final MemberDto memberDto;

    // 회원 가입
    @Transactional
    public Long registerMember(Member member) {
        validateDuplicateMember(member);
        memberDto.save(member);
        return member.getMemberId();
    }

    // 회원 조회
    @Transactional(readOnly = true)
    public Member findMember(Long memberId) {
        return memberDto.findOne(memberId);
    }

    // 중복 회원 검색
    public void validateDuplicateMember(Member member) {
        System.out.println("중복 회원 검사 시작");
        List<Member> findMember = memberDto.findByEmail(member.getEmail());

        if (!findMember.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }
}
