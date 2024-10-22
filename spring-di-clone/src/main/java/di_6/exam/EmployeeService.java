package di_6.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	// 방법 1, 그냥 의존성 주입
	@Autowired
	private EmpDao empDao;
	@Autowired
	private JobDao jobDao;
	@Autowired
	private DeptDao deptDao;
}
