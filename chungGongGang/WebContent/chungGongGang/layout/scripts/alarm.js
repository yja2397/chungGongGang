$(document).ready(function() {
	/*윤지애 : 알람 설정 자바스크립트 작성*/
	
    // 회원가입 버튼 클릭
    $('.submit').click(function(){
        //유효성 체크할 함수 호출
        invalidItem();
    });

    //유효성 체크할 함수
    function invalidItem() {
        // 알람 방식 체크
        if($("input[name=system]").is(":checked") != true){
            alert("알람 방식을 선택하세요.");
            $("input[name=system]").focus();
            return false;
        }
    }
});