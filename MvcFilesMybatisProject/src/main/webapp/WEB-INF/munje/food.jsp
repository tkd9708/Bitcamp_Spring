<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

	$(function(){

		getList();
		
		$("#photo").change(function(){
			var formData = new FormData();
			var inputFile = $("#photo");
			var files = inputFile[0].files;
			for(var i=0; i<files.length; i++){
				formData.append("upload", files[i]);
			}
			
			$.ajax({
				url: "munje/photo",
				type: "post",
				processData: false,
				contentType: false,
				data: formData,
				dataType: "json",
				success: function(data){
					
				}
			});
		});
		
		$("#insertBtn").click(function(){
			var su = $("#su").val();
			var dan = $("#dan").val();
			
			$.ajax({
				url: "munje/insert",
				type: "post",
				data: {"su":su, "dan":dan},
				dataType: "html",
				success: function(data){
					$("#su").val("");
					$("#dan").val("");
					$("#photo").val("");
					getList();
				}
			});
		});
	});
	
	function getList(){
		$.ajax({
			url: "munje/getlist",
			type: "get",
			dataType: "json",
			success: function(data){
				var s = "";
				s += "<table class='table table-bordered' style='width: 600px;'>";
				s += "<tr>";
				s += "<th> </th>";
				s += "<th>수량</th>";
				s += "<th>단가</th>";
				s += "<th>총가격</th>";
				$.each(data, function(i, ele){
					
					s += "<tr><td><img src='save/" + ele.photoname + "' style='width: 100px;'></td>";
					s += "<td>" + ele.su + "</td>";
					s += "<td>" + ele.dan + "</td>";
					s += "<td>" + (ele.su * ele.dan) + "원</td>";
					
					s += "</tr>";
				});
				s += "</table>";
				$("#out").html(s);
			}
		});
	}
</script>
</head>
<body>
	<h4>사진 업로드</h4>
	<input type="file" class="form-control" id="photo" style="width: 300px;"><br>
	<h4>수량</h4>
	<input type="text" class="form-control" id="su" style="width: 300px;"><br>
	<h4>단가</h4>
	<input type="text" class="form-control" id="dan" style="width: 300px;"><br>			
	<button type="button" id="insertBtn" class="btn btn-warning">저장</button>
	
	<br><br>
	<hr>
	<div id="out"></div>
</body>
</html>