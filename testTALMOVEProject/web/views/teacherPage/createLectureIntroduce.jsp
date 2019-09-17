<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <script type="text/javascript" src="../resorces/jquery-3.4.1.min.js"></script>
</head>

<body>
    <%@ include file="../common/gnb.jsp" %>
    <section id="left-top">
        <div class="tos-top">
            <p><span><%= loginUser.getUserName() %></span> 님의 새로운 수업</p>
            <p>당신의 재능을 나눠보세요!</p>
        </div>
    </section>
    <section id="center">
        <div id="center-box">
            <div>
                <span id="lectureName">설정된 강좌명</span>은 어떤 수업인가요?
            </div>
            <span>-간단한 글귀로 강좌를 표현해 주세요!.<br></span>
            <span>-해당 내용은 강좌를 검색하는 수강생들에게 나타납니다<br></span>
            <div id="input-zone">
                <textarea cols="40" rows="3" placeholder="- 해당 내용은  강좌를 검색하는 수강생들에게  나타납니다."></textarea>
                <button id="next-btn" type="submit" onclick="location.href='editLecture.jsp'">다음으로</button>
            </div>
        </div>
    </section>
    <%@ include file="../common/footer.jsp" %>
</body>

</html>