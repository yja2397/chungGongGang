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
	Map<String, Integer> map = new HashMap<String, Integer>();
	map.put("사과", 1000);
	map.put( "귤", 500);
	map.put( "파인애플", 3000);
	map.put( "자몽", 2000);
	map.put( "레몬", 1500);
	
	ArrayList<String> a = (ArrayList) session.getAttribute("productlist");
	
	if(a == null){
		out.println("0원");
	}else{
		int price = 0;
		for(int i = 0; i < a.size(); i++){
			price += map.get(a.get(i));
		}
		out.println("주문한 상품들의 총 가격은 : " + price);
	}
%>
</body>
</html>