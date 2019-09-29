<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="cart.model.vo.Cart, java.util.ArrayList, user.model.vo.User, onCourse.model.vo.OnCourse" %>

<%
Integer userNo = (Integer)session.getAttribute("userNo");
Integer courseNo = (Integer)session.getAttribute("courseNo");
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
	
	 <%
	//forwarding 된 request 객체에 저장한 정보 꺼내기
		ArrayList<Cart> carts = 
		(ArrayList<Cart>) request.getAttribute("carts");
	 System.out.println("jsp 확인" + carts);
		%>
		
			
</head>

<body>
	<%@ include file="/views/common/gnb.jsp" %>

  <input type="hidden" name="userNo" value="<%=loginUser.getUserNo()%>">
	<section class="cart-pay-top">
        <div class="link-top">
            <a href="/testt/index.jsp">Home</a><span>장바구니</span>    
        </div>
        <span class="link-title">장바구니</span>
	</section>
	
	 <% if (carts.size() == 0 ) { %>
  <div class="list_none"><h2>장바구니가 비어있습니다.</h2></div> 
  <% }else{ %>  
    <div class="list-count">
  		<p> <%=carts.size() %> 개의 항목이 담겨있음 </p>
  		
    </div>

    <section class="contents_box clearfix">
        <div class="shopping-cart">
           
  
            
        
  <% for(int i = 0; i < carts.size(); i++){ 
  			Cart cart = carts.get(i); %>

       
         <script>
       //삭제확인창
         function button_event(){
         if (confirm("정말 삭제하시겠습니까??") == true){    //확인
        	 location.href='/testt/cdel?cartNo=<%=cart.getCartNo()%>&&userNo=<%=loginUser.getUserNo()%>'
         }else{   //취소
             return;
         }
         }

       </script>  
       
       
        <div class="item">
           
          <div class="buttons" >
             <span class="delete-btn" onclick="button_event(); ">
             </span>
            
          </div>

          
           <img src="/testt/resources/img/sample_thumbnail4.jpg" />
          
          <div class="description">
            <span class="Lname"><%=cart.getCourseName() %></span><br />
            <span class="Tname"><%=cart.getTeacherName() %></span>
            
          </div>

          <div class="price" >
    		 ￦ <span class="num"><%=cart.getPrice() %></span>
          </div>
        
        </div><!-- /DB용 -->
        <% } %>

  
        </div>
    
        <div class="box_detail">
            <div class="box_detail_total">
                Total :
                <strong id="totalPrice"></strong>


      
            </div>
            <div class ="box_detail_price">

            <% int sum = 0; %>
            <% for(Cart cart : carts){  
  			 sum = sum + cart.getPrice();   %>
  			<%  } %> 
                &#8361; <%= sum %>
            </div>
            
            
            <a href="/testt/plist?userNo=<%=loginUser.getUserNo()%>" class="paybtn">결제하기</a> <br>
            <a href="/testt/index.jsp" class="paybtn"><i class="icon-right"></i>
            쇼핑 계속하기</a>
        </div>
            <% } %>
    </section>
       

	<%@ include file="/views/common/footer.jsp" %>

    
       


    <!-- COMMON SCRIPTS -->
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/testt/views/cart/cart.js"></script>
    <script type="text/javascript" src="/testt/resources/js/main.js"></script>
  </body>
</html>
