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
	<form action="savemember" method="post" enctype="multipart/form-data">
		<table class="table table-bordered" style="width: 500px;">
			<caption><h2>회원가입</h2></caption>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">이름</th>
				<td>
					<input type="text" name="name" style="width: 150px;" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">아이디</th>
				<td>
					<input type="text" name="myid" style="width: 150px;" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">비밀번호</th>
				<td>
					<input type="password" name="pass" style="width: 150px;" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">핸드폰</th>
				<td>
					<input type="text" name="hp" style="width: 150px;" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 120px;">사진</th>
				<td>
					<h3>사진 여러장을 올려주세요</h3>
					<input type="file" name="upload" multiple="multiple" class="form-control">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-warning" style="width: 100px;">저장</button>
					<button type="button" class="btn btn-warning" style="width: 100px;" onclick="location.href='list'">회원목록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>