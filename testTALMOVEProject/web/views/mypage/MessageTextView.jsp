<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="user.model.vo.User, message.model.vo.Message, java.util.ArrayList" %>
<%
/* 	User loginUser = (User)session.getAttribute("loginUser");  */
/* 	Message message = (Message)session.getAttribute("message"); */
	//forwarding 된 request 객체에 저장한 정보 꺼내기
	ArrayList<Message> msgone = (ArrayList<Message>)request.getAttribute("list");		
%>	
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
	<link rel="shortcut icon" type="image/x-icon" href="/testt/resources/img/titlelogo.png">
	<script type="text/javascript"
		src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/testt/resources/js/main.js"></script>
	<script type="text/javascript"
		src="/testt/views/mypage/UserUpdateView.js"></script>
	<script type="text/javascript" src="/testt/views/mypage/ckeditor/ckeditor.js"></script>


<title>탈무브 | 마이페이지</title>
</head>

<body>
	<%@ include file="../common/gnb.jsp"%>

	<section class="section-top">
		<div class="row" id="pannel">
			<div id="pfpreview">
			
		      	<% if(loginUser.getUserOImageName() != null) { %>       
			    	<img class="pfimg" src="/testt/views/mypage/images/fileimg/<%= loginUser.getUserOImageName() %>">
                <% }else{ %> 
             		<img class="pfimg" src="../../resources/img/customer-1.jpg">
            	<% } %>
				
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
					<li><a href="/testt/views/mypage/MessageNewSendView.jsp">새
							메시지</a></li>
					<li><a class="active-menu"  href="/testt/msglist?uemail=<%= loginUser.getUserEmail()%>">모든 메시지</a></li>
					<li><a href="/testt/msgimp?uemail=<%= loginUser.getUserEmail()%>">중요
							메시지</a></li>
				</ul>
			</ul>
		</div>
		<div class="right-side">
			<h2>모든 메시지(1:1 개인메시지)</h2>
			<p id="msglistbt">
				<a href="/testt/msglist?uemail=<%= loginUser.getUserEmail()%>">목록</a>
			</p>
			
	<!-- !-- 		<div id="msg1search__">
				<input type="text" placeholder="검색어 입력" id="sinput">
				<button id="sbtn">검색</button>
			</div> -->

			<div id="chatplace">
			<% String other = (String)request.getAttribute("other"); %>
			<% String mdate = (String)request.getAttribute("mdate"); %>
			
			<a id="msgonename"></a>
				<div id="chp">
					<img src="/testt/views/mypage/images/absence_08.jpg" id="sendImage2">
					<p id="sendName2"><%= other %></p>
			<!-- 		<button id="starbtn2" onclick="colorchange();">☆</button> -->
					<p id="sendDate2"><%= mdate %></p>
				</div>

				<div id="chatdiv">
					<% for(Message m : msgone) {%>
						<% if (m.getMsgSender() == "jangsy@naver.com") { %>
						<div class="rightms">
							<p class="rightdate"><%= m.getMsgDate() %></p>
							<p class="rightco">
							<%-- <%= m.getMsgSender()%>
							<%= other%> --%>
							<%= m.getMsgContent()%>
						
							</p>
						</div>
						<% } else {%>
						<div class="leftms">
							<p class="leftdate">	<%= m.getMsgDate() %></p>
							<p class="leftco">
							<%-- <%= m.getMsgSender()%>
							<%= other%> --%>
							<%= m.getMsgContent()%>
											</div>			
						<% } %>
					<% } %>
						<div>
							</div>
		
				
				</div>
	
				
				<div id="comment">
					<form action="/testt/msgsend" method="post" >
					
					
						<input type="hidden" name="recipientmail" value="<%=other%>" >

						<input type="hidden" name="sendermail"  value="<%=loginUser.getUserEmail()%>">
						<input type="hidden" name="senderNo"  value="<%=loginUser.getUserNo()%>">
					
						<textarea  rows="5" cols="40" class="form-control" id="m_cotext"  name="msgcontent" ></textarea>
					<!-- 	<script type="text/javascript">
 						CKEDITOR.replace('p_content', {
 							height: 300,
 					
 							});
 						
					</script> -->
				<!-- 					<input type="submit" value="보내기" class="ebtn"  id="subbtn"  id="rbtn" style="margin-right: 3%;"> 
					<input type="reset" value="작성취소" class="ebtn">
					 -->
						<input type="submit" value="보내기" id="subbtn"> <input
							type="reset" value="취소" id="rbtn">
					</form>
				</div>
		
	
		
			</div>

		</div>

	</section>

		<br>
				<br>
						<br>

	<%@ include file="../common/footer.jsp"%>


</body>
</html>