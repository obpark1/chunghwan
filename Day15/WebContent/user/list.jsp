<%@ page import="java.util.List"%>
<%@ page import="kdata.project.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 자바에서 제공되는 라이브러리 jstl을 쓰겠다, prefix로 c를 쓰겠다. -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
회원가입 - list.jsp
<%

List<UserDTO> list = (List<UserDTO>)request.getAttribute("list"); %>

<!-- EL로 간단히 쓸 수 있음. out.print도 기능에 포함됨 -->
<%-- ${ list } --%>
<table>
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>가입일</th>
	</tr>
	
	<% 
		for(int i=0; i<list.size();i++){
	%>
	<tr>
		<td><a href="detail.kdata?id=<%= list.get(i).getId() %>"><%= list.get(i).getId() %></a></td>
		<td><%= list.get(i).getName() %></td>
		<td><%= list.get(i).getReg_date() %></td>
	<%
		}
	%>


	<!-- JSTL을 쓰기 위해서 prefix로 선언해놓은 c를 쓰겠다 -->
	
	<!-- for(UserDTO dto : list){ 이거랑 밑에거랑 같음-->
	<c:forEach items="${list}" var="user">
	<tr>
		<td><a href="detail.kdata?id=${user.id}">${user.id}</a></td>
		<td> ${user.name}</td>
		<td> ${user.reg_date}</td>
	</c:forEach>

	<tr>
		

</table>
</body>
</html>