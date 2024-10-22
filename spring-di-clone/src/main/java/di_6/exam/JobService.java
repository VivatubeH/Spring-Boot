package di_6.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

	// 방법 3, 생성자를 이용한 의존성 주입
	private JobDao jobDao;
	
	@Autowired
	public JobService(JobDao jobDao) {
		this.jobDao = jobDao;
	}
}
