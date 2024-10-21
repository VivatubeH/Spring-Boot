com.example.demo.WebController 클래스 생성
-------------------------------------------
```java
package com.example.demo;

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

![image](https://github.com/user-attachments/assets/2b7907ef-b159-4056-93f7-ec7280c3e1ab)

webapp/resources 하위에 css, images, js 폴더를 생성한다.

#### 참고
- src/main/java : 자바 소스가 위치하는 곳
- src/main/resources : 설정 파일이 위치하는 곳
- src/main/webapp/resources : jsp에서 사용하는 그림과 별도의 위치에 있어야 함. [ 정적 컨텐츠 ]
- src/main/webapp/WEB-INF/views/jsp : jsp 파일이 위치하는 곳

![image](https://github.com/user-attachments/assets/60452f0b-265a-411c-a6a1-4cae2e550cd0)

views 하위에 common 폴더를 생성한다.

common/tags.jsp 파일 [ 사용할 태그를 미리 적어놓은 파일 ]
----------------------------------------------------------
```jsp
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
```

common/nav.jsp 파일 [ 내비게이션 메뉴를 적어놓은 파일 ]
------------------------------------------------------------
```jsp
<%@ page pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="/">샘플 쇼핑몰</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link ${menu eq 'home' ? 'active fw-bold' : '' }"  href="/">홈</a>
				</li>
				<li class="nav-item">
					<a class="nav-link ${menu eq 'product' ? 'active fw-bold' : '' }" href="/product/list">전체 상품</a>
				</li>
				
					<li class="nav-item dropdown ${menu eq 'my' ? 'active fw-bold' : '' }">
						<a class="nav-link dropdown-toggle" href="#" id="my-menu-link" role="button" data-bs-toggle="dropdown" aria-expanded="false">
							마이 메뉴
						</a>
						<ul class="dropdown-menu" aria-labelledby="my-menu-link">
							<li><a class="dropdown-item" href="/my/carts">장바구니</a></li>
							<li><a class="dropdown-item" href="/my/orders">구매내역</a></li>
							<li><a class="dropdown-item" href="/my/reviews">내가 작성한 리뷰</a></li>
							<li><a class="dropdown-item" href="/my/pointhistory">포인트변경 이력</a></li>
							<li><a class="dropdown-item" href="/my/info">내정보 보기</a></li>
						</ul>
					</li>
				
			</ul>
				<ul class="navbar-nav">
						<li class="nav-item">
							<a class="nav-link ${menu eq 'login' ? 'active fw-bold' : '' }" href="/login">로그인</a>
						</li>
						<li class="nav-item">
						  	<a class="nav-link ${menu eq 'register' ? 'active fw-bold' : '' }" href="/register">회원가입</a>
						</li>
					</ul>
				
					<span class="navbar-text"><strong>홍길동</strong><small>님 환영합니다.</small></span>
					<ul class="navbar-nav">
						<li class="nav-item">
							<a class="nav-link" href="/logout">로그아웃</a>
						</li>
					</ul>
			</div>
	</div>
</nav>
```

views/home.jsp 파일
------------------------------------------------------------------------
```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="common/tags.jsp" %>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<title>샘플 애플리케이션</title>
</head>
<body>
<c:set var="menu" value="home"/>
<%@ include file="common/nav.jsp" %>
<div class="container my-3">
   <div class="p-5 mb-4 bg-dark rounded-3 text-white">
      <div class="container-fluid py-3">
         <h1 class="display-5 fw-bold">샘플 애플리케이션</h1>
         <p class="col-10 fs-4">회원가입, 로그인, 로그아웃, 상품목록 조회, 상품상세정보 조회, 상품 리뷰쓰기, 장바구니 담기, 구매하기 연습용 샘플 애플리케이션 입니다.</p>
         <a class="btn btn-primary btn-lg" href="login">로그인</a>
      </div>
   </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>

</script>
</body>
</html>
```

views/common/common.jsp 파일 [ 라이브러리 중복 방지 ] 
-------------------------------------------------------------
```jsp
<%@ page pageEncoding="UTF-8"%>
<!-- 부트스트랩 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- 사용자 정의 공통 CSS -->

<!-- 부트스트랩 자바스크립트 라이브러리 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- jquery 자바스크립트 라이브러리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- momnet 라이브러리 -->
<!-- xxx 라이브러리 -->
```

![image](https://github.com/user-attachments/assets/1755d621-edb1-4a1e-a840-37e490fbf5b4)

board, cart, user, product 폴더 생성

views/product/list.jsp 파일
-----------------------------------
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
							<tr>
								<td>1</td>
								<td>컴퓨터</td>
								<td><a class="text-decoration-none" href="detail?no=10">삼성 갤럭시</a></td>
								<td class="text-end">1,250,000 원</td>
								<td class="text-end"><span class="text-danger">1,100,000</span> 원</td>
							</tr>
							<tr>
								<td>1</td>
								<td>컴퓨터</td>
								<td><a class="text-decoration-none" href="detail?no=10">삼성 갤럭시</a></td>
								<td class="text-end">1,250,000 원</td>
								<td class="text-end"><span class="text-danger">1,100,000</span> 원</td>
							</tr>
							<tr>
								<td>1</td>
								<td>컴퓨터</td>
								<td><a class="text-decoration-none" href="detail?no=10">삼성 갤럭시</a></td>
								<td class="text-end">1,250,000 원</td>
								<td class="text-end"><span class="text-danger">1,100,000</span> 원</td>
							</tr>
							<tr>
								<td>1</td>
								<td>컴퓨터</td>
								<td><a class="text-decoration-none" href="detail?no=10">삼성 갤럭시</a></td>
								<td class="text-end">1,250,000 원</td>
								<td class="text-end"><span class="text-danger">1,100,000</span> 원</td>
							</tr>
							<tr>
								<td>1</td>
								<td>컴퓨터</td>
								<td><a class="text-decoration-none" href="detail?no=10">삼성 갤럭시</a></td>
								<td class="text-end">1,250,000 원</td>
								<td class="text-end"><span class="text-danger">1,100,000</span> 원</td>
							</tr>
							<tr>
								<td>1</td>
								<td>컴퓨터</td>
								<td><a class="text-decoration-none" href="detail?no=10">삼성 갤럭시</a></td>
								<td class="text-end">1,250,000 원</td>
								<td class="text-end"><span class="text-danger">1,100,000</span> 원</td>
							</tr>
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

product/detail.jsp 파일
---------------------------
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
	<c:set var="menu" value="product"/>
	<%@ include file="../common/nav.jsp" %>
</header>

<!-- 메인 컨텐츠부 -->
<main>
	<div class="container my-3">
		<div class="row mb-3">
			<div class="col">
				<div class="border p-2 bg-dark text-white fw-bold">상품 상세정보</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-8">
				<div class="border p-2 bg-light">
					<table class="table">
						<colgroup>
							<col width="15%">
							<col width="35%">
							<col width="15%">
							<col width="35%">
						</colgroup>
						<tbody>
							<tr>
								<th>번호</th>
								<td>${product.no }</td>
								<th>등록일자</th>
								<td><fmt:formatDate value="${product.createdDate }" pattern="yyyy년 M월 d일"/></td>
							</tr>
							<tr>
								<th>카테고리</th>
								<td>${product.category }</td>
								<th>리뷰갯수</th>
								<td><fmt:formatNumber value="${product.reviewCnt }"/> 개</td>
							</tr>
							<tr>
								<th>상품명</th>
								<td colspan="3">${product.name }</td>
							</tr>
							<tr>
								<th>제조사</th>
								<td colspan="3">${product.maker }</td>
							</tr>
							<tr>
								<th>가격</th>
								<td><fmt:formatNumber value="${product.price }" /> 원</td>
								<th>할인가격</th>
								<td><strong class="text-danger"><fmt:formatNumber value="${product.discountPrice }" /></strong> 원</td>
							</tr>
							<tr>
								<th>재고량</th>
								<td><fmt:formatNumber value="${product.stock }"></fmt:formatNumber> 개</td>
								<th>판매여부</th>
								<td>
									<c:choose>
										<c:when test="${'Y' eq product.soldOut }">
											<strong class="text-danger">판매 일시 중지</strong>
										</c:when>
										<c:otherwise>
											<strong class="text-success">판매중</strong>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">${product.name }</h5>
						<div class="border-top py-2 mb-3">
							<table class="table">
								<tbody>
									<tr>
										<th>할인 가격</th>
										<td><strong class="text-danger"><fmt:formatNumber value="${product.discountPrice }" /></strong> 원</td>
									</tr>
									<tr>
										<th>적립포인트</th>
										<td><fmt:formatNumber value="${product.discountPrice * 0.01 }" pattern="##,###"/>  점</td>
									</tr>
									<tr>
										<th>배송비</th>
										<td>무료</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="text-end">
							<a href="../cart/add?no=${product.no }" class="btn btn-outline-primary ${empty LOGINED_USER ? 'disabled' : '' }">장바구니 담기</a>
							<a href="../order/add??no=${product.no }" class="btn btn-success ${empty LOGINED_USER ? 'disabled' : '' }">바로구매</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col">
				<div class="border p-2 bg-secondary text-white fw-bold d-flex justify-content-between">
					<span>리뷰 리스트</span>
					<c:if test="${not empty LOGINED_USER }">
						<button class="btn btn-light btn-sm" id="btn-show-review-modal">리뷰쓰기</button>	
					</c:if>
				</div>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col">
				<ul class="list-group">
					<c:choose>
						<c:when test="${empty product.reviews }">
							<li class="list-group-item text-center">등록된 리뷰가 없습니다.</li>
						</c:when>
						<c:otherwise>
							<c:forEach var="review" items="${product.reviews }">
								<li class="list-group-item">
									<div class="row mb-1">
										<div class="col-10"><span class="fw-bold">${review.title }</span></div>
										<div class="col-2 text-end"><small><fmt:formatDate value="${review.createdDate }"/> </small></div>
									</div>
									<div class="row">
										<div class="col-10">${review.content }</div>
										<c:if test="${LOGINED_USER.id eq review.userId }">
											<div class="col-2 text-end"><a href="deleteReview?no=${review.no }&productNo=${product.no }" class="text-danger"><small><i class="fas fa-trash"></i></small></a></div>
										</c:if>
									</div>
								</li>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>

		<div class="modal fade" id="form-review-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<form id="form-review" method="post" action="addReview">
					<input type="hidden" name="productNo" value="${product.no }">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">새 리뷰쓰기</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<div class="text-danger" id="form-alert">제목과 내용은 필수입력값입니다.</div>
							<div class="row mb-1 p-2">
								<input type="text" class="form-control" id="review-title" name="title" placeholder="제목을 입력하세요">
							</div>
							<div class="row mb-1 p-2">
								<textarea rows="5" class="form-control" id="review-content" name="content" placeholder="내용을 입력하세요"></textarea>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
							<button type="submit" class="btn btn-primary" id="btn-add-review">등록</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</main>
<script>
$(function() {
	var formReviewModal = new bootstrap.Modal(document.getElementById('form-review-modal'), {
		keyboard: false
	});
	
	$("#form-alert").hide();
	
	$("#form-review-modal").on('hidden.bs.modal', function() {
		$("#form-alert").hide();
		$("#review-title").val("");
		$("#review-content").val("");
	})
	$("#btn-show-review-modal").click(function() {
		formReviewModal.show();
	});
	
	$("#form-review").submit(function() {
		if (!$.trim($("#review-title").val())) {
			$("#form-alert").show();
			return false;
		}
		if (!$.trim($("#review-content").val())) {
			$("#form-alert").show();
			return false;
		}
		
		return true;
	});
})
</script>
</body>
</html>
```

![image](https://github.com/user-attachments/assets/23d00705-bb93-453d-a5a6-eb21e36828e3)

## <c:set>의 사용법
