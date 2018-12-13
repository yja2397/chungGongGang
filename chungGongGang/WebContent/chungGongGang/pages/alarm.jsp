<!-- 키워드 알람을 설정하는 페이지. 20181214기준 레이아웃만 완성.-->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*"%>
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
<title>CNU information | Alarm</title>
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
	<!--유정연 : 최상단 include-->
	<%@include file="Upper_part.jsp"%>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- Top Background Image Wrapper -->
	<!--유정연 : 메뉴가 포함된 상단-->
	<div class="bgded overlay"
		style="background-image: url('../images/demo/backgrounds/01.png');">
		<!-- ################################################################################################ -->
		<!--유정연 : 메뉴가 포함된 상단을 include-->
		<%@include file="dropdown.jsp"%>
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!-- ################################################################################################ -->
		<!--윤지애 : 세부 메뉴-->
		<div class="wrapper row2">
			<div id="breadcrumb" class="hoc clear">
				<!-- ################################################################################################ -->
				<ul>
					<li><a href="../index.html">Home</a></li>
					<li><a>키워드 알림</a></li>
					<li><a href="alarm.html">알림 설정</a></li>
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
	<!--윤지애 : 알림 설정-->
	<div class="wrapper row3">
		<main class="hoc container clear"> <!-- main body --> <!-- ################################################################################################ -->
		<h1>알림 설정</h1>
		<!--알림 설정-->
		<div id="alarm">
			<form name="form" method="post" action="alarmconfirm.jsp">
				<!-- 알람 확인.jsp에 넘김. -->
				<p class="formcaption">게시판</p>
				<select id="search" class="input" name="notice_board">
					<option value="cnuNew">충남대학교 새소식</option>
					<option value="cnuBae">충남대학교 학사정보</option>
					<option value="cnuEdu">충남대학교 교육정보</option>
					<option value="cnu">충남대학교 대학문화마당</option>
					<option value="dom">기숙사 은행사</option>
					<option value="domBac">기숙사 백행사</option>
					<option value="sw">SW 사업단 공지사항</option>
					<option value="comBae">컴퓨터공학과 학사정보</option>
					<option value="comBac">컴퓨터공학과 일반소식</option>
					<option value="com">컴퓨터공학과 사업단소식</option>
				</select> <br>
				<p class="formcaption">알림 방식</p>
				<div class="sub">
					<div class="newtext">새로운 글</div>
					<input class="new" type="radio" name="system" value="new">&nbsp;&nbsp;
					<div class="keywordtext">키워드 검색</div>
					&nbsp;<input class="keyword" type="radio" name="system"
						value="keyword">
				</div>
				<br>
				<p class="formcaption">
					키워드&nbsp;<span style="font-size: small">(예 : 공모전, 대회, 장학금)</span>
				</p>
				<input type="text" class="input" name="keyword"> <br> <input
					type="submit" value="확인" class="submit">
			</form>
		</div>
		<div style="height: 100px";></div>
		<!-- ################################################################################################ -->
		<!-- / main body -->
		<div class="clear"></div>
		</main>
	</div>
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- ################################################################################################ -->
	<!-- Footer Background Image Wrapper -->
	<!--유정연 : footer를 include-->
	<%@include file="Under_part.jsp"%>
</body>
</html>