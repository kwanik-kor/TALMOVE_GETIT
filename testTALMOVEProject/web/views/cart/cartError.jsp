<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8" errorPage="/testt/views/common/Error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>에러 발생</h1>
<h4>message : <%= request.getAttribute("message") %></h4>
<!-- <h4><a href="../../index.jsp">홈으로</a></h4> -->

</body>
</html>