package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {


            //영속
            Member member = em.find(Member.class, 150L);
            member.setName("AAAA");

            em.clear();
            Member member1 = em.find(Member.class, 150L);
            System.out.println("==================");
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}