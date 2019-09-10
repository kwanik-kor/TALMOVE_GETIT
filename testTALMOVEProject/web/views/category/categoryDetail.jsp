<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>category_1</title>
<link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
<link href="/testt/views/category/css/categoryDetail.css" rel="stylesheet">
<script type="text/javascript" src="/tal/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
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


<!-- 인기강좌 카드 -->
<div id="cardPlace">
<p class="title">인기 강좌</p>
<div id="cardp">
<div class="card">
  <img src="/testt/views/category/images/제목 없음.jpg" class="card-img-top">
  <div class="card-body">
    <ul class="cardlist">
       <li class="cli_1">쉽게 배우는 해운 시황의 이해</li>
       <li class="cli_2">By. 이학열</li>
       <li class="cli_3">★☆☆☆☆ 1.0(12)</li>
       <p class="cp">￦14,000</p>
    </ul>
  </div>
</div>
<div class="card">
  <img src="/testt/views/category/images/제목 없음.jpg" class="card-img-top">
  <div class="card-body">
     <ul class="cardlist">
       <li class="cli_1">쉽게 배우는 해운 시황의 이해</li>
       <li class="cli_2">By. 이학열</li>
       <li class="cli_3">★☆☆☆☆ 1.0(12)</li>
       <p class="cp">￦14,000</p>
    </ul>
  </div>
</div>
<div class="card">
  <img src="/testt/views/category/images/제목 없음.jpg" class="card-img-top">
  <div class="card-body">
     <ul class="cardlist">
       <li class="cli_1">쉽게 배우는 해운 시황의 이해</li>
       <li class="cli_2">By. 이학열</li>
       <li class="cli_3">★☆☆☆☆ 1.0(12)</li>
       <p class="cp">￦14,000</p>
    </ul>
  </div>
</div>
<div class="card">
  <img src="/testt/views/category/images/제목 없음.jpg" class="card-img-top">
  <div class="card-body">
     <ul class="cardlist">
       <li class="cli_1">쉽게 배우는 해운 시황의 이해</li>
       <li class="cli_2">By. 이학열</li>
       <li class="cli_3">★☆☆☆☆ 1.0(12)</li>
       <p class="cp">￦14,000</p>
    </ul>
  </div>
</div>
</div>
</div>

<!--정렬 -->
<div id="d3">
<div class="dropdown" style="float:left;">
<a class="menua">정렬▼</a>
<ul class="hide">
<li><a href="#">인기도</a></li><hr>
<li><a href="#">최고평점</a></li><hr>
<li><a href="#">최저가</a></li><hr>
<li><a href="#">최고가</a></li><hr>
</ul>
</div>
</div>

<!-- 모든 강좌 -->
<div style="width:100%;">
<p class="title" style="margin-bottom:20px;">모든 비즈니스 강좌</p>
<div class="class">
<div class="image_place"><img src="/testt/views/category/images/제목 없음.jpg" style="width:100%; height:100%;"></div>
<div class="comment">
<ul id="ulcomment_1">
<li class="co_1"><p>쉽게 배우는 해운 시황의 이해</p></li>
<li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
<li class="co_3"><p>안녕하세요 저는 영어 강의입니다아~~~~~~~~~~~~~~~~
~~~~~~~~~~~</p></li>
</ul>
<ul id="ulcomment_2">
<li class="rco_1"><p>￦14000</p></li>
<li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
<li class="rco_3"><p>(12개의 리뷰)</p></li>
</ul>
</div>
</div>
<hr class="h">
<div class="class">
<div class="image_place"><img src="/testt/views/category/images/제목 없음.jpg" style="width:100%; height:100%;"></div>
<div class="comment">
<ul id="ulcomment_1">
<li class="co_1"><p>쉽게 배우는 해운 시황의 이해</p></li>
<li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
<li class="co_3"><p>안녕하세요 저는 영어 강의입니다아~~~~~~~~~~~~~~~~
~~~~~~~~~~~</p></li>
</ul>
<ul id="ulcomment_2">
<li class="rco_1"><p>￦14000</p></li>
<li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
<li class="rco_3"><p>(12개의 리뷰)</p></li>
</ul>
</div>
</div>
<hr class="h"><div class="class">
<div class="image_place"><img src="/testt/views/category/images/제목 없음.jpg" style="width:100%; height:100%;"></div>
<div class="comment">
<ul id="ulcomment_1">
<li class="co_1"><p>쉽게 배우는 해운 시황의 이해</p></li>
<li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
<li class="co_3"><p>안녕하세요 저는 영어 강의입니다아~~~~~~~~~~~~~~~~
~~~~~~~~~~~</p></li>
</ul>
<ul id="ulcomment_2">
<li class="rco_1"><p>￦14000</p></li>
<li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
<li class="rco_3"><p>(12개의 리뷰)</p></li>
</ul>
</div>
</div>
<hr class="h"><div class="class">
<div class="image_place"><img src="/testt/views/category/images/제목 없음.jpg" style="width:100%; height:100%;"></div>
<div class="comment">
<ul id="ulcomment_1">
<li class="co_1"><p>쉽게 배우는 해운 시황의 이해</p></li>
<li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
<li class="co_3"><p>안녕하세요 저는 영어 강의입니다아~~~~~~~~~~~~~~~~
~~~~~~~~~~~</p></li>
</ul>
<ul id="ulcomment_2">
<li class="rco_1"><p>￦14000</p></li>
<li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
<li class="rco_3"><p>(12개의 리뷰)</p></li>
</ul>
</div>
</div>
<hr class="h"><div class="class">
<div class="image_place"><img src="/testt/views/category/images/제목 없음.jpg" style="width:100%; height:100%;"></div>
<div class="comment">
<ul id="ulcomment_1">
<li class="co_1"><p>쉽게 배우는 해운 시황의 이해</p></li>
<li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
<li class="co_3"><p>안녕하세요 저는 영어 강의입니다아~~~~~~~~~~~~~~~~
~~~~~~~~~~~</p></li>
</ul>
<ul id="ulcomment_2">
<li class="rco_1"><p>￦14000</p></li>
<li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
<li class="rco_3"><p>(12개의 리뷰)</p></li>
</ul>
</div>
</div>
<hr class="h"><div class="class">
<div class="image_place"><img src="/testt/views/category/images/제목 없음.jpg" style="width:100%; height:100%;"></div>
<div class="comment">
<ul id="ulcomment_1">
<li class="co_1"><p>쉽게 배우는 해운 시황의 이해</p></li>
<li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
<li class="co_3"><p>안녕하세요 저는 영어 강의입니다아~~~~~~~~~~~~~~~~
~~~~~~~~~~~</p></li>
</ul>
<ul id="ulcomment_2">
<li class="rco_1"><p>￦14000</p></li>
<li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
<li class="rco_3"><p>(12개의 리뷰)</p></li>
</ul>
</div>
</div>
<hr class="h"><div class="class">
<div class="image_place"><img src="/testt/views/category/images/제목 없음.jpg" style="width:100%; height:100%;"></div>
<div class="comment">
<ul id="ulcomment_1">
<li class="co_1"><p>쉽게 배우는 해운 시황의 이해</p></li>
<li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
<li class="co_3"><p>안녕하세요 저는 영어 강의입니다아~~~~~~~~~~~~~~~~
~~~~~~~~~~~</p></li>
</ul>
<ul id="ulcomment_2">
<li class="rco_1"><p>￦14000</p></li>
<li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
<li class="rco_3"><p>(12개의 리뷰)</p></li>
</ul>
</div>
</div>
<hr class="h"><div class="class">
<div class="image_place"><img src="/testt/views/category/images/제목 없음.jpg" style="width:100%; height:100%;"></div>
<div class="comment">
<ul id="ulcomment_1">
<li class="co_1"><p>쉽게 배우는 해운 시황의 이해</p></li>
<li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
<li class="co_3"><p>안녕하세요 저는 영어 강의입니다아~~~~~~~~~~~~~~~~
~~~~~~~~~~~</p></li>
</ul>
<ul id="ulcomment_2">
<li class="rco_1"><p>￦14000</p></li>
<li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
<li class="rco_3"><p>(12개의 리뷰)</p></li>
</ul>
</div>
</div>
<hr class="h"><div class="class">
<div class="image_place"><img src="/testt/views/category/images/제목 없음.jpg" style="width:100%; height:100%;"></div>
<div class="comment">
<ul id="ulcomment_1">
<li class="co_1"><p>쉽게 배우는 해운 시황의 이해</p></li>
<li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
<li class="co_3"><p>안녕하세요 저는 영어 강의입니다아~~~~~~~~~~~~~~~~
~~~~~~~~~~~</p></li>
</ul>
<ul id="ulcomment_2">
<li class="rco_1"><p>￦14000</p></li>
<li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
<li class="rco_3"><p>(12개의 리뷰)</p></li>
</ul>
</div>
</div>
<hr class="h"><div class="class">
<div class="image_place"><img src="/testt/views/category/images/제목 없음.jpg" style="width:100%; height:100%;"></div>
<div class="comment">
<ul id="ulcomment_1">
<li class="co_1"><p>쉽게 배우는 해운 시황의 이해</p></li>
<li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
<li class="co_3"><p>안녕하세요 저는 영어 강의입니다아~~~~~~~~~~~~~~~~
~~~~~~~~~~~</p></li>
</ul>
<ul id="ulcomment_2">
<li class="rco_1"><p>￦14000</p></li>
<li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
<li class="rco_3"><p>(12개의 리뷰)</p></li>
</ul>
</div>
</div>
</div>


<!-- 페이지 넘김 -->
<div id="d4">
  <ul class="page">
    <li class="page-item">
      <a class="page-link" href="#"><span>&laquo;</span></a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item"><a class="page-link" href="#">4</a></li>
    <li class="page-item"><a class="page-link" href="#">5</a></li>
    <li class="page-item">
      <a class="page-link" href="#"><span>&raquo;</span></a>
    </li>
  </ul>
</div>





</section>
<footer></footer>
</body>
</html>