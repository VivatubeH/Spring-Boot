package di_5.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	// 의존성을 주입받을 참조변수 선언
	@Autowired
	private BoardDao boardDao;
	
	public BoardService() {
		System.out.println("BoardService의 생성자 메서드 실행됨");
	}
	// Setter나 생성자 메소드 사용 없이 주입받아보자.
	public void 게시글등록(String title, String content) {
		System.out.println("BoardService의 게시글등록() 메서드 실행됨");
		boardDao.insert(title, content);
	}
}
