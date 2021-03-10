<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	caption {
		caption-side: top;
	}
</style>
</head>
<body>
	<table class="table table-bordered" style="width: 600px;">
		<caption><b>디테일 페이지</b></caption>
		<tr>
			<td>
				<h2>${dto.name }(${dto.myid })</h2>
			</td>
		</tr>
		<tr>
			<td>
				<span style="color: gray;">
					가입일 : <fmt:formatDate value="${dto.gaipday }" pattern="yyyy-MM-dd HH:mm"/>
				</span>
				<br>
				<h3>핸드폰 : ${dto.hp }</h3>
				<c:if test="${dto.photos=='no' }">
					<h3>저장된 이미지가 없습니다</h3>
				</c:if>
				<c:if test="${dto.photos!='no' }">
					<c:forTokens var="photo" items="${dto.photos }" delims=",">
						<img src="../save/${photo }" style="max-width: 400px;">
						<br>
					</c:forTokens>
				</c:if>
				
			</td>
		</tr>
		<tr>
			<td align="right">
				<button type="button" class="btn btn-warning btn-sm" style="width: 90px;" onclick="location.href='addform'">회원가입</button>
				<button type="button" class="btn btn-warning btn-sm" style="width: 90px;" onclick="location.href='list'">목록</button>
				<button type="button" class="btn btn-warning btn-sm" style="width: 90px;" onclick="location.href='updateform?num=${dto.num}'">수정</button>
				<button type="button" class="btn btn-warning btn-sm" style="width: 90px;" onclick="location.href='deleteform?num=${dto.num}'">삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>