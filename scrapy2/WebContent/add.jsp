<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="login" class="scrapy.Crawl" scope="page" />
<jsp:setProperty name="login" property="*" />
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	
		if (!login.CheckUser()) {
			out.println("�α��� ����!");
		} else {
			session.setAttribute("login_userid", login.getUserid());
			session.setAttribute("login_passwd", login.getPasswd());
			out.println("�α��� ����! <br>");
			out.println("����� ���̵� : " + session.getAttribute("login_userid") + "<br>");
			out.println("����� ��й�ȣ : " + session.getAttribute("login_passwd") + "<br>");
		}
	%>
</body>
</html>