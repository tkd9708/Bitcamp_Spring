<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action="update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${dto.num }">
		<table class="table table-bordered" style="width: 500px;">
			<caption><h2>회원정보수정</h2></caption>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">이름</th>
				<td>
					<input type="text" name="name" style="width: 150px;" class="form-control" required="required" value="${dto.name }">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">아이디</th>
				<td>
					<input type="text" name="myid" style="width: 150px;" class="form-control" required="required" value="${dto.myid }">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">비밀번호</th>
				<td>
				<h4>가입시 등록한 비밀번호를 입력해주세요</h4>
					<input type="password" name="pass" style="width: 150px;" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">핸드폰</th>
				<td>
					<input type="text" name="hp" style="width: 150px;" class="form-control" required="required" value="${dto.hp }">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">사진</th>
				<td>
					<h3>사진은 수정할 경우에만 선택해주세요</h3>
					<input type="file" name="upload" multiple="multiple" class="form-control">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-warning" style="width: 100px;">수정</button>
					<button type="button" class="btn btn-warning" style="width: 100px;" onclick="location.href='list'">회원목록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>