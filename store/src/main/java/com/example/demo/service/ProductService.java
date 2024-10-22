package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ListDto;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.util.Pagination;
import com.example.demo.vo.Product;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	/**
	 * 모든 상품정보 목록을 제공하는 서비스 메소드다.
	 * @param condition 조회조건이 포함된 Map 객체다.
	 * @return 모든 상품 목록
	 */
	public ListDto<Product> getAllProducts(Map<String, Object> condition) {
		// 검색조건에 맞는 전체 데이터 갯수를 조회한다.
		int totalRows = productMapper.getTotalRows(condition);
		
		// Pagination 객체를 생성한다.
		int page = (Integer) condition.get("page");
		int rows = (Integer) condition.get("rows");
		Pagination pagination = new Pagination(page, totalRows, rows);
		
		// 데이터 검색 범위를 조회해서 Map에 저장한다.
		int begin = pagination.getBegin();
		int end = pagination.getEnd();
		condition.put("begin", begin);
		condition.put("end", end);
		
		//  조회범위에 맞는 데이터 조회하기
		List<Product> products = productMapper.getProducts(condition);
		
		// Product타입의 데이터를 담는 ListDto 객체를 생성한다.
		// 상품목록(List<Products>), 페이징처리정보(Pagination)을 담는다.
		ListDto<Product> dto = new ListDto<>(products, pagination);
		return dto;
	}
	
	
}
