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

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.vo.Product;

@Mapper
public interface ProductMapper {

	List<Product> getProducts();
	Product getProductByNo(@Param("no") int no);
}

```

product/list.jsp 파일
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
						<c:forEach var="product" items="${products }">
							<tr>
								<td>${product.no }</td>
								<td>${product.category.name }</td>
								<td><a class="text-decoration-none" href="detail?no=10">${product.name }</a></td>
								<td class="text-end">
									<fmt:formatNumber value="${product.price }"/> 원
								</td>
								<td class="text-end">
									<fmt:formatNumber value="${product.discountPrice }"/> 원
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
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
