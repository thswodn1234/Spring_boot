package edu.pnu;

import java.util.Date;

import edu.pnu.domain.Board;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JPAClient2 {
	public static void test(EntityManagerFactory emf) {
    EntityManager em = emf.createEntityManager();
    //Transaction 생성
    EntityTransaction tx = em.getTransaction();
    try {
  	  // Transaction 시작
  	  tx.begin();
  	  for(int i = 0; i < 10; i++) {
  		  
       Board board = new Board();
//       board.setSeq(1L);
       board.setTitle("JPA 제목");
       board.setWriter("관리자");
       board.setContent("JPA 글 등록 잘 되네요.");
       board.setCreateDate(new Date());
       board.setCnt(0L);
       
       // 글 등록
       em.persist(board);
  	  }
       
       // Transaction commit
       tx.commit();
       System.out.println("---------->Commit");
       
    }catch(Exception e) {
       e.printStackTrace();
       tx.rollback();
       System.out.println("---------->RollBack");
    }finally {
       em.close();
       emf.close();
    }
	}		
	
   public static void main(String[] args) {
	   //EntityManager 생성
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
      EntityManager em = emf.createEntityManager();
      //Transaction 생성
      EntityTransaction tx = em.getTransaction();
      try {
    	  // Transaction 시작
    	  tx.begin();
    	 
    	  // 수정할 게시글 조회
    	  Board board = em.find(Board.class, 1L);
    	  board.setTitle("검색한 게시글의 제목 수정");
    
         // Transaction commit
         tx.commit();
         System.out.println("---------->Commit");
         
      }catch(Exception e) {
         e.printStackTrace();
         tx.rollback();
         System.out.println("---------->RollBack");
      }finally {
    	  
         em.close();
         emf.close();
      }
   }
}