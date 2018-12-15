<!-- 알람 정보를 모두 삭제하는 페이지. db에 있는 내용을 모두 삭제하고 다시 alarmconfirm.jsp로 돌아온다. -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="source.alarmData"%>

	<%
	/* 윤지애 : 알람 설정 정보를 모두 삭제 */
	request.setCharacterEncoding("UTF-8");
	alarmData save = new alarmData();
	save.delTable(); // alarmDB에 있는 정보를 지우는 메소드 실행.
	
	%>
	
	<script>
		alert("전부 삭제되었습니다."); // 전부 삭제되었다는 알림
		location.replace('alarmconfirm.jsp'); // alarmconfirm.jsp로 이동.
	</script>