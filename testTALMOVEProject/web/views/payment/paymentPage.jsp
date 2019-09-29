<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="payment.model.vo.Payment, java.util.ArrayList, user.model.vo.User, course.model.vo.Course" %>
<!DOCTYPE html>
<html>
  <head>
  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	
	<title>수강결제| 탈무브</title>
	
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

 
 
  <%
	//forwarding 된 request 객체에 저장한 정보 꺼내기
		ArrayList<Payment> payments = 
		(ArrayList<Payment>) request.getAttribute("payments");
	 System.out.println("jsp 확인" + payments);
		%>
		
	  <% int sum = 0; %>
            <% for(Payment payment : payments){  
  			 sum = sum + payment.getPrice();   %>
  			<%  } %> 	

		
  </head>
  <body>
    <%@ include file="/views/common/gnb.jsp" %>

   	<section class="cart-pay-top">
        <div class="link-top">
      <a class="link_main" href="/testt/index.jsp"><!-- 홈으로 링크 검-->
        <span>Home</span>
        
      </a>
      <a class="link_cart" href='/testt/cartl?userNo=<%=loginUser.getUserNo()%>' ><span>장바구니 </span></a> 
      <span>결제하기 </span>
       </div>
      <span class="link-title">결제하기</span>
   
    </section>

   <div class="list-count">
      내 항목 <%=payments.size() %>
    </div>

    <!-- 결제항목-->
    
    <div class="payment_box">
      
      <div class="box_left">
    	<div class="scroll_bar">
          
          
             <!-- DB용 -->
        
  <% for(int i = 0; i < payments.size(); i++){ 
  			Payment payment = payments.get(i); %>
  <%--  <input type="hidden" name="cartNo" value="<%=cart.getCartNo()%>">--%>
        <div class="item">
           
                   
           <img src="/testt/resources/img/sample_thumbnail4.jpg" />
          
          <div class="description">
            <span class="Lname"><%=payment.getCourseName() %></span><br />
            <span class="Tname"><%=payment.getTeacherName() %></span>
            
          </div>

          <div class="price" >
    		 ￦ <span class="num"><%=payment.getPrice() %></span>
          </div>
        
        </div><!-- /DB용 -->
        <% } %>
        

 
        </div> <!--  scroll_bar -->
      </div> <!--  /box_left -->

     
      <div class="box_right">
       
        <div class="payType">
          <h5><b><결제방법></b></h5>

          <div id="btn_group">
            <button id="card_button">카카오페이</button>
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
            <form name="checkboxArea" id="checkboxArea"  method="POST" onsubmit="return checkCheckBox(this)" ><!--  action="/testt/views/payment/paymentFinish.jsp"-->
             
              
              <input id="ckBox" type="checkbox" value="0" name="agree" 
              onclick="el=document.getElementById('pay_btn');if(this.checked)el.disabled=false; else el.disabled=true;"/>
              <label for="ckBox"><b>결제 약관에 동의합니다. </b></label>
              <br /><br />
	          
	           <div class="total_price">
           </div>
            <div class ="box_detail_price">
          
                &#8361; <%= sum %>
 		
 	<%-- 	<form action="/addonc" type="post">
 		<input type="hidden" name="userNo" value="<%= loginUser.getUserNo()  %>">
		<% for(int i = 0; i < payments.size(); i++){ 
  			Payment payment = payments.get(i); %>
 		<input type="hidden" name="courseName" value="<%= payment.getCourseName() %>">
 		<% } %>
 		</form>
  --%>
            </div>
	           <input id="pay_btn" type="button" value="결제하기" disabled="disabled" onclick="payTest();" />
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
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript">
IMP.init('imp56366274');

function payTest(){
	IMP.request_pay({
	    pg : 'kakaopay',
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    
	     <%-- `'<% for(int i = 0; i < payments.size(); i++){ %> 
  				<% Payment payment = payments.get(i); %>
		  		<%= payment.getCourseName() + ", " %>
		      	<% }%>'`, --%>
		
		name : '강좌결제',	      	
		      	
		amount : '<%= sum %>',
	    
		buyer_email : '<%= loginUser.getUserEmail() %>',

	    buyer_name : '<%= loginUser.getUserName() %>',

	    buyer_tel : '010-1234-5678'
	}, function(rsp) {
	    if ( rsp.success ) {
	    	//[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
	    	jQuery.ajax({
	    		url: "/pm_comp", //cross-domain error가 발생하지 않도록 주의해주세요
	    		type: 'post',
	    		dataType: 'json',
	    		data: {
		    		imp_uid : rsp.imp_uid
		    		//기타 필요한 데이터가 있으면 추가 전달
	    		}
	    	}).done(function(data) {
	    		//[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
	    		if ( everythings_fine ) {
	    			var msg = '결제가 완료되었습니다.';
	    			msg += '\n고유ID : ' + rsp.imp_uid;
	    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	    			msg += '\결제 금액 : ' + rsp.paid_amount;
	    			msg += '카드 승인번호 : ' + rsp.apply_num;
	    			
	    			alert(msg);
	    		} else {
	    			//[3] 아직 제대로 결제가 되지 않았습니다.
	    			//[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
	    		}
	    	});
	    	 <% for(int i = 0; i < payments.size(); i++){ 
	   			Payment payment = payments.get(i); %>
	    	location.href='/testt/addonc?userNo=<%=loginUser.getUserNo()%>&courseNo=<%=payment.getCourseNo() %>'
	    			<% } %>
	    	
	    	//location.href='/testt/cdall?userNo=<%=loginUser.getUserNo()%>'		
	    	
	    	//장바구니목록 전체 삭제하고, purchase 카운터 올리고 까지하면 얼추 될듯 		
	    	//location.href='/testt/views/payment/paymentFinish.jsp'
	    } else {
	        var msg = '결제에 실패하였습니다.';
	        msg += '에러내용 : ' + rsp.error_msg;
	        
	        alert(msg);
	    }
	});
}

</script>	
		
    
    <script type="text/javascript"
      src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/testt/views/payment/payment.js"></script>
  </body>
</html>
