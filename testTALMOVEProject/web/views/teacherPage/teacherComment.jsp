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
    <title>탈무브 | 강사페이지</title>
    <meta name="viewport" content="width:device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/testt/vendors/css/normalize.css">
    <link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/testt/resources/css/style.css">
    <link rel="stylesheet" href="/testt/resources/css/common/footer.css">
    <link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
    <link rel="stylesheet" href="/testt/resources/css/queries.css">
    <link type="text/css" rel="stylesheet" href="css/common.css">
    <link type="text/css" rel="stylesheet" href="css/teacherComment.css">
</head>

<body>
    <%@ include file="../common/gnb.jsp" %>
    <section class="section-top">
        <div class="row" id="pannel">
            <div id="pfpreview">
            	<% if(loginTeacher.getTeacherRimageName() != null){ %>
            	<img class="pfimg" src="/testt/resources/tprofile_upfiles/<%= loginTeacher.getTeacherRimageName() %>">
            	<% }else{ %>
                <img class="pfimg" src="../../resources/img/defaultUser.jpg">
                <% } %>
            </div>
            <h2 id="teacher-name"><span><%= loginTeacher.getTeacherName() %></span> 선생님 정보</h2>
        </div>
    </section>
    <section class="section-middle clearfix">
        <div class="left-side">
            <ul class="tmenu">
                <li><a href="teacherPageDetail.jsp">강사정보</a></li>
                <li><a href="/testt/gtcourse">강좌관리</a></li>
                <li><a href="teacherReferenceData.jsp">수강생정보</a></li>
                <li><a href="teacherIncomeDetail.jsp">수익내역</a></li>
                <li><a class="active-menu" href="teacherComment.jsp">댓글</a></li>
            </ul>
        </div>
        <div class="right-side">
            <h2>댓글</h2>
            <div class="block">
                    <table cellspacing="0px">
                        <tr id="first-line">
                            <th></th>
                            <th>사용자</th>
                            <th>강좌</th>
                            <th>댓글</th>
                            <th><button id="alldelete-btn">모두삭제</button></th>
                        </tr>

                        <tr>
                            <td>오늘</td>
                            <td><span>조영찬</span></td>
                            <td>지옥에서 온 GIT</td>
                            <td>visual studio code를 열면 이 에러가 떠요 ㅠㅠ</td>
                            <td><button class="select delete-btn">X</button></td>
                        </tr>
                        <tr>

                            <td>하루전</td>
                            <td><span>이학열</span></td>
                            <td>지옥에서 온 GIT</td>
                            <td>강의 잘 들었습니다~</td>
                            <td><button class="select delete-btn">X</button></td>
                        </tr>

                    </table>
                </div>

            </div>
    </section>
    <%@ include file="../common/footer.jsp" %>
</body>

</html>