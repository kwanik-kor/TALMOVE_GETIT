<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="course.model.vo.Course, java.util.ArrayList, section.model.vo.Section, lecture.model.vo.Lecture, teacher.model.vo.Teacher, review.model.vo.Review"%>
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
	String videoSrc = ((String)request.getAttribute("videoSrc"));
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
	<input type="hidden" id="courseNoName" value="<%= course.getCourseNo() %>">
		<div id="courseintro">
			<p id="coursename"><%= course.getCourseName() %></p>
			<p class="coursecomment"><%= course.getDescription() %></p>
			<p class="coursecomment"><span class="star-prototype"><%= reviewPoint %></span> <%= reviewPoint %> (<%= reviewCount %>명의 평점)  <%= studentCount %>명의 수강생</p>
			<p class="coursecomment">강사 : <%= course.getTeacherName()%></p>
		</div>
		<div id="coursedetail">
			<div id="dvideo">
				<video src="<%= videoSrc %>" controls></video>
			</div>

		<div id="priceinfo">
		<% if(loginUser == null){ %>
       
			<p id="price"><div id="priceContent">￦<%= course.getPrice() %></div></p>
			<button id="login-btn" class="addcartN" onclick="location.href='/testt/views/loginEnroll/login.jsp'">장바구니추가</button><br>
			<button id="login-btn" class="directN" onclick="location.href='/testt/views/loginEnroll/login.jsp'">강의 수강하기</button><br>
			 <% }else if(course.getPrice() == 0){ %>
			 <p id="price"><div id="priceContent">무료</div></p>
			<button id="direct" onclick="location.href='/testt/addonc?userNo=<%=loginUser.getUserNo()%>&courseNo=<%=course.getCourseNo() %>'">강좌 수강하기</button><br>
			<% }else{ %>
			 <p id="price"><div id="priceContent">￦<%= course.getPrice() %></div></p>
			<button id="addcart" onclick="location.href='/testt/addcart?userNo=<%= (loginUser == null ? 0 : loginUser.getUserNo()) %>&courseNo=<%= course.getCourseNo() %>'">장바구니추가</button><br>
			<button id="direct" onclick="location.href='/testt/dclist?userNo=<%=loginUser.getUserNo()%>&courseNo=<%= course.getCourseNo() %>'">강좌 수강하기</button><br>
			<% } %>
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
				<% for(Lecture lecture : llist){ %>
				<div class="hide1">
					<!-- <p class="secmin">(6:46)</p> -->
					<p class="secundo"><%= lecture.getLectureName() %></p><br>
					<hr>
				</div>
				<% } %>
			<hr>	
		</div>
	
		<div id="teacherinfo">
				<p id="title">강사 정보</p>
				<% for(Teacher teacher : tlist){ %>
				<img src="/testt/views/course/img/관익.png">
			<div id="inforight">
				<p id="tname"><%= teacher.getTeacherName() %></p>
				<p id="gradu"><%= teacher.getTeacherCareer() %></p>
				<p id="tco"><%= teacher.getTeacherIntro() %></p>
			</div>
			<% } %>
		</div>
	
		<div id="review" class="clearfix">
			<p id="rtitle">강좌 리뷰</p>
			<div class="clearfix" >
			<% for(Review r : rlist){ %>
				<img src="/testt/views/course/img/제목 없음.jpg">
				<div class="clearfix" id="talkbubble">
					<div class="clearfix" id="rco">
						<p class="rname"><%= r.getReviewUserName() %></p><p class="rday"><%= r.getReviewDate() %></p>
						<p><span class="star-prototype"><%= r.getRating() %></span></p>
						<p class="rre"><%= r.getReviewContent() %></p>
					</div>
				</div>
			<% } %>
			</div>
		</div>
	</div>
	
</section>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<%@ include file="../common/footer.jsp" %>

<script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/testt/resources/js/main.js"></script>

<script type="text/javascript">
	$(function (){
		$("#addcart").click(function(){
			alert("장바구니에 추가되었습니다");
		});
	});



	$(function(){
		$("document").ready(function(){

			var cNo = $("#courseNoName").val()
			
			$.ajax({
				url: "/testt/coverlap",
				data: { courseNo : cNo },
				type: "get",
				dataType: "json",
				success: CartSucceeded,
			    error: AjaxFailed
			});	
					
			function CartSucceeded(data){
		 $("#addcart, #direct").off();
		 $("#addcart").html("장바구니에 추가");
		 $("#direct").html("강좌 수강하기");
			$("#addcart, #direct").click(function(){
				var result = confirm('이미 담겨있는 강좌입니다. 장바구니로 이동하시겠습니까?'); 
				if(result) { 
					
					location.href = '/testt/cartl?userNo=<%= (loginUser == null ? 0 : loginUser.getUserNo()) %>'
				} else { 
					location.href = '/testt/coursedetail?courseNo=' + $('#courseNoName').val();
					}
	
					
				<%-- alert("이미 담겨있는 강좌입니다.");
				 location.href = '/testt/mclist?userNo=<%= (loginUser == null ? 0 : loginUser.getUserNo()) %>'  --%>
					 
					})
					
					
					
			}
		
			
					
			function AjaxFailed(jqXHR, textStatus, errorThrown){
				<%-- 	$("#addcart").html($("#addcart").text() + 
							
					decodeURIComponent(data.cartContent).replace(/\+/gi, " ")
							), 
				 $("#addcart").on("click", function(){
					alert("장바구니에 추가되었습니다");
					 location.href = '/testt/addcart?userNo=<%= (loginUser == null ? 0 : loginUser.getUserNo()) %>&courseNo=' + $('#courseNoName').val();
					})  --%>	 
				}
			
			
			
			
			//$.ajax() 사용
			$.ajax({
				url: "/testt/occheck",
				data: { courseNo : cNo },
				type: "get",
				dataType: "json",
				success: AjaxSucceeded,
			    error: AjaxFailed
			});	
					
			function AjaxSucceeded(data){
			$("#priceContent, #direct").remove();
			$("#price").html("<h6>이미 보유한 강좌입니다.</h6>");
			$("#addcart").off().empty();		
			$("#addcart").html($("#addcart").text() + 
						
			decodeURIComponent(data.cartContent).replace(/\+/gi, " ")
				
			), 	
			$("#addcart").click(function(){
				
				 location.href = '/testt/mclist?userNo=<%= (loginUser == null ? 0 : loginUser.getUserNo()) %>' 
					 
					})	
			}
		
			
					
			function AjaxFailed(jqXHR, textStatus, errorThrown){
				<%-- 	$("#addcart").html($("#addcart").text() + 
							
					decodeURIComponent(data.cartContent).replace(/\+/gi, " ")
							), 
				 $("#addcart").on("click", function(){
					alert("장바구니에 추가되었습니다");
					 location.href = '/testt/addcart?userNo=<%= (loginUser == null ? 0 : loginUser.getUserNo()) %>&courseNo=' + $('#courseNoName').val();
					})  --%>	 
				}
				
		
			
		});  //test4 button click
	});  //document ready
	</script>
	


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
</html>

