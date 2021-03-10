<%@page import="board.dao.AnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${totalCount == 0 }">
		<div class="alert alert-info">
			<b>등록된 글이 없습니다.</b>
		</div>
	</c:if>
	<c:if test="${totalCount > 0 }">
		<div class="alert alert-info">
			<b>총 ${totalCount }개의 글이 있습니다.</b>
		</div>
	</c:if>
	<br>
	
	<!-- table 출력 -->
	<table class="table table-bordered" style="width: 800px;">
		<tr bgcolor="#ddd">
			<th style="width: 60px;">번호</th>
			<th style="width: 400px;">제목</th>
			<th style="width: 80px;">작성자</th>
			<th style="width: 120px;">작성일</th>
			<th style="width: 60px;">조회</th>
		</tr>
		<c:forEach var="a" items="${list }">
			<tr>
				<td align="center">
					${no }
					<c:set var="no" value="${no-1 }"/>
				</td>
				<td>
					<!-- 제목출력 -->
					<a href="content?num=${a.num }&pageNum=${currentPage }&key=list">
						<!-- 공백출력 : level당 3칸-->
						<c:forEach var="sp" begin="1" end="${a.relevel }">
							&nbsp;&nbsp;&nbsp;
						</c:forEach>
						
						<!-- 원글제외하고 앞에 r 이미지 넣기 -->
						<c:if test="${a.restep>0 }">
							<img src="../image/re.png">
						</c:if>
						
						<!-- 제목 출력 -->
						${a.subject }
						
						<!-- 업로드한 파일이 한개라도 있으면 클립모양 표시 -->
						<c:if test="${a.upload != 'no' }">
							<i class="fa fa-paperclip" style="color: gray;"></i>
						</c:if>
						<c:if test="${a.cnt > 0 }">
							<a href="content?num=${a.num }&pageNum=${currentPage }#alist" style="color: red;">[${a.cnt }]</a>
						</c:if>
					</a>
				</td>
				<td align="center">${a.writer }</td>
				<td align="center">
					<fmt:formatDate value="${a.writeday }" pattern="yyyy-MM-dd"/>
				</td>
				<td align="center">${a.readcount }</td>
			</tr>
		</c:forEach>
	</table>
	<!-- 페이징 출력 -->
	<div style="width: 800px;">
		<ul class="pagination justify-content-center">
			<c:if test="${startPage > 1 }">
				<li class="page-item">
					<a class="page-link" href="list?pageNum=${startPage-1 }">이전</a>
				</li>
			</c:if>
			<!-- 페이지 번호 -->
			<c:forEach var="pp" begin="${startPage }" end="${endPage }">
				<c:if test="${pp==currentPage }">
					<li class="page-item active">
						<a class="page-link" href="list?pageNum=${pp }">${pp }</a>
					</li>
				</c:if>
				<c:if test="${pp!=currentPage }">
					<li class="page-item">
						<a class="page-link" href="list?pageNum=${pp }">${pp }</a>
					</li>
				</c:if>
			</c:forEach>
			<c:if test="${endPage < totalPage }">
				<li class="page-item">
					<a class="page-link" href="list?pageNum=${endPage+1 }">다음</a>
				</li>
			</c:if>
		</ul>
	</div>
	
	<!-- 글쓰기 버튼 -->
	<button class="btn btn-info" style="width: 100px;" onclick="location.href='writeform'">글쓰기</button> 
</body>
</html>