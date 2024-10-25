package com.example.demo.web.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.security.CustomUserDetails;

@Controller
@RequestMapping("/my")
public class UserController {

	
	@GetMapping("/info")
	public String detail(Authentication authentication) {
		// Principal은 요청 주체 정보를 담고 있는 객체.
		// 해당 객체에는 개발자가 만든 객체가 들어있음.
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal(); 
		System.out.println("사용자 번호: " + userDetails.getNo());
		System.out.println("닉네임: " + userDetails.getNickname());
		System.out.println("이메일: " + userDetails.getUsername());
		
		return "user/detail";
	}
}
