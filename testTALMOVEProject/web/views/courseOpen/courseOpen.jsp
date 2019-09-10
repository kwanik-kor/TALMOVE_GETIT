<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="user.model.vo.User" %> --%>
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
    <link rel="stylesheet" href="/testt/resources/css/queries.css">
    <link rel="stylesheet" href="css/courseOpen.css">
	<title>탈무브 | 강사가 되어보세요!</title>
</head>
<body>
	<%@ include file="../common/gnb.jsp" %>
	
	<section class="fullscreen">
        <div class="hero-text-box">
            <h3>TALMOVE를 통해<br>여러분의 지식과 경험을<br>공유해주세요.</h3>
            <% if(loginUser != null){ %>
            <a href="#" class="bttn">강좌 개설하러 가기</a>
            <% }else{ %>
            <a href="#" class="bttn" onclick="javascript:alert('로그인 후에 이용해주세요.');">강좌 개설하러 가기</a>
            <% } %>
        </div>
    </section>
    
	<%@ include file="../common/footer.jsp" %>
	<script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/testt/resources/js/main.js"></script>
</body>
</html>