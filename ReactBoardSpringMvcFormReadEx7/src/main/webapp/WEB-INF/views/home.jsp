<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
<meta charset="utf-8">
	<title>Home</title>
</head>
<body>
	<h1>폼태그 읽기</h1>
	<ul>
		<li>
			<a href="form1">폼 데이터 각각 읽기</a>
		</li>
		<li>
			<a href="form2">폼 데이터 DTO로 읽기</a>
		</li>
		<li>
			<a href="form3">폼 데이터 Map으로 읽기</a>
		</li>
	</ul>
	<hr>
	<a href="mapping">매핑연습</a>
</body>
</html>
