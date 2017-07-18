<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> scope3.jsp</h1>
	<%
		//page영역에 저장시킨거 꺼내올 때, 반환형이 Object라서 set할 때 했던 String으로 형변환 해줘야
		String pageS = (String) pageContext.getAttribute("PAGE");
		String requestS = (String) request.getAttribute("REQUEST");
		String sessionS = (String) session.getAttribute("SESSION");
		String applicationS = (String) application.getAttribute("APPLICATION");
	
		out.print(pageS + "<br>");
		out.print(requestS + "<br>");
		out.print(sessionS + "<br>");
		out.print(applicationS + "<br>");
		
	%>
</body>
</html>