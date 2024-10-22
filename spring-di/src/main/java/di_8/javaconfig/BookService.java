package di_8.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	private BookDao bookDao;
	
	@Autowired
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
		System.out.println("BookService의 setBookDao() 메소드 실행됨");
		System.out.println("BookService의 setBookDao() 메소드가 전달받은 객체: " + bookDao);
	}
	
	public BookService() {
		System.out.println("BookServcie 생성자 메소드 실행됨");
	}
}
