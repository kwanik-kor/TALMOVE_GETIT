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
    <link type="text/css" rel="stylesheet" href="/testt/views/teacherPage/css/common.css">
    <link type="text/css" rel="stylesheet" href="/testt/views/teacherPage/css/teacherPageDetail.css">
    <!--ck editor 불러오기 -->
    <script src="https://cdn.ckeditor.com/ckeditor5/12.0.0/classic/ckeditor.js"></script>
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
                <li><a class="active-menu" href="#">강사정보</a></li>
                <li><a href="#">강좌관리</a></li>
                <li><a href="#">수강생정보</a></li>
                <li><a href="#">수익내역</a></li>
                <li><a href="#">댓글</a></li>
            </ul>
        </div>
        <div class="right-side">
            <h2>강사정보</h2>
            <div class="right-top">
                <form action="">
                    <div class="right-top-left clearfix">
                        <img class="pfimg" src="../../resources/img/customer-1.jpg" alt="">
                        <label for="">사진변경<input type="file" id="pffile" name="pffile" accept="image/*"></label>    
                    </div>
                    <div class="right-top-right">
                        <label for="">선생님 이름</label><input type="text" id="tname" name="tname">
                        <label for="">선생님 메일</label><input type="email" id="temail" value="rhksdlr134@naver.com" readonly>
                        <label for="">이력</label><input type="text" placeholder="학력, 경력 등">
                        <button class="addBtn">추가</button>
                    </div>
                    
                    <div id="edit-zone">
                        <textarea id="content"></textarea>
                    </div>
                    <button id="savebtn">저장하기</button>
                </form>
            </div>
        </div>
    </section>
    <%@ include file="../common/footer.jsp" %>
    
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/testt/resources/js/main.js"></script>
	<script type="text/javascript">
	    ClassicEditor.create(document.querySelector('#content'));
        var pf_file;
        $(document).ready(function() {
            $("#pffile").on("change", handleImgFileSelect);
        });

        function handleImgFileSelect(e) {
            var upfiles = e.target.files;
            var upfilesArr = Array.prototype.slice.call(upfiles);

            upfilesArr.forEach(function(f) {
                if (!f.type.match("image.*")) {
                    alert("확장자는 이미지 확장자만 가능합니다.");
                } else {
                    pf_file = f;
                    var reader = new FileReader();
                    reader.onload = function(e) {
                        $(".pfimg").attr("src", e.target.result);
                    }
                    reader.readAsDataURL(f);
                }
            });
        } //handleImgFileSelect
	    </script>
</body>
</html>