package com.jjambbong.note.repository;

import com.jjambbong.note.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryOld {

	private final EntityManager em;

	// 회원 가입
	public void save(Member member)  {
		em.persist(member);
	}

	// 회원 조회
	public Member findById(Long id) {
		return em.find(Member.class, id);
	}

	// 회원 이메일로 조회
	public List<Member> findByEmail(String email) {
		return em.createQuery("select m from Member m where m.email = :email", Member.class)
				.setParameter("email", email)
				.getResultList();
	}
}
