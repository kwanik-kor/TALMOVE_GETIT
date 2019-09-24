<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teacher.model.vo.Teacher,course.model.vo.Course, lecture.model.vo.Lecture, section.model.vo.Section, java.util.ArrayList, java.sql.Date" %>

<%
    ArrayList<Section> SectionList =  (ArrayList<Section>)request.getAttribute("sectionList");
	String teacherName = (String)request.getAttribute("teacherName");
	String courseName = (String)request.getAttribute("courseName");
	String courseDescription = (String)request.getAttribute("courseDescription");
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>탈무브 | <%= courseName %></title>
    <meta name="viewport" content="width:device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/testt/vendors/css/normalize.css">
    <link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/testt/resources/css/style.css">
    <link rel="stylesheet" href="/testt/resources/css/common/footer.css">
    <link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
    <link rel="stylesheet" href="/testt/resources/css/queries.css">
    <link href="/testt/views/teacherPage/css/editLecture.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
    <meta charset="UTF-8">
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/12.4.0/classic/ckeditor.js"></script>
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
    <link type="text/css" rel="stylesheet" href="/testt/views/teacherPage/css/dist/dropzone.css">
    <script src="/testt/views/teacherPage/css/dist/dropzone.js"></script>
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <title>강사</title>





</head>

<body>
    <%@ include file="../common/gnb.jsp" %>

    <section id="outline">
        <div id="body_left">
            <div id="name_zone">
                <span><%= teacherName %></span>님의 수업
            </div>
            <div id="list">
                <div id="contents">
                    <div id="info_zone">
                        <div>
                            <span><%= courseName %></span>
                        </div>
                        <div id="lectureIntro">
                            <span>강좌 소개</span>
                        </div>
                    </div>

                    <!--
                    <div class="create_nclass">
                        새 수업 생성
                    </div>
                    -->

                </div>
                <div class="create_nsect">
                    새강좌 생성
                </div>
            </div>
        </div>

        <div id="body_right">
            <form>
                <div id="blank_zone">
                    강의 편집
                </div>
                <div>
                    <div name="content" id="editor">
                        <%= courseDescription %>
                    </div>
                </div>
                <div id="document-zone">
                    <span>첨부파일</span>
                    <div class="fallback">
                        <input name="file" type="file" multiple />
                    </div>
                </div>
            </form>
            <div id="page-save">
                <button type="submit">SAVE</button>
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
<script>
    $(document).ready(function() {
        createClass();
        createSection();
        clickon();

    });

    function callcall() {
        transToServ.action = "/testt/pnewc"; //호출명

        transToServ.method = "post"; //POST방식 

        transToServ.submit();

    }
/*
    function callLectureName() {
        $.ajax({
                url: "plload",
                data: {
                    no: $(".sect_name").val()
                },
                type: "get",
                dataType: "json",
                success: function(data) {
                    alert("ajax 성공");
                    console.log("ajax 실행시작");
                    //객체를 문자열로 변환 처리함
                    var jsonStr = JSON.stringify(data);
                    //문자열을 배열 객체로 바꿈
                    var json = JSON.parse(jsonStr);

                    var values = "";
                    for (var i in json.list) {

                        values += '<ul><li><input type="text" placeholder="CLASS NAME" value="d" readOnly><div>button class="del-btn"><i class="fas fa-times"></i></button>"<button class="modi-btn"><i class="fa fa-pen"></i></button><div></li></ul>;';
                        $("#editor").html($("#editor").html() + values());

                    }
                }
            }
        }
    }
*/
    function createClass() {
        $('.create_nclass').click(function() {
            var kt = '<ul><li class="df"> <input type="text" placeholder="CLASS NAME" readOnly>   <div>   <button class="del-btn"><i class="fas fa-times"></i></button>   <button class="modi-btn"><i class="fa fa-pen"></i></button> </div>  </li>   </ul>';
            $(this).prev().append(kt);
            clickon();
            alert($(this).prevAll(".sect_name").attr("value"));
            callcall();
        });
    }

    function createSection() {
        $('.create_nsect').click(function() {
            var kt = '<!--#1. 섹션 추가--><div class="sect_zone"><div class="sect_name"><input type="text" placeholder="SECTION NAME" readOnly><div><button class="del-btn"><i class="fas fa-times"></i></button><button class="modi-btn"><i class="fa fa-pen"></i></button></div></div><!--#2. 클래스추가--><ul><li><input type="text" placeholder="CLASS NAME" readOnly><div><button class="del-btn"><i class="fas fa-times"></i></button><button class="modi-btn"><i class="fa fa-pen"></i></button></div></li><!--#2--></ul><div class="create_nclass">새 수업</div></div><!--#1-->'
            $("#contents").last().append(kt);
            createClass();
            clickon();
        });
    }

    function clickon() {
        $('.modi-btn').click(function() {
            $(this).parent().prev("input").attr("readOnly", false);
            $(this).parent().prev("input").focus();
            $(this).parent().prev("input").attr("readOnly", false).keydown(function() {
                if (event.which == 13) {
                    $(this).attr("readOnly", true);
                };
            });

        });

        $('.del-btn').click(function() {
            if ((this).closest("li")) {
                (this).closest("li").remove();
            } else {
                $(this).parents(".sect_zone").remove();
            }
        });

    }
</script>




</html>