<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> scope1.jsp</h1>
	<form action="scope2.jsp">
		<ul>
			<li> page영역 : <input type="text"  name="page" value = "page영역">
			<li> request영역 : <input type="text"  name="request" value = "request영역">
			<li> session영역 : <input type="text"  name="session" value = "session영역">
			<li> application영역 : <input type="text"  name="application" value = "application영역">
			
		</ul>
		<input type="submit" value="영역테스트">
	</form>
</body>
</html>