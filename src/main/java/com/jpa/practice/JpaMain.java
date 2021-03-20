package com.jpa.practice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.practice.domain.Book;
import com.jpa.practice.domain.Order;
import com.jpa.practice.domain.OrderItem;

public class JpaMain{
    public static void main(String[] args) {
        //db와의 연결
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //트랜잭션 정의
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //code
        try{
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("최준호");

            em.persist(book);

            tx.commit();
        }catch(Exception e){
            tx.rollback();
        } finally{
            //자원 반납
            em.close();
        }
        //자원 반납
        emf.close();
    }
}