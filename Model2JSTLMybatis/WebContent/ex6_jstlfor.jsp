<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	List<String> list = new ArrayList();
	list.add("장미꽃");
	list.add("안개꽃");
	list.add("국화꽃");
	list.add("후리지아꽃");
	
	// request에 저장
	request.setAttribute("list", list);
	
	// 세션에 아이디와 핸드폰번호 저장하기
	session.setAttribute("id", "angel");
	session.setAttribute("hp", "010-2334-6677");
%>
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
	<h1>request의 list 출력하기</h1>
	<c:forEach var="s" items="${requestScope.list }" varStatus="i">
		${i.count } : ${s }<br>
	</c:forEach>
	
	<h1>request의 list 출력하기 - requestScope는 생략가능</h1>
	<c:forEach var="s" items="${list}" varStatus="i">
		${i.count } : ${s }<br>
	</c:forEach>
	
	<h1>세션에 들어있는 아이디와 핸드폰번호 가져오기</h1>
	아이디: ${sessionScope.id }<br>
	핸드폰: ${sessionScope.hp }<br>
	
	<h1>Token 분리해서 출력하기</h1>
	<c:set var="msg" value="red,green,blue,yellow,pink"></c:set>
	<c:forTokens var="s" items="${msg }" delims="," varStatus="i">
		<h4>${i.count } : <b style="color:${s }">${s }</b></h4>
	</c:forTokens>
</body>
</html>