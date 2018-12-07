<%@ page contentType="text/html;charset=UTF-8"%>

<jsp:useBean id="login" class="bean.loginBean" scope="page" />
<jsp:setProperty name="login" property="*" />

<!DOCTYPE html>
<html>
<head>
<title>로그인 결과</title>
</head>
<body>
	<%
		if (!login.CheckUser()) {
			out.println("로그인 실패!");
		} else {
			session.setAttribute("login_userid", login.getUserid());
			session.setAttribute("login_passwd", login.getPasswd());
			out.println("로그인 성공! <br>");
			out.println("사용자 아이디 : " + session.getAttribute("login_userid") + "<br>");
			out.println("사용자 비밀번호 : " + session.getAttribute("login_passwd") + "<br>");
		}
	%>
</body>
</html>

