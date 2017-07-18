<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<!-- out.print 축약한 것 -->
		<li><a href="<%= request.getContextPath() %>/user/register.jsp">회원가입</a>
		<li><a href="../login.jsp">로그인안녕추가</a>
		<li><a href="<%= request.getContextPath() %>/list.kdata">회원리스트</a>
	
	</ul>
</body>
</html>
