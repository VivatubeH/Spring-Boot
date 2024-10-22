package di_6.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HrService {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private JobService jobService;
	
}
