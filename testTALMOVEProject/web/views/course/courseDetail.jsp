<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="course.model.vo.Course, java.util.ArrayList, section.model.vo.Section, lecture.model.vo.Lecture"%>
<%
	ArrayList<Course> list = ((ArrayList<Course>)request.getAttribute("list"));
	int studentCount = ((Integer)request.getAttribute("studentCount"));
	int reviewCount = ((Integer)request.getAttribute("reviewCount"));
	double reviewPoint = ((Double)request.getAttribute("reviewPoint"));
	int videoCount = ((Integer)request.getAttribute("videoCount"));
	int fileCount = ((Integer)request.getAttribute("fileCount"));
	ArrayList<Section> slist = ((ArrayList<Section>)request.getAttribute("slist"));
	ArrayList<Lecture> llist = ((ArrayList<Lecture>)request.getAttribute("llist"));
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
				<img src="/testt/views/course/img/관익.png">
				<p class="tp"><span class="boldfont">4.6</span> 강사평점</p>
				<p class="tp"><span class="boldfont">1427</span> 개의 리뷰</p>
				<p class="tp"><span class="boldfont">2,000,000</span> 명의 수강생</p>
				<p class="tp"><span class="boldfont">3</span> 강좌</p>
			</div>
			<div id="inforight">
				<p id="tname">장관익</p>
				<p id="gradu">한국외대 졸업<br>
					KH정보교육원 수료예정</p>
				<p id="tco">장관익 강사는 한국외대에서 프론트앤드를 접하며 프로그래밍에입문하였다.<br>
				KH정보교육원에서 체계적인 교육을 받은 후 현재
				TALMOVE의 프로그래밍<br>강사로 활발히 활동중이다.</p>
			</div>
		</div>
	
		<div id="review" class="clearfix">
			<p id="rtitle">강좌 리뷰</p>
			<div class="clearfix" >
				<img src="/testt/views/course/img/제목 없음.jpg">
				<div class="clearfix" id="talkbubble">
					<div class="clearfix" id="rco">
						<p class="rname">황지우</p><p class="rday">08.30</p>
						<p class="rstar">★★★★★</p>
						<p class="rre">이 강의를 듣고 네이버에 취업되었습니다
						정말 감사합니다</p>
					</div>
				</div>
			</div>
			<br>
			<div>
				<img src="/testt/views/course/img/제목 없음.jpg">
				<div class="clearfix" id="talkbubble">
					<div class="clearfix" id="rco">
						<p class="rname">박건우</p><p class="rday">08.01</p>
						<p class="rstar">★★★★★</p>
						<p class="rre">이 강의를 듣고 구글에 취업되고 말았습니다 감사합니다</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</section>
<br><br><br><br><br><br><br><br><br><br><br><br><br>
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

/* $.ajax({
    url: "coursedetail",
    type: "get",
    dataType: "json",
    success: function(data){
       console.log("btop3 request success : " 
             + data);
       //객체를 문자열로 변환 처리함
       var jsonStr = JSON.stringify(data);
       //문자열을 배열 객체로 바꿈
       var json = JSON.parse(jsonStr);
       
       var values = "";
       for(var i in json.list){
             values += "<tr><td>" + json.list[i].bnum + 
                   "</td><td><a href='bdetail?bnum=" 
                   + json.list[i].bnum + "'>" + 
                   decodeURIComponent(json.list[i].btitle).replace(/\+/gi, " ")
                   + "</a></td><td>" + json.list[i].rcount
                   + "</td></tr>";
       } //for in
       
       //테이블에 추가
       $("#toplist").html($("#toplist").html() + values);
       
    },
    error: function(jqXHR, textStatus, errorThrown){
       console.log("error : " + jqXHR + ", " + 
             textStatus + ", " + errorThrown);
    }
 });  //ajax btop3 */


</script>
</body>
</html>
