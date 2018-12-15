<!-- 유정연, 윤지애 : 로그인 성공. 오류(아이디 오류, 비밀번호 오류)를 확인하는 jsp -->

<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="source.SaveData"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		// 인코딩 처리
		request.setCharacterEncoding("euc-kr");

		// 로그인 화면에 입력된 아이디와 비밀번호를 가져온다
		String id = request.getParameter("id");
		String pw = request.getParameter("password");

		// DB에서 아이디, 비밀번호 확인
		SaveData save = new SaveData();
		int flag = save.getlogin(id, pw);

		// URL 및 로그인관련 전달 메시지
		String gotothe = "";

		if (flag == 1) // 로그인 성공
		{
			// 세션에 현재 아이디 세팅후 어디로 갈지(우리는 메인 화면으로 갈 것입니다) 지정해 준다.
			session.setAttribute("sessionID", id);
			gotothe = "../index.jsp";
		} else if (flag == 0) // 로그인 정보가  안맞는 경우?
		{
			//비번오류
			gotothe = "login.jsp?gotothe=0";

		} else {
	
			gotothe = "login.jsp?gotothe=-1";
		}

		// sendRedirect(String URL) : 해당 URL로 이동
		// URL뒤에 get방식 처럼 데이터를 전달가능
		response.sendRedirect(gotothe);
	%>


</body>
</html>