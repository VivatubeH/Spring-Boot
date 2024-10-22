package com.example.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	/*
	 * 요청URL
	 * 	http://localhost 혹은 http://localhost/
	 * 요청파라미터
	 * 	없음
	 * 반환값
	 * 	"home" -> "/WEB-INF/views/home.jsp"
	 *  컨트롤러 실행이 완료된 후에 이동할 JSP 페이지의 이름을 반환한다.
	 *  Model 객체에 값을 담으면 JSP 페이지에서 표현할 수 있다.
	 *  Model: 화면에 표현할 데이터[뷰에 전달할 데이터]를 담는 객체 
	 */
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("msg", "홈페이지 방문을 환영합니다.");
		return "home";
	}
}
