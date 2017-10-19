/**
 * Created by lichunyu on 16/9/22.
 * 首页核心js文件
 */
$(function(){
    //实现左侧导航动画效果
    $(".baseUI>li>a").off("click");
    $(".baseUI>li>a").on("click",function () {
        $(".baseUI>li>ul").slideUp();
        $(this).next().slideDown(300);
    });
    //默认收起全部，展示第一个
    $(".baseUI>li>ul").slideUp();
    $(".baseUI>li>a").eq(0).trigger("click");

    $(".baseUI>li>ul>li").off();
    $(".baseUI>li>ul>li").on("click",function () {
        if(!$(this).hasClass("current")){
            $(".baseUI>li>ul>li").removeClass("current");
            $(this).addClass("current");
        }
    });
    //模拟点击
    $(".baseUI>li>ul>li>a").eq(0).trigger("click");
});

$(function(){
	//首页默认显示
	$(".right").load("/exam/subject/subjectListPage.action");
	
	//侧栏点击跳转
	$(".toAction").click(function(){
		$("#right").load($(this).attr('href'));
		return false;
	})
});

