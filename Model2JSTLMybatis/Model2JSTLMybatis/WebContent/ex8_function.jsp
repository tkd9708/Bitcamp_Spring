<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<h1>JSTL의 문자 함수들 공부하기</h1>
	<c:set var="msg1" value="    Have a Nice Day!!    "/>	
	<h3>msg1 문자열 출력과 길이 구하기</h3>
	msg1 : [${msg1 }]<br>
	length : ${fn:length(msg1) }글자 입니다.<br>
	
	<h3>msg1에서 양쪽의 공백 제거후 출력과 길이 구하기</h3>
	<c:set var="msg2" value="${fn:trim(msg1 )}"/>
	msg2 : [${msg2}]<br>
	length : ${fn:length(msg2) }글자 입니다.<br>
	
	<h3>msg2를 대문자와 소문자로 변경후 출력</h3>
	${fn:toUpperCase(msg2) }<br>
	${fn:toLowerCase(msg2) }<br>
	
	<h3>특정 문자열로 시작할경우 true</h3>
	${fn:startsWith(msg2, "Have") }<br>
	${fn:startsWith(msg2, "Nice") }<br>
	
	<h3>특정 문자열로 끝날경우 true</h3>
	${fn:endsWith(msg2, "!!") }<br>
	${fn:endsWith(msg2, "%%") }<br>
	
	<h3>contains : 특정 문자열을 포함하고 있으면 true</h3>
	${fn:contains(msg2, "Day") }<br>
	${fn:contains(msg2, "Happy") }<br>
	
	<h3>replace : 문자열 A를 B로 교체</h3>
	${fn:replace(msg2,"a","*") }<br>
	
	<h3>substring : 문자열 추출</h3>
	${fn:substring(msg2,7,11) }<br>
</body>
</html>