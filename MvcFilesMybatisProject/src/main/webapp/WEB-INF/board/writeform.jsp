<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
caption{
	caption-side: top;
}
</style>
</head>
<body>
	<form action="write" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${num }">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<input type="hidden" name="regroup" value="${regroup }">
		<input type="hidden" name="restep" value="${restep }">
		<input type="hidden" name="relevel" value="${relevel }">
		<table class="table table-bordered" style="width: 600px;">
			<caption><b>${num==0?"새글쓰기":"답글쓰기"}</b></caption>
			<tr>
				<th style="width: 120px;" bgcolor="#ddd">이름</th>
				<td>
					<input type="text" name="writer" style="width: 120px;" class="form-control input-sm" required="required">
				</td>
			</tr>
			<tr>
				<th style="width: 120px;" bgcolor="#ddd">비밀번호</th>
				<td>
					<input type="password" name="pass" style="width: 120px;" class="form-control input-sm" required="required">
				</td>
			</tr>
			<tr>
				<th style="width: 120px;" bgcolor="#ddd">파일업로드</th>
				<td>
					<input type="file" name="files" multiple="multiple" class="form-control input-sm">
				</td>
			</tr>
			<tr>
				<th style="width: 120px;" bgcolor="#ddd">제목</th>
				<td>
					<input type="text" name="subject" style="width: 120px;" class="form-control input-sm" required="required">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea style="width: 490px; height: 100px;" name="content" class="form-control input-sm" required="required"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-warning btn-sm" style="width: 100px;">저장</button>
					<button type="button" class="btn btn-warning btn-sm" style="width: 100px;" onclick="location.href='list?pageNum=${pageNum}'">목록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>