<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	table, tr, th, td {
		border: 1px solid gray;
	}
</style>
</head>
<body>
	<button type="button" style="width: 100px;" onclick="location.href='../samsung/list'">차 List</button>
	<button type="button" style="width: 100px;" onclick="location.href='../member/list'">멤버 List</button>
	<br><br>
	
	<c:if test="${total==0}">
		<h2>등록된 회원이 없습니다.</h2>	
	</c:if>
	<c:if test="${total>0}">
		<h2>${total }명의 회원이 있습니다.</h2>	
		
		<table>
			<tr bgcolor="orange">
				<th width="60">번호</th>
				<th width="100">이름</th>
				<th width="120">휴대폰</th>
				<th width="120">주소</th>
				<th width="120">가입일</th>
				<th width="120">편집</th>
			</tr>
			<c:forEach var="dto" items="${list }" varStatus="i">
				<tr align="center">
					<td>${i.count }</td>
					<td>${dto.name }</td>
					<td>${dto.hp }</td>
					<td>${dto.addr }</td>
					<td>${dto.gaipday }</td>
					<td>
						<button type="button" onclick="location.href='updateform?num=${dto.num}'">수정</button>
						<button type="button" onclick="location.href='delete?num=${dto.num}'">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<br><br>
	<button type="button" style="width: 100px;" onclick="location.href='writeform'">멤버 등록</button>
	
</body>
</html>