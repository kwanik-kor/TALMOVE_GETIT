<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teacher.model.vo.Teacher, course.model.vo.Course, java.util.ArrayList" %>
<%
	Teacher loginTeacher = (Teacher)session.getAttribute("loginTeacher");
	ArrayList<Course> clist = (ArrayList<Course>)request.getAttribute("courseList");
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>탈무브 | 강사페이지</title>
    <meta name="viewport" content="width:device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/testt/vendors/css/normalize.css">
    <link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/testt/resources/css/style.css">
    <link rel="stylesheet" href="/testt/resources/css/common/footer.css">
    <link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
    <link rel="stylesheet" href="/testt/resources/css/queries.css">
    <link type="text/css" rel="stylesheet" href="/testt/views/teacherPage/css/common.css">
    <link type="text/css" rel="stylesheet" href="/testt/views/teacherPage/css/teacherManageLecture.css">
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
</head>

<body>
    <%@ include file="../common/gnb.jsp" %>
    <section class="section-top">
        <div class="row" id="pannel">
            <div id="pfpreview">
                <img class="pfimg" src="/testt/resources/img/customer-1.jpg">
            </div>
            <h2 id="teacher-name"><span>장관익</span> 선생님 정보</h2>
        </div>
    </section>
    <section class="section-middle clearfix">
        <div class="left-side">
            <ul class="tmenu">
                <li><a href="/testt/views/teacherPage/teacherPageDetail.jsp">강사정보</a></li>
                <li><a class="active-menu" href="/testt/gtcourse">강좌관리</a></li>
                <li><a href="/testt/views/teacherPage/teacherReferenceData.jsp">수강생정보</a></li>
                <li><a href="/testt/views/teacherPage/teacherIncomeDetail.jsp">수익내역</a></li>
                <li><a href="/testt/views/teacherPage/teacherComment.jsp">댓글</a></li>
            </ul>
        </div>
        <div class="right-side">
            <div class="clearfix">
                <a href="/testt/views/teacherPage/createLectureName.jsp" class="newCourse">새 강좌</a>
                <h2>강좌관리</h2>
            </div>
            <% for(Course c : clist){ %>
            <div class="right-top">
                <div class="course">
                    <img src="/testt/resources/course_upfiles/<%= c.getThumbnailRfileName() %>">
                    <div class="course-content">
                        <h3><%= c.getCourseName() %></h3>
                        <h4 class="openYN">강좌 공개 여부 : </h4><span><%= c.getOpenYN() %></span><br>
                        <a class="lecAdmin" href="#">강좌편집</a>
                        <a class="lecEdit" href="#">강좌관리</a>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    </section>
    <%@ include file="../common/footer.jsp" %>
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
    	
    	
    </script>
</body>

</html>