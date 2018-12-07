<%@ page import="org.jsoup.Jsoup" %>
<%@ page import="org.jsoup.nodes.Document" %>
<%@ page import="org.jsoup.nodes.Element" %>
<%@ page import="org.jsoup.select.Elements" %>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<jsp:useBean id="t" class="bean.Crawl" scope="page" />
<jsp:setProperty name="t" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="table.js"></script>
</head>
<body>
	<div class="scrollable">
                <table>공지사항 받아오는 표.
                    <thead>
                    <th style="width: 115.56px">번호</th>
                    <th style="width: 317.33px">제목</th>
                    <th style="width: 115.56px">작성자</th>
                    <th style="width: 115.56px">작성일</th>
                    <th style="width: 65.78px">조회</th>
                    </thead>
      <%
      String url = "http://wise.cnu.ac.kr/community/notice";
      /* Document doc = Jsoup.connect(url).get();
        Elements elem = doc.select("table");
        String str = elem.text();
        Elements titles = doc.select("table a");
        String title = titles.text();
         */
         t.setting("sw", url);
         ArrayList<String> table = t.getTable();/* new ArrayList<String>(Arrays.asList(str.split(" ")));
        ArrayList<String> tt = new ArrayList<String>(Arrays.asList(title.split(" ")));
        for(int i=0; i < 5; i++)
        	table.remove(0);
        int j=0;
        System.out.println("table1");
        /* for(int i=0; i<table.size(); i++){
        	System.out.print(table.get(i) + " ");
        } */
        /* for(int i=0; i<table.size(); i++){
        	if(table.get(i) == tt.get(j)){
        		table.remove(i);
        		j++;
        	}
        
        } *//* 
        t.setUrl(url);
        table = t.getTable(); */
        /* System.out.println("table2");
        for(int i=0; i<table.size(); i++){
        	System.out.print(table.get(i) + " ");
        } */
for ( int i =0; i < 8; i++)
{    
%>

<tr>
<td style="width: 115.56px"> <%=table.get(i*5 + 0)%></td>
<td style="width: 317.33px"> <%=table.get(i*5 + 1)%></td>
<td style="width: 115.56px"> <%=table.get(i*5 + 2)%></td>
<td style="width: 115.56px"> <%=table.get(i*5 + 3)%></td>
<td style="width: 65.78px"> <%=table.get(i*5 + 4)%></td>
</tr>

<%       
}
%>
                </table>
            </div>
</body>
</html>