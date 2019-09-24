<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="user.model.vo.User, message.model.vo.Message, java.util.ArrayList" %>
<%
	User loginUser = (User)session.getAttribute("loginUser");
/* 	Message message = (Message)session.getAttribute("message"); */
	//forwarding 된 request 객체에 저장한 정보 꺼내기
	ArrayList<Message> msglist = (ArrayList<Message>)request.getAttribute("list");		
%>	


	
<!DOCTYPE html>
<html>
<head>
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
	href="/testt/views/mypage/css/MessageListView.css">
<title>탈무브 | 마이페이지</title>
</head>

<body>
	<%-- <%@ include file="../common/gnb.jsp"%> --%>

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
			<h2>
				<p id="allMessage">모든메시지</p>
			</h2>
			<!--      <p id="allMessage">모든메시지</p> -->
			<!--                      <hr style="border:1.5px solid lightgray;"> -->
			<div id="messagediv">
				<div id="searchForm">
					<select>
						<option>최근 메시지</option>
						<option>읽지 않은 메시지</option>
					</select>
					<div id="searchInput">
						<input type="text" placeholder="검색"> <input type="submit"
							value="검색" class="schbtn">
					</div>
				</div>

				<!-- 메시지영역 -->
				<div id="messageArea">
					
					<% for(Message m : msglist){ %>
					<div class="message" onclick="location.href='/testt/views/mypage/MessageTextView.jsp'">
						<!--               <div class="imgBox">
                              <img src="/testt/views/mypage/images/absence_08.jpg">
                           </div> -->
		<%-- 				<% if(m.getMsgRecipient() == loginUser.getUserEmail()) { %> --%>
						<div class="sendMessageBox">
								<form>
								<img class="msgpfimg" src="/testt/views/mypage/images/fileimg/absence_08.jpg<%-- <%= loginUser.getUserOImageName() %> --%>">
								<%-- <input type="hidden" name="sendermail"  value="<%= loginUser.getUserEmail() %>"> --%>
								<!-- 이메일로 가져오기 -->
								</form>
								<form>
								<span	id="personName"><%= m.getMsgSender() %></span> 
								<span id="star">★</span>
								<p id="sendDate"><%= m.getMsgDate() %><!-- 19/09/13 --></p>
								<div class="balloon">
									Hello~~~~~~~~~~~~~~~~~
									<%= m.getMsgContent()%>
								</div>
								<!--                      클릭시 1:1 메시지창으로 -->
								<p id="count"><!-- 3 --><%= m.getMsgReadCount()%></p>
								</form>
							
						</div>
<%-- 						<% } %>	 --%>

					</div>
					<% } %>	
					<!-- 
					<div class="message">
					
						              <div class="imgBox">
                              <img src="/testt/views/mypage/images/absence_08.jpg">
                           </div>

						<div class="sendMessageBox">
							<img src="/testt/views/mypage/images/absence_08.jpg"> 
							<span	id="personName">Chris Haroun</span> 
							<span id="star">★</span>
							<p id="sendDate">19/09/13</p>
							<div class="balloon"
								onclick="location.href='/testt/views/mypage/MessageTextView.jsp'">
								Hello~~~~~~~~~~~~~~~~~</div>
							                     클릭시 1:1 메시지창으로
							<p id="count">3</p>
						</div>

					</div>

					<div class="message">
						              <div class="imgBox">
                              <img src="/testt/views/mypage/images/absence_08.jpg">
                           </div>

						<div class="sendMessageBox">
							<img src="/testt/views/mypage/images/absence_08.jpg"> <span
								id="personName">Chris Haroun</span> <span id="star">★</span>
							<p id="sendDate">19/09/13</p>
							<div class="balloon"
								onclick="location.href='/testt/views/mypage/MessageTextView.jsp'">
								Hello~~~~~~~~~~~~~~~~~</div>
							                     클릭시 1:1 메시지창으로
							<p id="count">3</p>
						</div>

					</div>

					<div class="message">
						              <div class="imgBox">
                              <img src="/testt/views/mypage/images/absence_08.jpg">
                           </div>

						<div class="sendMessageBox">
							<img src="/testt/views/mypage/images/absence_08.jpg"> <span
								id="personName">Chris Haroun</span> <span id="star">★</span>
							<p id="sendDate">19/09/13</p>
							<div class="balloon"
								onclick="location.href='/testt/views/mypage/MessageTextView.jsp'">
								Hello~~~~~~~~~~~~~~~~~</div>
							                     클릭시 1:1 메시지창으로
							<p id="count">3</p>
						</div>

					</div>

					<div class="message">
						              <div class="imgBox">
                              <img src="/testt/views/mypage/images/absence_08.jpg">
                           </div>

						<div class="sendMessageBox">
							<img src="/testt/views/mypage/images/absence_08.jpg"> <span
								id="personName">Chris Haroun</span> <span id="star">★</span>
							<p id="sendDate">19/09/13</p>
							<div class="balloon"
								onclick="location.href='/testt/views/mypage/MessageTextView.jsp'">
								Hello~~~~~~~~~~~~~~~~~</div>
							                     클릭시 1:1 메시지창으로
							<p id="count">3</p>
						</div>

					</div> -->

				</div>

			</div>


		</div>



		</div>
	</section>	
	
			<%@ include file="../common/footer.jsp" %>

	<script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/testt/resources/js/main.js"></script>
	<script type="text/javascript" src="/testt/views/mypage/UserUpdateView.js"></script>
	
		
</body>
</html>