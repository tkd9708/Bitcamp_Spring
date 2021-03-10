<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<c:if test="${totalCount == 0 }">
		<div class="alert alert-info">
			<b>저장된 상품정보가 없습니다.</b>
		</div>
	</c:if>
	<c:if test="${totalCount > 0 }">
		<div class="alert alert-info">
			<b>총 ${totalCount}개의 상품정보가 있습니다.</b>
		</div>
	</c:if>
	
	<table class="table table-bordered" style="width: 500px;">
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>
					<img src="photo/${dto.photoname }">
				</td>
				<td>
					상품명 : ${dto.sangpum }<br>
					단 가 : ${dto.price }<br>
					입고일 : ${dto.ipgoday }
					
					<button type="button" class="btn btn-warning" onclick="location.href='updateform?num=${dto.num}'">수정</button>
					<button type="button" class="btn btn-danger" onclick="location.href='delete?num=${dto.num}'">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<button type="button" class="btn btn-warning" onclick="location.href='form'">상품 추가</button>
	
</body>
</html>