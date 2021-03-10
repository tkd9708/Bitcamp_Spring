<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="passcheck" method="post">
		<input type="hidden" name="num" value="${num }">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<h3>비밀번호를 입력해주세요</h3>
		<input type="password" name="pass" class="form-control input-sm" style="width: 200px;" autofocus="autofocus">
		<br>
		<button type="submit" class="btn btn-warning">비밀번호 확인</button>
	</form>
</body>
</html>