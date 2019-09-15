<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
   <link type="text/css" rel="stylesheet" href="/testt/views/mypage/css/UserUpdateView.css">
 <script type="text/javascript" src="/testt/resources/js/jquery-3.4.1.min.js"></script>

</head>

<body>
<section>
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
        
    <div id="right-page">
    
     <!--  프로필 첫번째영역 -이미지/ 이메일 -->
       <div class="msgpfirdiv">
       
         <p id="proimg">프로필 사진</p>
             <img class="fileimg" src="/testt/views/mypage/images/absence_08.jpg">
          <input type="file" accept="image/*"  id="filebutton" name="filebutton"/>
          <p id="proemail">이메일</p>
          <input type="email" id="email" size="50" readonly>
          <p id="propwd">비밀번호</p>
   		  <form>
   		  <input type="password" id="pwd1" name="mpwd1" placeholder="현재 비밀번호"  required>
          <p class="pwdguide" id="pw1_wn">　</p>
         
         <input type="password" id="pwd2" placeholder="새 비밀번호" required>
		  <p class="pwdguide" id="pw2_wn">6자 이상 26자 미만으로 입력해주세요.　</p> 
	   
         <input type="password" id="pwd3" name="mpwd3" placeholder="새 비밀번호 확인" required>
          <p class="pwdguide">6자 이상 26자 미만으로 입력해주세요.　</p>
      
          <input type="submit" value="저장" id="submitb">
         </form>
            <form>
          <p id="prode">회원 탈퇴</p>
          <input type="checkbox" id="checkbox1" name="checkbox1" onclick="" />
          <p id="delok">회원 탈퇴 약관 동의</p>
          <div id="text1"><p>TALMOVE에서 
            본 약관은 TALMOVE 주식회사(이하 “당사”)가 TALMOVE 회원(이하 “회원”)의 탈퇴에 관한 모든 조건을 규정한 것입니다. 
          	회원탈퇴를 하실 경우에는 아래의 내용에 동의하신 것으로 간주됩니다.
          	수강중인 강의가 존재할 경우, 탈퇴 후에는 더 이상 해당 강의를 수강할 수 없습니다. 
          	당사가 운영하는 웹사이트(이하 “TALMOVE 사이트”)에서 제공하는 모든 회원 대상 서비스를 이용하실 수 없습니다.
          	보유하신 TALMOVE 강의는 탈퇴하시는 시점부터 전부 무효가 됩니다
          	탈퇴 후에도 카드결제 등으로 발생한 이용요금 지불책임은 이행해야 합니다.
          	회원 대상 서비스의 재이용을 원하실 경우에는 다시 신규회원에 가입하셔야 하며, 이전 강의는 이관되지 않습니다.
          	회원 탈퇴 수속이 수리된 후에도 회원정보에 대해서는 당사가 관리하게 됩니다. 
          	탈퇴 전 다시 한번 확인해 주십시오 </p></div>
      </div>
      <input type="submit" value="회원탈퇴" id="delbtn">
      </form>
       </div>

   </div>

     
            
</section>
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
      </script>
</body>
</html>