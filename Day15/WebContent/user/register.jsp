<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
회원가입 - register.jsp

<%@ include file="../common/menu.jsp" %>
<form action="../register.kdata">
	<ul>
		<li>아이디: <input type="text" name="id" value="test">
				  <input type="button" value="중복확인">
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