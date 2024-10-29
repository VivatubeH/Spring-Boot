package com.example.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserRegisterForm;
import com.example.demo.exception.AlreadyUsedEmailException;
import com.example.demo.service.UserService;
import com.example.demo.vo.User;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String loginform() {
		return "login-form";
	}
	
	@GetMapping("/register")
	public String registerform(Model model) {
		model.addAttribute("registerForm", new UserRegisterForm());
		
		return "register-form";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("registerForm")UserRegisterForm form, BindingResult errors) {
		
		// 유효성 검증을 통과하지 못하면 register-form.jsp로 내부이동시킨다.
		if(errors.hasErrors()) {
			
			return "register-form";
		}
		
		// 추가적인 유효성 검증 실시하기
		if(!form.getPassword().equals(form.getPasswordConfirm())) {
			errors.rejectValue("passwordConfirm", null, "비밀번호가 일치하지 않습니다.");
			return "register-form";
		}
		
		// 아주 특별하지않는 이상 try catch 사 용 하 지 말 것 (되돌아가야해서 사용함) 
		try {
			// 업무로직 메소드를 호출한다.
			 userService.addNewUser(form);
		} catch (AlreadyUsedEmailException ex) {
			// 이메일 중복으로 폼 입력값이 유효하지 않는 경우 
			errors.rejectValue("email", null, "이미 사용중인 이메일입니다..");
			return "register-form";
		}
		
		return "redirect:/home";
	}
}