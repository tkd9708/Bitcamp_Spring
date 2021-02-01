<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>한명한테만 메일 보내기</h1>
	<form action="mailsend1" method="post">
		<b>메일주소 : </b>
		<input type="text" name="emailaddr" value="tkd9708@naver.com">
		<br>
		<input type="text" name="emailcontent" placeholder="메일내용을 입력해주세요">
		<br>
		<button type="submit">구글이메일 보내기</button>
	</form>
</body>
</html>