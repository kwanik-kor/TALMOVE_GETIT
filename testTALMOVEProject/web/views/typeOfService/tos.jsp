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
    <link rel="stylesheet" href="/testt/views/typeOfService/tos.css">
	<title>탈무브 | 당신의 재능을 공유해주세요</title>
	<script src="https://kit.fontawesome.com/08d0951667.js"></script>
</head>
<body>
	<%@ include file="../common/gnb.jsp" %>
	<section class="section-tos">
		<div class="tos-top">
		    <p><span><%= loginUser.getUserName() %></span> 님의 새로운 수업</p>
		    <p>당신의 재능을 나눠보세요!</p>
		</div>
		<div class="tos-content">
		    <div class="tos-content-top">
		        <h2>TALMOVE 강사 이용약관</h2>
		    </div>
		    <div class="tos-content-middle">
		        <div class="tos-title">
		            <input type="checkbox" id="usingContents">
		            <label for="usingContents">컨텐츠 이용에 대한 건</label>
		            <i class="fas fa-chevron-down"></i>
		            <div class="tos-details details-0">
		                <p>콘텐츠 삭제 또는 가용성. 유료 서비스 내에서 이용할 수 있는 콘텐츠가 동 콘텐츠를 당사에 라이센스하여 주는 파트너가 부과한 제한, 또는 기타 법적 또는 정책상의 이유로 이용할 수 없게 될 수 있습니다.<br><br>TalMove는 그렇게 이용할 수 없게 된 것에 대하여 사용자에게 아무런 책임을 부담하지 않습니다. 비디오 대여 및 구매의 경우, 사용자의 대여 기간 또는 콘텐츠를 구매한 날로부터 처음 1년 동안에 이용할 수 없게 되는 경우, 사용자는 구매가의 환불을 요청하거나, 이용할 수 없게 된 대여 또는 구매 콘텐츠에 대하여 합리적인 대체물을 요청할 수 있습니다.</p>
		            </div>
		        </div>
		        <div class="tos-title">
		            <input type="checkbox" id="sellContents">
		            <label for="sellContents">TALMOVE의 컨텐츠 접속판매의 건</label>
		            <i class="fas fa-chevron-down"></i>
		            <div class="tos-details details-1">
		                <p>귀하는 TalMove의 사전 서면 승인을 얻은 경우를 제외하고 이하에 기재된 상업적 목적을 위하여 본 서비스를 이용하지 않을 것에 동의합니다<br><br>본 서비스에 대한 접속 판매<br>본 서비스 또는 콘텐츠 상에서 또는 그 안에 게시(placed)된 광고, 후원 또는 선전의 판매, 또는 본 서비스를 통하여 제공된 콘텐츠를 포함하는 광고가 가능한 블로그 또는 웹사이트의 페이지 상의 광고, 후원 또는 선전의 판매. 단, TalMove에서 획득하지 않은 다른 자료가 해당 페이지에 나타나고 위와 같은 판매의 근거로서 충분한 가치가 있는 경우는 제외합니다.</p>
		            </div>
		        </div>
		        <div class="tos-title">
		            <input type="checkbox" id="cantService">
		            <label for="cantService">유료서비스 제공 불능에 대한 건</label>
		            <i class="fas fa-chevron-down"></i>
		            <div class="tos-details details-2">
		               <p>귀하는 TalMove의 사전 서면 승인 없이는 본 서비스 또는 콘텐츠의 어느 부분이라도 그리고 이를 어떤 매체로도 배포하지 않을 것에 동의합니다. 단, TalMove가 본 서비스에서 제공된 기능(예를 들어, Embeddable Player)을 통하여 그러한 배포를 위한 수단을 제공하는 경우는 제외합니다.</p>
		            </div>
		        </div>
		        <div class="tos-title">
		            <input type="checkbox" id="outContents">
		            <label for="outContents">컨텐츠의 임의 방출에 대한 건</label>
		            <i class="fas fa-chevron-down"></i>
		            <div class="tos-details details-3">
		               <p>귀하는 TalMove의 사전 서면 승인 없이는 본 서비스 또는 콘텐츠의 어느 부분이라도 그리고 이를 어떤 매체로도 배포하지 않을 것에 동의합니다. 단, TalMove가 본 서비스에서 제공된 기능(예를 들어, Embeddable Player)을 통하여 그러한 배포를 위한 수단을 제공하는 경우는 제외합니다.</p>
		            </div>
		        </div>
		        <input id="agreeAll" type="checkbox"><label for="agreeAll">전체 약관에 동의합니다.</label>
		    </div>
		    <div class="tos-content-bottom">
		        <p>상단의 내용을 모두 확인하였습니다.</p>
		        <button class="to-nextBtn">다음으로.</button>
		    </div>
		</div>
	</section>
	<%@ include file="../common/footer.jsp" %>
	
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="/testt/resources/js/main.js"></script>
    <script type="text/javascript" src="/testt/views/typeOfService/tos.js"></script>
</body>
</html>