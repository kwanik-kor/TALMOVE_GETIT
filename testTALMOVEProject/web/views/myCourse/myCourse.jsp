<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="course.model.vo.Course, java.util.ArrayList, user.model.vo.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="stylesheet" href="/testt/vendors/css/normalize.css">
<link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
<link rel="stylesheet" href="/testt/vendors/css/bootstrap.css">
<link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/testt/resources/css/style.css">
<link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
<link rel="stylesheet" href="/testt/resources/css/common/footer.css">
<link rel="stylesheet" href="/testt/resources/css/queries.css">
<link rel="stylesheet" href="css/myCourse.css">
<link href="/testt/views/cart/css/cart_pay_common.css" rel="stylesheet" />

<%
	ArrayList<Course> course = (ArrayList<Course>) request.getAttribute("course");
%>



<title>탈무브 | 내 강좌</title>
</head>
<body>
	<%@ include file="../common/gnb.jsp"%>
	
		<section class="cart-pay-top">
        <div class="link-top">
      <a class="link_main" href="/testt/index.jsp"><!-- 홈으로 링크 검-->
        <span>Home</span></a>
      <span>내강좌 </span>
       </div> <span class="link-title">내강좌</span>
   
    </section>


	<div class="container">
		<!-- 첫째줄4개 -->
		
		
	
  		
		<div class="row">
		<% if (course.size() == 0 ) { %>
  		<div class="list_none" style="text-align: center; width:90%; height:400px; margin:auto;"><h2 style="margin-top : 180px;">내 강좌가 비어있습니다.</h2></div> 
  			<% }else{ %> 
		  		<% for(int i = 0; i < course.size(); i++){ 
  			Course myCourse = course.get(i); %>
			<div class="col-sm-6 col-md-4 col-lg-3 mt-4">
				<div class="card">
					<a href="/testt/cplay.ed?courseNo=<%= myCourse.getCourseNo() %>"> <!--  강좌번호로 페이징처리될꺼고  -->
						<img class="card-img-top"src="https://picsum.photos/100/50/?random">
					</a>
					<div class="card-block">
					
							<h6 class="card-title" style="cursor:pointer" onclick='location.href="/testt/cplay.ed?courseNo=<%= myCourse.getCourseNo() %>"'><%= myCourse.getCourseName() %> </h6>
						
						<div class="meta">
							<span id="name"><%= myCourse.getTeacherName() %></span>
						</div>
					</div>
					<div class="card-footer bg-white">
						<div class="progress" style="height: 10px;"">
							<div class=" progress-bar" role="progressbar" style="width: 40%;"
								aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
							</div>
						</div>
						<div class='small course-progress-percentage'>
							<span class='percentage'>40%</span> 
							완료 
							<span class='float-right rating'>★★★★★</span>
						</div>
						<div class="meta" id="open-review-box" style="text-align: right;"
							data-toggle="modal" data-target="#exampleModal">
							<a href="#">등급 남기기</a>
						</div>
					</div>
				
				</div>
				
			</div>
				<% } %>
						<% } %>
					
				</div>
				</div>
			
		<!-- /둘째줄 -->

		<!-- 리뷰 모달 -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">
						<div>
							<h3 align="center">이 과정을 어떻게 평가합니까?</h3>
						</div>
						<select id="example">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
						<textarea></textarea>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /리뷰 모달 -->
	</div>
	<!-- <div style="min-height:400px"></div> -->	
	<%@ include file="../common/footer.jsp"%>
	<script src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
	<script src="/testt/vendors/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/08d0951667.js"></script>
	<script src="/testt/resources/js/main.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#example').barrating({
				theme : 'css-stars'
			});
		});
	</script>


</body>
</html>