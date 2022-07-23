package com.jjambbong.note.repository;

import com.jjambbong.note.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

	List<Member> findByEmail(String email);

}
