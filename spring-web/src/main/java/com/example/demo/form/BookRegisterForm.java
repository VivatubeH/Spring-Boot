package com.example.demo.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookRegisterForm {

	private String title;
	private String author;
	private String publisher;
	private int price;
	private String pubDate;
}
