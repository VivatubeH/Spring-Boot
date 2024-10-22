package di_5.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public BoardService() {
		System.out.println("BoardService의 생성자 메소드 실행됨");
	}
	
	public void 게시글등록(String title, String content) {
		System.out.println("BoardService의 게시글등록() 메소드 실행됨");
		boardDao.insert(title, content);
	}
}
