package di_6.exam;

import org.springframework.stereotype.Repository;

@Repository
public class DeptDao {

	public DeptDao() {
		System.out.println("DeptDao의 생성자 메소드 실행됨");
	}
}
