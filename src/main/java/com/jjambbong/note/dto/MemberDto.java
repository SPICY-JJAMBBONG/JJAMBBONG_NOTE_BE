package com.jjambbong.note.dto;

import com.jjambbong.note.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberDto {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member)  {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public Member findByEmail(String email) {
        return em.find(Member.class, email);
    }
}
