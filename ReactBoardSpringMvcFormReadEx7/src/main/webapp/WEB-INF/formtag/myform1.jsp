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
	<h1>폼 데이터 각각 읽기</h1>
	<form action="read1" method="post">
		<table class="table table-bordered" style="width: 300px;">
			<tr>
				<th style="width: 100px;">이름</th>
				<td>
					<input type="text" name="name" class="form-control">
				</td>
			</tr>
			<tr>
				<th style="width: 100px;">자바</th>
				<td>
					<input type="text" name="java" class="form-control">
				</td>
			</tr>
			<tr>
				<th style="width: 100px;">스프링</th>
				<td>
					<input type="text" name="spring" class="form-control">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-danger">서버에 전송</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>