<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	
	<title>수강결제</title>
	
	<link rel="stylesheet" href="/testt/vendors/css/normalize.css">
	<link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
	<link rel="stylesheet" href="/testt/vendors/css/bootstrap.css">
	<link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="/testt/resources/css/style.css">
	<link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
	<link rel="stylesheet" href="/testt/resources/css/common/footer.css">
	<link rel="stylesheet" href="/testt/resources/css/queries.css">
   
    <link href="/testt/views/payment/css/payment.css" rel="stylesheet" />
    <link href="/testt/views/cart/css/cart_pay_common.css" rel="stylesheet" />

 
  </head>
  <body>
    <%@ include file="/views/common/gnb.jsp" %>

    <div class="link_bar">
      <a class="link_main" href="/testt/index.jsp"
        ><!-- 홈으로 링크 검-->
        <span>Home/</span>
      </a>
      <a class="link_cart" href="/testt/views/cart/cartPage.jsp"
        ><span>장바구니 </span></a
      > 
      <span>/결제하기 </span>
      <h2>결제하기</h2>
    </div>

    <div class="title">
      내 항목(3)
    </div>

    <!-- 결제항목-->
    <div class="payment_box">
      
      <div class="box_left">
    	<div class="scroll_bar">
          
          
          <!-- Product #1 -->
          <div class="item">
          
           
              <img src="/testt/views/cart/images/item-1.jpg" />
            

            <div class="description">
              <span class="Lname">Bootstrap 4 & 3 Framework Tutorial </span><br/>
              <span class="Tname">강사 : 박건우</span>
            </div>

            <div class="price">
          	    ￦30000
            </div>
          
          </div><!-- /Product #1 -->

          <!-- Product #2 -->
          <div class="item">
            
              <img src="/testt/views/cart/images/item-2.jpg" />
            

            <div class="description">
              <span class="Lname">JavaScript Framework Tutorial </span><br />
              <span class="Tname">강사 : 이학열</span>
            </div>
            <div class="price">
             	 ￦30000
            </div>
         
          </div>  <!-- /Product #2 -->

          <!-- Product #3 -->
          <div class="item">
          
          
              <img src="/testt/views/cart/images/item-3.png" />
       

            <div class="description">
              <span class="Lname">Python Framework Tutorial </span><br />
              <span class="Tname">강사 : 장관익</span>
            </div>
            
            <div class="price">
            	  ￦30000
            </div>
          
          </div> <!--  /Product #3 -->

 
        </div> <!--  scroll_bar -->
      </div> <!--  /box_left -->

     
      <div class="box_right">
       
        <div class="payType">
          <h5><b><결제방법></b></h5>

          <div id="btn_group">
            <button id="card_button">카드</button>
          </div>
       
        </div> <!--/payType-->

        <div class="agree_box">
          <h5><b><결제약관></b></h5>
          <div class="agree"><b> 개인정보판매자동의      
          	 <span class="popup" id="popupButton1">확인하기</b></span>
          </div>
          
          <div class="agree"><b>개인정보수집동의
            <span class="popup" id="popupButton2">확인하기</b></span><br />
          </div>
          
          <div class="agree"><b>주문정보제공동의
            <span class="popup" id="popupButton3">확인하기</b></span><br />
          </div>

          <div id="myModal" class="modal_yc"> <!-- Modal content -->
           
            <div class="modal-content_yc">
              <span class="closeYc">&times;</span>
              
              <div id="mcontent"></div>
            </div> <!-- /Modal content-->
          
          </div> <!-- /modal_yc -->

          <div class="put_custom_wrap">
            <!-- check box-->
            <form name="checkboxArea" id="checkboxArea" action="/testt/views/payment/paymentFinish.jsp"
              method="POST" onsubmit="return checkCheckBox(this)" >
              
              <input id="ckBox" type="checkbox" value="0" name="agree" />
              <label for="ckBox"><b>결제 약관에 동의합니다. </b></label>
              <br /><br />
	          
	           <div class="total_price"><b>총계 : ￦60,000 </b></div>
	           <input id="pay_btn" type="submit" value="결제하기" />
            </form>
          </div>
          <!-- /check box-->
        </div>
        <!-- /agree box-->
      </div>
      <!-- /box_right -->
    </div>
    <!--  /payment_box -->

    <%@ include file="/views/common/footer.jsp" %>

    <!-- COMMON SCRIPTS -->
    <script
      type="text/javascript"
      src="/testt/vendors/js/jquery-3.4.1.min.js"
    ></script>
    <script type="text/javascript" src="payment.js"></script>
  </body>
</html>
