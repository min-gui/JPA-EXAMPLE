package hellojpa.jpashop;

import hellojpa.jpashop.domain.Member;
import hellojpa.jpashop.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            System.out.println("----------");

            Member member1 = new Member();
            member1.setName("min");
            //member1.changeTeam(team); // 단방향 연관관계 설정, 참조 저장
            //team.getMembers().add(member1);

            team.addMember(member1);
            em.persist(member1);


            //em.flush();
            //em.clear();
            System.out.println("-----------");

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();
            for (Member m : members){
                System.out.println("member1.getName() = " + m.getName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
