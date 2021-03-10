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
<style type="text/css">
	table, tr, th, td{
		border: 1px solid gray;
	}
</style>
</head>
<body>
	<form action="update" method="post">
	<input type="hidden" name="num" value="${dto.num }">
		<table>
			<caption><b>멤버 정보 수정</b></caption>
			<tr>
				<th bgcolor="pink" width="100">이름</th>
				<td width="200">
					<input type="text" name="name" size="10" required="required" value="${dto.name }">
				</td>
			</tr>
			<tr>
				<th bgcolor="pink" width="100">휴대폰</th>
				<td width="200">
					<input type="text" name="hp" size="10" required="required" value="${dto.hp }">
				</td>
			</tr>
			<tr>
				<th bgcolor="pink" width="100">주소</th>
				<td width="200">
					<input type="text" name="addr" size="10" required="required" value="${dto.addr }">
				</td>
			</tr>
			<%-- <tr>
				<th bgcolor="pink" width="100">가입일</th>
				<td width="200">
					<input type="date" name="gaipday" size="10" required="required" value="${dto.gaipday }">
				</td>
			</tr> --%>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">DB수정</button>
					<button type="button" onclick="location.href='list'">목록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>