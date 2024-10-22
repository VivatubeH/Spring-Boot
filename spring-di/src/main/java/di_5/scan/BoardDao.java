package di_5.scan;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {

	public BoardDao() {
		System.out.println("BoardDao의 생성자 메소드 실행됨");
	}
	public void insert(String title, String content) {
		System.out.println("BoardDao의 insert() 메소드 실행됨");
		System.out.println("제목: " + title);
		System.out.println("내용: " + content);
		
		System.out.println("BoardDao의 insert() 메소드 종료됨");
	}
}
