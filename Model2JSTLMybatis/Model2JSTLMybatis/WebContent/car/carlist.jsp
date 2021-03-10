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
	
	<c:if test="${totalCount==0 }">
		<h2>저장된 차의 정보가 없습니다.</h2>
	</c:if>
	<c:if test="${totalCount>0 }">
		<h2>총 ${totalCount }개의 차 정보가 있습니다.</h2>
		
		<table>
			<tr bgcolor="orange">
				<th width="60">번호</th>
				<th width="100">차이름</th>
				<th width="80">차색상</th>
				<th width="100">차가격</th>
				<th width="120">구입일</th>
				<th width="120">편집</th>
			</tr>
			<c:forEach var="dto" items="${list }" varStatus="i">
				<tr align="center">
					<td>${i.count }</td>
					<td>${dto.carname }</td>
					<td>
						<div style="width: 20px; height: 20px; background-color: ${dto.carcolor}; border: 1px solid black;"></div>
					</td>
					<td align="right">
						<fmt:formatNumber value="${dto.carprice }" type="currency"></fmt:formatNumber>
					</td>
					<td>${dto.carguip }</td>
					<td>
						<button type="button" onclick="location.href='updateform?num=${dto.num}'">수정</button>
						<button type="button" onclick="location.href='delete?num=${dto.num}'">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<br><br>
	<button type="button" style="width: 100px;" onclick="location.href='writeform'">차정보입력</button>
</body>
</html>