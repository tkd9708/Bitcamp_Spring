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
	<h2>Shop 정보 입력하기</h2>
	<form action="insert" method="post" enctype="multipart/form-data">
		<b>상품명</b> : 
		<input type="text" name="sangpum"><br>
		<b>단가</b> :
		<input type="text" name="price"><br>
		<b>이미지</b> :
		<input type="file" name="photo"><br>
		<button type="submit">DB에 저장</button>
	</form>
</body>
</html>