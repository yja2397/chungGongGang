<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=utf-8");
%>

<html>
<head>
<title>JSP Example</title>
</head>
<body>
<%
	session.invalidate();
%>
</body>
</html>