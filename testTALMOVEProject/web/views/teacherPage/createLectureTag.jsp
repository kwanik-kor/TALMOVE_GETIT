<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>새강좌_태그</title>
    <link type="text/css" rel="stylesheet" href="../resorces/css/createCommon.css">
    <link type="text/css" rel="stylesheet" href="../resorces/css/createLectureTag.css">

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
            <span>-수업의 관련 키워드 들을 적어주세요.<br></span>
            <span>-해당 키워드 검색 시 강좌가 추천됩니다.<br></span>
            <div id="tag">
                <input type="text" placeholder=" : 10글자 미만, 15개 태그까지 가능.">
                <button id="next-btn" type="submit" onclick="location.href='createLectureIntroduce.jsp'">다음으로</button>
            </div>
            <div id="plus-tag">
                <div class="tags">TAG</div>
                <div class="tags">기본태그</div>
                <div class="tags">장문태그장문태그</div>
                <div class="tags">TAG</div>
                <div class="tags">TAG</div>
                <div class="tags">장문태그장문태그</div>
                <div class="tags">장문TAG</div>
                <div class="tags">장문태그장문태그</div>
                <div class="tags">TAG태그</div>
                <div class="tags">장문태그장문태그</div>
            </div>
            <div id="auto-height"></div>
        </div>
    </section>
</body>

</html>