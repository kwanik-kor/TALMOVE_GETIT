<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/08d0951667.js"></script>

<link href="/testt/views/mypage/css/MessageNewSendView.css" rel="stylesheet">
<script type="text/javascript" src="/testt/resources/js/jquery-3.4.1.min.js"></script>


<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
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
    
    
    $(function(){
        $("#description").summernote({
            height : 300,
            width : 800
        });
    });    
      
   
</script>
</head>
<body>
<header></header>
<section>
   <div id="pannel">
        <img class="fileimg" id="pfimg"  src="/testt/views/mypage/images/absence_08.jpg">
        <p id="teacherPage" style="padding-top:10%;font-size:3rem;font-weight:bold;padding-left:18%;"><span id="tname">장서영</span>님의 마이페이지</p>
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
   
   <p id="nmp1">새 메시지</p>
   <hr style="border:1.5px solid lightgray;">
   
       <div class="container-fluid">   
         <form>
            <div class="email_list" >
            
            <img  class="fileimg" src="/testt/views/mypage/images/emailicon.png" id="eimage">
            <input type="text" placeholder="받는 계정 입력" id="emailadd">
            <textarea rows="5" cols="60" name="description" id="description"></textarea>
            <p id="ptip">팁 : 사이트 & 모바일 앱과 관련된 기술적 문제나 환불에 관한 질문은 지원에 문의하십시오.</p>
            <input type="submit" value="보내기" class="ebtn" style="margin-right:101px;"> 
            <input type="reset" value="작성취소" class="ebtn" >   
         </form>
    </div>
    </div>            
</section>
<footer>
</footer>
</body>
</html>