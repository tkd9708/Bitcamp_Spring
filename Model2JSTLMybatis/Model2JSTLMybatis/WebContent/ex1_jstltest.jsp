<%@page import="java.util.Date"%>
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
</head>
<body>
<c:set var="name" value="한지민"></c:set>
<c:set var="age" value="23"/>
<c:set var="today" value="<%=new Date() %>"/>

<!-- jstl에서의 변수 선언하는 방법 1-->
<h2>이름: <c:out value="${name}"></c:out></h2>

<!-- jstl에서의 변수 선언하는 방법 2-->
<h2>이름: ${name}</h2>
<h2>나이: ${age }</h2>
<h2>오늘날짜: ${today }</h2>

<!-- pattern을 이용한 fmt 날짜형식 -->
<pre>
	<fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm"/>
	<fmt:formatDate value="${today }" pattern="yyyy-MM-dd a hh:mm"/>
	<fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm EEE"/>
	<fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm EEEE"/>
</pre>

<c:set var="money" value="6789000"></c:set>
<c:set var="num1" value="123.456789"/>

<!--  jstl에서의 숫자 출력 양식-->
<pre>
	${money }
	${num1 }
	<!-- number: 3자리마다 컴마 -->
	<fmt:formatNumber value="${money}" type="number"></fmt:formatNumber>
	<!-- currency: 3자리마다 컴마와 화폐단위 -->
	<fmt:formatNumber value="${money}" type="currency"></fmt:formatNumber>
	<!-- pattern -->
	<fmt:formatNumber value="${num1 }" pattern="0.00"></fmt:formatNumber>
	<fmt:formatNumber value="1.2" pattern="0.00"></fmt:formatNumber> <!-- 0은 값이 없어도 무조건 0 출력 -->
	<fmt:formatNumber value="1.2" pattern="0.##"></fmt:formatNumber><!-- #은 값이 없을경우 출력안함 -->
</pre>
</body>
</html>