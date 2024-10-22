package com.example.demo.dto;

import java.util.List;

import com.example.demo.util.Pagination;

public class ListDto<T> { // 화면에 표시할 때는 데이터와 페이징 2개가 필요하다.
	// 목록화면에 표시되는 데이터다.
	List<T> data;
	// 목록화면에 표시되는 페이징처리정보다.
	Pagination paging;
	
	public ListDto(List<T> data, Pagination paging) {
		this.data = data;
		this.paging = paging;
	}
	
	public List<T> getData() {
		return data;
	}
	
	public Pagination getPaging() {
		return paging;
	}
}
