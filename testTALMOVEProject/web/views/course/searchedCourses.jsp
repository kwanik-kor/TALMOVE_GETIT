<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, course.model.vo.Course" %>
<%
	String keyword = (String)request.getAttribute("keyword");
	ArrayList<Course> clist = (ArrayList<Course>)request.getAttribute("clist");
	int currentPage = (Integer)request.getAttribute("currentPage");
	int maxPage = (Integer)request.getAttribute("maxPage");
	int startPage = (Integer)request.getAttribute("startPage");
	int endPage = (Integer)request.getAttribute("endPage");
	int listCount = (Integer)request.getAttribute("listCount");
	String priceRange = (String)request.getAttribute("priceRange");
	String sort = (String)request.getAttribute("sort");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width:device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="/testt/vendors/css/normalize.css">
    <link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/testt/resources/css/style.css">
    <link rel="stylesheet" href="/testt/resources/css/common/footer.css">
    <link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
    <link rel="stylesheet" href="/testt/resources/css/queries.css">
    <link rel="stylesheet" href="/testt/views/course/css/searchedCourses.css">
    <link rel="shortcut icon" type="image/x-icon" href="/testt/resources/img/titlelogo.png">
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
    
	<title>검색결과 | 탈무브</title>
</head>
<body>
	<%@ include file="../common/gnb.jsp" %>
    <div>
        <section class="section-result-title">
            <div class="result-title">
                <p class="title">검색 결과</p>
                <p class="keyword"><%= keyword %></p>
            </div>
        </section>
        <div class="wrapper">
        <section class="section-classList">
        	<% if(listCount == 0){ %>
            <img src="/testt/resources/img/oops.PNG" class="oopsimg">
            <h2 class="no-course">관련된 강좌를 찾지 못했습니다. 다른 검색어를 시도해주세요.<br>배우고자 하시는 것들을 모두 찾을 수 있도록 <span>탈무브</span>가 노력하겠습니다.</h2>
            <% 
            }else{ 
            	for(Course c : clist){
            %>
	            <div class="searched-class clearfix" onclick="toCourseDetail(<%=c.getCourseNo() %>);">
	                <img src="/testt/resources/course_upfiles/<%= c.getThumbnailRfileName() %>" class="thumbnail">
	                <div class="class-content">
	                    <h3><%= c.getCourseName() %></h3>
	                    <p class="class-description"><%= c.getDescription() %></p>
	                    <p class="class-teacher">장관익</p>
	                    <p class="class-price">&#8361;<%= c.getPrice() %></p>
	                </div>
	            </div>
            <% } %>
            	<div class="page-wrapper">
            		<ul class="page">
            			<li class="page-item">
            				<% if(currentPage <= 1){ %>
            					<a class="page-link"><span>&laquo;</span></a>
            				<% }else{ %>
            					<a class="page-link" href="/testt/searchcourses.ed?page=1&keyword=<%= keyword %>&sort=<%= sort %>&priceRange=<%= priceRange %>"><span>&laquo;</span></a>
            				<% } %>
            			</li>
            			<% 
            			for(int p = startPage; p <= endPage; p++){
            				if(p == currentPage){
            			%>
            				<li class="page-item"><a class="page-link active-page"><%= p %></a></li>
            				<% }else{ %>
            				<li class="page-item"><a class="page-link" href="/testt/searchcourses.ed?page=<%= p %>&keyword=<%= keyword %>&sort=<%= sort %>&priceRange=<%= priceRange %>"><%= p %></a></li>
            			<% 
            				}
            			}
            			%>
            			<li class="page-item">
            				<% if(currentPage >= maxPage){ %>
            					<a class="page-link"><span>&raquo;</span></a>
            				<% }else{ %>
            					<a class="page-link" href="/testt/searchcourses.ed?page=<%= maxPage %>&keyword=<%= keyword %>&sort=<%= sort %>&priceRange=<%= priceRange %>"><span>&raquo;</span></a>
            				<% } %>
            			</li>
            		</ul>
            	</div>
            <% } %>
        </section>
        <section class="section-sortStandard">
            <div class="fixed-area">
                <div class="sortStandard-top">
                    <h3><%= listCount %>개의 검색결과</h3>
                </div>
                <div class="sortStandard-middle">
                	<input type="hidden" value="<%= sort %>" id="sortVal">
                	<% if(sort.equals("featured")){ %>
                    <label>정렬</label><input type="text" id="sort-standard" name="sort" value="탈무브 추천순" readonly><p>▼</p>
                    <% }else if(sort.equals("price-asc")){ %>
                    <label>정렬</label><input type="text" id="sort-standard" name="sort" value="낮은 가격순" readonly><p>▼</p>
                    <% }else{ %>
                    <label>정렬</label><input type="text" id="sort-standard" name="sort" value="인기순" readonly><p>▼</p>
                    <% } %>
                    <div class="sort-option">
                        <ul class="sort-options">
                            <li class="featured">탈무브 추천순</li>
                            <li class="price-asc">낮은 가격순</li>
                            <li class="popular">인기순</li>
                        </ul>
                    </div>
                </div>
                <div class="sortStandard-bottom">
                    <p>가격필터</p>
                    <label class="radioCon" for="filAll">전체<input id="all" type="radio" value="all"><span class="checkmark"></span></label>
                    <label class="radioCon" for="filFree">무료<input id="free" type="radio" value="free"><span class="checkmark"></span></label>
                    <label class="radioCon" for="filCost">유료<input id="paid" type="radio" value="paid"><span class="checkmark"></span></label>
                </div>
            </div>       
        </section>
        </div>
    </div>
    <%@ include file="../common/footer.jsp" %>
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/testt/resources/js/main.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$('.search').val("<%= keyword %>");
    		$('.<%= sort %>').addClass("active-option");
    		$('input#<%= priceRange %>').attr('checked', true);
    	});
        $(window).scroll(function(e){
            if($(this).scrollTop() > 315){
               $('.fixed-area').addClass('fix-sort');
            }else{
               $('.fixed-area').removeClass('fix-sort');
            }
        });
        var sortflag = 0;
        $('#sort-standard, #sort-standard ~ p').on('click', function(){
            if(sortflag == 0){
                $('.sort-option').addClass('is-visible');
                $('#sort-standard ~ p').text("▲");
                sortflag = 1;
            }else{
                $('.sort-option').removeClass('is-visible');
                $('#sort-standard ~ p').text("▼");
                sortflag = 0;
            }
        });
        
        function toCourseDetail(courseNo){
        	location.href = "/testt/coursedetail?courseNo="+courseNo;
        }
        
        /* page, keyword, filter, sort 값 네개 보내야함 */
        $(".radioCon").on('click', function(){
        	var index = $(".radioCon").index(this);
        	var sort = $('#sortVal').val();
        	var filter = $('input[type="radio"]').eq(index).val();
        	sortFilter(sort, filter);
        });
        
        $('.sort-options li').on('click', function(){
        	var index = $('.sort-options li').index(this);
        	var filter;
        	$('input[type="radio"]').each(function(){
        		if($(this).is(":checked")){
        			filter = $(this).val();
        		}
        	});
        	
        	var sort;
        	if(index == 0){
        		sort = "featured";
        	}else if(index == 1){
        		sort = "price-asc";
        	}else{
        		sort = "popular";
        	}
        	
        	sortFilter(sort, filter);
        });
        
        function sortFilter(sort, filter){
			location.href="/testt/searchcourses.ed?page=<%= currentPage %>&keyword=<%= keyword %>&sort="+sort+"&priceRange="+filter;
        }
    </script>
</body>
</html>