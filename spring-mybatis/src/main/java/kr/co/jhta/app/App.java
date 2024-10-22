package kr.co.jhta.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.jhta.mapper.JobMapper;
import kr.co.jhta.vo.Job;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext ctx 
			= new ClassPathXmlApplicationContext("context/context.xml");
		
		JobMapper jobMapper = ctx.getBean(JobMapper.class);
		
		Job job = jobMapper.getJobById("vivatesf");
		System.out.println(job);
//		Job job = new Job();
//		job.setId("교육");
//		job.setTitle("직원 교육 및 강의");
//		job.setMinSalary(4500);
//		job.setMaxSalary(8000);
//		
//		jobMapper.insertJob(job);
		
	}
}
