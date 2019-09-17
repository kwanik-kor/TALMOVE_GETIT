<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>새강좌</title>
    <link type="text/css" rel="stylesheet" href="css/createCommon.css">
    <link type="text/css" rel="stylesheet" href="css/createLectureName.css">
    <script type="text/javascript" src="../resorces/jquery-3.4.1.min.js"></script>
</head>

<body>
    <section id="left-top">
        <div>
            <span>장관익</span>
            님의 새로운 수업
        </div>
        <span>당신의 재능을 나눠보세요</span>
    </section>
    <section id="center">
        <div id="center-box">
            <div>
                <span>수업에 사용될 강의명을 입력해 주세요.<br></span>
            </div>
            <span>-강의의 성격을 나타낼 이름을 적어주세요.<br></span>
            <span>-강의 공개 전, 변경 가능합니다.<br></span>
            <div id="input-zone">
                <input type="text" placeholder=" : 1~30 글자,특수문자 사용가능">
                <button id="next-btn" type="submit" onclick="location.href='createLectureCategory.jsp'">다음으로</button>
            </div>
        </div>
    </section>
</body>

</html>