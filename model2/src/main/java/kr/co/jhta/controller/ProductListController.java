package kr.co.jhta.controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jhta.vo.Company;
import kr.co.jhta.vo.Product;
import model2.controller.Controller;

public class ProductListController implements Controller {

	@Override
	public String exe(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("### 상품목록컨트롤러: exe(req, res) 실행됨");
		
		Company c1 = new Company(100, "애플코리아", "02-1234-5678");
		Company c2 = new Company(200, "삼성전자", "02-1111-1111");
		Company c3 = new Company(300, "LG전자", "02-2222-2222");
		
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(11, "아이폰16", c1, 1650000, false));
		productList.add(new Product(22, "애플와치10", c1, 500000, false));
		productList.add(new Product(24, "갤럭시폴드10", c2, 2000000, false));
		productList.add(new Product(31, "갤럭시폴드7", c2, 1700000, true));
		productList.add(new Product(46, "그램노트북", c3, 2500000, false));
		
		req.setAttribute("products", productList);
		
		System.out.println("### 상품목록컨트롤러: exe(req, res) 종료됨");
		
		return "product/list.jsp";
	}
}
