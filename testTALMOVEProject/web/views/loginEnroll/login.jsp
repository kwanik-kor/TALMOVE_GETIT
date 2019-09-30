<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>탈무브 | 로그인해주세요</title>
    <meta name="viewport" content="width:device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="/testt/vendors/css/normalize.css">
    <link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
    <!--CSS링크 수정하세요-->
    <link rel="stylesheet" href="/testt/views/loginEnroll/loginPage.css">
    <link rel="shortcut icon" type="image/x-icon" href="/testt/resources/img/titlelogo.png">
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
</head>
<body>
    <div class="wrapper fadeInDown">
    	<div class="forms">
	        <div class="formContent one">
	            <h1 class="logo-text"><a href="/testt/index.jsp">TALMOVE</a></h1>
	        
	            <button id="api-login"><img src="/testt/resources/img/google_logo.png" alt="">Google로 로그인</button>
	            <p id="center-word">또는</p>
	            <form action="/testt/login.ed" method="post" id="login-form">
	                <p class="placeholder" id="login-email-placeholder">이메일</p>
	                <input type="text" id="login-email" name="uemail" autocomplete=off required>
	                <p class="guide" id="login-email-focus">　</p>
	
	                <p class="placeholder" id="login-pwd-placeholder">비밀번호</p>
	                <input type="password" id="login-pwd" name="upwd" required>
	                <p class="guide" id="login-pwd-focus">　</p>
	
	                <button class="form-btn login-btn" type="submit">이메일로 로그인</button>
	            </form>
				
	            <div class="formFooter">
	                <a class="underlineHover forgetPwd" href="/testt/views/findpwd/findpwd.jsp">비밀번호를 잊어버렸어요.</a>
	            </div>
	            <div class="form-message">
               		<p>LOG IN <span>&#187;</span></p>
            	</div>
	        </div>
	        <div class="formContent two">
	        	<h1 class="logo-text"><a href="/testt/index.jsp">TALMOVE</a></h1>
	        	<form action="/testt/enroll.ed" method="post">
					<p class="placeholder" id="email-placeholder">이메일</p>
					<input type="text" name="uemail" id="signup-email" autocomplete=off required>
					<p class="guide" id="email-focus">　</p>
					
					<p class="placeholder" id="pwd-placeholder">비밀번호</p>
					<input type="password" name="upwd" id="signup-pwd" required>
					<p class="guide" id="pwd-focus">　</p>
					
					<p class="placeholder" id="pwdchk-placeholder">비밀번호 확인</p>
					<input type="password" id="signup-pwdchk" required>
					<p class="guide" id="pwdchk-focus">　</p>
					
					<p class="placeholder" id="name-placeholder">이름(실명)</p>
					<input type="text" name="uname" id="signup-name" autocomplete=off required>
					<p class="guide" id="name-focus">　</p>
					
					<button class="form-btn enroll-btn" type="submit">이메일로 회원가입</button>
         		</form>
	          	<div class="formFooter enrollFooter">
	                <p>회원가입 시, <a href="#">탈무브 이용약관</a>, <a href="#">개인정보 취급방침</a> 및 <a href="#">개인정보 3자 제공</a>에 동의하게 됩니다.</p>
				</div>
				<div class="form-message">
	                <p>SIGN UP <span>&#187;</span></p>
	            </div>
	        </div>
		</div>
    </div>
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/testt/views/loginEnroll/loginPage.js"></script>
</body>
</html>