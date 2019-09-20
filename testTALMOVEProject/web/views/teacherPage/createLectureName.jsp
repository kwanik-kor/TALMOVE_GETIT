<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teacher.model.vo.Teacher" %>
<%
	Teacher loginTeacher = (Teacher)session.getAttribute("loginTeacher");
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
    <link type="text/css" rel="stylesheet" href="css/createLectureName.css">
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
                <span>수업에 사용될 강좌명을 입력해 주세요.<br></span>
            </div>
            <span>-강의의 성격을 나타낼 이름을 적어주세요.<br></span>
            <span>-강의 공개 전, 변경 가능합니다.<br></span>
            <div id="input-zone">
                <input  id="lectureName" type="text" maxlength="30" placeholder=" : 1~30 글자,특수문자 사용가능">
                <button id="next-btn" type="submit">다음으로</button>
            </div>
        </div>
    </section>
    <%@ include file="../common/footer.jsp" %>
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
    	$('#next-btn').on('click', function(){
    		var lectureName = $('#lectureName').val();
    		if(lectureName.length == 0){
    			alert('강좌명을 입력해주세요');
    		}else{
    			location.href="createLectureCategory.jsp?lectureName="+lectureName;
    		}
    	});
    </script>
</body>

</html>