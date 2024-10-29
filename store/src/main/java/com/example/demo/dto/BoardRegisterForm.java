package com.example.demo.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BoardRegisterForm {

	private String title;
	private String content;
	private MultipartFile upfile; // 절대로 null 아니다. 언제나 생성됨 비어있음
}
