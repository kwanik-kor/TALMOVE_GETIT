<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <title>탈무브 | 비밀번호 찾기</title>
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
</head>
<body>
	<%@ include file="../common/gnb.jsp" %>
	<div class="msg-content">
		<div class="msg-box">
			<h3>비밀번호 재설정</h3>
			<p>계정의 이메일을 입력해주세요</p>
			<form action="/testt/findpwd.ed" method="post" class="find-pwd">
				<p class="placeholdermsg" id="find-pwd-placeholder">이메일</p>
				<input type="email" id="find-pwd" name="uemail" autocomplete=off required>
				<p class="guidemsg" id="find-pwd-focus">등록한 이메일 주소를 입력해주세요</p>
				<button class="sendmail">인증메일 전송</button>
			</form>
		</div>
	</div>
	
	<%@ include file="../common/footer.jsp" %>
	<script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/testt/resources/js/main.js"></script>
	<script type="text/javascript" src="/testt/views/findpwd/findpwd.js"></script>
</body>
</html>