<%@ page import="org.jsoup.Jsoup"%>
<%@ page import="org.jsoup.nodes.Document"%>
<%@ page import="org.jsoup.nodes.Element"%>
<%@ page import="org.jsoup.select.Elements"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*"%>

<jsp:useBean id="t" class="scrapy.Crawl" scope="page" />
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
<title>CNU information | Notice</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!--외부 소스 : 외부 css 연결-->
<link href="../layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body id="top">
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!--유정연 : 최상단-->
	<div class="wrapper row0">
		<div id="topbar" class="hoc clear">
			<!-- ################################################################################################ -->
			<div class="fl_left">
				<ul class="nospace">
					<li><i class="fa fa-phone"></i>042-821-5114</li>
					<!--충남대학교 홈페이지-->
					<li><i class="fa fa-envelope-o"></i> dbwjddus1997@gmail.com |
						yja2397@gmail.com</li>
					<!--유정연, 윤지애 이메일 주소-->
				</ul>
			</div>
			<div class="fl_right">
				<ul class="nospace">
					<li><a href="../index.html"><i class="fa fa-lg fa-home"></i></a></li>
					<li><a href="about.html">About</a></li>
					<!--개발자 정보-->
					<li><a href="login.html">Login</a></li>
					<!--로그인-->
					<li><a href="join.html">Register</a></li>
					<!--회원가입-->
				</ul>
			</div>
			<!-- ################################################################################################ -->
		</div>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- Top Background Image Wrapper -->
	<!--유정연 : 메뉴가 포함된 상단-->
	<div class="bgded overlay"
		style="background-image: url('../images/demo/backgrounds/01.png');">
		<!-- ################################################################################################ -->
		<div class="wrapper row1">
			<header id="header" class="hoc clear">
				<!-- ################################################################################################ -->
				<div id="logo" class="fl_left">
					<h1>
						<a href="../index.html" style="font-weight: bold">충공갱</a>
					</h1>
					<!--사이트 이름-->
				</div>
				<nav id="mainav" class="fl_right">
					<ul class="clear">
						<li class="active"><a href="../index.html">Home</a></li>
						<!--첫 화면-->
						<li><a class="drop">공지사항</a>
							<ul>
								<li class="drop"><a href="cnu.jsp">충남대 공지사항</a>
									<ul>
										<li><a href="cnuNew.jsp">새소식</a></li>
										<li><a href="cnuBae.jsp">학사정보</a></li>
										<li><a href="cnuEdu.jsp">교육정보</a></li>
										<li><a href="cnu.jsp">대학문화마당</a></li>
									</ul></li>
								<li class="drop"><a href="dom.jsp">기숙사 공지사항</a>
									<ul>
										<li><a href="dom.jsp">은행사</a></li>
										<li><a href="domBac.jsp">백행사</a></li>
									</ul></li>
								<li><a href="sw.jsp">SW 사업단 공지사항</a></li>
								<li class="drop"><a href="com.jsp">컴퓨터공학과 공지사항</a>
									<ul>
										<li><a href="comBae.jsp">학사정보</a></li>
										<li><a href="comBac.jsp">일반소식</a></li>
										<li><a href="com.jsp">사업단소식</a></li>
									</ul></li>
							</ul></li>

						<li><a class="drop">키워드 알림</a> <!--키워드 알림 메뉴-->
							<ul>
								<li class="submenu"><a href="alarm.html" target="iframe">알림
										설정</a></li>
								<!--알림 설정-->
								<li class="submenu"><a href="alarmconfirm.html"
									target="iframe">알림 확인</a></li>
								<!--알림 확인-->
							</ul></li>
					</ul>
				</nav>
				<!-- 여기까지가 메인페이지 윗 드롭다운 메뉴 설정. -->
			</header>
		</div>
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!--윤지애 : 세부 메뉴-->

		<div class="wrapper row2">
			<div id="breadcrumb" class="hoc clear">
				<!-- ################################################################################################ -->
				<ul>
					<li><a href="../index.html">Home</a></li>
					<li><a>공지사항</a></li>
					<li><a>컴퓨터공학과 공지사항</a></li>
					<li><a href="notice.html">학사정보</a></li>
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
			<h1>학사정보</h1>
			<!--사이트 공지사항-->
			<div class="info">총 #### 건 / 금일 : ### 건</div>
			<!--검색창-->
			<div class="search" style="grid-area: search">
				<form action="#" method="post" id="search_position"
					style="float: right">
					<input list="search" name="subject" class="input" size="22"
						style="float: left">
					<datalist id="search" value="제목">
						<option>제목</option>
						<option>내용</option>
						<option>작성자</option>
					</datalist>
					<!--제목/내용/작성자를 기준으로 검색할 수 있음.-->
					&nbsp;&nbsp;&nbsp; <input type="text" size="22" style="float: left">&nbsp;&nbsp;&nbsp;
					<button style="float: left">검색</button>
				</form>
			</div>
			<br> <br> <br>
			<div class="scrollable">
				<table>
					공지사항 받아오는 표.
					<thead>
						<th style="width: 8%">번호</th>
						<th style="width: 57%">제목</th>
						<th style="width: 13%">작성자</th>
						<th style="width: 14%">작성일</th>
						<th style="width: 8%">조회</th>
					</thead>
					<%
						String url = "http://computer.cnu.ac.kr/index.php?mid=notice"; // 컴퓨터공학과 사업단 공지사항 받아오기
						String table = t.printTable(url);
						out.println(table);
						/* t.setting("com", url); // setting
						ArrayList<String> table = t.getTable(); // table 받아오기
						ArrayList<String> tableAHref = t.getAttr(); // table의 a tag 받아오기
						for (int i = 0; i < 8; i++) { */
					%>

					<%-- <tr>
						<td style="width: 8%"><%=table.get(i * 5 + 0)%></td>
						<td style="width: 57%"><%=tableAHref.get(i)%></td>
						<td style="width: 13%"><%=table.get(i * 5 + 2)%></td>
						<td style="width: 14%"><%=table.get(i * 5 + 3)%></td>
						<td style="width: 8%"><%=table.get(i * 5 + 4)%></td>
					</tr>

					<%
						}
					%> --%>
				</table>
			</div>

		</div>
		<!-- ################################################################################################ -->
		<!-- / main body -->
		<div class="clear"></div>
		</main>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- Footer Background Image Wrapper -->
	<!--유정연 : footer-->
	<div class="bgded overlay"
		style="background-image: url('../images/demo/backgrounds/04.png');">
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<nav class="quicklinks row4">
			<ul class="hoc clear">
				<li><a href="../index.html"><i class="fa fa-lg fa-home"></i></a></li>
				<li><a href="about.html">About</a></li>
				<li><a href="http://plus.cnu.ac.kr/html/kr/">CNU</a></li>
				<li><a href="http://dorm.cnu.ac.kr/html/kr/">Domitory</a></li>
				<li><a href="http://wise.cnu.ac.kr/">SW</a></li>
				<li><a href="http://computer.cnu.ac.kr/">Computer</a></li>
			</ul>
		</nav>
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<div class="wrapper row5">
			<div id="copyright" class="hoc clear">
				<!-- ################################################################################################ -->
				<p class="fl_left">
					Copyright &copy; 2018 - All Rights Reserved - <a
						href="../index.html">ChungGongGang</a>
				</p>
				<p class="fl_right">
					Template by <a target="_blank" href="https://www.os-templates.com/"
						title="Free Website Templates">OS Templates</a>
				</p>
				<!-- ################################################################################################ -->
			</div>
		</div>
		<!-- ################################################################################################ -->
	</div>
	<!-- End Footer Background Image Wrapper -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
	<!-- JAVASCRIPTS -->
	<script src="../layout/scripts/jquery.min.js"></script>
	<script src="../layout/scripts/jquery.backtotop.js"></script>
	<script src="../layout/scripts/jquery.mobilemenu.js"></script>
	<script src="../layout/scripts/jquery.flexslider-min.js"></script>
</body>
</html>