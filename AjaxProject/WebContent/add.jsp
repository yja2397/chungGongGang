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
	String pr = request.getParameter("product");
	
/*
	Map<String, String> map = new HashMap<String, String>();
	map.put("사과(1000원)","사과");
	map.put("귤(500원)", "귤");
	map.put("파인애플(3000원)", "파인애플");
	map.put("자몽(2000원)", "자몽");
	map.put("레몬(1500원)", "레몬");
	*/
	
	
	ArrayList<String> a = (ArrayList) session.getAttribute("productlist");
	
	if(a == null){
		a = new ArrayList<String>();
		session.setAttribute("productlist", a);
	}
	a.add(pr);
	for(int i = 0; i < a.size(); i++){
		out.println(a.get(i) + "<br>");
	}
%>
</body>
</html>