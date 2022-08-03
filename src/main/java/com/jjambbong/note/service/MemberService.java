package com.jjambbong.note.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.dto.MemberDto;
import com.jjambbong.note.entity.Member;

@Service
public interface MemberService {

	public ApiResponse registerMember(Member member);

	public Optional<Member> findMember(Long memberId);

	public ApiResponse updateMember(MemberDto memberDto, Long memberId);

	public ApiResponse deleteMember(Long memberId);

	public ApiResponse getMemberFromMemberId(Long memberId);
}
