package hellojpa.jpashop;

import hellojpa.jpashop.domain.Book;
import hellojpa.jpashop.domain.Order;
import hellojpa.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        try {

            Book book = new Book();
            book.setAuthor("min");
            book.setIsbn("2323");
            book.setName("JPA");
            em.persist(book);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
