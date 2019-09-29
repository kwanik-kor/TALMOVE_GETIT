<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width:device-width, initial-scale=1.0">

<link rel="stylesheet" href="/testt/vendors/css/normalize.css">
<link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/testt/resources/css/style.css">
<link rel="stylesheet" href="/testt/resources/css/common/footer.css">
<link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
<link rel="stylesheet" href="/testt/resources/css/queries.css">
<link type="text/css" rel="stylesheet"
	href="/testt/views/teacherPage/css/common.css">
<link type="text/css" rel="stylesheet"
	href="/testt/views/mypage/css/MessageTextView.css">
<title>탈무브 | 마이페이지</title>
</head>

<body>
	<%@ include file="../common/gnb.jsp"%>

	<section class="section-top">
		<div class="row" id="pannel">
			<div id="pfpreview">
				<img class="pfimg" src="../../resources/img/customer-1.jpg">
			</div>
			<h2 id="teacher-name">
				<span><%=loginUser.getUserName()%></span> 님 마이페이지
			</h2>
		</div>
	</section>
	<section class="section-middle clearfix">
		<div class="left-side">
			<ul class="tmenu">
				<li><a class="active-menu"
					href="/testt/views/mypage/UserUpdateView.jsp">프로필</a></li>
				<li id="msgmenu"><a>메시지</a></li>
				<ul class="maghidemenu">
					<li><a href="/testt/views/mypage/MessageNewSendView.jsp">새
							메시지</a></li>
					<li><a href="/testt/views/mypage/MessageListView.jsp">모든
							메시지</a></li>
					<li><a href="/testt/views/mypage/MessageImportantListView.jsp">중요
							메시지</a></li>
				</ul>
			</ul>
		</div>
		<div class="right-side">
			<h2>모든 메시지(1:1 개인메시지)</h2>
			<p id="msglistbt">
				<a href="/testt/views/mypage/MessageListView.jsp">◀목록</a>
			</p>
			
			<div id="msg1search">
				<input type="text" placeholder="검색어 입력" id="sinput">
				<button id="sbtn">검색</button>
			</div>
<!-- 			<br clear:="both"> -->
			<div id="chatplace">
		
				<div id="chp">
					<img src="/testt/views/mypage/images/absence_08.jpg" id="sendImage2">
					<p id="sendName2">장관익</p>
					<button id="starbtn2" onclick="colorchange();">☆</button>
					<p id="sendDate2">19/09/13</p>
				</div>

				<div id="chatdiv">
					<div class="rightms">
						<p class="rightdate">19/08/02</p>
						<p class="rightco">
							Thank you for signing up to my course!<br> Thanks a lot for
							the supporting!
						</p>
					</div>
					<div class="leftms">
						<p class="leftdate">19/08/02</p>
						<p class="leftco">
							Thank you for signing up to my course!<br> Thanks a lot for
							the supporting!
						</p>
					</div>
					<div class="leftms">
						<p class="leftdate">19/08/10</p>
						<p class="leftco">
							Thank you for signing up to my course!<br> Thanks a lot for
							the supporting!
						</p>
					</div>
					<div class="rightms">
						<p class="rightdate">19/09/13</p>
						<p class="rightco">
							Thank you for signing up to my course!<br> Thanks a lot for
							the supporting!
						</p>
					</div>
				</div>
				
				<div id="comment">
					<form>
						<textarea id="cotext" placeholder="보낼 메시지를 입력하세요"></textarea>
						<input type="submit" value="보내기" id="subbtn"> <input
							type="reset" value="취소" id="rbtn">
					</form>
				</div>
		
			</div>

		</div>

	</section>



	<%@ include file="../common/footer.jsp"%>

	<script type="text/javascript"
		src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/testt/resources/js/main.js"></script>
	<script type="text/javascript"
		src="/testt/views/mypage/UserUpdateView.js"></script>

</body>
</html>