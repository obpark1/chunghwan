<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.2.1.js"></script>
<script>
	$(function(){
		$("#idcheck").click(function(){
			/* 버튼을 클릭했을 때 여기다가 ajax를 쓰겠다. */
			/* 비동기 통신은 동기 통신이 response로 html을 가져오는 반면 data(xml or json or text를 가져온다.) */
			$.ajax({
				// 어디로 갈껀지
				url : "../idcheck.kdata",
				// 이 값 받을 때 request.getParameter로 받으면 됨
				data : {"id" : $("#id").val()},
				dataType: "text",
				// 성공했을 때 이게 자동으로 호출
				success : function(data){
					console.log(data);
					if(data == 0)
						$("#msg").html("중복").css("color","red");
					else
						$("#msg").html("사용가능");
				},
				// 실패했을 때 이게 자동으로 호출
				error : function(){
					console.log("error");
				}
			});
			
		}) 
	})

</script>
</head>
<body>
회원가입 - register.jsp

<%@ include file="../common/menu.jsp" %>

<form action="../register.kdata" method = "post" enctype="multipart/form-data">
	<ul>
		<!-- name은 requst.getParameter할 때 쓰는 것, jQuery에서는 id를 써줘야함 -->
		<li>아이디: <input type="text" name="id" value="test" id="id">
				  <input type="button" value="중복확인" id="idcheck">
				 <span id="msg"></span>
		<li>비밀번호: <input type="password" name="pw" value="1234">
		<li>이름: <input type="text" name="name" value="홍길동">
		<li>프로필 사진: <input type="file" name="file">
	</ul>
	
	<input type="submit" value="회원가입">
</form>
</body>
</html>

<!-- getparameter 클라이언트에서 submit버튼눌러서 ?뒤에 나오는 애들 받아올 때 씀
getAttribute request영역에 저장할 때 setAttribute쓰는데 여기 있는거 꺼내올 때 씀 -->

<!-- 네트워크를 통해 객체를 넘길 때는 스트림데이터를 이용하는데 이를 위해 직렬화를 해줘야한다. -->