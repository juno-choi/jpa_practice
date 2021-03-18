package com.jpa.practice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
            //test34
            Order order = new Order();
            //order.addOrderItem(new OrderItem());
            //이런식으로 양방향 연관관계를 사용하지 않고 단방향 연관관계로만으로도 충분히 insert할수 있다.
            em.persist(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);

            em.persist(orderItem);

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
