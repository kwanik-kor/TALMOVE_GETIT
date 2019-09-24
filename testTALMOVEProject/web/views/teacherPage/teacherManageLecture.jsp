<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teacher.model.vo.Teacher, course.model.vo.Course, java.util.ArrayList" %>
<%
	Teacher loginTeacher = (Teacher)session.getAttribute("loginTeacher");
	ArrayList<Course> clist = (ArrayList<Course>)request.getAttribute("courseList");
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
    <link type="text/css" rel="stylesheet" href="/testt/views/teacherPage/css/common.css">
    <link type="text/css" rel="stylesheet" href="/testt/views/teacherPage/css/teacherManageLecture.css">
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
                <li><a href="/testt/views/teacherPage/teacherPageDetail.jsp">강사정보</a></li>
                <li><a class="active-menu" href="/testt/gtcourse">강좌관리</a></li>
                <li><a href="/testt/views/teacherPage/teacherReferenceData.jsp">수강생정보</a></li>
                <li><a href="/testt/views/teacherPage/teacherIncomeDetail.jsp">수익내역</a></li>
                <li><a href="/testt/views/teacherPage/teacherComment.jsp">댓글</a></li>
            </ul>
        </div>
        <div class="right-side">
            <div class="clearfix">
                <a href="/testt/views/teacherPage/createLectureName.jsp" class="newCourse">새 강좌</a>
                <h2>강좌관리</h2>
            </div>
            <% for(Course c : clist){ %>
            <div class="right-top">
                <div class="course">
                    <img src="/testt/resources/course_upfiles/<%= c.getThumbnailRfileName() %>">
                    <div class="course-content">
                        <h3><%= c.getCourseName() %></h3>
                        <h4 class="openYN">강좌 공개 여부 : </h4><span><%= c.getOpenYN() %></span><br>
                        <a class="lecEdit">강좌편집</a>
                        <a class="lecAdmin">강좌관리</a>
                    </div>
                </div>
            </div>
            <div class="modal-course">
                <div class="modal-course-content">
                   	 <div class="course-admin-top">
                        <h3>강좌 정보 수정</h3><button class="closeBtn">&times;</button>
                        <form class="course-info" action="">
                            <label for="">강좌명</label> <input type="text" name="courseName" value="<%= c.getCourseName() %>">
                            <label for="">강좌소개</label> <input type="text" name="description" value="<%= c.getDescription() %>">
                            <label for="">태그</label> <input type="text">
                            <label for="">카테고리</label>
                            <select class="1stC" name="bank" style="text-align: center;" required>
                                <option value="">1차 카테고리</option>
                                <option value="비즈니스">비즈니스</option>
                                <option value="프로그래밍">프로그래밍</option>
                            </select>
                            <select class="2ndC" name="bank" style="text-align: center;" required>
                                <option value="">2차 카테고리</option>
                            </select>
                            <label for="">썸네일</label><input type="file">
                            <img src="/testt/resources/course_upfiles/<%= c.getThumbnailRfileName() %>" alt="thumbnailImage">
                            <button class="saveBtn">저장</button><button class="cancelBtn">취소</button>
                        </form>
                    </div>
                    <div class="course-admin-middle clearfix">
                        <h3>강좌 공개</h3>
                        <form action="/testt/copen" method="post" class="course-price">
                        	<input type="hidden" name="cno" value="<%= c.getCourseNo() %>">
                            <label for="cprice">가격 책정</label><input id="cprice" name="cprice" type="number" value="<%= c.getPrice() %>">
                            <button class="openBtn">강좌 공개하기</button>
                        </form>
                    </div>
                    <div class="course-admin-bottom clearfix">
                        <h3>강좌 삭제</h3>
                        <input type="hidden" class="cothumb" value="<%= c.getThumbnailRfileName() %>">
                        <input type="hidden" class="copenyn" value="<%= c.getOpenYN() %>">
                        <input type="hidden" class="cdelno" name="cno" value="<%= c.getCourseNo() %>">
                        <button class="delBtn">강좌 삭제하기</button>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    </section>
    <%@ include file="../common/footer.jsp" %>
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
	    $('.lecAdmin').on('click', function(){
	    	var index = $('.lecAdmin').index(this);
	        $('.modal-course').eq(index).addClass('is-visible');
	        setTimeout(function(){
	            $('.modal-course').eq(index).addClass('is-open'); 
	        });
	        $('body').css('overflow-y', 'hidden');
	    });
	    $('.closeBtn').on('click', function(){
            var index = $('.closeBtn').index(this);
            $('.modal-course').eq(index).removeClass('is-visible');
            $('.modal-course').eq(index).removeClass('is-open');
            $('body').css('overflow-y', 'scroll');
        });
	    
	    $('.1stC').on('change', function(){
    		if($(this).val() != ""){
    			var cateName = $(this).val();
    			$.ajax({
    				url: "/testt/gcateli.ed",
    				data: {categoryName: cateName},
    				type: "get",
    				dataType: "json",
    				async: false,
    				success: function(data){
    					var jsonStr = JSON.stringify(data);
    					var json = JSON.parse(jsonStr);
    					var values = "<option value=''>2차 카테고리</option>";
    					for(var i in json.clist){
    						values += "<option value='" + json.clist[i].cNo + "'>" + decodeURIComponent(json.clist[i].cName).replace(/\+/gi, " ") + "</option>";
    					}
    					$('.2ndC').html(values);
    				},
    				error: function(jqXHR, textStatus, errorThrown){
    			        console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
    			    }
    			});	
    		}
    	});
	    
	    $('.openBtn').click(function(){
	    	if($('#cprice').val() == 0){
	    		var open = confirm("강의를 무료로 제공하시겠습니까?");
	    		if(!open){
	    			alert("강의 공개를 취소하였습니다.");
	    			return false;
	    		}
	    	}else{
	    		var open = confirm("강의를 정말 공개하시겠습니까?");
	    		if(!open){
	    			alert("강의 공개를 취소하였습니다.");
	    			return false;
	    		}
	    	}
	    });
	    
	    $('.delBtn').click(function(){
	    	var index = $('.delBtn').index(this);
	    	if($('.copenyn').eq(index).val() == 'Y'){
	    		alert("공개된 강좌는 삭제할 수 없습니다.");
	    		return false;
	    	}else{
	    		var del = confirm("정말로 강의를 삭제하시겠습니까? 삭제 후엔 복구되지 않습니다.");
	    		if(del){
	    			var cothumb = $('.cothumb').eq(index).val();
	    			var cno = $('.cdelno').eq(index).val();
	    			location.href="/testt/coursedel?cno="+cno+"&cothumb="+cothumb;
	    		}else{
	    			return false;
	    		}
	    	}
	    });
    </script>
</body>

</html>