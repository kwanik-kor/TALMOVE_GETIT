<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link type="text/css" rel="stylesheet" href="../resorces/css/common.css">
    <link type="text/css" rel="stylesheet" href="../resorces/css/teacherPageDetail.css">
    <script src="https://cdn.ckeditor.com/ckeditor5/12.0.0/classic/ckeditor.js"></script>
    <!--ck editor 불러오기 -->
    <script src="../resorces/jquery-3.4.1.min.js"></script>
</head>

<body>
    <section id="top-background">
        <div id="pannel">
            <div id="pfpreview">
                <img class="pfimg">
            </div>
            <div id="teacher-name"><span>장관익</span>선생님</div>
        </div>
    </section>
    <section id="left-tap">
        <div class="tap" onclick="location.href='teacherPageDetail.jsp'">
            강사정보
        </div>
        <div class="tap" onclick="location.href='teacherManageLecture.jsp'">
            강좌관리
        </div>
        <div class="tap" onclick="location.href='teacherReferenceData.jsp'">
            수강생정보
        </div>
        <div class="tap" onclick="location.href='teacherIncomeDetail.jsp'">
            수익내역
        </div>
        <div class="tap" onclick="location.href='teacherComment.jsp'">
            댓글
        </div>
    </section>
    <section id="right-page">
        <div>
            <p id="pagename">강사정보</p>
        </div>

        <form>
            <section id="right-top">
                <div id="profilephoto-zone">
                    <div>
                        <div id="pfpreview">
                            <img class="pfimg">
                        </div>
                        <label for="pffile">사진변경</label>
                        <input type="file" id="pffile" name="pffile" accept="image/*">
                    </div>
                </div>
                <div id="stars">
                    4.8 /5.0
                </div>
                <div id="update-zone">
                    <div id="tname">
                        선생님 이름
                        <input type="text" placeholder="장관익">
                    </div>
                    <div id="temail">
                        이메일
                        <input type="email" readonly value="wkdrhksdlr94@naver.com">
                    </div>
                    <div id="thistory">
                        이력
                        <input type="text" placeholder="학력, 경력 등">
                        <input type="text" placeholder="수상 이력 등">
                    </div>
                </div>
            </section>

            <div id="edit-zone">
                <textarea id="content"></textarea>
            </div>
            <button id="save-btn" type="submit">저장 하기</button>
        </form>
    </section>
</body>
<script>
    ClassicEditor
        .create(document.querySelector('#content'))
</script>
 <script type="text/javascript">
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
</html>