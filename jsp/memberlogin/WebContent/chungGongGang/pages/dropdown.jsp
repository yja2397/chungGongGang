<!-- 유정연 : iclude를 위한 상 하부를 따로 관리 -->
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>




<!--
Template Name: Boguco
Author: <a href="https://www.os-templates.com/">OS Templates</a>
Author URI: https://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: https://www.os-templates.com/template-terms
-->


<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!--외부 소스 : 외부 css 연결-->
<link href="../layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">
</head>

<body>

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
							<li class="submenu"><a href="alarm.html">알림 설정</a></li>
							<!--알림 설정-->
							<li class="submenu"><a href="alarmconfirm.html">알림 확인</a></li>
							<!--알림 확인-->
						</ul></li>
				</ul>
			</nav>
			<!-- 여기까지가 메인페이지 윗 드롭다운 메뉴 설정. -->
		</header>
	</div>
</body>
</html>