package com.nobrand.jpa.standalone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-standalone");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic(em);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(EntityManager em) {
        Member member = new Member();
        String id = String.valueOf(member.hashCode());
        member.setId(id);
        member.setUsername("camellia");
        member.setAge(1);

        em.persist(member);
        member.setAge(2);

        Member found = em.find(Member.class, id);
        System.out.println(found.toString());

        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("members.size: " + members.size());

        em.remove(member);
    }
}
