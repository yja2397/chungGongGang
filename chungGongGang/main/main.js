
$(function(){
    $(".main-menu li").hover(function(){
        $('ul:first',this).show();
    }, function(){
        $('ul:first',this).hide();
    });
    $(".main-menu>li:has(ul)>a").each( function() {
        $(this).html( $(this).html()+' &or;' );
    });
    $(".main-menu ul li:has(ul)")
        .find("a:first")
        .append("<p style='float:right;margin:-3px'>&#9656;</p>");
});