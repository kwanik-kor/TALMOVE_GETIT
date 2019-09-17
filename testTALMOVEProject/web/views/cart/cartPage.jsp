<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="cart.model.vo.Cart, java.util.ArrayList" %>

<%
	//forwarding 된 request 객체에 저장한 정보 꺼내기
	ArrayList<Cart> list = (ArrayList<Cart>)request.getAttribute("list");
%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	
	<link rel="stylesheet" href="/testt/vendors/css/normalize.css">
	<link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
	<link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="/testt/resources/css/style.css">
	<link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
	<link rel="stylesheet" href="/testt/resources/css/common/footer.css">
	<link rel="stylesheet" href="/testt/resources/css/queries.css">
	<link href="/testt/views/cart/css/cart_pay_common.css" rel="stylesheet" />
	<link href="/testt/views/cart/css/cart.css" rel="stylesheet">
	<title>장바구니 | 탈무브</title>
	<script src="https://kit.fontawesome.com/08d0951667.js"></script>
</head>

<body>
	<%@ include file="/views/common/gnb.jsp" %>
	
	<section class="cart-pay-top">
        <div class="link-top">
            <a href="/testt/index.jsp">Home</a><span>장바구니</span>    
        </div>
        <span class="link-title">장바구니</span>
	</section>
	
    <div class="list-count">
  		<p>n개의 항목이 담겨있음</p>
    </div>

    <section class="contents_box clearfix">
        <div class="shopping-cart">
            <div class="item clearfix">
                <div class="buttons">
                    <span class="delete-btn"></span>
                </div>
                <img src="../../resources/img/sample_thumbnail2.jpg" />
                <div class="description">
                    <span class="Lname">Bootstrap 4 & 3 Framework Tutorial </span><br>
                    <span class="Tname">By 박건우</span>
                </div>
                <div class="price">
                    ￦ 30000
                </div>
            </div>
            <div class="item clearfix">
                <div class="buttons">
                    <span class="delete-btn"></span>
                </div>
                <img src="../../resources/img/sample_thumbnail2.jpg" />
                <div class="description">
                    <span class="Lname">Bootstrap 4 & 3 Framework Tutorial </span><br>
                    <span class="Tname">By 박건우</span>
                </div>
                <div class="price">
                    ￦ 30000
                </div>
            </div>
            <div class="item clearfix">
                <div class="buttons">
                    <span class="delete-btn"></span>
                </div>
                <img src="../../resources/img/sample_thumbnail2.jpg" />
                <div class="description">
                    <span class="Lname">Bootstrap 4 & 3 Framework Tutorial </span><br>
                    <span class="Tname">By 박건우</span>
                </div>
                <div class="price">
                    ￦ 30000
                </div>
            </div>
        </div>
        
        <div class="box_detail">
            <div class="box_detail_total">
                Total :
            </div>
            <div class ="box_detail_price">
                &#8361; 90000 
            </div>
            <a href="/testt/views/payment/paymentPage.jsp" class="paybtn">결제하기</a> <br>
            <a href="/testt/index.jsp" class="paybtn"><i class="icon-right"></i>
            쇼핑 계속하기</a>
        </div>
    </section>
       

	<%@ include file="/views/common/footer.jsp" %>

    <!-- COMMON SCRIPTS -->
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/testt/resources/js/main.js"></script>
  </body>
</html>
