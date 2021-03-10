<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:set var="root" value="<%=request.getContextPath() %>"></c:set>
<body>
	<h1>두번째 레이아웃입니다</h1>
	<img src="${root }/image/08.png">
	<img src="${root }/image/15.png">
	<img src="${root }/image/16.png">
	<img src="${root }/image/f3.png">
</body>
</html>