<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/testt/views/mypage/css/MessageTextView.css" rel="stylesheet">
<script type="text/javascript" src="/testt/resources/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    // menu 클래스 바로 하위에 있는 a 태그를 클릭했을때
    $("#msgmenu").click(function(){	
        var submenu = $(this).next("ul");

        // submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 보드랍게 펼치기
        if( submenu.is(":visible") ){
            submenu.slideUp();
        }else{
            submenu.slideDown();
        }
    });
}); // sidebar 클릭시

function colorchange(){
   this.inneHtml();
}
</script>
</head>
<body>
<section>
   <div id="pannel">
      <img  class="fileimg" id="pfimg" src="/testt/views/mypage/images/absence_08.jpg">
        <p id="teacherPage"><span id="tname">장서영</span>님의 마이페이지</p>
    </div>  
   
    <div id="left-tap">
        <ul id="tap">
        <li><a href="/testt/views/mypage/UserUpdateView.jsp">프로필</a></li>
        <li id="msgmenu"><a>메시지</a></li>
           <ul class="maghidemenu">
                <li><a href="/testt/views/mypage/MessageNewSendView.jsp">새 메시지</a></li>
                <li><a href="/testt/views/mypage/MessageListView.jsp">모든 메시지</a></li>
                <li><a href="/testt/views/mypage/MessageImportantListView.jsp">중요 메시지</a></li>
            </ul>
        </ul>          
    </div>
        
    <div id="right-page">
       <!--   <메시지 이메일추가> -->
   
   <p id="nmp1">모든 메시지(1:1 개인메시지)</p>
   <hr style="border:1.5px solid lightgray;">
   <p id="plist"><a href="/testt/views/mypage/MessageListView.jsp">◀목록</a></p>
   <div id="search">
   <input type="text" placeholder="검색어 입력" id="sinput">
   <button id="sbtn">검색</button>
   </div>
   
   <div id="chatplace">
      <div id="chp">
      <img src="/testt/views/mypage/images/absence_08.jpg" id="sendImage">
      <p id="sendName">장관익</p>
      <button id="starbtn" onclick="colorchange();">☆</button>
      <p id="sendDate">19/09/13</p>
      </div>
      
      <div id="chatdiv">
         <div class="rightms">
            <p class="rightdate">19/08/02</p>
            <p class="rightco">Thank you for signing up to my course!<br>
            Thanks a lot for the supporting!</p>
         </div>
         <div class="leftms">
            <p class="leftdate">19/08/02</p>
            <p class="leftco">Thank you for signing up to my course!<br>
            Thanks a lot for the supporting!</p>
         </div>
         <div class="leftms">
            <p class="leftdate">19/08/10</p>
            <p class="leftco">Thank you for signing up to my course!<br>
            Thanks a lot for the supporting!</p>
         </div>
         <div class="rightms">
            <p class="rightdate">19/09/13</p>
            <p class="rightco">Thank you for signing up to my course!<br>
            Thanks a lot for the supporting!</p>
         </div>
      </div>
      <div id="comment">
         <form>
            <textarea id="cotext" placeholder="보낼 메시지를 입력하세요"></textarea>
            <input type="submit"value="보내기" id="subbtn">
            <input type="reset" value="취소" id="rbtn">
         </form>
      </div>
   </div>
   
    </div>            
</section>
</body>
</html>