<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="delete" method="post">
		<input type="hidden" name="num" value="${dto.num }">
		비밀번호를 입력하시오
		<input type="password" name="pass">
		<button type="submit" class="btn btn-warning">삭제</button>
	</form>
	
	
</body>
</html>