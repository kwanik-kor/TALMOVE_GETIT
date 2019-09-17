<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>새강좌_카테고리</title>
    <link type="text/css" rel="stylesheet" href="../resorces/css/createCommon.css">
    <link type="text/css" rel="stylesheet" href="../resorces/css/createLectureCategory.css">

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
</body>

</html>