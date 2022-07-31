package com.jjambbong.note.controller;

import com.jjambbong.note.common.ApiResponse;
import com.jjambbong.note.dto.MemberDto;
import com.jjambbong.note.entity.Member;
import com.jjambbong.note.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
		System.out.println("member = " + member);

		ApiResponse response;
		try {
			response = memberService.registerMember(member);
		} catch (Exception e) {
			response = new ApiResponse();
		}
		return response;
	}

	@GetMapping(path = "/api/auth/user/{memberId}")
	public ApiResponse getMember(@PathVariable Long memberId) {
		return memberService.getMemberFromMemberId(memberId);
	}

//    @PutMapping(path = "/api/auth/user/{userId}")
//
//    @DeleteMapping(path = "/api/auth/user/{userId}")

	@Data
	static class RegisterMemberResponse {
		private Long id;

		public RegisterMemberResponse(Long id) {
			this.id = id;
		}
	}
}
