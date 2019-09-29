<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="user.model.vo.User, message.model.vo.Message, java.util.ArrayList" %>
<%
	/* User loginUser = (User)session.getAttribute("loginUser"); */
/* 	Message message = (Message)session.getAttribute("message"); */
	//forwarding 된 request 객체에 저장한 정보 꺼내기
	ArrayList<Message> msgimplist = (ArrayList<Message>)request.getAttribute("list");		
%>	
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width:device-width, initial-scale=1.0">

<link rel="stylesheet" href="/testt/vendors/css/normalize.css">
<link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
<link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap"	rel="stylesheet">
<link rel="stylesheet" href="/testt/resources/css/style.css">
<link rel="stylesheet" href="/testt/resources/css/common/footer.css">
<link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
<link rel="stylesheet" href="/testt/resources/css/queries.css">
<link type="text/css" rel="stylesheet"	href="/testt/views/teacherPage/css/common.css">
<link type="text/css" rel="stylesheet"	href="/testt/views/mypage/css/MessageImportantListView.css">
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
					<li><a href="/testt/msglist?uemail=<%= loginUser.getUserEmail()%>">모든 메시지</a></li>
				
					<li><a class="active-menu" href="/testt/msgimp?uemail=<%= loginUser.getUserEmail()%>">중요
							메시지</a></li>
				</ul>
			</ul>
		</div>
		<div class="right-side">
			<h2>
				<p id="allMessage"> 중요메시지</p>
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
	<a id="mlistname"><% for(Message m : msgimplist){ %></a>
					<div class="message">
<!-- msgimplist
 -->
						<div class="sendMessageBox">
								
								<img class="msgpfimg" src="/testt/views/mypage/images/absence_08.jpg<%-- <%= loginUser.getUserOImageName() %> --%>">
								<%-- <input type="hidden" name="sendermail"  value="<%= loginUser.getUserEmail() %>"> --%>
								<!-- 이메일로 가져오기 -->
							
								<span	id="personName"><%= m.getMsgSender() %></span> 
								<input type="hidden" name="msgno" id="msgno" value="<%= m.getMsgNum()%>">
								
								<% if(m.getMsgstar() == 0) { %> 
								<a href="#" class="mstar"  title="<%= m.getMsgNum()%>">☆</a>
								<% } else { %>
								<a href="#" class="mstar" title="<%= m.getMsgNum()%>">★</a>
								<% } %>											
							
								<p id="sendDate"><%= m.getMsgDate() %></p>
	
								<div class="balloon" >
								
									<%= m.getMsgContent()%>       
								</div>
							<p id="count"><%= m.getMsgReadCount()%></p>
						
						</div>

					</div>

					<% } %>	
			
				</div>
			</div>
		</div>
		</div>
		<br>
		<br>
		<br>
	</section>
				<%@ include file="../common/footer.jsp" %>	
	
		</script>


	<script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/testt/resources/js/main.js"></script>
	<script type="text/javascript" src="/testt/views/mypage/UserUpdateView.js"></script>
	
</body>
</html>