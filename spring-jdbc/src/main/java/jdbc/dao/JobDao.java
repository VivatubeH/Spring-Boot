package jdbc.dao;

import java.time.format.TextStyle;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jdbc.vo.Job;

@Repository
public class JobDao {
	
	@Autowired
	private JdbcTemplate t;
	
	public void insertJob(Job job) {
		String sql = """
				insert into jobs
				(job_id, job_title, min_salary, max_salary)
				values
				(?, ?, ?, ?)
				""";
		
		// jdbcTemplate에서는 update라는 메서드로 insert, update, delete를 모두 수행함.
		t.update(sql,
				job.getId(),
				job.getTitle(),
				job.getMinSalary(),
				job.getMaxSalary());
	}
	
	public List<Job> getAllJobs() {
		String sql = """
			SELECT *
			FROM JOBS
			ORDER BY JOB_ID ASC
		""";
		
		return t.query(sql, (rs, rowNum) -> {
			Job job = new Job();
			job.setId(rs.getString("job_id"));
			job.setTitle(rs.getString("job_title"));
			job.setMinSalary(rs.getInt("min_salary"));
			job.setMaxSalary(rs.getInt("max_salary"));
			
			return job;
		});
	}
	
	public Job getJobById(String id) {
		String sql = """
			SELECT *
			FROM JOBS
			WHERE JOB_ID = ?
		""";
		
		return t.queryForObject(sql, (rs, rowNum) -> {
			return null;
		}, id);
	}
	
	public void updateJob(Job job) {
		String sql = """
			UPDATE JOBS
			SET 
				JOB_TITLE = ?,
				MIN_SALARY = ?,
				MAX_SALARY = ?
			WHERE JOB_ID = ?
		""";
		
		t.update(sql,
				job.getTitle(),
				job.getMinSalary(),
				job.getMaxSalary(),
				job.getId());
	}
}
