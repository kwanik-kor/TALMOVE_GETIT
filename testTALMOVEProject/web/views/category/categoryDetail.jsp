<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width:device-width, initial-scale=1.0">
	<title>탈무브 | </title>
	<link rel="stylesheet" href="/testt/vendors/css/normalize.css">
    <link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
	<link href="/testt/views/category/css/categoryDetail.css" rel="stylesheet">
	<link rel="stylesheet" href="/testt/resources/css/style.css">
    <link rel="stylesheet" href="/testt/resources/css/common/footer.css">
    <link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
    <link rel="stylesheet" href="/testt/resources/css/queries.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/08d0951667.js"></script>
</head>
<body>
	<%@ include file="../common/gnb.jsp" %>

	<section>
		<!-- 카테고리명 -->
		<div class="category-title">
		    <p id="category-1">비즈니스</p>
		    <p id="category-2">커뮤니케이션</p>
		</div>
		<!-- 메뉴 바 -->
		<div class="category-menu">
		    <ul class="categories">
		       <li><a href="#" id="upcat">비즈니스<i class="fas fa-chevron-down"></i></a></li>
		       <ul class="dropdown-upcat">
		           <li><a href="#">비즈니스</a></li>
		           <li><a href="#">프로그래밍</a></li>
		       </ul>
		       <li><a href="#">커뮤니케이션</a></li>
		       <li><a href="#">경영</a></li>
		       <li><a href="#">판매</a></li>
		       <li><a href="#">전략</a></li>
		       <li><a href="#">운영</a></li>
		    </ul>
		</div>
    </section>
    <section>
		<!-- 인기강좌 카드 -->
		<div class="row">
            <p class="favorite-course"><span>커뮤니케이션</span> 분야의 인기 강좌</p>
            <div class="row">
                <div class="course-card">
                  <img src="/testt/resources/img/sample_thumbnail2.jpg" class="card-img-top">
                  <div class="card-body">
                    <ul class="cardlist clearfix">
                       <li class="cli_1">쉽게 배우는 해운 시황의 이해</li>
                       <li class="cli_2">By. 이학열</li>
                       <li class="cli_3"><span class="starpoint">★☆☆☆☆</span> 1.0(12)</li>
                       <p class="cp">￦14,000</p>
                    </ul>
                  </div>
                </div>
                <div class="course-card">
                  <img src="/testt/resources/img/sample_thumbnail3.jpg" class="card-img-top">
                  <div class="card-body">
                     <ul class="cardlist">
                       <li class="cli_1">모두를 위한 딥러닝 - Reinforcement Learning</li>
                       <li class="cli_2">By. 이학열</li>
                       <li class="cli_3"><span class="starpoint">★☆☆☆☆</span> 1.0(12)</li>
                       <p class="cp">￦14,000</p>
                    </ul>
                  </div>
                </div>
                <div class="course-card">
                  <img src="/testt/resources/img/sample_thumbnail4.jpg" class="card-img-top">
                  <div class="card-body">
                     <ul class="cardlist">
                       <li class="cli_1">쉽게 배우는 해운 시황의 이해</li>
                       <li class="cli_2">By. 이학열</li>
                       <li class="cli_3"><span class="starpoint">★☆☆☆☆</span> 1.0(12)</li>
                       <p class="cp">￦14,000</p>
                    </ul>
                  </div>
                </div>
                <div class="course-card">
                  <img src="images/제목 없음.jpg" class="card-img-top">
                  <div class="card-body">
                     <ul class="cardlist">
                       <li class="cli_1">쉽게 배우는 해운 시황의 이해</li>
                       <li class="cli_2">By. 이학열</li>
                       <li class="cli_3"><span class="starpoint">★☆☆☆☆</span> 1.0(12)</li>
                       <p class="cp">￦14,000</p>
                    </ul>
                  </div>
                </div>
            </div>
		</div>
    </section>
    <section>
        <!--정렬 -->
        <div class="order-courses">
            <ul class="categories">
                <li><a href="#" id="upcat2">정렬<i class="fas fa-chevron-down"></i></a></li>
                <ul class="dropdown-upcat">
                    <li><a href="#">인기도</a></li>
                    <li><a href="#">최고평점</a></li>
                    <li><a href="#">최저가</a></li>
                    <li><a href="#">최고가</a></li>
                </ul>
            </ul>
        </div>
    </section>
    
    <section>
		<!-- 모든 강좌 -->
		<h3 class="row class-title">모든 커뮤니케이션 강좌</h3>
		<div class="row">
		<div class="class clearfix">
            <div class="image-place"><img src="/testt/resources/img/sample_thumbnail2.jpg"></div>
            <div class="comment">
                <ul id="ulcomment_1">
                    <li class="co_1"><p>쉽게 배우는 해운 시황의 이해</p></li>
                    <li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
                    <li class="co_3"><p>글로벌 해운 시장과 경제과정에 앞서 해운 시황에 대한 기초적인 지식을 습득 할 수 있는 과정입니다.</p></li>
                </ul>
                <ul id="ulcomment_2">
                    <li class="rco_1"><p>￦14000</p></li>
                    <li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
                    <li class="rco_3"><p>(12개의 리뷰)</p></li>
                </ul>
            </div>
		</div>
		<div class="class clearfix">
            <div class="image-place"><img src="/testt/resources/img/sample_thumbnail3.jpg"></div>
            <div class="comment">
                <ul id="ulcomment_1">
                    <li class="co_1"><p>모두를 위한 딥러닝 - Reinforcement Learning</p></li>
                    <li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
                    <li class="co_3"><p>모두를 위한 딥러닝 그 두번째 시간입니다.</p></li>
                </ul>
                <ul id="ulcomment_2">
                    <li class="rco_1"><p>￦14000</p></li>
                    <li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
                    <li class="rco_3"><p>(12개의 리뷰)</p></li>
                </ul>
            </div>
		</div>
		<div class="class clearfix">
            <div class="image-place"><img src="/testt/resources/img/sample_thumbnail4.jpg"></div>
            <div class="comment">
                <ul id="ulcomment_1">
                    <li class="co_1"><p>누구나 쉽게 배우는 Git(깃) &amp; Github(깃허브)</p></li>
                    <li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
                    <li class="co_3"><p>Git(깃)의 기초와 Github(깃허브) 활용법을 3.5시간만에 정복해봅시다!</p></li>
                </ul>
                <ul id="ulcomment_2">
                    <li class="rco_1"><p>￦14000</p></li>
                    <li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
                    <li class="rco_3"><p>(12개의 리뷰)</p></li>
                </ul>
            </div>
		</div>
		<div class="class clearfix">
            <div class="image-place"><img src="/testt/resources/img/sample_thumbnail2.jpg"></div>
            <div class="comment">
                <ul id="ulcomment_1">
                    <li class="co_1"><p>쉽게 배우는 해운 시황의 이해</p></li>
                    <li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
                    <li class="co_3"><p>글로벌 해운 시장과 경제과정에 앞서 해운 시황에 대한 기초적인 지식을 습득 할 수 있는 과정입니다.</p></li>
                </ul>
                <ul id="ulcomment_2">
                    <li class="rco_1"><p>￦14000</p></li>
                    <li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
                    <li class="rco_3"><p>(12개의 리뷰)</p></li>
                </ul>
            </div>
		</div>
		<div class="class clearfix">
            <div class="image-place"><img src="/testt/resources/img/sample_thumbnail3.jpg"></div>
            <div class="comment">
                <ul id="ulcomment_1">
                    <li class="co_1"><p>모두를 위한 딥러닝 - Reinforcement Learning</p></li>
                    <li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
                    <li class="co_3"><p>모두를 위한 딥러닝 그 두번째 시간입니다.</p></li>
                </ul>
                <ul id="ulcomment_2">
                    <li class="rco_1"><p>￦14000</p></li>
                    <li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
                    <li class="rco_3"><p>(12개의 리뷰)</p></li>
                </ul>
            </div>
		</div>
		<div class="class clearfix">
            <div class="image-place"><img src="/testt/resources/img/sample_thumbnail4.jpg"></div>
            <div class="comment">
                <ul id="ulcomment_1">
                    <li class="co_1"><p>누구나 쉽게 배우는 Git(깃) &amp; Github(깃허브)</p></li>
                    <li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
                    <li class="co_3"><p>Git(깃)의 기초와 Github(깃허브) 활용법을 3.5시간만에 정복해봅시다!</p></li>
                </ul>
                <ul id="ulcomment_2">
                    <li class="rco_1"><p>￦14000</p></li>
                    <li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
                    <li class="rco_3"><p>(12개의 리뷰)</p></li>
                </ul>
            </div>
		</div>
		<div class="class clearfix">
            <div class="image-place"><img src="/testt/resources/img/sample_thumbnail2.jpg"></div>
            <div class="comment">
                <ul id="ulcomment_1">
                    <li class="co_1"><p>쉽게 배우는 해운 시황의 이해</p></li>
                    <li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
                    <li class="co_3"><p>글로벌 해운 시장과 경제과정에 앞서 해운 시황에 대한 기초적인 지식을 습득 할 수 있는 과정입니다.</p></li>
                </ul>
                <ul id="ulcomment_2">
                    <li class="rco_1"><p>￦14000</p></li>
                    <li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
                    <li class="rco_3"><p>(12개의 리뷰)</p></li>
                </ul>
            </div>
		</div>
		<div class="class clearfix">
            <div class="image-place"><img src="/testt/resources/img/sample_thumbnail3.jpg"></div>
            <div class="comment">
                <ul id="ulcomment_1">
                    <li class="co_1"><p>모두를 위한 딥러닝 - Reinforcement Learning</p></li>
                    <li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
                    <li class="co_3"><p>모두를 위한 딥러닝 그 두번째 시간입니다.</p></li>
                </ul>
                <ul id="ulcomment_2">
                    <li class="rco_1"><p>￦14000</p></li>
                    <li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
                    <li class="rco_3"><p>(12개의 리뷰)</p></li>
                </ul>
            </div>
		</div>
		<div class="class clearfix">
            <div class="image-place"><img src="/testt/resources/img/sample_thumbnail4.jpg"></div>
            <div class="comment">
                <ul id="ulcomment_1">
                    <li class="co_1"><p>누구나 쉽게 배우는 Git(깃) &amp; Github(깃허브)</p></li>
                    <li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
                    <li class="co_3"><p>Git(깃)의 기초와 Github(깃허브) 활용법을 3.5시간만에 정복해봅시다!</p></li>
                </ul>
                <ul id="ulcomment_2">
                    <li class="rco_1"><p>￦14000</p></li>
                    <li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
                    <li class="rco_3"><p>(12개의 리뷰)</p></li>
                </ul>
            </div>
		</div>
		<div class="class clearfix">
            <div class="image-place"><img src="/testt/resources/img/sample_thumbnail4.jpg"></div>
            <div class="comment">
                <ul id="ulcomment_1">
                    <li class="co_1"><p>누구나 쉽게 배우는 Git(깃) &amp; Github(깃허브)</p></li>
                    <li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li><li>초급</li></ul></li>
                    <li class="co_3"><p>Git(깃)의 기초와 Github(깃허브) 활용법을 3.5시간만에 정복해봅시다!</p></li>
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
		<div class="row page-index">
		  <ul class="page clearfix">
		    <li class="page-item">
		      <a class="page-link" href="#"><span>&laquo;</span></a>
		    </li>
		    <li class="page-item active-page"><a class="page-link" href="#">1</a></li>
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
	
	<%@ include file="../common/footer.jsp" %>
	
	<script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/testt/resources/js/main.js"></script>
	<script type="text/javascript">
	$('#upcat').click(function(){
        var submenu = $('.dropdown-upcat');
        var icon = $('#upcat i');
        if(icon.hasClass('fa-chevron-down')){
            icon.removeClass('fa-chevron-down');
            icon.addClass('fa-chevron-up');
            submenu.css('display', 'block');
        }else{
            icon.removeClass('fa-chevron-up');
            icon.addClass('fa-chevron-down');
            submenu.css('display', 'none');
        }
    });
	</script>
</body>
</html>