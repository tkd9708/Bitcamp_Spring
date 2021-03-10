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
<!-- jstl encoding -->
<fmt:requestEncoding value="utf-8"/>
<form action="ex4_jstltest.jsp" method="post">
	이름: <input type="text" name="name" value="${param.name }"><br>
	나이: <input type="text" name="age"><br>
	<h2>여행가고 싶은 나라를 선택하세요</h2>
	<select name="nara">
		<option value="미국">미국</option>
		<option value="프랑스">프랑스</option>
		<option value="프라하">프라하</option>
		<option value="스위스">스위스</option>
	</select><br>
	<button type="submit">서버 전송</button>
</form>

<!-- 이름에 값이 있을경우에만 출력 -->
<c:if test="${!empty param.name }">
	<h1>입력한 값들 읽기</h1>
	<h2>
	이름: ${param.name }<br>
	나이: ${param.age }<br>
	여행가고 싶은 나라는 ${param.nara } 입니다<br>
	</h2>
	
	<!-- 여러개의 조건을 주고싶을 경우 choose문 사용 -->
	<h2>
		<c:choose>
		<c:when test="${param.nara=='미국' }">
			<b style="color: yellow;">미국은 아름다운 나라입니다.</b>
		</c:when>
		<c:when test="${param.nara=='프랑스' }">
			<b style="color: green;">프랑스의 에펠탑은 최고예요!!</b>
		</c:when>
		<c:when test="${param.nara=='프라하' }">
			<b style="color: red;">프랑스는 너무 가고싶은 나라입니다.</b>
		</c:when>
		<c:otherwise>
			<b style="color: gray;">${param.nara } 이곳은 가본적이 없어요!!</b>
		</c:otherwise>
	</c:choose>
	</h2>
	<h2>
	<!-- 나이가 10대일경우 '10대에는 열심히 공부해야죠', 20대: '자바공부 열심히 합시다',
		30대: '직장일은 재미있나요?' 나머지 연령대는 모두 '현재 나이가 어떻게 된다구요??' -->
		<c:choose>
		<c:when test="${param.age>=10 && param.age<20 }">
			<b>10대에는 열심히 공부해야죠</b>
		</c:when>
		<c:when test="${param.age>=20 && param.age<30 }">
			<b>자바공부 열심히 합시다</b>
		</c:when>
		<c:when test="${param.age>=30 && param.age<40 }">
			<b>직장일은 재미있나요?</b>
		</c:when>
		<c:otherwise>
			<b>현재 나이가 어떻게 되신다구요??</b>
		</c:otherwise>
		</c:choose>
	</h2>
</c:if>
</body>
</html>