package com.example.demo.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeRegisterForm {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	// 날짜 데이터의 경우, 이렇게 패턴을 지정해줘야 오류가 나지 않는다.
	// 안 그러면 String -> Date에서 오류가 발생함.
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	private String jobId;
	private double salary;
}
