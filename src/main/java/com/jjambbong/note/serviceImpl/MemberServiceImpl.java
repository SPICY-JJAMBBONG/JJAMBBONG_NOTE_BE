package com.jjambbong.note.serviceImpl;

import com.jjambbong.note.repository.MemberRepository;
import com.jjambbong.note.repository.MemberRepositoryOld;
import com.jjambbong.note.entity.Member;
import com.jjambbong.note.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    // 회원 가입
    @Override
    @Transactional
    public Long registerMember(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getMemberId();
    }

    // 회원 조회
    @Override
    @Transactional(readOnly = true)
    public Optional<Member> findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 중복 회원 검색
    public void validateDuplicateMember(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());

        if (findMember != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }

    @Override
    public Member updateMember() {
        return null;
    }

    @Override
    public Long deleteMember() {
        return null;
    }
}
