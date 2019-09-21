<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="course.model.vo.Course" %>
<%
	Course course = (Course)request.getAttribute("course");
%>
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
    <link href="css/editLecture.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
    <meta charset="UTF-8">
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>

    <link rel="stylesheet" href="../resorces/src/tuieditor/markdown.css">
    <script src="https://cdn.ckeditor.com/ckeditor5/12.4.0/classic/ckeditor.js"></script>
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
    <link type="text/css" rel="stylesheet" href="css/dist/dropzone.css">
    <script src="css/dist/dropzone.js"></script>
    <title>강사</title>

</head>

<body>
    <%@ include file="../common/gnb.jsp" %>
    <section id="outline">
        <div id="body_left">
            <div id="name_zone">
                <span>장관익</span>님의 수업
            </div>
            <div id="list">
                <div id="info_zone">
                    <div>
                        <span>생성된 강좌명</span>
                    </div>
                    <div onclick="#">
                        강좌 소개
                    </div>
                </div>
                <!--#1. 섹션 추가-->
                <div class="sect_zone">
                    <div class="sect_name" onclick="#">
                        <span>첫번째목차 열세글자까지</span>
                        <div>
                            <button class="modi-btn"><i class="fas fa-times"></i></button>
                            <button class="modi-btn"><i class="fa fa-pen"></i></button>
                        </div>
                    </div>
                    <ui>
                        <!--#2. 클래스추가-->
                        <li onclick="#">
                            <span>1번강의 열여섯글자까지가능</span>
                            <div>
                                <button class="modi-btn"><i class="fas fa-times"></i></button>
                                <button class="modi-btn"><i class="fa fa-pen"></i></button>
                            </div>
                        </li>
                        <!--#2-->
                        <li onclick="#">
                            <span>2번강의 열여섯글자까지가능</span>
                            <div>
                                <button class="modi-btn"><i class="fas fa-times"></i></button>
                                <button class="modi-btn"><i class="fa fa-pen"></i></button>
                            </div>
                        </li>
                    </ui>
                    <div class="create_nclass" onclick="#">
                        새 수업
                    </div>
                </div>
                <!--#1-->
                <!--#1. 섹션 추가-->
                <div class="sect_zone">
                    <div class="sect_name" onclick="#">
                        <span>첫번째목차 열세글자까지</span>
                        <div>
                            <button class="modi-btn"><i class="fas fa-times"></i></button>
                            <button class="modi-btn"><i class="fa fa-pen"></i></button>
                        </div>
                    </div>
                    <ui>
                        <!--#2. 클래스추가-->
                        <li onclick="#">
                            <span>1번강의 열여섯글자까지가능</span>
                            <div>
                                <button class="modi-btn"><i class="fas fa-times"></i></button>
                                <button class="modi-btn"><i class="fa fa-pen"></i></button>
                            </div>
                        </li>
                        <!--#2-->
                        <li onclick="#">
                            <span>2번강의 열여섯글자까지가능</span>
                            <div>
                                <button class="modi-btn"><i class="fas fa-times"></i></button>
                                <button class="modi-btn"><i class="fa fa-pen"></i></button>
                            </div>
                        </li>
                    </ui>
                    <div class="create_nclass" onclick="#">
                        새 수업
                    </div>
                </div>
                <!--#1-->

                <div class="create_nsect" onclick="#">
                    새 섹션
                </div>
            </div>
        </div>

        <div id="body_right">
            <div id="blank_zone">
                강의 편집
            </div>
            <div>
                <div name="content" id="editor">WELCOME TO TALMOVE !</div>
            </div>
            <div id="document-zone">
                <span>첨부파일</span>
                <form action="/file-upload" class="dropzone">
                    <div class="fallback">
                        <input name="file" type="file" multiple />
                    </div>
                </form>
            </div>
            <div id="page-save">
                <button>SAVE</button>
            </div>
        </div>

    </section>
    <div style="clear: both; height: 30px"></div>
    <%@ include file="../common/footer.jsp" %>
</body>
<script>
    ClassicEditor
        .create(document.querySelector('#editor'))
        .then(editor => {
            console.log(editor);
        })
        .catch(error => {
            console.error(error);
        });
</script>

</html>