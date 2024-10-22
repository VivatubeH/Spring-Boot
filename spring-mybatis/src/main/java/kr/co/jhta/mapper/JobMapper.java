package kr.co.jhta.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import kr.co.jhta.vo.Job;

@Mapper
public interface JobMapper {
	
	void insertJob(Job job);
	void deleteJobById(String id);
	void updateJob(Job job);
	/*
	 void insertJob(@Param("x") Job job);
	 <insert id="insertJob">
	 	insert into jobs (job_id, job_title, min_salary, max_salary)
	 	values(#{x.id}, #{x.b}, #{x.c}, #{x.d})
	 </insert>
	 
	 void insertJob(@Param("a") String id,
	 				@Param("b") String title,
	 				@Param("c") int minSalary,
	 				@Param("d") int maxSalary);
	 			
	 <insert id="insertJob">
	 	insert into jobs (job_id, job_title, min_salary, max_salary)
	 	values(#{id}, #{b}, #{c}, #{d})
	 </insert>
	 */
	List<Job> getAllJobs();
	Job getJobById(String id);
}