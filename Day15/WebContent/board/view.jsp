<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.2.1.js"></script>
<script>
/* 이 밑에 html의 트리구조가 완성됬을 때 이 함수가 불려진다 */
// $(document).ready(function(){});

$(function(){
	// 이게 준비가 되면 ajax를 시작하겠다.
	// 댓글 쓰기---------------------------------
	$("#write").click(function(){
		$.ajax({
			url : "../writecomments.kdata",
			// 데이터 보내기 (아이디, 내용, 게시판 글번호)
			data : {"id": $("#id").val(), 
				"comments": $("#comments").val(), 
				"num" : 1},
			// 비동기 통신으로 갖다오면서 어떤 타입으로 가져오겠다. xml은 시작태그가 있고 닫는 태그가 있어서 불편
			// 그래서 간편한 json이 나옴
			// 배열: [ ], 객체 { }
			dataType:"json",
			success : function(data){
				var str = "<table>";
				$.each(data, function(index, item){
					// CommentsWriteService의 obj.put에 들어가는 String
					
					str = str + "<tr>";
					str = str + "<td>" + item.comment_num + "</td>";
					str = str + "<td>" + item.id + "</td>";
					str = str + "<td>" + item.content + "</td>";
					str = str + "<td><input type='button' value='x' id='delete'></td>";
					str = str + "</tr>";
					
					
					
				});
				str = str + "</table>"
				//str을 list에 출력
				$("#list").html(str);
			},
			error : function(){}
		});
	});
	// ---------------------------------------
	
	// 동적으로 처리할 때는 on으로 해줘야 함
	// #list로 전체를 불러온다. 이거 안 쓰면 첫 번째 버튼은 클릭이 되는데 나머지는 안됨
	$("#list").on("click", "#delete", (function(){
		//alert("gg");
		//console.log($(this).parent().parent().find("td:first-child").text());
		var tr = $(this)
		
		 $.ajax({
			url: "../deletecomments.kdata",
			data: {"comment_num": $(this).parent().parent().find("td:first-child").text()},
			success : function(){
				$(tr).parent().parent().remove();
			},
			error : function(){
				console.log("error")
			}
		}) 
	}));

});

</script>
</head>
<body>
<fieldset>
	<legend> 게시판 내용 보기</legend>
	<table>
		<tr>
			<th>제목</th>
			<td>안녕하세요.</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>안녕하세요</td>
		</tr>
	</table>
</fieldset>	
<fieldset>
	<legend> 댓글 쓰기</legend>
	<form>
	<ul>
		<li>아이디: <input type ="text" name="id" id = "id"><br>
		<li>내용	<textarea name="comment" id="comments" ></textarea>
	</ul>
	<input type = "button" value="댓글쓰기" id="write">
	</form>
</fieldset>
<fieldset>
	<legend>댓글 내용</legend>
	<div id = "list">
	
	</div>
	
	<!-- <table>
		<tr>
			<td>1</td>
			<td>안녕하세요</td>
			<input type = "button" value="X">
		</tr>
	</table> -->
</fieldset>
</body>
</html>