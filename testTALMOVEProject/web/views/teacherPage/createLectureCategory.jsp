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
    <link type="text/css" rel="stylesheet" href="css/createLectureCategory.css">

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
            <div id="category">
                <div class="choice-category">
                    <select name="bank" style="text-align: center;">
                        <option value='' selected>카테고리</option>
                        <option value="">카테고리</option>
                    </select>
                </div>
                <div class="choice-category">
                    <select name="bank" style="text-align: center;">
                        <option value='' selected>카테고리</option>
                        <option value="">카테고리</option>
                    </select>
                </div>
            </div>
            <button id="next-btn" type="submit" onclick="location.href='createLectureTag.jsp'">다음으로</button>
            <div id="auto-height"></div>
        </div>
    </section>
<<<<<<< HEAD
=======
    <%@ include file="../common/footer.jsp" %>
>>>>>>> master
</body>

</html>