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
	<h1>폼태그 1 데이터 읽기</h1>
	
	<pre>
	<h2>
		이름 : ${name }
		자바점수 : ${java }
		스프링점수 : ${spring }
		총점 : ${tot }
		평균 : ${avg }
		현재 페이지 번호는 ${currentPage }페이지입니다.
	</h2>
	</pre>	
	
</body>
</html>