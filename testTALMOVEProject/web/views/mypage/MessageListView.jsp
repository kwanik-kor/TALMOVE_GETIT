<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 메세지</title>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/08d0951667.js"></script>
<link href="/testt/views/mypage/css/MessageListView.css" rel="stylesheet">
<script type="text/javascript" src="/testt/resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<div id="pannel">
      <img class="fileimg" id="pfimg"  src="/testt/views/mypage/images/absence_08.jpg">
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
           <!-- /사이드바 -->
         
           <!-- 본문 -->
         

           <div id="right-page">
                              <p id="allMessage">모든메시지</p>
                     <hr style="border:1.5px solid lightgray;">
             <div id="messagediv">
                  <div id="searchForm">
                     <select>
                        <option>최근 메시지</option>
                        <option>읽지 않은 메시지</option>
                     </select>
                     <div id="searchInput">
                        <input type="text" placeholder="검색">
                     <input type="submit" value="검색">
                  </div>
                  </div>
                  
                  <!-- 메시지영역 -->
                  <div id="messageArea">
                  
                        <div class="message">
                           <div class="imgBox">
                              <img src="/testt/views/mypage/images/absence_08.jpg">
                           </div>
                           <div class="sendMessageBox">
                              <span id="personName">Chris Haroun</span>
                              <span id="star">★</span>
                              <p id="sendDate">19/09/13</p>
                           <div class="balloon" onclick="location.href='/testt/views/mypage/MessageTextView.jsp'" >
                                   Hello~~~~~~~~~~~~~~~~~
                             </div>
        <!--                      클릭시 1:1 메시지창으로 -->
                           <p id="count">3</p>
                           </div>
                     </div>
                     
                     <div class="message">
                           <div class="imgBox">
                              <img src="/testt/views/mypage/images/absence_08.jpg">
                           </div>
                           <div class="sendMessageBox">
                              <span id="personName">Chris Haroun</span>
                              <span id="star">★</span>
                              <p id="sendDate">19/09/13</p>
                           <div class="balloon" onclick="location.href='/testt/views/mypage/MessageTextView.jsp'">
                           Hello~~~~~~~~~~~~~~~~~
                           </div>
                           <p id="count">3</p>
                           </div>
                     </div>
                     
                                             <div class="message">
                           <div class="imgBox">
                              <img src="/testt/views/mypage/images/absence_08.jpg">
                           </div>
                           <div class="sendMessageBox">
                              <span id="personName">Chris Haroun</span>
                              <span id="star">★</span>
                              <p id="sendDate">19/09/13</p>
                           <div class="balloon" onclick="location.href='/testt/views/mypage/MessageTextView.jsp'">
                           Hello~~~~~~~~~~~~~~~~~
                           </div>
                           <p id="count">3</p>
                           </div>
                     </div>
                     
                                             <div class="message">
                           <div class="imgBox">
                              <img src="/testt/views/mypage/images/absence_08.jpg">
                           </div>
                           <div class="sendMessageBox">
                              <span id="personName">Chris Haroun</span>
                              <span id="star">★</span>
                              <p id="sendDate">19/09/13</p>
                           <div class="balloon" onclick="location.href='/testt/views/mypage/MessageTextView.jsp'">
                           Hello~~~~~~~~~~~~~~~~~
                           </div>
                           <p id="count">3</p>
                           </div>
                     </div>
                     
                                             <div class="message">
                           <div class="imgBox">
                              <img src="/testt/views/mypage/images/absence_08.jpg">
                           </div>
                           <div class="sendMessageBox">
                              <span id="personName">Chris Haroun</span>
                              <span id="star">★</span>
                              <p id="sendDate">19/09/13</p>
                           <div class="balloon" onclick="location.href='/testt/views/mypage/MessageTextView.jsp'">
                           Hello~~~~~~~~~~~~~~~~~
                           </div>
                           <p id="count">3</p>
                           </div>
                     </div>
                     </div>
                  
             </div>
             
             
           </div>
   
       
   
         </div>
<script type="text/javascript">
      var pf_file;
      $(document).ready(function(){
        $("#filebutton").on("change", handleImgFileSelect);
      });
      
      function handleImgFileSelect(e) {
        var upfiles = e.target.files;
        var upfilesArr = Array.prototype.slice.call(upfiles);

        upfilesArr.forEach(function(f){
          if(!f.type.match("image.*")) {
            alert("확장자는 이미지 확장자만 가능합니다.");



          }else{
          pf_file = f;

          var reader = new FileReader();
          reader.onload = function(e) {
            $(".fileimg").attr("src", e.target.result);
          }
          reader.readAsDataURL(f);
         }
        });
      } //handleImgFileSelect
      
      $(document).ready(function(){
          //div message 하위의  div balloon  클릭했을때
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

      
      
      </script>
</body>
</html>