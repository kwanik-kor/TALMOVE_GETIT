<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link type="text/css" rel="stylesheet" href="css/teacherManageLecture.css">
</head>

<body>
    <%@ include file="../common/gnb.jsp" %>
    <section class="section-top">
        <div class="row" id="pannel">
            <div id="pfpreview">
                <img class="pfimg" src="../../resources/img/customer-1.jpg">
            </div>
            <h2 id="teacher-name"><span>장관익</span> 선생님 정보</h2>
        </div>
    </section>
    <section class="section-middle clearfix">
        <div class="left-side">
            <ul class="tmenu">
                <li><a href="teacherPageDetail.jsp">강사정보</a></li>
                <li><a class="active-menu" href="teacherManageLecture.jsp">강좌관리</a></li>
                <li><a href="teacherReferenceData.jsp">수강생정보</a></li>
                <li><a href="teacherIncomeDetail.jsp">수익내역</a></li>
                <li><a href="teacherComment.jsp">댓글</a></li>
            </ul>
        </div>
        <div class="right-side">
            <h2>강좌관리</h2>
            <div class="right-top">
                <form action="">
                    <div class="block">
                        <div class="block-img"></div>
                        <div class="block-text">
                            <div style="width: inherit; margin-left: 10px;">
                                <div style="float: right">
                                    <button class="detailbtn" onclick="location.href ='lectureDetail.jsp'">관리하기</button><br style="clear: right">
                                    <button class="detailbtn">강좌편집</button>
                                </div>
                                <p style="text-align: center"> 지옥에서 온 GIT</p><br>
                                IT > 프로그래밍<br>
                                ★★★★★<br>
                                강좌 오픈
                            </div>
                        </div>
                        <br style="clear: left">
                    </div>
                    
                    <div class="block">
                        <div class="block-img"></div>
                        <div class="divide" text-align: center>
                            <label for="make-newlecture"></label>
                            <a id="make-newlecture" href="createLectureName.jsp">새강좌</a>
                        </div>
                        <br style="clear: left">
                    </div>
                </form>
            </div>
        </div>
    </section>
    <%@ include file="../common/footer.jsp" %>
</body>

</html>