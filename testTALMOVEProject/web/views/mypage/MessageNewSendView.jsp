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
	href="/testt/views/mypage/css/MessageNewSendView.css">
<link rel="shortcut icon" type="image/x-icon" href="/testt/resources/img/titlelogo.png">
<script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/testt/resources/js/main.js"></script>
<script type="text/javascript" src="/testt/views/mypage/UserUpdateView.js"></script>
<script type="text/javascript" src="/testt/views/mypage/ckeditor/ckeditor.js"></script>

<title>탈무브 | 마이페이지</title>
</head>
<body>
	<%@ include file="../common/gnb.jsp"%>

	<section class="section-top">
		<div class="row" id="pannel">
			<div id="pfpreview">

				<%
					if (loginUser.getUserOImageName() != null) {
				%>
				<img class="pfimg"
					src="/testt/views/mypage/images/fileimg/<%=loginUser.getUserOImageName()%>">
				<%
					} else {
				%>
				<img class="pfimg" src="../../resources/img/customer-1.jpg">
				<%
					}
				%>

			</div>
			<h2 id="teacher-name">
				<span><%=loginUser.getUserName()%></span> 님 마이페이지
			</h2>
		</div>
	</section>
	<section class="section-middle clearfix">
		<div class="left-side">
			<ul class="tmenu">
				<li><a
					href="/testt/views/mypage/UserUpdateView.jsp">프로필</a></li>
				<li id="msgmenu"><a>메시지</a></li>
				<ul class="maghidemenu">
					<li><a class="active-menu" href="/testt/views/mypage/MessageNewSendView.jsp">새
							메시지</a></li>
					<li><a href="/testt/msglist?uemail=<%= loginUser.getUserEmail()%>">모든 메시지</a></li>
					<li><a href="/testt/msgimp?uemail=<%= loginUser.getUserEmail()%>">중요
							메시지</a></li>
				</ul>
			</ul>
		</div>

		<div class="right-side">
			<h2>새 메시지 </h2>
			<!--   <메시지 이메일추가> -->


		 	<div class="right-side-row clearfix"> 
		 	<form action="/testt/msgsend" method="post" >		
				<!-- enctype="multipart/form-data"  --> 	
					<div class="email_list">
					
						<!--  보낸유저번호 송신자 수신자 메시지내용 -->
						<img class="fileimg" src="/testt/views/mypage/images/emailicon3.png" id="eimage" 
						onclick="window.open('/testt/views/mypage/EmailList.jsp','window팝업','width=300, height=300, menubar=no, status=no, toolbar=no');">
						
						<input type="text" placeholder="받는 이메일을 입력하세요" name="recipientmail" id="mrecipient" >

						<input type="hidden" name="sendermail"  value="<%=loginUser.getUserEmail()%>">
						<input type="hidden" name="senderNo"  value="<%=loginUser.getUserNo()%>">
					<%-- 	<input type="hidden" name="senderImg"  value="<%= loginUser.getUserOImageName()%>"> --%>
					
					</div>
					<br clear="both">
					<textarea rows="5" cols="60" class="form-control" id="p_content" name="msgcontent" ></textarea>
					<script type="text/javascript">
 						CKEDITOR.replace('p_content', {
 							height: 300,
 					
 							});
 						
					</script>

					
					<!-- <textarea rows="5" cols="60" name="description" id="description"></textarea> -->
					<br>
					<p id="ptip">팁 : 사이트 & 모바일 앱과 관련된 기술적 문제나 환불에 관한 질문은 지원에
						문의하십시오...</p>
						
					<input type="submit" value="보내기" class="ebtn" style="margin-right: 3%;"> 
					<input type="reset" value="작성취소" class="ebtn">

				</form>
				 </div> 
		</div>

	</section>

	<%@ include file="../common/footer.jsp"%>

</body>
</html>