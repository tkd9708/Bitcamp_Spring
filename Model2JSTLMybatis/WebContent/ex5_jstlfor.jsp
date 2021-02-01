<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	table, tr, td, th {
	
		border: 1px solid gray;
	}
</style>
</head>
<body>
<h2>JSTL의 for문</h2>
<c:forEach var="n" begin="1" end="10">
	${n }&nbsp;
</c:forEach>
<br>

<c:forEach var="n" begin="1" end="30" step="5">
	${n }&nbsp;
</c:forEach>
<br>

<%
	// 자바영역에서 배열값을 준후 JSTL 변수로 전환해보자
	String[] colors = {"red", "green", "blue", "magenta", "gray"};
%>
<c:set var="colors" value="<%=colors %>"></c:set>
<h2>출력 1 - 전체출력</h2>
<table>
	<tr>
		<th width="70">index</th>
		<th width="70">count</th>
		<th width="70">colors</th>
		<th width="70">fill</th>
	</tr>
	<c:forEach var="a" items="${colors }" varStatus="i">
		<tr>
			<td>${i.index }</td>
			<td>${i.count }</td>
			<td>${a }</td>
			<td style="background-color: ${a}"></td>
		</tr>
	</c:forEach>
</table>
<br><br>

<h2>출력 2 - index 0~2까지 출력</h2>
<table>
	<tr>
		<th width="70">index</th>
		<th width="70">count</th>
		<th width="70">colors</th>
		<th width="70">fill</th>
	</tr>
	<c:forEach var="a" items="${colors }" begin="0" end="2" varStatus="i">
		<tr>
			<td>${i.index }</td>
			<td>${i.count }</td>
			<td>${a }</td>
			<td style="background-color: ${a}"></td>
		</tr>
	</c:forEach>
</table>
<br><br>

<h2>출력 3 - index 3~4까지 출력</h2>
<table>
	<tr>
		<th width="70">index</th>
		<th width="70">count</th>
		<th width="70">colors</th>
		<th width="70">fill</th>
	</tr>
	<c:forEach var="a" items="${colors }" begin="3" end="4" varStatus="i">
		<tr>
			<td>${i.index }</td>
			<td>${i.count }</td>
			<td>${a }</td>
			<td style="background-color: ${a}"></td>
		</tr>
	</c:forEach>
</table>
<br><br>
</body>
</html>