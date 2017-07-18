<%@ page import="kdata.project.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Detail Info</h1>
<% UserDTO dto = (UserDTO)request.getAttribute("dto"); %>
<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>등록일</th>
		<th>사진</th>
		<th>사진1</th>
	</tr>
	<tr>	
		<td><%= dto.getId() %></td>
		<td><%= dto.getName() %></td>
		<td><%= dto.getReg_date() %></td>
		<td><img src="./profile/${requestScope.dto.profile}"></td>
		<td><img src="./profile/<%= dto.getProfile() %>"></td>
	</tr>
</table>
</body>
</html>
