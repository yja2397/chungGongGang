$(document).ready(function() {
	/*윤지애 : 회원가입 javascript*/

    // 회원가입 버튼 클릭
    $('.submit').click(function(){
        //유효성 체크할 함수 호출
        invalidItem();
    });

    //유효성 체크할 함수
    function invalidItem() {
        // 아이디 체크
        if($("input[name=id]").val() == '') {
            alert("아이디를 입력하세요.");
            $("input[name=id]").focus();

            return false;
        }

        // 이름 체크
        if($("input[name=name]").val() == ''){
            alert("이름을 입력하세요.");
            $("input[name=name]").focus();

            return false;
        }

        // 비밀번호 체크
        if($("input[name=password]").val() == ''){
            alert("비밀번호를 입력하세요");
            $("input[name=password]").focus();

            return false;
        }

        // 비밀번호 확인 체크
        if ($("input[name=passwordConfirm]").val() == '') {
            alert("비밀번호 확인을 입력하세요");
            $("input[name=passwordConfirm]").focus();

            return false;
        }

        // 비밀번호, 비밀번호 확인 동일 데이터 검사
        if ($("input[name=password]").val() != $("input[name=passwordConfirm]").val()) {
            alert("비밀번호가 일치하지 않습니다.");
            $("input[name=password]").val('');
            $("input[name=passwordConfirm]").val('');

            return false;
        }

        // 휴대폰 번호 체크
        if ($("input[name=phone]").val() == '') {
            alert("휴대폰 번호를 입력하세요");
            $("input[name=phone]").focus();

            return false;
        }

        // 이메일 체크
        if ($("input[name=email]").val() == '') {
            alert("이메일을 입력하세요");
            $("input[name=email]").focus();

            return false;
        }

        alert($("input[name=name]").val() + "님 회원가입을 축하합니다");
    }
});