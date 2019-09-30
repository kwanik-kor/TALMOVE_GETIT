<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String category = ((String)request.getAttribute("category"));
	String categoryUpper = ((String)request.getAttribute("categoryUpper"));
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
	<link href="/testt/views/category/css/noCourseCategory.css" rel="stylesheet">
	<link rel="stylesheet" href="/testt/resources/css/style.css">
    <link rel="stylesheet" href="/testt/resources/css/common/footer.css">
    <link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
    <link rel="stylesheet" href="/testt/resources/css/queries.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
    <link rel="shortcut icon" type="image/x-icon" href="/testt/resources/img/titlelogo.png">
	<script src="https://kit.fontawesome.com/08d0951667.js"></script>
	<script type="text/javacsript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">

	</script>

</head>
<body>
	<%@ include file="../common/gnb.jsp" %>	
<section>
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
		           <li><a a href="/testt/cupperview?page=1&category=비즈니스">비즈니스</a></li>
		           <li><a href="/testt/pcaupview?page=1&category=프로그래밍">프로그래밍</a></li>
		       </ul>
		       <li><a href="/testt/ccourse?page=1&category=커뮤니케이션">커뮤니케이션</a></li>
		       <li><a href="/testt/ccourse?page=1&category=경영">경영</a></li>
		       <li><a href="/testt/ccourse?page=1&category=판매">판매</a></li>
		       <li><a href="/testt/ccourse?page=1&category=전략">전략</a></li>
		       <li><a href="/testt/ccourse?page=1&category=운영">운영</a></li>
		    </ul>
		</div>
</section>
<section>
<div id="noco">
<p id="nocop">빠른 시일 내에 좋은 강좌로<br>
찾아 뵙겠습니다 :)</p>
</div>
</section>

</section>

	<%@ include file="../common/footer.jsp" %>
	
<script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/testt/resources/js/main.js"></script>
<script type="text/javascript">
// html dom 이 다 로딩된 후 실행된다.

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