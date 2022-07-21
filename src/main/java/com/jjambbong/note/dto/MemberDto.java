package com.jjambbong.note.dto;

import com.jjambbong.note.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class MemberDto {

    private final EntityManager em;

    public void save(Member member)  {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public Member findByEmail(String email) {
        System.out.println("findByEmail");
        return em.find(Member.class, email);
    }
}
