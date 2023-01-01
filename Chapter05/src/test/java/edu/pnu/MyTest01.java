package edu.pnu;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class MyTest01 {

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	void dateinsert() {
		Random random = new Random();
		for (int i = 1; i <=100; i++) {
			boardRepo.save(new Board( "title" + i, "writer" + i, "content" + i,  random.nextLong(100)));
			
		}
	}
}
