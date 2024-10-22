<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="row mb-3">
		<div class="col-12">
			<h1>도서 상세 정보</h1>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-12">
			<table class="table">
				<colgroup>
					<col width="15%">
					<col width="35">
					<col width="15%">
					<col width="35%">
				</colgroup>
				<tbody>
					<tr>
						<th>번호</th>
						<td>100</td>
						<th>출판일자</th>
						<td>2023년 10월</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3">HTML5 + CSS3 + JavaScript로 배우는 웹프로그래밍 기초 </td>
					</tr>
					<tr>
						<th>저자</th>
						<td>천인국</td>
						<th>출판사</th>
						<td>한빛미디어</td>
					</tr>
					<tr>
						<th>가격</th>
						<td>33,000 원</td>
						<th>할인가격</th>
						<td><strong class="text-danger">31,200</strong> 원</td>
					</tr>
				</tbody>
			</table>
			
			<div class="text-end">
				<a href="" class="btn btn-primary btn-sm">도서목록</a>
			</div>
		</div>
	</div>
	
</div>
</body>
</html>