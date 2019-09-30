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
    <link rel="stylesheet" href="/testt/resources/css/common/footer.css">
    <link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
    <link rel="stylesheet" href="/testt/resources/css/queries.css">
    <link type="text/css" rel="stylesheet" href="/testt/views/teacherPage/css/common.css">
    <link type="text/css" rel="stylesheet" href="/testt/views/mypage/css/UserUpdateView.css">
    <link rel="shortcut icon" type="image/x-icon" href="/testt/resources/img/titlelogo.png">
	<script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/testt/resources/js/main.js"></script>
	<script type="text/javascript" src="/testt/views/mypage/UserUpdateView.js"></script>
	<title>탈무브 | 마이페이지</title>
</head>

<body>
	<%@ include file="../common/gnb.jsp" %>
	
	<section class="section-top">
        <div class="row" id="pannel">
            <div id="pfpreview">
  				<!-- 프로필 이미지 재로그인해야 적용됨..-->
  		      	<% if(loginUser.getUserOImageName() != null) { %>       
			    	<img class="pfimg" src="/testt/views/mypage/images/fileimg/<%= loginUser.getUserOImageName() %>">
                <% }else{ %> 
             		<img class="pfimg" src="../../resources/img/customer-1.jpg">
            	<% } %> 

            </div>
            <h2 id="teacher-name"><span><%= loginUser.getUserName() %></span> 님 마이페이지</h2>
        </div>
    </section>
    <section class="section-middle clearfix">
    	<div class="left-side">
            <ul class="tmenu">
                <li><a class="active-menu" href="/testt/views/mypage/UserUpdateView.jsp">프로필</a></li>
                <li id="msgmenu"><a>메시지</a></li>
                <ul class="maghidemenu">
                	<li><a href="/testt/views/mypage/MessageNewSendView.jsp">새 메시지</a></li>
                	<li><a href="/testt/msglist?uemail=<%= loginUser.getUserEmail()%>">모든 메시지</a></li>
                	<li><a href="/testt/msgimp?uemail=<%= loginUser.getUserEmail()%>">중요 메시지</a></li>
                </ul>
            </ul>
        </div>
        <div class="right-side">
        	<h2>프로필</h2>
        	<!-- 프로필사진 -->
        	<div class="right-side-row clearfix">
        		<h3>프로필 사진</h3>
        		
        		<div class="right-side-right">
        		
        		<form action="/testt/ufileup" method="post" 
				enctype="multipart/form-data"  id="profileForm">
 		      			<% if(loginUser.getUserOImageName() != null) { %>       
			    	<img class="pfimg" src="/testt/views/mypage/images/fileimg/<%= loginUser.getUserOImageName() %>">
                <% }else{ %> 
             		<img class="pfimg" src="../../resources/img/customer-1.jpg">
            	<% } %> 
        			
        			
        			
        			&nbsp;
        			<input type="file" accept="image/*" id="efilebutton" name="profileImg"/>
        			<input type="hidden" name="uemail" id="subBtn" value="<%= loginUser.getUserEmail() %>">
        			<br>
        			 <input class="upUserFile" type="submit" value="등록"> 
        		</form>

        		</div>
        	</div>
        	<!-- 이메일 -->
        	<div class="right-side-row clearfix">
        		<h3>이메일</h3>
        		<div class="right-side-right">
        		<input type="email" id="user-email" size="50" readonly value="<%= loginUser.getUserEmail() %>">
        		</div>
        	</div>
        	<!-- 비밀번호 변경 -->
        	<div class="right-side-row clearfix">
        		<h3>비밀번호 변경</h3>
        		<div class="right-side-right newPwdSet">
        			<form action="" method="post">
        			<input type="password" placeholder="현재 비밀번호" name="upwdNow" id="upwdNow">
        			<p class="guide" id="upwdNow-focus">사용중인 비밀번호를 입력해주세요</p>
        			<input type="password" placeholder="새 비밀번호" name="upwdNew" id="upwdNew">
        			<p class="guide" id="upwdNew-focus">새 비밀번호를 입력해주세요</p>
        			<input type="password" placeholder="새 비밀번호  확인" name="upwdNewchk" id="upwdNewchk">
        			<p class="guide" id="upwdNewchk-focus">새 비밀번호를 한 번 더 입력해주세요</p>
        			<button class="newPwdBtn">비밀번호 변경</button>
        			</form>
        		</div>
        	</div>
        	<!-- 회원탈퇴 -->
        	<div class="right-side-row clearfix">
        		<h3>회원탈퇴</h3>
        		<div class="right-side-right">
        			<form action="" method="post">
	        		<p class="withdrawl-text">TALMOVE에서  본 약관은 TALMOVE 주식회사(이하 “당사”)가 TALMOVE 회원(이하 “회원”)의 탈퇴에 관한 모든 조건을 규정한 것입니다. 
		          	회원탈퇴를 하실 경우에는 아래의 내용에 동의하신 것으로 간주됩니다.
		          	수강중인 강의가 존재할 경우, 탈퇴 후에는 더 이상 해당 강의를 수강할 수 없습니다. 
		          	당사가 운영하는 웹사이트(이하 “TALMOVE 사이트”)에서 제공하는 모든 회원 대상 서비스를 이용하실 수 없습니다.
		          	보유하신 TALMOVE 강의는 탈퇴하시는 시점부터 전부 무효가 됩니다
		          	탈퇴 후에도 카드결제 등으로 발생한 이용요금 지불책임은 이행해야 합니다.
		          	회원 대상 서비스의 재이용을 원하실 경우에는 다시 신규회원에 가입하셔야 하며, 이전 강의는 이관되지 않습니다.
		          	회원 탈퇴 수속이 수리된 후에도 회원정보에 대해서는 당사가 관리하게 됩니다. 
		          	탈퇴 전 다시 한번 확인해 주십시오 </p>
<%-- 		          	<input type="hidden" name="usmail" id="usmsubBtn" value="<%= loginUser.getUserEmail() %>">
		          	<input type="hidden" name="uspwd" id="uspsubBtn" value="<%= loginUser.getUserPwd() %>"> --%>
	          		<input type="checkbox" id="withdrawl-chk"><label for="withdrawl-chk">회원탈퇴 약관 동의</label>
	          		<br>
					<input type="hidden" name="usmail" id="usmsubBtn" value="<%= loginUser.getUserEmail() %>">
<!-- 					<input type="password" placeholder="현재 비밀번호" name="upwdNowD" id="upwdNowD">
        			<p class="guide" id="upwdNowD-focus">사용중인 비밀번호를 입력해주세요</p>
 -->
	          		<button class="withdrawlBtn clearfix">회원 탈퇴</button>
	          		<script type="text/javascript">
					$(document).ready(function(){

						$('.withdrawlBtn').on('click', function(){
						   var checked = $('#withdrawl-chk').prop('checked');
						   if(checked){
						      var r = confirm("정말로 탈퇴하시겠습니까?");
						      if(r){
						
									
						    	  location.href = "/testt/udelete.ed?uemail=<%= loginUser.getUserEmail()%>";
						    	  return false;
						      }else{
									alert("탈퇴를 취소하였습니다.");
						      }
						   }else{
						      alert("탈퇴 약관에 동의해 주십시오.");
						   }
						});
					}); // documentready
					// 회원탈퇴 -----------------------
					</script>
        			</form>
        		</div>
        	</div>
        </div>
    </section>
    
    
	<%@ include file="../common/footer.jsp" %>

	
</body>
</html>

