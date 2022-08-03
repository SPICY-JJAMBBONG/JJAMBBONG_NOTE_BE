package com.jjambbong.note.controller;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.dto.MemberDto;
import com.jjambbong.note.entity.Member;
import com.jjambbong.note.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping(path = "/api/auth/registration")
	public ApiResponse registerMember(MemberDto memberDto) {
		Member member = Member.builder()
				.email(memberDto.getEmail())
				.password(memberDto.getPassword())
				.name(memberDto.getName())
				.build();

		ApiResponse response;
		try {
			response = memberService.registerMember(member);
		} catch (Exception e) {
			response = new ApiResponse();
		}
		return response;
	}

	@PutMapping(path = "/api/auth/user/{userId}")
	public ApiResponse updateMember(MemberDto memberDto, @PathVariable Long userId) {
		ApiResponse response = memberService.updateMember(memberDto, userId);
		return response;
	}

	@GetMapping(path = "/api/auth/user/{memberId}")
	public ApiResponse getMember(@PathVariable Long memberId) {
		return memberService.getMemberFromMemberId(memberId);
	}


//    @DeleteMapping(path = "/api/auth/user/{userId}")

	@Data
	static class RegisterMemberResponse {
		private Long id;

		public RegisterMemberResponse(Long id) {
			this.id = id;
		}
	}
}
