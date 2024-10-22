package aop.demo1;

public interface BookService {

	int getTotalRows(String cat, String keyword);
	void addCart(int bookNo, int amount, String userId);
}
