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
	            <div class="searched-class clearfix">
	                <img src="/testt/resources/course_upfiles/<%= c.getThumbnailRfileName() %>" class="thumbnail">
	                <div class="class-content">
	                    <h3><%= c.getCourseName() %></h3>
	                    <p class="class-description"><%= c.getDescription() %></p>
	                    <p class="class-teacher">장관익</p>
	                    <p class="class-price">&#8361;<%= c.getPrice() %></p>
	                </div>
	            </div>
            <% 
            	} 
            }	
            %>
        </section>
        <section class="section-sortStandard">
            <div class="fixed-area">
                <div class="sortStandard-top">
                    <h3><%= listCount %>개의 검색결과</h3>
                </div>
                <div class="sortStandard-middle">
                    <label>정렬</label><input type="text" id="sort-standard" name="sort" value="탈무브 추천순" readonly><p>▼</p>
                    <div class="sort-option">
                        <ul class="sort-options">
                            <li class="active-option">탈무브 추천순</li>
                            <li>낮은 가격순</li>
                            <li>인기순</li>
                        </ul>
                    </div>
                </div>
                <div class="sortStandard-bottom">
                    <p>가격필터</p>
                    <label class="radioCon" for="filAll">전체<input id="filAll" type="radio"><span class="checkmark"></span></label>
                    <label class="radioCon" for="filFree">무료<input id="filFree" type="radio"><span class="checkmark"></span></label>
                    <label class="radioCon" for="filCost">유료<input id="filCost" type="radio"><span class="checkmark"></span></label>
                </div>
            </div>       
        </section>
        </div>
    </div>
    <%@ include file="../common/footer.jsp" %>
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/testt/resources/js/main.js"></script>
    <script type="text/javascript">
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
        $(function(){
        	$("input[type='radio']").eq(0).attr('checked', true);
        });
        
    </script>
</body>
</html>