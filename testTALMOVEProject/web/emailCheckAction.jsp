<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width:device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="vendors/css/normalize.css">
    <link rel="stylesheet" href="vendors/css/bootstrap-grid.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/common/gnb.css">
    <link rel="stylesheet" href="resources/css/common/footer.css">
    <link rel="stylesheet" href="resources/css/emailSended.css">
    <link rel="stylesheet" href="resources/css/queries.css">
    <title>탈무브 | 인증완료</title>
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
</head>
<body>
    <%@ include file="views/common/gnb.jsp" %>
    <div class="msg-content">
	    <div class="msg-box">
	        <h3>이메일 인증완료</h3>
	        <p>
	        	이메일 인증이 완료되었습니다!<br>
	        	로그인하고 서비스를 이용해 주세요
	        </p>
	        <a class="link-btn link-btn-full" href="index.jsp">로그인</a>
	    </div>
    </div>
    <%@ include file="views/common/footer.jsp" %>
    <script type="text/javascript" src="vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="resources/js/main.js"></script>
</body>
</html>