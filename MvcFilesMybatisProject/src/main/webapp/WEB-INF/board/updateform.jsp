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
	<form action="update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${dto.num }">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<table class="table table-bordered" style="width: 600px;">
			<caption><b>수정하기</b></caption>
			<tr>
				<th style="width: 120px;" bgcolor="#ddd">이름</th>
				<td>
					<input type="text" name="writer" style="width: 120px;" class="form-control input-sm" required="required" value="${dto.writer }">
				</td>
			</tr>
			<tr>
				<th style="width: 120px;" bgcolor="#ddd">파일업로드</th>
				<td>
					<h4>수정하고자 할경우에만 선택 <br>(기존 파일 모두 삭제)</h4>
					<input type="file" name="files" multiple="multiple" class="form-control input-sm">
				</td>
			</tr>
			<tr>
				<th style="width: 120px;" bgcolor="#ddd">제목</th>
				<td>
					<input type="text" name="subject" style="width: 120px;" class="form-control input-sm" required="required" value="${dto.subject }">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea style="width: 490px; height: 100px;" name="content" class="form-control input-sm" required="required">${dto.content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-warning btn-sm" style="width: 100px;">수정</button>
					<button type="button" class="btn btn-warning btn-sm" style="width: 100px;" onclick="location.href='list?pageNum=${pageNum}'">목록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>