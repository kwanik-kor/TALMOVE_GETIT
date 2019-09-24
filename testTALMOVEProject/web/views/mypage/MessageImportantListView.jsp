<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			    	<img class="pfimg" src="/testt/views/mypage/images/fileimg/absence_08.jpg<%= loginUser.getUserOImageName() %>">
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
		<!-- <meta charset="UTF-8">
<title>모든 메세지</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/08d0951667.js"></script>
<link href="/testt/views/mypage/css/MessageListView.css" rel="stylesheet">
<script type="text/javascript" src="/testt/resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<div id="pannel">
      <img class="fileimg" id="pfimg"  src="/testt/views/mypage/images/absence_08.jpg">
        <p id="teacherPage"><span id="tname">장서영</span>님의 마이페이지</p>
    </div>  
   
    <div id="left-tap">
        <ul id="tap">
        <li><a href="/testt/views/mypage/UserUpdateView.jsp">프로필</a></li>
        <li id="msgmenu"><a>메시지</a></li>
           <ul class="maghidemenu">
                <li><a href="/testt/views/mypage/MessageNewSendView.jsp">새 메시지</a></li>
                <li><a href="/testt/views/mypage/MessageListView.jsp">모든 메시지</a></li>
                <li><a href="/testt/views/mypage/MessageImportantListView.jsp">중요 메시지</a></li>
            </ul>
        </ul>          
    </div>
           /사이드바
         
           본문
         

           <div id="right-page"> -->

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

					<div class="message">
						<!--               <div class="imgBox">
                              <img src="/testt/views/mypage/images/absence_08.jpg">
                           </div> -->

						<div class="sendMessageBox">
							<img src="/testt/views/mypage/images/absence_08.jpg"> 
							<span	id="personName">Chris Haroun</span> 
							<span id="star">★</span>
							<p id="sendDate">19/09/13</p>
							<div class="balloon"
								onclick="location.href='/testt/views/mypage/MessageTextView.jsp'">
								Hello~~~~~~~~~~~~~~~~~</div>
							<!--                      클릭시 1:1 메시지창으로 -->
							<p id="count">3</p>
						</div>

					</div>
					<div class="message">
						<!--               <div class="imgBox">
                              <img src="/testt/views/mypage/images/absence_08.jpg">
                           </div> -->

						<div class="sendMessageBox">
							<img src="/testt/views/mypage/images/absence_08.jpg"> <span
								id="personName">Chris Haroun</span> <span id="star">★</span>
							<p id="sendDate">19/09/13</p>
							<div class="balloon"
								onclick="location.href='/testt/views/mypage/MessageTextView.jsp'">
								Hello~~~~~~~~~~~~~~~~~</div>
							<!--                      클릭시 1:1 메시지창으로 -->
							<p id="count">3</p>
						</div>

					</div>

					<div class="message">
						<!--               <div class="imgBox">
                              <img src="/testt/views/mypage/images/absence_08.jpg">
                           </div> -->

						<div class="sendMessageBox">
							<img src="/testt/views/mypage/images/absence_08.jpg"> <span
								id="personName">Chris Haroun</span> <span id="star">★</span>
							<p id="sendDate">19/09/13</p>
							<div class="balloon"
								onclick="location.href='/testt/views/mypage/MessageTextView.jsp'">
								Hello~~~~~~~~~~~~~~~~~</div>
							<!--                      클릭시 1:1 메시지창으로 -->
							<p id="count">3</p>
						</div>

					</div>

			
	<!-- 				<div class="message">
						<div class="imgBox">
							<img src="/testt/views/mypage/images/absence_08.jpg">
						</div>
						<div class="sendMessageBox">
							<span id="personName">Chris Haroun</span> <span id="star">★</span>
							<p id="sendDate">19/09/13</p>
							<div class="balloon"
								onclick="location.href='/testt/views/mypage/MessageTextView.jsp'">
								Hello~~~~~~~~~~~~~~~~~</div>
							<p id="count">3</p>
						</div>
					</div> -->
				</div>

			</div>


		</div>



		</div>
	</section>
				<%@ include file="../common/footer.jsp" %>	
	
		</script>


	<script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/testt/resources/js/main.js"></script>
	<script type="text/javascript" src="/testt/views/mypage/UserUpdateView.js"></script>
	
</body>
</html>