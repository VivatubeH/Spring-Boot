package com.example.demo.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.security.LoginUser;

@Controller
@RequestMapping("/my")
public class UserController {

	@GetMapping("/info")
	public String detail(@AuthenticationPrincipal LoginUser loginUser) { // 유저 details가 들어있다. 요청주체를 담고있는 객체 

		System.out.println("사용자 번호:" + loginUser.getNo());
		System.out.println("사용자 이메일:" + loginUser.getEmail());
		System.out.println("사용자 닉네임:" + loginUser.getNickname());
		
		return "user/detail";	
	}
	 
}
