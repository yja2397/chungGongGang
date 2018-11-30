// 메인 홈페이지의 메뉴를 구현하였다.

$(function(){
    $(".menus").hover(function(){
        $('ul:first',this).show();
    }, function(){
        $('ul:first',this).hide();
    });
    //마우스가 올라가거나 떨어지는 경우. 올라가면 서브메뉴를 보여주고 마우스를 이동시키면 사라지게 한다.
    // $(".main-menu>li:has(ul)>a").each( function() {
    //     $(this).html( $(this).html()+' &or;' );
    // });
    // $(".main-menu ul li:has(ul)")
    //     .find("a:first")
    //     .append("<p style='float:right;margin:-3px'>&#9656;</p>");

    //여기 주석처리한건 서브메뉴의 서브메뉴가 있는 경우의 코드인것 같아요!
});