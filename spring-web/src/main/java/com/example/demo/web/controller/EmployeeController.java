package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.form.EmployeeRegisterForm;
import com.example.demo.service.EmployeeService;
import com.example.demo.vo.Employee;

/*
 * 컨트롤러 클래스
 * 	- 사원정보 관련 HTTP 요청을 처리하는 컨트롤러 클래스다.
 *  - 사원정보 관련 HTTP 요청을 처리하기 위해서는 업무로직
 *   메소드의 호출이 필수다.
 *   * EmployeeService 객체에 의존한다.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	/*
	 * 신규 직원 입력폼화면 요구 요청을 처리한다.
	 * 요청 URL
	 * 		http://localhost/employee/register
	 * 요청 방식
	 * 		GET 
	 * 
	 */
	@GetMapping("/register")
	public String registerform() {
		
		return "emp/form"; // WEB-INF/views/emp/form.jsp [ 내부 이동 ]
	}
	
	/*
	 * 신규 직원 등록 요청을 처리한다.
	 * 요청 URL
	 * 		http://localhost/employee/register
	 * 요청 방식
	 * 		POST
	 * 요청 파라미터
	 * 		firstName
	 * 		lastName
	 * 		email
	 * 		phoneNumber
	 * 		hireDate
	 * 		jobId
	 * 		salary
	 */
	@PostMapping("/register")
	public String register(EmployeeRegisterForm form) {
		System.out.println("입력폼에서 전달한 값: " + form);
		
		// 폼정보를 서비스에 전달해서 신규 직원으로 등록시킨다.
		employeeService.addNewEmployee(form);
		
		// 재요청 URL을 응답으로 보낸다.
		return "redirect:/employee/list";
	}
	
	/*
	 * 사원상세정보 요청을 처리한다.
	 * 요청 URL
	 * 	http://localhost/employee/detail?id=100
	 * 요청 파라미터
	 * 	id=100
	 */
	@GetMapping("/detail")
	public String detail(@RequestParam("id") int id, Model model) { // 기본자료형값이면 항상 요청 파라미터라고 생각한다.
		System.out.println("직원아이디: " + id);
		
		// 업무로직을 호출해서 직원 상세정보 조회하기
		Employee employee = employeeService.getEmployeeDetail(id);
		// JSP에 전달하기 위해서 Model 객체에 객체 담기
		model.addAttribute("emp", employee);
		return "emp/detail"; // /WEB-INF/views/emp/detail.jsp
	}
	
	/*
	 * 요청 URL
	 * 	http://localhost/employee/list
	 * 	http://localhost/employee/list?dept=10
	 */
	@GetMapping("/list") // employee/list에 매핑되는 핸들러 메소드
	public String employees(@RequestParam(name = "dept", required = false, defaultValue = "0") int dept, Model model) {
		
		List<Employee> emps = employeeService.getEmployees(dept);
		model.addAttribute("employeeList", emps);
		
		return "emp/list"; // JSP 페이지 경로 
	}
}
