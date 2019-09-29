<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="course.model.vo.Course, java.util.ArrayList"%>
<%
	ArrayList<Course> list = (ArrayList<Course>)request.getAttribute("list");
	String category = ((String)request.getAttribute("category"));
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	String categoryUpper = ((String)request.getAttribute("categoryUpper"));
	ArrayList<Course> flist = (ArrayList<Course>)request.getAttribute("flist");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="icon" href="data:;base64,iVBORw0KGgo=">
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
	<script type="text/javacsript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">

	</script>
</head>
<body>
	<%@ include file="../common/gnb.jsp" %>

	<section>
		<!-- 카테고리명 -->
		<div class="category-title">
		<% if(categoryUpper != null){ %>
		    <p id="category-1"><%= categoryUpper %></p>
		<% }else{ %>
			<p id="category-1"></p>
		<% } %>
		    <p id="category-2"><%= category %></p>
		</div>
		<!-- 메뉴 바 -->
		<div class="category-menu">
		    <ul class="categories">
		       <li><a id="upcat">비즈니스<i class="fas fa-chevron-down"></i></a></li>
		       <ul class="dropdown-upcat">
		           <li><a id="bbtn" href="#">비즈니스</a></li>
		           <li><a id="pbtn" href="#">프로그래밍</a></li>
		       </ul>
		       <li><a href="#">커뮤니케이션</a></li>
		       <li><a href="#">경영</a></li>
		       <li><a href="#">판매</a></li>
		       <li><a href="#">전략</a></li>
		       <li><a href="#">운영</a></li>
		       <li><a href="#"></a></li>
		       <li><a href="#"></a></li>
		    </ul>
		</div>
    </section>
    <section>
		<!-- 인기강좌 카드 -->
		<div class="row">
            <p class="favorite-course"><span><%= category %></span> 분야의 인기 강좌</p>
            <div class="row">
            <% for(Course course : flist){ %>
                <div class="course-card">
                  <img src="/testt/resources/img/sample_thumbnail3.jpg" class="card-img-top">
                  <div class="card-body">
                     <ul class="cardlist">
                       <li class="cli_1"><%= course.getCourseName() %></li>
                       <li class="cli_2">By. <%= course.getTeacherName() %></li>
                       <li class="cli_3"><span class="starpoint">★☆☆☆☆</span> 1.0(12)</li>
                       <p class="cp">￦<%= course.getPrice() %></p>
                    </ul>
                  </div>
                </div>
               	<% } %>
            </div>
		</div>
    </section>
    <section>
        <!--정렬 -->
        <div class="order-courses">
            <ul class="categories">
                <li><a id="upcat2">정렬<i class="fas fa-chevron-down"></i></a></li>
                <ul class="dropdown-upcat2">
                    <li><a id="purchase">인기도</a></li>
                    <li><a onclick="sortCourse('최고평점')">최고평점</a></li>
                    <li><a onclick="sortCourse('최저가')">최저가</a></li>
                    <li><a onclick="sortCourse('최고가')">최고가</a></li>
                </ul>
            </ul>
        </div>
    </section>
    
    <section>
		<!-- 모든 강좌 -->
		<input type="hidden" id="category" value="<%= category %>">
		<h3 class="row class-title">모든 <%= category %> 강좌</h3>
		<div class="row">
		<% for(Course course : list){ %>
		<div class="class clearfix">
            <div class="image-place"><a href="/testt/coursedetail?courseNo=<%= course.getCourseNo() %>"><img src="/testt/resources/img/sample_<%= course.getThumbnailOfileName() %>"></a></div>
            <div class="comment">
                <ul id="ulcomment_1">
                    <li class="co_1"><a href="/testt/coursedetail?courseNo=<%= course.getCourseNo() %>"><%= course.getCourseName() %></a></li>
                    <li class="co_2"><ul class="detail"><li>19개의 강의</li><li>33분</li></ul></li>
                    <li class="co_3"><p><%= course.getDescription() %></p></li>
                </ul>
                <ul id="ulcomment_2">
                    <li class="rco_1"><p>￦<%= course.getPrice() %></p></li>
                    <li class="rco_2"><p><span class="ystar">★★☆☆☆</span> 2.0</p></li>
                    <li class="rco_3"><p>(12개의 리뷰)</p></li>
                </ul>
            </div>
		</div>
		<% } %>

		</div>
		
		
		<!-- 페이지 넘김 -->
		<div class="row page-index">
		  <ul class="page clearfix">
		    <li class="page-item">
		    <% if(currentPage <= 1){ %>
		      <a class="page-link"><span>&laquo;</span></a>
		    <% }else{  %>
		    <a class="page-link" href="/testt/ccourse?page=1&category=<%= category %>"><span>&laquo;</span></a>
		    <% } %>
		    </li>
		    
		    <% for(int p = startPage; p <= endPage; p++){
				if(p == currentPage){%>
					<li class="page-item"><a class="page-link"><%= p %></a></li>
				<% }else{ %>
					<li class="page-item"><a class="page-link" href="/testt/ccourse?page=<%= p %>&category=<%= category %>"><%= p %></a></li>
				<% }} %>

		    <li class="page-item">
		    <% if(currentPage >= maxPage){ %>
		      <a class="page-link"><span>&raquo;</span></a>
		    <% }else{ %>
		    	<a class="page-link" href="/testt/ccourse?page=<%= maxPage %>&category=<%= category %>"><span>&raquo;</span></a>
		    <% } %>
		    </li>
		  </ul>
		</div>
		<div></div>
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
	
	$('#upcat2').click(function(){
        var submenu = $('.dropdown-upcat2');
        var icon = $('#upcat2 i');
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
	
	
	$(function(){
		$("document").ready(function(){
			$("#purchase").click(function(){
				var ca = $("#category").val();
			$.ajax({
				url: "/testt/selsort",
				type: "get",
				data : {category : ca},
				dataType: "json",
				success: function(data){
					//객체를 문자열로 변환 처리함
					var jsonStr = JSON.stringify(data);
					//문자열을 배열 객체로 바꿈
					var json = JSON.parse(jsonStr);
				
					var values = "";
					for(var i in json.list){
						values += "<div class='image-place'><a href='/testt/coursedetail?courseNo='" + json.list[i].courseNo + "><img src='/testt/resources/img/sample_'" + json.list[i].fileName + "></a></div>"
					            +"<div class='comment'>"
				                +"<ul id='ulcomment_1'>"
				                    +"<li class='co_1'><a href='/testt/coursedetail?courseNo='" + json.list[i].courseNo +  ">" + json.list[i].courseName +"></a></li>"
				                    +"<li class='co_2'><ul class='detail'><li>19개의 강의</li><li>33분</li></ul></li>"
				                    +"<li class='co_3'><p>" + json.list[i].description + "></p></li>"
				                +"</ul>"
				                +"<ul id='ulcomment_2'>"
				                    +"<li class='rco_1'><p>￦" +json.list[i].price + "></p></li>"
				                    +"<li class='rco_2'><p><span class='ystar'>★★☆☆☆</span> 2.0</p></li>"
				                    +"<li class='rco_3'><p>(12개의 리뷰)</p></li>"
				                +"</ul>"
				            +"</div>";
					} //for in
				
					//테이블에 추가
					$(".clearfix").html($(".clearfix").html(values));
				
				},
				error: function(jqXHR, textStatus, errorThrown){
					console.log("error : " + jqXHR + ", " + 
							textStatus + ", " + errorThrown);
				}
			}) 
			})
		})
	});
	</script>
</body>
</html>
