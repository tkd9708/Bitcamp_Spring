<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	table tr,th,td {
		border: 1px solid gray;
	}
</style>
</head>
<body>
	<table>
		<tr>
		<c:forEach var="a" begin="2" end="9">
		<th>
			${a }단
		</th>
		</c:forEach>
		</tr>
		<c:forEach var="a" begin="1" end="9">
			<tr>
				<c:forEach var="b" begin="2" end="9">
				<td>
					${b } x ${a } = ${a*b }
				</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>