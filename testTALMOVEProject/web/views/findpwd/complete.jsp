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
    <link rel="stylesheet" href="/testt/resources/css/emailSended.css">
    <link rel="stylesheet" href="/testt/resources/css/queries.css">
    <link rel="shortcut icon" type="image/x-icon" href="/testt/resources/img/titlelogo.png">
    <title>탈무브 | 비밀번호 변경 완료</title>
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
</head>
<body>
	<%@ include file="../common/gnb.jsp" %>
    <div class="msg-content">
	    <div class="msg-box">
	        <h3>비밀번호 변경완료</h3>
	        <p>
	        	다시 로그인해주세요.
	        </p>
	        <a class="link-btn link-btn-full" href="/testt/index.jsp">로그인</a>
	    </div>
    </div>
    <%@ include file="../common/footer.jsp" %>
</body>
</html>