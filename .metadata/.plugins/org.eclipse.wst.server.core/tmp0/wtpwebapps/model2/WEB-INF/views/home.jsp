<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈</h1>
	<p>모델2 홈입니다.</p>
	<p>${msg}</p>
	<p>오늘 방문자 수 : ${visitorCnt }</p>
	
	<h3>공지사항</h3>
	<dl>
		<dt>번호</dt>
		<dd>${event.no }</dd>
		<dt>제목</dt>
		<dd>${event.title }</dd>
		<dt>내용</dt>
		<dd>${event.content }</dd>
		<dt>등록일자</dt>
		<dd><fmt:formatDate value="${event.createdDate }" pattern="yyyy년 M월 d일 EEEE a h시 m분 s초"/></dd>
	</dl>
	
	<h3>메뉴</h3>
	<ul>
		<li><a href="/model2/product/list.do">상품</a></li>
		<li><a href="/model2/board/list.do">게시판</a></li>
		<li><a href="/model2/cart/home.do">장바구니</a></li>
	</ul>
</body>
</html>