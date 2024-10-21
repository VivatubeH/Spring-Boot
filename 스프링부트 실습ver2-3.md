application.yml
------------------------------
```xml
### 톰캣서버의 포트번호를 정의한다.
server:
  port: 80

spring:
### 애플리케이션 이름을 정의한다.
  application:
    name: store
### 데이터베이스 연결정보를 정의한다.
  datasource:
    driver-class-name: oracle.jdbc.OracleDriver
    url: jdbc:oracle:thin:@localhost:1521:xe
    username: hta
    password: zxcv1234
### spring mvc 설정
  mvc:            # JSP 뷰페이지 경로 및 확장자를 정의한다.
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp

### mybatis 설정
mybatis:
  mapper-locations: # 매퍼파일 저장경로를 정의한다.
    - mybatis/mappers/*.xml
  type-aliases-package: com.example.demo.vo
  configuration:    # 기타 설정정보를 정의한다.
    jdbc-type-for-null: NULL
    log-impl: org.apache.ibatis.logging.log4j2.Log4j2Impl

```

com.example.demo.vo.Category // [Alias 설정하면 Result 적을 때 그냥 이 이름으로 적으면 됨 ]
-------------------------------------------
```java
package com.example.demo.vo;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Alias("Category")
public class Category {

	private int no;
	private String name;
}

```

com.example.demo.vo.Product
----------------------------------------
```java
package com.example.demo.vo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Alias("Product")
public class Product {

	private int no;
	private String name;
	private String maker;
	private int price;
	private int discountPrice;
	private int stock;
	private int reviewCnt;
	private String sell;
	private Date createdDate;
	private Date updatedDate;
	private Category category;
}
```

com.example.demo.mapper.CategoryMapper 클래스
--------------------------------------------
```java
package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.Category;

@Mapper
public interface CategoryMapper {

	List<Category> getAllCategories();
	Category getCategoryByNo(@Param("no") int no);
}
```

com.example.demo.mapper.ProductMapper 클래스
--------------------------------------------
```java
package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.Product;

@Mapper
public interface ProductMapper {

	List<Product> getProducts(@Param("condition") Map<String, Object> condition);
	Product getProductByNo(@Param("no") int no);
}

```

ProductController 클래스
--------------------------
```java
package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.ProductService;
import com.example.demo.vo.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public String list(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
					   @RequestParam(name = "rows", required = false, defaultValue = "10") int rows,
					   @RequestParam(name = "opt", required = false) String opt,
					   @RequestParam(name = "value", required = false) String value,
					   Model model) {
		
		Map<String, Object> condition = new HashMap<>();
		condition.put("page", page);
		condition.put("rows", rows);
		if(StringUtils.hasText(value)) { // null이 아니고 값이 있는 경우에만
			condition.put("opt", opt);
			condition.put("value", value);
		}
		
		List<Product> products = productService.getAllProducts(condition);
		model.addAttribute("products", products);
		
		return "product/list";
	}
	
	@GetMapping("/detail")
	public String detail() {
		
		return "product/detail";
	}
}
```

WebController 클래스
-----------------------------------------------
```java
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
}
```

ProductService 클래스
--------------------------------------------
```java
package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.ProductMapper;
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
	public List<Product> getAllProducts(Map<String, Object> condition) {
		List<Product> products = productMapper.getProducts(condition);
		return products;
	}
	
	
}

```

CategoryMapper.xml
----------------------------
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.demo.mapper.CategoryMapper"></mapper>
```

ProductMapper.xml
-----------------------------
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.demo.mapper.ProductMapper">
	<!-- 
		List<Product> getProducts();
	-->
	<select id="getProducts" resultType="Product">
		select 
			P.product_no 				as no
			, P.product_name 			as name
			, P.product_price 			as price
			, P.product_discount_price 	as discountPrice
			, C.category_no				as "category.no"
			, C.category_name			as "category.name"
		from
			mall_products P, mall_categories C
		where
			P.category_no = C.category_no
			<if test="condition.opt != null">
				<choose>
					<when test="condition.opt == 'name'">
						and P.product_name like '%' || #{condition.value} || '%'
					</when>
					<when test="condition.opt == 'maker'">
						and P.product_maker like '%' || #{condition.value} || '%'
					</when>
					<when test="condition.opt == 'minPrice'">
						and P.product_price &gt;= #{condition.value}
					</when>
					<!-- 여는 태그 <는 xml 문서내에서 사용 못함.. -->
					<when test="condition.opt == 'maxPrice'"> 
						and P.product_price &lt;= #{condition.value}
					</when>
				</choose>
			</if>
		order by
			P.product_no desc
	</select>
	
	<!-- 
		Product getProductByNo(@Param("no") int no);
	-->
	<select id="getProductByNo" resultType="Product">
	
	</select>
</mapper>
```

product/list.jsp 파일 [ 페이징을 할 때는 페이징에 영향을 미치는 값들을 무조건 전달해야 함 ] 
------------------------------
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../common/tags.jsp" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../common/common.jsp" %>
<title>샘플 애플리케이션</title>
</head>
<body>
<!-- 헤더부 -->
<header>
	<c:set var="menu" value="product" />
	<%@ include file="../common/nav.jsp" %>
</header>

<!-- 메인 컨텐츠 부  -->
<main>
	<div class="container my-3">
		<div class="row mb-3">
			<div class="col">
				<div class="border p-2 bg-dark text-white fw-bold">전체 상품 리스트</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-12">
				<form>
		  			<div class="row g-3">
		  				<div class="col-2 offset-5">
		  					<select class="form-control">
		  						<option>제목</option>
		  						<option>제목</option>
		  						<option>제목</option>
		  					</select>
		  				</div>
		  				<div class="col-4">
		  					<input type="text" class="form-control">
		  				</div>
		  				<div class="col-1">
		  					<button class="btn btn-outline-primary">검색</button>
		  				</div>
		  			</div>
				</form>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col">
				<div class="border p-2 bg-light">
					<table class="table">
						<colgroup>
							<col width="7%">
							<col width="15%">
							<col width="*">
							<col width="15%">
							<col width="15%">
						</colgroup>
						<thead>
							<tr>
								<th>번호</th>
								<th>카테고리</th>
								<th>상품명</th>
								<th class="text-end">가격</th>
								<th class="text-end">할인가격</th>
							</tr>
						</thead>
						<tbody>
						<%--
							varStatus 속성
								+ 객체를 담는 변수명을 지정한다.
								+ <c:forEach >태그의 현재 반복상태 정보를 표현하는 객체가 전달된다.
								+ <c:forEach var="p" items="${products }" varStatus="x">
									${x.index } 	0부터 시작하는 인덱스가 표시된다.
									${x.count }		1부터 시작하는 순번이 표시된다.
									${x.first }		첫번째 값이면 true가 반환된다.
									${x.last }		마지막번째 값이면 true가 반환된다.
									 
						 --%>
						<c:forEach var="p" items="${products }" varStatus="loop">
							<tr>
								<td>${loop.count }</td>
								<td>${p.category.name }</td>
								<td><a class="text-decoration-none" href="detail?no=10">${p.name }</a></td>
								<td class="text-end"><fmt:formatNumber value="${p.price }"/> 원</td>
								<td class="text-end"><span class="text-danger"><fmt:formatNumber value="${p.discountPrice }"/></span> 원</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div class="row mb-3">
			<div class="col-12">
				<nav>
					<ul class="pagination justify-content-center">
					    <li class="page-item">
					    	<a class="page-link" href="#">이전</a>
					    </li>
					    <li class="page-item">
					    	<a class="page-link" href="#">1</a>
					    </li>
					    <li class="page-item">
					    	<a class="page-link" href="#">2</a>
					    </li>
					    <li class="page-item">
					    	<a class="page-link" href="#">3</a>
					    </li>
					    <li class="page-item">
					    	<a class="page-link" href="#">다음</a>
					    </li>
				  	</ul>
				</nav>
			</div>
		</div>
		
	</div>
</main>

<!-- 푸터부 -->
<footer>

</footer>
</body>
</html>
```

### Model에 담으면 EL로 꺼낼 수 있음. [ 과정은 몰라도 됨 ]

임의로 순번을 부여해서 뽑고 싶을 때 [ VarStatus 속성을 사용한다. ]
---------------------------------
```java
<c:forEach var="p" items="${products }" varStatus="loop">
<tr>
<td>${loop.count }</td>

// varStatus 속성
	+ 객체를 담는 변수명을 지정한다.
	+ <c:forEach >태그의 현재 반복상태를 표현하는 객체가 전달된다.
	+ <c:forEach var="p" items="${products }" varStatus="x">
		${x.index } 0부터 시작하는 인덱스가 표시된다.
		${x.count } 1부터 시작하는 순번이 표시된다.
		${x.first } 첫 번째 값이면 true가 반환된다.
		${x.last } 마지막 값이면 true가 반환된다.
```
