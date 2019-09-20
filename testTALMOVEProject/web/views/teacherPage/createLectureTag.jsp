<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teacher.model.vo.Teacher" %>
<%
	Teacher loginTeacher = (Teacher)session.getAttribute("loginTeacher");
	String lectureName = request.getParameter("lectureName");
	int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
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
    <link type="text/css" rel="stylesheet" href="css/createCommon.css">
    <link type="text/css" rel="stylesheet" href="css/createLectureTag.css">

</head>

<body>
    <%@ include file="../common/gnb.jsp" %>
    <section id="left-top">
        <div class="tos-top">
            <p><span><%= loginTeacher.getTeacherName() %></span> 님의 새로운 수업</p>
            <p>당신의 재능을 나눠보세요!</p>
        </div>
    </section>
    <section id="center">
        <div id="center-box">
            <div>
                <span id="lectureName"><%= lectureName %></span>은(는) 어떤 수업인가요?
            </div>
            <div class="sub-text">
                <span>- 수업의 관련 키워드 들을 적어주세요.<br></span>
                <span>- 해당 키워드 검색 시 강좌가 추천됩니다.<br></span>    
            </div>
            <div id="tag">
                <input id="tag-input" type="text" maxlength="10" placeholder=" : 10글자 미만, 15개 태그까지 가능.">
                <button id="next-btn">다음으로</button>
            </div>
            <div id="plus-tag">
                <!--태그 플러스 영역-->
            </div>
            <div id="auto-height"></div>
        </div>
    </section>
    <%@ include file="../common/footer.jsp" %>
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
    $('#tag-input').keyup(function(){
        if(window.event.keyCode == 13){
            if($(this).val() != ""){
                addTag();
            }
        }
        if(window.event.keyCode == 32){
            if($(this).val() == " "){
                alert("내용을 입력해주세용");
                $(this).val('');
            }else{
                addTag();
            }
        }
    });
    
    function addTag(){
        var tag = "<div class='tags'><p class='tagName'>";
        var tagInput = $('#tag-input').val();
        tag += tagInput + "</p><p class='del-tag' onclick='deleteTag(this);'>&times;</p></div>";
        $('#plus-tag').html($('#plus-tag').html() + tag);
        $('#tag-input').val('');
    }
    
    function deleteTag(del){
        var indexNo = $('.del-tag').index(del);
        $('.tags').eq(indexNo).remove();
    }
    
    $('#next-btn').on('click', function(){
         if($('.tags').length == 0){
             alert("태그를 추가해주세요!");
         }else{
             var tags = "";
             $('.tags').each(function(){
                 var otagname = $(this).children().text();
                 var rtagname = (otagname.substring(0,otagname.length-1)).trim();
                 tags += rtagname +",";
             });
             tags = tags.substring(0, tags.lastIndexOf(","));
             location.href="createLectureIntroduce.jsp?lectureName=<%= lectureName %>&categoryNo=<%= categoryNo %>&tags="+tags;
         }
    });
    </script>
</body>

</html>