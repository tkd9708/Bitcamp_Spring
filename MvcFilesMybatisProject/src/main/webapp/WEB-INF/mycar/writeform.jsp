<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action="read" method="post">
		<table class="table table-bordered" style="width: 300px;">
			<tr>
				<th bgcolor="#ddd" style="width: 100px;">차이름</th>
				<td>
					<input type="text" name="carname" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 100px;">차가격</th>
				<td>
					<input type="text" name="carprice" class="form-control" required="required">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 100px;">차색상</th>
				<td>
					<input type="color" name="carcolor" class="form-control" value="#ffccff">
				</td>
			</tr>
			<tr>
				<th bgcolor="#ddd" style="width: 100px;">구입일</th>
				<td>
					<input type="date" name="carguip" class="form-control" value="2020-10-10">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-success" style="width: 100px;">DB저장</button>
					<button type="button" class="btn btn-info" style="width: 100px;" onclick="location.href='list'">차목록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>