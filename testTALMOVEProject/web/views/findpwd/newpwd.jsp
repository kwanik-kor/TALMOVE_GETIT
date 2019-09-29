<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uemail = (String)request.getAttribute("uemail");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width:device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="/testt/vendors/css/normalize.css">
    <link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/testt/resources/css/style.css">
    <link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
    <link rel="stylesheet" href="/testt/resources/css/common/footer.css">
    <link rel="stylesheet" href="/testt/views/findpwd/findpwd.css">
    <link rel="stylesheet" href="/testt/resources/css/queries.css">
    <link rel="shortcut icon" type="image/x-icon" href="/testt/resources/img/titlelogo.png">
    <title>탈무브 | 비밀번호를 다시 설정해주세요</title>
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
</head>
<body>
	<%@ include file = "../common/gnb.jsp" %>
	<div class="msg-content">
		<div class="msg-box">
			<h3>비밀번호 재설정</h3>
			<p>비밀번호를 다시 입력해주세요</p>
			<form action="/testt/setpwd.ed?uemail=<%= uemail %>" method="post" class="new-pwd">
				<p class="placeholdermsg" id="new-pwd-placeholder">비밀번호</p>
				<input type="password" id="new-pwd" name="upwd" autocomplete=off required>
				<p class="guidemsg" id="new-pwd-focus">6글자 이상, 20글자 미만으로 입력해 주세요</p>
				<p class="placeholdermsg" id="new-pwdchk-placeholder">비밀번호 확인</p>
				<input type="password" id="new-pwdchk"autocomplete=off required>
				<p class="guidemsg" id="new-pwdchk-focus">비밀번호를 다시 한 번 입력해 주세요.</p>
				<button class="sendpwd">비밀번호 변경</button>
			</form>
		</div>
	</div>
	<%@ include file = "../common/footer.jsp" %>
	<script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/testt/resources/js/main.js"></script>
	<script type="text/javascript" src="/testt/views/findpwd/findpwd.js"></script>
</body>
</html>