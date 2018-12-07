$(document).ready(function() {

		// 로그인 버튼 클릭
		$(function() {
			// post 방식을 사용하여 loginP.jsp로 이동
			$.post("add.jsp", 
			{
				url : "http://wise.cnu.ac.kr/community/notice";
			},
			// loginP.jsp에서 받아온 값을 <div id="login_result">에 저장
			function(data, status) {
				$('.scrollable table').html(data);
			});
		});
		
		
	});	