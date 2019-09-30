<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teacher.model.vo.Teacher" %>
<%
	Teacher loginTeacher = (Teacher)session.getAttribute("loginTeacher");
	String lectureName = request.getParameter("lectureName");
	int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
	String tags = request.getParameter("tags");
	String lecIntro = request.getParameter("lecIntro");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>탈무브 | 새 강좌</title>
    <meta name="viewport" content="width:device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/testt/vendors/css/normalize.css">
    <link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/testt/resources/css/style.css">
    <link rel="stylesheet" href="/testt/resources/css/common/footer.css">
    <link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
    <link rel="stylesheet" href="/testt/resources/css/queries.css">
    <link type="text/css" rel="stylesheet" href="css/createCommon.css">
    <link type="text/css" rel="stylesheet" href="css/createLectureThumbnail.css">
    <link rel="shortcut icon" type="image/x-icon" href="/testt/resources/img/titlelogo.png">
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
</head>
<body>
    <%@ include file="../common/gnb.jsp" %>
    <section id="left-top">
        <div class="tos-top">
            <p><span><%= loginTeacher.getTeacherName() %></span> 님의 새로운 수업</p>
            <p>당신의 재능을 나눠보세요!</p>
        </div>
    </section>
	<section id="center">
        <div id="center-box">
            <div>
                <span id="lectureName"><%= lectureName %></span>은 어떤 수업인가요?
            </div>
            <div class="sub-text">
	            <span>- 강좌를 나타낼 수 있는 썸네일 이미지를 등록해 주세요!<br></span>
            </div>
            <form action="/testt/courseset.ed" method="post" enctype="multipart/form-data">
            	<input type="hidden" name="lectureName" value="<%= lectureName %>">
            	<input type="hidden" name="categoryNo" value="<%= categoryNo %>">
            	<input type="hidden" name="tags" value="<%= tags %>">
            	<input type="hidden" name="lecIntro" value="<%= lecIntro %>">
            	<input id="lecThumb" name="lecThumb" type="file" accept="image/*">
            	<button id="next-btn">다음으로</button>
            </form>
        </div>
    </section>

	<%@ include file="../common/footer.jsp" %>
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
    	$('#next-btn').on('click', function(){
    		var input = $('#lecThumb').val();
    		if(!input){
    			alert("썸네일 이미지를 등록해주세요!");
    			return false;
    		}
    	});
    </script>
</body>
</html>