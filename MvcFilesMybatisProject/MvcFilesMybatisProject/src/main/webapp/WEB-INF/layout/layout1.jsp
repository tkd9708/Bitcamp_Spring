<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<title>스프링 MVC 프로젝트</title>
<style type="text/css">
	#top {
		position: absolute;
		top: 0px;
		left: 0px;
		width: 100%;
		height: 100px;
		line-height: 100px;
		font-size: 2em;
		font-weight: bold;
		text-align: center;
	}
	
	#menu {
		position: absolute;
		top: 130px;
		left: 0px;
		width: 100%;
		height: 100px;
		line-height: 100px;
		font-size: 1.5em;
		font-weight: bold;
		text-align: center;
	}
	
	#info {
		position: absolute;
		top: 200px;
		left: 40px;
		width: 200px;
		height: 100px;
		font-size: 1.5em;
		font-weight: bold;
	}
	
	#main {
		position: absolute;
		top: 300px;
		left: 400px;
		width: 900px;
		height: 500px;
		font-weight: bold;
	}
</style>
</head>
<body>
	<div class="layout">
		<div id="top">
			<tiles:insertAttribute name="top"></tiles:insertAttribute>
		</div>
		<div id="menu">
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>
		</div>
		<div id="main">
			<tiles:insertAttribute name="main"></tiles:insertAttribute>
		</div>
		<div id="info">
			<tiles:insertAttribute name="info"></tiles:insertAttribute>
		</div>
	</div>
</body>
</html>