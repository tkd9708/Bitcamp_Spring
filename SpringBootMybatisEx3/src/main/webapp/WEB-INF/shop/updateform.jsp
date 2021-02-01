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
	<h2>Shop 정보 수정하기</h2>
	<form action="update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${dto.num }">
		<b>상품명</b> : 
		<input type="text" name="sangpum" value="${dto.sangpum }"><br>
		<b>단가</b> :
		<input type="text" name="price" value="${dto.price }"><br>
		
		<h3>기존이미지를 수정할 경우에만 선택해주세요</h3>
		<b>이미지</b> :
		<input type="file" name="photo"><br>
		<button type="submit">수정</button>
	</form>
</body>
</html>