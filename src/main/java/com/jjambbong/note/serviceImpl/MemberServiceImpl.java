package com.jjambbong.note.serviceImpl;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.common.ResponseCode;
import com.jjambbong.note.dto.MemberDto;
import com.jjambbong.note.entity.Member;
import com.jjambbong.note.repository.MemberRepository;
import com.jjambbong.note.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Transactional
@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;


	// 회원 가입
	@Override
	@Transactional
	public ApiResponse<String> registerMember(Member member) {
		if (isAlreadyUsedEmail(member)) {
			return new ApiResponse<>(ResponseCode.DUPLICATED_USER, ResponseCode.DUPLICATED_USER.getMessage());
		} else {
			try {
				memberRepository.save(member);
			} catch (Exception e) {
				return new ApiResponse<>(e);
			}
			return new ApiResponse<>(ResponseCode.SUCCESS, member.getMemberId().toString());
		}
	}

	// 회원 조회
	@Override
	@Transactional(readOnly = true)
	public Optional<Member> findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}

	// 중복 회원 검색
	public boolean isAlreadyUsedEmail(Member member) {
		List<Member> findMember = memberRepository.findByEmail(member.getEmail());
		return !findMember.isEmpty();
	}

	@Override
	public ApiResponse<String> updateMember(MemberDto memberDto, Long memberId) {
		Member member = memberRepository.getMemberByMemberId(memberId);

		member.setName(memberDto.getName());
		member.setRole(memberDto.getRole());

		memberRepository.save(member);

		return new ApiResponse<>(ResponseCode.SUCCESS, member.getMemberId().toString());
	}

	@Override
	public Long deleteMember() {
		return null;
	}

	@Override
	public ApiResponse<?> getMemberFromMemberId(Long memberId) {
		try {
			Member findMember = memberRepository.getMemberByMemberId(memberId);

			HashMap<String, String> map = new HashMap<>();
			map.put("memberId", findMember.getMemberId().toString());
			map.put("email", findMember.getEmail());
			map.put("name", findMember.getName());
			map.put("createdDateTime", findMember.getCreatedDateTime().toLocalDate().toString());
			map.put("role", findMember.getRole());

			return new ApiResponse<>(ResponseCode.SUCCESS, map);
		} catch (Exception e) {
			return new ApiResponse<String>(e);
		}
	}
}
