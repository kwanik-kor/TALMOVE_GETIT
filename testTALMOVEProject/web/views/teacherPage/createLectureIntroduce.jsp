<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teacher.model.vo.Teacher" %>
<%
	Teacher loginTeacher = (Teacher)session.getAttribute("loginTeacher");
	String lectureName = request.getParameter("lectureName");
	int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
	String tags = request.getParameter("tags");
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
    <link type="text/css" rel="stylesheet" href="css/createLectureIntroduce.css">
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
	            <span>- 간단한 글귀로 강좌를 표현해 주세요!<br></span>
	            <span>- 해당 내용은 강좌를 검색하는 수강생들에게 나타납니다<br></span>
            </div>
            <div id="input-zone">
                <textarea id="lecIntro" maxlength="100" cols="40" rows="3" placeholder="해당 내용은  강좌를 검색하는 수강생들에게  나타납니다.(최대 100자)"></textarea>
                <button id="next-btn">다음으로</button>
            </div>
            <div id="auto-height"></div>
        </div>
    </section>
    <%@ include file="../common/footer.jsp" %>
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
    	$('#next-btn').on('click', function(){
    		var lecIntro = $('#lecIntro').val();
    		if(lecIntro == ""){
    			alert("강좌 소개 내용을 입력해주세요!");
    		}else{
    			location.href="createLectureThumbnail.jsp?lectureName=<%= lectureName %>&categoryNo=<%= categoryNo %>&tags=<%= tags %>&lecIntro="+lecIntro;
    		}
    	});
    </script>
</body>

</html>