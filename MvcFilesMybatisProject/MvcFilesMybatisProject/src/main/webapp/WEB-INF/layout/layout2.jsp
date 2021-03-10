<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<meta name="viewport" content="width=device-width, initial-scale=1">	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> <!-- 아이콘 쓰기 -->
</head>
<title>스프링 MVC 프로젝트</title>
<style type="text/css">
	#menu2 {
		position: absolute;
		top: 100px;
		left: 30px;
		width: 200px;
		height: 400px;
		font-size: 1.5em;
		font-weight: bold;
		text-align: center;
	}
	
	#main2 {
		position: absolute;
		top: 100px;
		left: 600px;
		width: 800px;
		height: 500px;
		font-weight: bold;
	}
</style>
</head>
<body>
	<div class="layout2">
		<div id="menu2">
			<tiles:insertAttribute name="menu2"></tiles:insertAttribute>
		</div>
		<div id="main2">
			<tiles:insertAttribute name="main2"></tiles:insertAttribute>
		</div>
	</div>
</body>
</html>