package aop.demo1;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

	@Override
	public int getTotalRows(String cat, String keyword) {
		
		System.out.println("핵심기능: 총 검색건수를 반환한다.");
		return 0;
	}
	
	@Override
	public void addCart(int bookNo, int amount, String userId) {
		
		System.out.println("핵심기능: 장바구니에 추가한다.");
		
	}
}
