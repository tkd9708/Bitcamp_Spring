<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
caption{
	caption-side: top;
}

div.filedownload{
		width: 550px;
		height: 70px;
		line-height: 70px;
		border: 1px solid gray;
		border-radius: 10px;
		text-align: center;
	}
	
	span.mod, span.del {
		cursor: pointer;
		margin-right: 10px;
		color: blue;
		font-size: 0.9em;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		answer_list();
		
		$("#camera").click(function(){
			$("#photo").trigger("click");
		});
		
		$(document).on("click", "#up_camera", function(){
			$("#up_photo").trigger("click");
		});
		
		
		$("#photo").change(function(){
			var formData = new FormData();
			var inputFile = $("#photo");
			var files = inputFile[0].files;
			for(var i=0; i<files.length; i++){
				//console.log(files[i].name);
				// formData에 파일추가
				formData.append("upload", files[i]);
			}
			
			// ajax함수를 이용해서 스프링으로 보낸다
			$.ajax({
				url: "photo",
				type: "post",
				processData: false,
				contentType: false,
				data: formData,
				dataType: "json",
				success: function(data){
					$("#myimg").attr("src", "../save/" + data.photo);
				}
			});
		});
		
		$(document).on("change", "#up_photo", function(){
			readURL(this);
			var formData = new FormData();
			var inputFile = $("#up_photo");
			var files = inputFile[0].files;
			for(var i=0; i<files.length; i++){
				formData.append("upload", files[i]);
			}
			
			// ajax함수를 이용해서 스프링으로 보낸다
			$.ajax({
				url: "updatephoto",
				type: "post",
				processData: false,
				contentType: false,
				data: formData,
				dataType: "html",
				success: function(data){
					
				}
			});
		});
		
		// 댓글 저장 버튼 이벤트
		$("#btn").click(function(){
			var num = $("#num").val();
			var msg = $("#msg").val();
			$.ajax({
				type: "post",
				url: "answersave",
				data: {"num":num, "msg":msg},
				dataType: "html",
				success: function(data){
					$("#msg").val("");
					$("#myimg").attr("src", "");
					answer_list();
				}
			});
		});
		
		$(document).on("click", "span.mod", function(){
			var idx = $(this).attr("idx");
			//alert(idx);
			
			$.ajax({
				type: "get",
				url: "answerdata",
				data: {"idx":idx},
				dataType: "json",
				success: function(data){
					var s = "";
					if(data.photoname != null)
						s += "<img src='../save/" + data.photoname + "' style='width: 200px;' id='up_img'><br>";
					else
						s += "<div style='width: 200px;' id='up_img'>선택한 이미지가 없습니다.</div>";
					s += "<input type='hidden' id='up_idx' value='" + data.idx + "'>";
					s += "<br><input type='file' class='form-control' id='up_photo' style='width: 100px; display:none;' idx='" + data.idx + "'>";
					s += "<br><span class='fa fa-camera' id='up_camera' style='font-size: 1.5em; cursor: pointer;'></span>";
					s += "&nbsp;&nbsp;<input type='text' class='form-control input-sm' id='up_msg' style='width: 300px;' value='" + data.msg + "'>";
					
					
					$("div.modal-body").html(s);
				}
			});
		});
		
		$(document).on("click", "span.del", function(){
			var idx = $(this).attr("idx");
			//alert(idx);
			var a = confirm("댓글을 삭제하시겠습니까?");
			if(a){
				$.ajax({
					type: "get",
					url: "answerdelete",
					data: {"idx":idx},
					dataType: "html",
					success: function(data){
						answer_list();
					}
				});
			}
			
		});
		
		$("#modalUpdateBtn").click(function(){
			var idx = $("#up_idx").val();
			var msg = $("#up_msg").val();
			
			$.ajax({
				url: "answerupdate",
				type: "post",
				data: {"idx":idx, "msg":msg},
				dataType: "html",
				success: function(data){
					$("#myModal").modal("hide");
					answer_list();
				}
			});
		});
		
		
	});
	
	// 사용자 함수
	function answer_list(){
		// db로부터 댓글목록을 가져와서 id "answer" 출력하기
		var num = $("#num").val();
		$.ajax({
			type: "get",
			url: "answerlist",
			data: {"num":num},
			dataType: "json",
			success: function(data){
				var s = "";
				$.each(data, function(i, ele){
					
					s += "<div style='width: 700px;'>";
					if(ele.photoname!=null){

						s += "<img src='../save/" + ele.photoname + "' style='width: 40px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
					}
					s += "<b style='width: 500px;'>" + ele.msg + "</b>";
					s += "<span style='color:gray; float:right;'>" + ele.writeday + "</span>";
					s += "<span class='mod' style='float:right;'  data-toggle='modal' data-target='#myModal' idx=" + ele.idx + ">수정</span>";
					s += "<span class='del' style='float:right;' idx=" + ele.idx + ">삭제</span>";
					s += "</div><hr>";
					
				});
				
				$("#answer").html(s);
			}
		});
	}
	
	function readURL(input){
		if(input.files && input.files[0]){
			var reader = new FileReader();
			
			reader.onload = function(e){
				$("#up_img").attr("src", e.target.result);
			};
			
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
</head>
<body>
	<table class="table table-bordered" style="width: 700px;">
			<caption><b>내용 확인</b></caption>
			<tr>
				<td>
					<b style="font-size: 1.5em;">${dto.subject }</b>
					
					<span style="float: right; color: gray; font-size: 0.8em;">
						<fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd"/>
					</span><br>
					<span style="float: right; color: gray;">
						작성자 : <b>${dto.writer }</b>
					</span>
				</td>
			</tr>
			<tr style="height: 180px;">
				<td style="vertical-align: top; text-align: left;">
					<pre style="background-color: white; border: none; white-space:pre-wrap; word-wrap: break-word;">${dto.content }</pre>
					<br><br>
					
					<%-- 
					 강사님 답안 
					<c:if test="${dto.upload!='no' }">
						<c:forTokens var="f" items="${dto.upload }" delims=",">
							<c:if test="${dto.isImage(f)==false }">
								<div class="filedownload">
								 파일 출력
								</div>
							</c:if>
						</c:forTokens>
					</c:if>
					<c:forTokens var="f" items="${dto.upload }" delims=",">
						<c:if test="${dto.isImage(f)==true }">
							 이미지 출력 
						</c:if>
					</c:forTokens>
					 --%>
					
					<c:forEach var="img" items="${imguploads }">
						<img src="../save/${img }" style="max-width: 200px;">
						<br>
					</c:forEach>
					<br><br>
					<c:if test="${fileuploads.size() != 0 }">
						<c:forEach var="file" items="${fileuploads }">
							<div class="filedownload">
								<a href="../download?clip=${file }">
										${file }
									<span class="fa fa-save"></span>
									
								</a>
							</div>
						</c:forEach>
					</c:if>
						
					<c:if test="${fileuploads.size() == 0 }">
					<div class="filedownload">
						<span style="color: red;">서버에 파일이 존재하지 않습니다.</span>
					</div>
					</c:if>
					
					
					
				</td>
			</tr>
			<tr>
				<td>
					<a id="alist"></a>
					<div id="answer">
					
					</div>
					<br><br>
					<div class="form-inline form-group" style="text-align: center;">
						<input type="hidden" id="num" value="${dto.num }">
						<input type="text" class="form-control input-sm" id="msg" placeholder="댓글입력" style="width: 500px;">
						<input type="file" class="form-control" id="photo" style="width: 200px; display:none;">
						&nbsp;&nbsp;
						<span class="fa fa-camera" id="camera" style="font-size: 1.5em; cursor: pointer;"></span>
						&nbsp;&nbsp;
						<button type="button" id="btn" class="btn btn-success">저장</button>
						<img src="" id="myimg">
					</div>
					
				</td>
			</tr>
			<tr>
				<td>
					조회 ${dto.readcount }
					<br>
					<div style="float: right">
					<button type="button" class="btn btn-warning btn-sm" onclick="location.href='writeform'" style="width: 80px;">글쓰기</button>
					<button type="button" class="btn btn-warning btn-sm" 
						onclick="location.href='writeform?num=${dto.num }&regroup=${dto.regroup }&relevel=${dto.relevel }&restep=${dto.restep }&pageNum=${pageNum}'" style="width: 80px;">답글</button>		
					<button type="button" class="btn btn-warning btn-sm" onclick="location.href='updatepassform?num=${dto.num }&pageNum=${pageNum}'" style="width: 80px;">수정</button>
					<button type="button" class="btn btn-warning btn-sm" onclick="location.href='deletepassform?num=${dto.num }&pageNum=${pageNum}'" style="width: 80px;">삭제</button>
					<button type="button" class="btn btn-warning btn-sm" onclick="location.href='list?pageNum=${pageNum}'" style="width: 80px;">목록</button>				
									
					</div>
				</td>
			</tr>
		</table>
		
		<!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Modal Heading</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" id="modalUpdateBtn" class="btn btn-warning">수정</button>
          <button type="button" id="modalColseBtn" class="btn btn-warning" data-dismiss="modal">닫기</button>
        </div>
        
      </div>
    </div>
  </div>
</body>
</html>