<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html>
<HTML>
<HEAD>
<title>selProduct.jsp</title>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		// 추가 버튼 클릭
		$("input[name=add]").click(function() {
			$.post("add.jsp", 
					// userid, passwd에 입력된 데이터를 전송
					{
						product : $("select[name=product]").val()
					},

					// loginP.jsp에서 받아온 값을 <div id="login_result">에 저장
					function(data, status) {
						$('#item_list').html(data);
					});
		});

		// 계산 버튼 클릭
		$("input[name=checkOut]").click(function() {
			$.post("checkOut.jsp", 
					// userid, passwd에 입력된 데이터를 전송
					{
						products : $("#item_list").val()
					},

					// loginP.jsp에서 받아온 값을 <div id="login_result">에 저장
					function(data, status) {
						$('#item_check_out').html(data);
					});
		});

		
		// 취소 버튼 클릭
		$("input[name=clean]").click(function() {

			$.post("clean.jsp", {}, function(data, status) {
				if (status == 'success') {
					$('#item_list').html("선택한 상품이 없습니다.");
					$('#item_check_out').html("0원");
				} else {
				}

			});
		});
	});

</script>
</head>

<body>
	<div align="center">
		<h2>상품선택</h2>

		<form name="form" method="post">
			<select name="product">
				<option value="사과">사과(1000원)</option>
				<option value="귤">귤(500원)</option>
				<option value="파인애플">파인애플(3000원)</option>
				<option value="자몽">자몽(2000원)</option>
				<option value="레몬">레몬(1500원)</option>
			</select> 
			
			<input type="button" name="add" value="추가" /> 
			<input type="button" name="checkOut" value="계산" />
			<input type="button" name="clean" value="취소" />
		</form>
	</div>

	<div align="center">
		<h2>선택한 상품 목록</h2>
		<div id="item_list">선택한 상품이 없습니다.</div>
	</div>


	<div align="center">
		<h2>계산 결과</h2>
		<div id="item_check_out">0원</div>
	</div>
</body>
</html>