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
    <link type="text/css" rel="stylesheet"  href="/testt/views/mypage/css/MessageNewSendView.css" >
    
<!--     include libraries(jQuery, bootstrap)
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
		
	<script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="/testt/resources/js/main.js"></script>
	<script type="text/javascript" src="/testt/views/mypage/UserUpdateView.js"></script>

<!-- 	<script type="text/javascript" src="//code.jquery.com/jquery.min.js"></script>  --><!-- 
<script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script> -->

<script type="text/javascript">
    
    $(function(){
        $("#description").summernote({
            height : 50%,
            width : 50%
        });
    });    
 
   
</script>
	<title>탈무브 | 마이페이지</title>
</head>
<body>
	<%@ include file="../common/gnb.jsp" %>
	
	<section class="section-top">
        <div class="row" id="pannel">
            <div id="pfpreview">
                <img class="pfimg" src="../../resources/img/customer -1.jpg">
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
                	<li><a href="/testt/views/mypage/MessageListView.jsp">모든 메시지</a></li>
                	<li><a href="/testt/views/mypage/MessageImportantListView.jsp">중요 메시지</a></li>	
                </ul>
            </ul>
        </div>

         <div class="right-side">
        	<h2>새 메시지</h2>       <!--   <메시지 이메일추가> -->

   
       <div class="right-side-row clearfix">   
         <form>
            <div class="email_list" >
            
            <img  class="fileimg" src="/testt/views/mypage/images/emailicon.png" id="eimage">
            <input type="text" placeholder="받는 계정 입력" id="emailadd">
                        </div>
            <textarea rows="5" cols="60" name="description" id="description"></textarea><br>
            <p id="ptip">팁 : 사이트 & 모바일 앱과 관련된 기술적 문제나 환불에 관한 질문은 지원에 문의하십시오...</p>
            <input type="submit" value="보내기" class="ebtn" style="margin-right:3%;"> 
            <input type="reset" value="작성취소" class="ebtn" >   

         </form>
    		</div>
    </div>       
     
</section>
   
	<%@ include file="../common/footer.jsp" %>

</body>
</html>