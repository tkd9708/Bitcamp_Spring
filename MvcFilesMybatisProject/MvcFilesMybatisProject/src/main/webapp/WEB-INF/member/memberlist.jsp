<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	caption {
		caption-side: top;
	}
</style>
</head>
<body>
	<table class="table table-bordered" style="width: 600px;">
		<caption><b>멤버 목록 출력</b></caption>
		<tr bgcolor="#ddd">
			<th style="width: 60px;">번호</th>
			<th style="width: 120px;">아이디</th>
			<th style="width: 100px;">이름</th>
			<th style="width: 130px;">핸드폰</th>
			<th>가입일</th>
		</tr>
		<c:forEach var="dto" items="${list }" varStatus="i">
			<tr align="center" onclick="location.href='detail?num=${dto.num}'" style="cursor: pointer;">
				<td>${i.count }</td>
				<td align="left">
					<c:if test="${dto.mainphoto!='no'}">
						<img src="../save/${dto.mainphoto }" style="width: 50px; height: 50px;" class="img-circle">
					</c:if>
					${dto.myid }
				</td>
				<td>
					${dto.name }
				</td>
				<td>
					${dto.hp }
				</td>
				<td>
					<fmt:formatDate value="${dto.gaipday }" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>