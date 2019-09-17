<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>새강좌</title>
    <link type="text/css" rel="stylesheet" href="../resorces/css/createCommon.css">
    <link type="text/css" rel="stylesheet" href="../resorces/css/createLectureIntroduce.css">
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
                <span>설정된 강좌명</span>은 어떤 수업인가요?
            </div>
            <span>-간단한 글귀로 강좌를 표현해 주세요!.<br></span>
            <span>-해당 내용은  강좌를 검색하는 수강생들에게  나타납니다<br></span>
            <div id="input-zone">
               <textarea cols="40" rows="3" placeholder="- 해당 내용은  강좌를 검색하는 수강생들에게  나타납니다."></textarea>
                <button id="next-btn" type="submit" onclick="location.href='editLecture.jsp'">다음으로</button>
            </div>
        </div>
    </section>
</body>

</html>