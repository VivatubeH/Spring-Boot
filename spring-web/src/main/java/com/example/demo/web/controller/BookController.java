package com.example.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.form.BookRegisterForm;
import com.example.demo.service.BookService;
import com.example.demo.vo.Book;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "book/list";
	}
	
	@PostMapping("/add")
	// 신규 도서 입력을 처리하는 메소드
	public String addBook(BookRegisterForm form) {
		System.out.println(form);
		return null;
	}
	
	// 신규 도서 입력폼 요청을 처리하는 메소드
	@GetMapping("/add")
	public String form() {
		return "book/form"; // 내부 이동
	}
	
	@GetMapping("/detail")
	public String select(int no) { // 무조건이면 @RequestParam도 적을 필요가 없다.
		return "book/detail";
	}
}
