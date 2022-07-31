package com.jjambbong.note.service;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.dto.MemberDto;
import com.jjambbong.note.entity.Member;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MemberService {

	public ApiResponse registerMember(Member member);

	public Optional<Member> findMember(Long memberId);

	public ApiResponse updateMember(MemberDto memberDto, Long memberId);

	public Long deleteMember();

}
