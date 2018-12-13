<!-- 충남대학교 공지사항을 나타내는 페이지. 20181214기준 최근 파일 크롤링 완료. 다음페이지 넘어가기 구현 요망 -->

<%@ page import="org.jsoup.Jsoup"%>
<%@ page import="org.jsoup.nodes.Document"%>
<%@ page import="org.jsoup.nodes.Element"%>
<%@ page import="org.jsoup.select.Elements"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*"%>

<jsp:useBean id="t" class="source.Crawl" scope="page" />
<jsp:setProperty name="t" property="*" />
<!DOCTYPE html>
<!--
Template Name: Boguco
Author: <a href="https://www.os-templates.com/">OS Templates</a>
Author URI: https://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: https://www.os-templates.com/template-terms
-->
<html>
<!--윤지애 : 탭 이름-->
<head>
<title>CNU information | CNU</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!--외부 소스 : 외부 css 연결-->
<link href="../layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body id="top">
	<!--유정연 : 최상단 파일을 include형식으로 불러옴.-->
	<%@include file="Upper_part.jsp"%>


	<!-- ################################################################################################ -->
	<!-- Top Background Image Wrapper -->
	<!--유정연 : 메뉴가 포함된 상단-->
	<div class="bgded overlay"
		style="background-image: url('../images/demo/backgrounds/01.png');">
		<!-- 유정연 : dropdown part를 include로 불러옴. -->
		<%@include file="dropdown.jsp"%>
		
		<!-- ################################################################################################ -->
		<!--윤지애 : 세부 메뉴-->

		<div class="wrapper row2">
			<div id="breadcrumb" class="hoc clear">
				<!-- ################################################################################################ -->
				<ul>
					<li><a href="../index.html">Home</a></li>
					<li><a>공지사항</a></li>
					<li><a>충남대학교</a></li>
					<li><a href="cnu.jsp">대학문화마당 공지사항</a></li>
				</ul>
				<!-- ################################################################################################ -->
			</div>
		</div>
		<!-- ################################################################################################ -->
	</div>
	<!-- End Top Background Image Wrapper -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!--윤지애 : 공지사항 크롤링-->
	<div class="wrapper row3">

		<main class="hoc container clear"> <!-- main body --> <!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<div class="content">
			<h1><a href="http://plus.cnu.ac.kr/_prog/_board/?code=sub07_070801&site_dvs_cd=kr&menu_dvs_cd=070801">대학문화마당 공지사항</a></h1> <!-- 누르면 대학문화마당 공지사항 홈페이지로 이동된다. -->
			<!--사이트 공지사항-->
			<div class="scrollable">
				<table>
					<!--충남대학교 대학문화마당 공지사항 받아오는 표.-->
					<thead>
						<th style="width: 8%">번호</th>
						<th style="width: 57%">제목</th>
						<th style="width: 13%">작성자</th>
						<th style="width: 14%">작성일</th>
						<th style="width: 8%">조회</th>
					</thead> <!-- 표 head. -->
					<%
						String url = "http://plus.cnu.ac.kr/_prog/_board/?code=sub07_070801&site_dvs_cd=kr&menu_dvs_cd=070801"; // 충남대학교 대학문화마당 url
						String table = t.printTable(url); // printTable을 통해 tag를 받아온다.
						table = t.printStr("cnu"); // href 바꾸고 target _blank로 바꿈.
						out.println(table); // table을 print한다.
					%>
					</table>
			</div>

		</div>
					<!-- ################################################################################################ -->
					<!-- / main body -->
					<div class="clear"></div>
		</main>
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- Footer Background Image Wrapper -->
		<!--유정연 : footer를 include하였다.-->
		<%@include file="Under_part.jsp" %>
</body>
</html>