<!-- ������, ������ : �α��� ����. ����(���̵� ����, ��й�ȣ ����)�� Ȯ���ϴ� jsp -->

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
		// ���ڵ� ó��
		request.setCharacterEncoding("euc-kr");

		// �α��� ȭ�鿡 �Էµ� ���̵�� ��й�ȣ�� �����´�
		String id = request.getParameter("id");
		String pw = request.getParameter("password");

		// DB���� ���̵�, ��й�ȣ Ȯ��
		SaveData save = new SaveData();
		int flag = save.getlogin(id, pw);

		// URL �� �α��ΰ��� ���� �޽���
		String gotothe = "";

		if (flag == 1) // �α��� ����
		{
			// ���ǿ� ���� ���̵� ������ ���� ����(�츮�� ���� ȭ������ �� ���Դϴ�) ������ �ش�.
			session.setAttribute("sessionID", id);
			gotothe = "../index.jsp";
		} else if (flag == 0) // �α��� ������  �ȸ´� ���?
		{
			//�������
			gotothe = "login.jsp?gotothe=0";

		} else {
	
			gotothe = "login.jsp?gotothe=-1";
		}

		// sendRedirect(String URL) : �ش� URL�� �̵�
		// URL�ڿ� get��� ó�� �����͸� ���ް���
		response.sendRedirect(gotothe);
	%>


</body>
</html>