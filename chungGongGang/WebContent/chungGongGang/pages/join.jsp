<!-- 회원가입을 나타내는 페이지이다. 20181214기준 로그인을 하는 자바스크립트 추가 요망-->
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*"%>
<html>
<!--윤지애 : 탭 이름-->
<head>
<title>CNU information | About</title>
<meta charset="utf-8">

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
					<li><a href="join.html">Join</a></li>
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
	<!--윤지애 : 회원가입-->
	<div class="wrapper row3">
		<main class="hoc container clear"> <!-- main body --> <!-- ################################################################################################ -->
		<h1>회원가입</h1>
		<!--회원가입-->
		<div id="join">
			<form name="form" method="post" action="JoinPro.jsp">

				<p>
					*아이디&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="text" name="id" class="input" autofocus required
						placeholder="아이디를 입력하시오">
				</p>
				<p>
					*이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="text" name="name" class="input" required
						placeholder="이름을 입력하시오">
				</p>
				<p>
					*비밀번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="password" name="password" class="input" required
						placeholder="비밀번호를 입력하시오">
				</p>
				<p>
					*비밀번호 확인&nbsp;&nbsp;<input type="password" name="passwordConfirm"
						class="input" required placeholder="비밀번호를 한 번 더 입력하시오">
				</p>
				<p>
					*휴대폰 번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"
						name="phone" class="input" pattern="\d{2,3}-\d{3,4}-\d{4}"
						required placeholder="휴대폰 번호를 입력하시오">
				</p>
				<p>
					*이메일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="email" name="email" class="input" autocomplete="off"
						required placeholder="이메일을 입력하시오">
				</p>
				<p>
					&nbsp;&nbsp;생년월일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="date" name="birthday" class="input">
				</p>
				<p>
					&nbsp;&nbsp;관심분야&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
						list="subject" name="subject" class="input">
					<datalist id="subject">
						<option value="개발">
						<option value="디자인">
						<option value="외국어">
					</datalist>
				</p>
				<p>
					<input type="submit" value="회원가입" class="submit">
				</p>
			</form>
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
	<!--유정연 : footer를 include-->
	<%@include file="Under_part.jsp"%>
</body>
</html>