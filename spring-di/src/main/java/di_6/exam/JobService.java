package di_6.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

	private JobDao jobDao;
	
	@Autowired
	public JobService(JobDao jobDao) {
		this.jobDao = jobDao;
	}
}
