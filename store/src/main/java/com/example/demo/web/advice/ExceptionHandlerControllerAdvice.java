package com.example.demo.web.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.StoreException;

/*
 * @ControllerAdvice
 * 	- 모든 컨트롤러에서 공통으로 사용되는 기능을 정의하는 클래스임을 나타낸다.
 *  - 주로, 예외처리 관련 내용을 정의한다.
 */
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
//	@ExceptionHandler(Exception.class) // 더 구체적인 예외에 걸리도록 설계되어 있다.
//	// Exception은 모든 예외클래스의 조상이니 보험용이다.
//	// 내 의도와 관계없이 발생하는 예외
//	public String handleException(Exception ex) {
//		return "error/server-error"; // WEB-INF/views/error/server-error.jsp로 보낸다.
//	}
	
	@ExceptionHandler(StoreException.class)
	// 내가 예외 발생을 의도해서 설계해놓은 업무적인 예외
	public String handleStoreException(StoreException ex, Model model) {
		model.addAttribute("msg", ex.getMessage());
		
		return "error/business-error";
	}
}
