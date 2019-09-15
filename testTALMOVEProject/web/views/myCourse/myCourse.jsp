<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="user.model.vo.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
<link rel="stylesheet" href="/testt/resources/css/common/footer.css">
<link rel="sytlesheet" href="/testt/resources/css/style.css">
<link rel="stylesheet" href="/testt/resources/css/queries.css">
<link rel="stylesheet" href="/testt/resources/js/main.js">

<link href="https://fonts.googleapis.com/css?family=Lato&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="/testt/vendors/css/bootstrap.min.css">
<link rel="stylesheet" href="css/myCourse.css">
<script src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
<script src="/testt/vendors/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/08d0951667.js"></script>

<title>내강좌</title>
</head>
<body>
	<%@ include file="../common/gnb.jsp"%>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-7">강의 듣기</h1>
			<h2 class="display-7">내 강좌</h2>
		</div>
	</div>

	<div class="container">
		<!-- 첫째줄4개 -->
		<div class="row">
			<div class="col-sm-6 col-md-4 col-lg-3 mt-4">
				<div class="card">
					<a href="/testt/views/coursePlay/coursePlay.jsp">
						<img class="card-img-top"src="https://picsum.photos/200/150/?random">
					</a>
					<div class="card-block">
						<a href="/testt/views/coursePlay/coursePlay.jsp">
							<h4 class="card-title">자바 java 8 프로그래밍 중고급 배우기[2단계] 강좌</h4>
						</a>
						<div class="meta">
							<span id="name">장관익</span>
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
			<div class="col-sm-6 col-md-4 col-lg-3 mt-4">
				<div class="card">
					<a href="/testt/views/coursePlay/coursePlay.jsp">
						<img class="card-img-top"src="https://picsum.photos/200/150/?random">
					</a>
					<div class="card-block">
						<a href="/testt/views/coursePlay/coursePlay.jsp">
							<h4 class="card-title">자바 java 8 프로그래밍 중고급 배우기[2단계] 강좌</h4>
						</a>
						<div class="meta">
							<span id="name">장관익</span>
						</div>
					</div>
					<div class="card-footer bg-white">
						<div class="progress" style="height: 10px;"">
							<div class=" progress-bar" role="progressbar" style="width: 40%;"
								aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
							</div>
						</div>
						<div class='small course-progress-percentage'>
							<span class='percentage'>40%</span> 완료 <span
								class='float-right rating'>★★★★★</span>
						</div>
						<div class="meta" id="open-review-box" style="text-align: right;"
							data-toggle="modal" data-target="#exampleModal">
							<a href="#">등급 남기기</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-md-4 col-lg-3 mt-4">
				<div class="card">
					<a href="/testt/views/coursePlay/coursePlay.jsp">
						<img class="card-img-top"src="https://picsum.photos/200/150/?random">
					</a>
					<div class="card-block">
						<a href="/testt/views/coursePlay/coursePlay.jsp">
							<h4 class="card-title">자바 java 8 프로그래밍 중고급 배우기[2단계] 강좌</h4>
						</a>
						<div class="meta">
							<span id="name">장관익</span>
						</div>
					</div>
					<div class="card-footer bg-white">
						<div class="progress" style="height: 10px;"">
							<div class=" progress-bar" role="progressbar" style="width: 40%;"
								aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
							</div>
						</div>
						<div class='small course-progress-percentage'>
							<span class='percentage'>40%</span> 완료 <span
								class='float-right rating'>★★★★★</span>
						</div>
						<div class="meta" id="open-review-box" style="text-align: right;"
							data-toggle="modal" data-target="#exampleModal">
							<a href="#">등급 남기기</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-md-4 col-lg-3 mt-4">
				<div class="card">
					<a href="/testt/views/coursePlay/coursePlay.jsp">
						<img class="card-img-top"src="https://picsum.photos/200/150/?random">
					</a>
					<div class="card-block">
						<a href="/testt/views/coursePlay/coursePlay.jsp">
							<h4 class="card-title">자바 java 8 프로그래밍 중고급 배우기[2단계] 강좌</h4>
						</a>
						<div class="meta">
							<span id="name">장관익</span>
						</div>
					</div>
					<div class="card-footer bg-white">
						<div class="progress" style="height: 10px;"">
							<div class=" progress-bar" role="progressbar" style="width: 40%;"
								aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
							</div>
						</div>
						<div class='small course-progress-percentage'>
							<span class='percentage'>40%</span> 완료 <span
								class='float-right rating'>★★★★★</span>
						</div>
						<div class="meta" id="open-review-box" style="text-align: right;"
							data-toggle="modal" data-target="#exampleModal">
							<a href="#">등급 남기기</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /첫쨰줄 4개 -->
	
		<!-- 둘쨰줄 4개 -->
		<div class="row mb-5">
			<div class="col-sm-6 col-md-4 col-lg-3 mt-4">
				<div class="card">
					<a href="/testt/views/coursePlay/coursePlay.jsp">
						<img class="card-img-top"src="https://picsum.photos/200/150/?random">
					</a>
					<div class="card-block">
						<a href="/testt/views/coursePlay/coursePlay.jsp">
							<h4 class="card-title">자바 java 8 프로그래밍 중고급 배우기[2단계] 강좌</h4>
						</a>
						<div class="meta">
							<span id="name">장관익</span>
						</div>
					</div>
					<div class="card-footer bg-white">
						<div class="progress" style="height: 10px;"">
							<div class=" progress-bar" role="progressbar" style="width: 40%;"
								aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
							</div>
						</div>
						<div class='small course-progress-percentage'>
							<span class='percentage'>40%</span> 완료 <span
								class='float-right rating'>★★★★★</span>
						</div>
						<div class="meta" id="open-review-box" style="text-align: right;"
							data-toggle="modal" data-target="#exampleModal">
							<a href="#">등급 남기기</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-md-4 col-lg-3 mt-4">
				<div class="card">
					<a href="/testt/views/coursePlay/coursePlay.jsp">
						<img class="card-img-top"src="https://picsum.photos/200/150/?random">
					</a>
					<div class="card-block">
						<a href="/testt/views/coursePlay/coursePlay.jsp">
							<h4 class="card-title">자바 java 8 프로그래밍 중고급 배우기[2단계] 강좌</h4>
						</a>
						<div class="meta">
							<span id="name">장관익</span>
						</div>
					</div>
					<div class="card-footer bg-white">
						<div class="progress" style="height: 10px;"">
							<div class=" progress-bar" role="progressbar" style="width: 40%;"
								aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
							</div>
						</div>
						<div class='small course-progress-percentage'>
							<span class='percentage'>40%</span> 완료 <span
								class='float-right rating'>★★★★★</span>
						</div>
						<div class="meta" id="open-review-box" style="text-align: right;"
							data-toggle="modal" data-target="#exampleModal">
							<a href="#">등급 남기기</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-md-4 col-lg-3 mt-4">
				<div class="card">
					<a href="/testt/views/coursePlay/coursePlay.jsp">
						<img class="card-img-top"src="https://picsum.photos/200/150/?random">
					</a>
					<div class="card-block">
						<a href="/testt/views/coursePlay/coursePlay.jsp">
							<h4 class="card-title">자바 java 8 프로그래밍 중고급 배우기[2단계] 강좌</h4>
						</a>
						<div class="meta">
							<span id="name">장관익</span>
						</div>
					</div>
					<div class="card-footer bg-white">
						<div class="progress" style="height: 10px;"">
							<div class=" progress-bar" role="progressbar" style="width: 40%;"
								aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">
							</div>
						</div>
						<div class='small course-progress-percentage'>
							<span class='percentage'>40%</span> 완료 <span
								class='float-right rating'>★★★★★</span>
						</div>
						<div class="meta" id="open-review-box" style="text-align: right;"
							data-toggle="modal" data-target="#exampleModal">
							<a href="#">등급 남기기</a>
						</div>
					</div>
				</div>
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

	<%@ include file="../common/footer.jsp"%>
	<script type="text/javascript">
		$(function() {
			$('#example').barrating({
				theme : 'css-stars'
			});
		});
	</script>


</body>
</html>