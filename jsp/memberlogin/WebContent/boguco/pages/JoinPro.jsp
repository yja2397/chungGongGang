<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%request.setCharacterEncoding("UTF-8");
//한글 깨짐 방지를 위한 코드.
%>
<html>
<head>
<link href="../layout/styles/layout.css" rel="stylesheet"
	type="text/css" media="all">
<meta charset="EUC-KR">
<title>가입을 축하드립니다!</title>
</head>
<body>
	<!--유정연 : jsp파일 전체적인 css관리. ->상단부 , 하단부 링크 추가--!>
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
			<li class="active"><a href="index.html">Home</a></li>
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
			<li><a class="drop">키워드 알림</a>
			<!--키워드 알림 메뉴-->
				<ul>
					<li class="submenu"><a href="alarm.html" target="iframe">알림
							설정</a></li>
					<!--알림 설정-->
					<li class="submenu"><a href="alarmconfirm.html"
						target="iframe">알림 확인</a></li>
					<!--알림 확인-->
				</ul></li>
		</ul>
		<form action="#">
			<select><option selected="selected" value="">MENU</option>
				<option value="index.html">Home</option>
				<option>공지사항</option>
				<option value="notice.html">- - 충남대 공지사항</option>
				<option value="#">- - 기숙사 공지사항</option>
				<option value="#">- - SW 사업단 공지사항</option>
				<option value="#">- - 컴퓨터공학과 공지사항</option>
				<option>키워드 알림</option>
				<option value="alarm.html">- - 알림 설정</option>
				<option value="alarmconfirm.html">- - 알림 확인</option></select>
		</form>
	</nav>
	<!-- 여기까지가 메인페이지 윗 드롭다운 메뉴 설정. -->
	</header>
	</div>
	<% 
        // getParameter()를 이용해 넘겨진 파라미터 값을 얻어올 수 있다.
        // 파라미터 값을 얻을때 name= 에 지정해둔 값과 동일한 값을 인자로 지정해야 된다.
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        //2018120 오전 1:34 수정. 눌린거 없음 해당사항 없음으로 출력됩니다!
        String subject = (request.getParameter("subject") != "")? request.getParameter("subject"): "해당사항 없음!";
       
    %>
	<div class="wrapper row3">
		<main class="hoc container clear"> <!-- main body --> <!-- ################################################################################################ -->
		<h1>회원가입 확인</h1>
		<!--회원가입 확인 코드!-->
		<div id="join">
			<div id="wrapper">
				<br>
				<br> <b><font size="5" color="gray">회원가입 정보를 확인하세요.</font></b>
				<br>
				<br> <font color="blue"><%=name %></font>님 가입을 축하드립니다. <br>
				<br>

				<table>
					<tr>
						<td id="title">아이디</td>
						<td><%=id %></td>
					</tr>

					<tr>
						<td id="title">비밀번호</td>
						<td><%=password %></td>
					</tr>

					<tr>
						<td id="title">이름</td>
						<td><%=name %></td>
					</tr>

					<tr>
						<td id="title">생일</td>
						<td><%=birthday %></td>
					</tr>

					<tr>
						<td id="title">이메일</td>
						<td><%=email %></td>
					</tr>

					<tr>
						<td id="title">휴대전화</td>
						<td><%=phone %></td>
					</tr>
					<tr>
						<td id="title">흥미사항</td>
						<td><%=subject %></td>
					</tr>
				</table>

				<br>
				<!--버튼을 누르면 로그인창으로 이동한다-->
				<a href="join.html"> <input type="button" value="확인"
					class="submit"></a>
			</div>
		</div>
		<!-- ################################################################################################ -->
		<!-- / main body -->
		<div class="clear"></div>
		</main>
	</div>
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

</body>
</html>