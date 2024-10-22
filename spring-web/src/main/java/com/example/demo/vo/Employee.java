package com.example.demo.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 기본 생성자 메소드를 추가한다.
@NoArgsConstructor
// 모든 매개변수를 초기화하는 생성자 메소드를 추가한다.
@AllArgsConstructor
// 모든 Getter 메소드를 추가한다.
@Getter
// 모든 Setter 메소드를 추가한다.
@Setter
// toString() 메소드를 재정의한다.
@ToString
public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
}
