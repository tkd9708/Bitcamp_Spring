<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<button type="button" class="btn btn-info" style="margin-left: 200px; width: 100px;" onclick="location.href='carform'">차정보입력</button>
	<hr>
	<img src="08.png" style="width: 100px">
	<c:if test="${totalCount==0 }">
		<span class="alert alert-info">
			저장된 데이터가 없습니다.
		</span>
	</c:if>
	<c:if test="${totalCount>0 }">
		<span class="alert alert-info">
			총 ${totalCount }개의 차정보가 있습니다.
		</span>
	</c:if>
	
	<br><br>
	<table class="table table-bordered" style="width: 700px;">
		<tr bgcolor="#ddd">
			<th style="width: 60px;">번호</th>
			<th style="width: 100px;">자동차명</th>
			<th style="width: 80px;">색상</th>
			<th style="width: 100px;">가격</th>
			<th style="width: 120px;">구입일</th>
			<th style="width: 100px;">관리</th>
		</tr>
		<c:forEach var="a" items="${list }" varStatus="i">
			<tr align="center">
				<td>${i.count }</td>
				<td>${a.carname }</td>
				<td>
					<div style="background-color: ${a.carcolor}; width:50px; height:50px;"></div>
				</td>
				<td>
					<fmt:formatNumber value="${a.carprice }" type="currency"/>
				</td>
				<td>${a.carguip }</td>
				<td>
					<a href="updateform?num=${a.num }">수정</a> / 
					<a href="delete?num=${a.num }">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>