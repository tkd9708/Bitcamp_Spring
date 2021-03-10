<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<img src="pic/c4.png">
	<img src="pic/c8.png">
	<hr>
	<form action="read">
		<h3>오늘 먹은 점심메뉴를 입력해보세요</h3>
		<input type="text" name="food">
		<br>
		<button type="submit">서버로 보내기</button>
	</form>
</body>
</html>