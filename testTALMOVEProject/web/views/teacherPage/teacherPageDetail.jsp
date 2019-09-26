<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teacher.model.vo.Teacher" %>
<%
	Teacher loginTeacher = (Teacher)session.getAttribute("loginTeacher");
%>

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
    <link rel="stylesheet" href="/testt/vendors/css/croppie.css">
    <link type="text/css" rel="stylesheet" href="/testt/views/teacherPage/css/common.css">
    <link type="text/css" rel="stylesheet" href="/testt/views/teacherPage/css/teacherPageDetail.css">
    <!--ck editor 불러오기 -->
    <script src="https://cdn.ckeditor.com/ckeditor5/12.0.0/classic/ckeditor.js"></script>
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
</head>

<body>
	<%@ include file="../common/gnb.jsp" %>
	
    <section class="section-top">
        <div class="row" id="pannel">
            <div id="pfpreview">
            	<% if(loginTeacher.getTeacherRimageName() != null){ %>
            	<img class="pfimg" src="/testt/resources/tprofile_upfiles/<%= loginTeacher.getTeacherRimageName() %>">
            	<% }else{ %>
                <img class="pfimg" src="../../resources/img/defaultUser.jpg">
                <% } %>
            </div>
            <h2 id="teacher-name"><span><%= loginTeacher.getTeacherName() %></span> 선생님 정보</h2>
        </div>
    </section>
    
    <section class="section-middle clearfix">
        <div class="left-side">
            <ul class="tmenu">
                <li><a class="active-menu" href="/testt/views/teacherPage/teacherPageDetail.jsp">강사정보</a></li>
                <li><a href="/testt/gtcourse">강좌관리</a></li>
                <li><a href="/testt/views/teacherPage/teacherReferenceData.jsp">수강생정보</a></li>
                <li><a href="/testt/views/teacherPage/teacherIncomeDetail.jsp">수익내역</a></li>
                <li><a href="/testt/views/teacherPage/teacherComment.jsp">댓글</a></li>
            </ul>
        </div>
        <div class="right-side">
            <h2>강사정보</h2>
            <div class="right-top">
                <form action="/testt/teaup.ed" method="post" enctype="multipart/form-data">
                    <div class="right-top-left clearfix">
                    	<% if(loginTeacher.getTeacherRimageName() != null){ %>
                    	<img id="editImg" class="pfimg" src="/testt/resources/tprofile_upfiles/<%= loginTeacher.getTeacherRimageName() %>" alt="">
                    	<% }else{ %>
                        <img id="editImg" class="pfimg" src="../../resources/img/defaultUser.jpg" alt="">
                        <% } %>
                        <input type="hidden">
                        <label for="pffile">사진변경<input type="file" id="pffile" name="pffile" accept="image/*"></label>
                    </div>
                    <div class="right-top-right">
                        <label for="tname">선생님 이름</label>
                        <input type="text" id="tname" name="tname" value="<%= loginTeacher.getTeacherName() %>" name="tname">
                        <label for="temail">선생님 메일</label>
                        <input type="email" id="temail" value="<%= loginUser.getUserEmail() %>" readonly>
                        <label for="tcareer">이력</label>
                        <% if(loginTeacher.getTeacherCareer() != null){ %>
                        <input type="text" id="tcareer" name="tcareer" placeholder="학력, 경력 등" value="<%= loginTeacher.getTeacherCareer() %>">
                        <% }else{ %>
                        <input type="text" id="tcareer" name="tcareer" placeholder="학력, 경력 등">
                        <% } %>
                    </div>
                    
                    <div id="edit-zone">
                        <textarea id="content" name="tintro"><%= loginTeacher.getTeacherIntro() %></textarea>
                    </div>
                    <button id="savebtn">저장하기</button>
                </form>
            </div>
        </div>
    </section>
    <div id="profile-crop" class="modal-crop">
        <div class="modal-crop-content">
            <div class="crop-top clearfix">
                <a class="close-crop">&times;</a>
                <button class="change-img">확인</button>
            </div>
            <div class="crop-main">
            </div>
        </div>
    </div>
    
    <%@ include file="../common/footer.jsp" %>
    
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/testt/resources/js/main.js"></script>
    <script type="text/javascript" src="/testt/vendors/js/croppie.js"></script>
	<script type="text/javascript">
	ClassicEditor.create(document.querySelector('#content'));
    
    $("#pffile").on("change", function(){ readFile(this); });
    
    var modalCrop = document.getElementById("profile-crop");
    var basic = $('.crop-main').croppie({
        viewport: {width: 300, height: 300},
        boundary: {width: 400, height: 500},
        showZoomer: false
    });
    
    function readFile(input){
		if(input.files && input.files[0]){
		    var reader = new FileReader();
		    
		    reader.onload = function(e){
		        $('.modal-crop').addClass('is-visible');
		        setTimeout(function(){
		            $('.modal-crop').addClass('is-open');
		        }, 20);
		        $('.crop-main').croppie('bind', {
		            url: e.target.result 
		        });
		        
		        $('.change-img').on('click', function(){
		            $('.crop-main').croppie('result', {
		                type: 'blob',
		                format: 'jpeg',
		                size: {width: 300, height: 300}
		            }).then(function(resp){
		            	const blobUrl = window.URL.createObjectURL(resp);
		                $('#editImg').attr("src", blobUrl);
		                
		                console.log(resp);
		                
		                $('.modal-crop').removeClass('is-open');
		                $('.modal-crop').removeClass('is-visible');
		            });
		        });
		        
		        $('.close-crop').on('click', function(){
		        	input.value = "";
                    $('.modal-crop').removeClass('is-open');
                    $('.modal-crop').removeClass('is-visible');
		        });
		    }
		    reader.readAsDataURL(input.files[0]);
		}
    }
    
    window.onclick = function(event){
        if(event.target == modalCrop){
            $('.modal-crop').removeClass('is-open');
            $('.modal-crop').removeClass('is-visible');
        }
    }
    </script>
</body>
</html>