package com.example.demo.web.view;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FileDownloadView implements View {

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String directory = (String) model.get("directory");
		String filename = (String) model.get("filename");
		
		System.out.println("디렉토리: " + directory);
		System.out.println("파일이름: " + filename);
	}
	
}
