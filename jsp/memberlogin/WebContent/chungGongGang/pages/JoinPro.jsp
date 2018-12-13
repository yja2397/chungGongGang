
<!--출처: http://all-record.tistory.com/110?category=733042 [세상의 모든 기록]  -->
<!-- 유정연 : 위 출처를 바탕으로 상황에 맞도록 작성함. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("UTF-8");
	//한글 깨짐 방지를 위한 코드.
%>
<!-- 작성한 빈을 가져오는 코드! -->
<%@ page import="source.memberBean"%>
<%@ page import="source.SaveData"%>
<html>
<head>
<link href="../layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">
<meta charset="UTF-8">
<title>가입을 축하드립니다!</title>
</head>
<body>
	<!--유정연 : jsp파일 전체적인 css관리. ->상단부 , 하단부 링크 추가-->
	<!--유정연 : 메뉴가 포함된 상단을 include-->
	<%@include file="dropdown.jsp"%>
	<!-- id파라미터는 id 프로퍼티로 적용하는 등 각각의 요소들을 모두 지정할 수 있다.-->
	<jsp:useBean id="memberBean" class="source.memberBean" />
	<jsp:useBean id="save" class="source.SaveData" /> <!-- database에 저장하기 위한 클래스 호출 -->
	<jsp:setProperty property="*" name="memberBean" />
	
	<%	/* 윤지애 : 데이터베이스에 회원가업 정보 데이터 저장. */
		save.dataSave(memberBean); // 회원 정보를담고 있는 memberBean을 database 테이블에 저장한다.
	%>
	<div class="wrapper row3">
		<main class="hoc container clear"> <!-- main body --> <!-- ################################################################################################ -->
		<h1>회원가입 확인</h1>
		<!--회원가입 확인 코드! bean의 getter setter를 통해 저장된 회원 정보를 확인할 수 있게 구현하였다.-->
		<div id="join">
			<div id="wrapper">
				<br> <br> <b><font size="5" color="gray">회원가입
						정보를 확인하세요.</font></b> <br> <br> <font color="blue"><%=memberBean.getName()%></font>님
				가입을 축하드립니다. <br> <br>
				<table>
					<tr>
						<td id="title">아이디</td>
						<td><%=memberBean.getId()%></td>
					</tr>
					<tr>
						<td id="title">비밀번호</td>
						<td><%=memberBean.getPassword()%></td>
					</tr>
					<tr>
						<td id="title">이름</td>
						<td><%=memberBean.getName()%></td>
					</tr>
					<tr>
						<td id="title">생일</td>
						<td><%=memberBean.getBirthday()%></td>
					</tr>
					<tr>
						<td id="title">이메일</td>
						<td><%=memberBean.getEmail()%></td>
					</tr>
					<tr>
						<td id="title">휴대전화</td>
						<td><%=memberBean.getPhone()%></td>
					</tr>
					<tr>
					<!-- 유정연 : 흥미사항 추가. (로그인 구현 화면에 맞게 table을 원본에서 수정함) -->
						<td id="title">흥미사항</td>
						<td><%=memberBean.getSubject()%></td>
					</tr>
				</table>
				<br>
				<!--버튼을 누르면 로그인창으로 이동한다-->
				<a href="join.jsp"> <input type="button" value="확인"class="submit" ></a>
			</div>
		</div>
		<!-- ################################################################################################ -->
		<!-- / main body -->
		<div class="clear"></div>
		</main>
	</div>
	<nav class="quicklinks row4">
		<ul class="hoc clear">
			<li><a href="../index.jsp"><i class="fa fa-lg fa-home"></i></a></li>
			<li><a href="about.jsp">About</a></li>
			<li><a href="http://plus.cnu.ac.kr/html/kr/">CNU</a></li>
			<li><a href="http://dorm.cnu.ac.kr/html/kr/">Domitory</a></li>
			<li><a href="http://wise.cnu.ac.kr/">SW</a></li>
			<li><a href="http://computer.cnu.ac.kr/">Computer</a></li>
		</ul>
	</nav>
</body>
</html>