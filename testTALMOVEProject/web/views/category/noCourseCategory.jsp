<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 없을때 </title>
<link href="/testt/views/category/css/noCourseCategory.css" rel="stylesheet">
<script type="text/javascript" src="/tal/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
// html dom 이 다 로딩된 후 실행된다.

$(document).ready(function(){
    $(".menua").click(function(){
       
        var submenu = $(this).next("ul");

        if( submenu.is(":visible") ){
            submenu.slideUp();
        }else{
            submenu.slideDown();
        }
    });
});


</script>
</head>
<body>
<header></header>
<section>

<!-- 카테고리명 -->
<div id="d1">
<p id="category_1">비즈니스</p><p id="category_2">커뮤니케이션</p>
</div>


<!-- 메뉴 바 -->
<div id="d2">
<div class="dropdown">
<a class="menua" >비즈니스▼</a>
<ul class="hide">
<li><a href="#">비즈니스</a></li><hr>
<li><a href="#">프로그래밍</a></li>
</ul>
</div>
<div id="dlist">
<ul id="list">
<li><a href="#">커뮤니케이션</a></li>
<li><a href="#">경영</a></li>
<li><a href="#">판매</a></li>
<li><a href="#">전략</a></li>
<li><a href="#">운영</a></li>
</ul>
</div>
</div>

<div id="noco">
<p id="nocop">빠른 시일 내에 좋은 강좌로<br>
찾아 뵙겠습니다 :)</p>
</div>


</section>
<footer></footer>


</body>
</html>