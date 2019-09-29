<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="course.model.vo.Course, java.util.ArrayList, section.model.vo.Section, lecture.model.vo.Lecture, teacher.model.vo.Teacher,review.model.vo.Review"%>
<%
	ArrayList<Course> list = ((ArrayList<Course>)request.getAttribute("list"));
	int studentCount = ((Integer)request.getAttribute("studentCount"));
	int reviewCount = ((Integer)request.getAttribute("reviewCount"));
	double reviewPoint = ((Double)request.getAttribute("reviewPoint"));
	int videoCount = ((Integer)request.getAttribute("videoCount"));
	int fileCount = ((Integer)request.getAttribute("fileCount"));
	ArrayList<Section> slist = ((ArrayList<Section>)request.getAttribute("slist"));
	ArrayList<Lecture> llist = ((ArrayList<Lecture>)request.getAttribute("llist"));
	ArrayList<Teacher> tlist = ((ArrayList<Teacher>)request.getAttribute("tlist"));
	ArrayList<Review> rlist = ((ArrayList<Review>)request.getAttribute("rlist"));
%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="icon" href="data:;base64,iVBORw0KGgo=">
	<meta name="viewport" content="width:device-width, initial-scale=1.0">
	<title>탈무브 | </title>
	<link rel="stylesheet" href="/testt/vendors/css/normalize.css">
    <link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
	<link href="/testt/views/course/css/courseDetail.css" rel="stylesheet">
	<link rel="stylesheet" href="/testt/resources/css/style.css">
    <link rel="stylesheet" href="/testt/resources/css/common/footer.css">
    <link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
    <link rel="stylesheet" href="/testt/resources/css/queries.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/08d0951667.js"></script>
	<script type="text/javacsript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">

	</script>

</head>
<body>
	<%@ include file="../common/gnb.jsp" %>
	
	<section class="clearfix">
	<% for(Course course : list){ %>
		<div id="courseintro">
			<p id="coursename"><%= course.getCourseName() %></p>
			<p class="coursecomment"><%= course.getDescription() %></p>
			<p class="coursecomment"><span class="star-prototype"><%= reviewPoint %></span> <%= reviewPoint %> (<%= reviewCount %>명의 평점)  <%= studentCount %>명의 수강생</p>
			<p class="coursecomment">강사 : <%= course.getTeacherName()%></p>
		</div>
		<div id="coursedetail">
			<div id="dvideo">
				<video src="" controls></video>
			</div>

		<div id="priceinfo">
			<p id="price">￦<%= course.getPrice() %></p>
			<button id="addcart"><a href="#">장바구니에 추가</a></button><br>
			<button id="direct"><a href="#">강의 수강하기</a></button><br>
			<img id="videoimage" src="/testt/views/course/img/video.png"><p id="videonum"><%=videoCount %>개의 동영상</p><br>
			<img id="fileimage" src="/testt/views/course/img/file.png"><p id="filenum"><%= fileCount %>개의 자료</p>
		</div>
	
		<div id="comment">
			<p id="pco">배울 내용</p>
			<p id="ulco"><%= course.getDescription() %></p>
		</div>
	<% } %>
	
		<div id="lectureList">
			<p id="lectlist">강의 목차</p>
			<hr><hr>
			<% for(Section section : slist){ %>
			<div id="sec1">
				<p class="secname"><a class="dropdown1"><%= section.getSectionName() %>&nbsp;▼</a></p>
				<hr>
				<% for(Lecture lecture : llist){ %>
				<div class="hide1">
					<p class="secmin">(6:46)</p>
					<p class="secundo"><%= lecture.getLectureName() %></p><br>
					<hr>
				</div>
				<% } %>
			</div>
			<% } %>
			<hr>	
		</div>
	
		<div id="teacherinfo">
			<div id="infoleft">
				<p id="title">강사 정보</p>
				<% for(Teacher teacher : tlist){ %>
				<img src="/testt/views/course/img/관익.png">
			</div>
			<div id="inforight">
				<p id="tname"><%= teacher.getTeacherName() %></p>
				<p id="gradu"><%= teacher.getTeacherCareer() %></p>
				<p id="tco"><%= teacher.getTeacherIntro() %></p>
			</div>
			<% } %>
		</div>
	
		<div id="review" class="clearfix">
			<p id="rtitle">강좌 리뷰</p>
			<% if(rlist.size() > 0){
			for(Review r : rlist){ %>
			<div id="reviewr" class="clearfix" >
				<img src="/testt/views/course/img/제목 없음.jpg">
				<div class="clearfix" id="talkbubble">
					<div class="clearfix" id="rco">
						<p class="rname"><%= r.getReviewUserName() %></p><p class="rday"><%= r.getReviewDate() %></p>
						<p class="rstar"><span class="star-prototype"><%= r.getRating() %></span></p>
						<p class="rre"><%= r.getReviewContent()%></p>
					</div>
				</div>
			</div>
			<% }}else{ %>
			<p id="noreview">등록된 리뷰가 없습니다</p>
			<% } %>
		</div>
	</div>
	
</section>

	<%@ include file="../common/footer.jsp" %>

<script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/testt/resources/js/main.js"></script>
<script type="text/javascript">
// html dom 이 다 로딩된 후 실행된다.

$(document).ready(function(){
    $(".dropdown1").click(function(){
       
        var submenu = $(".hide1");

        if( submenu.is(":visible") ){
            submenu.slideUp();
        }else{
            submenu.slideDown();
        }
    });
});
$(document).ready(function(){
    $(".dropdown2").click(function(){
       
        var submenu = $(".hide2");

        if( submenu.is(":visible") ){
            submenu.slideUp();
        }else{
            submenu.slideDown();
        }
    });
});

$.fn.generateStars = function() {
    return this.each(function(i,e){$(e).html($('<span/>').width($(e).text()*16));});
};

// 숫자 평점을 별로 변환하도록 호출하는 함수
$('.star-prototype').generateStars();

</script>
</body>
</html>
