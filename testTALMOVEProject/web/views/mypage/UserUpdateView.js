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
            $(".pfimg").attr("src", e.target.result);
         }
         reader.readAsDataURL(f);
      }
   });
} //handleImgFileSelect
         

// 회원탈퇴----------------
$(document).ready(function(){
   $("#msgmenu").click(function(){
      var submenu = $('.maghidemenu');
      if(submenu.is(":visible") ){
         submenu.slideUp();
      }else{
         submenu.slideDown();
      }
   });
});
$('.withdrawlBtn').on('click', function(){
   var checked = $('#withdrawl-chk').prop('checked');
   if(checked){
      var r = confirm("정말로 탈퇴하시겠습니까?");
      if(r){
    	 /* alert("탈퇴를 취소하였습니다.");*/
    	  $.ajax({
    	         url: "/testt//udelete.ed",
    	         async: false,
    	         data: {uemail: $('#user-email').val()},
    	         type: "post",
    	         success: function(data){
    	            if(data == "1"){
    	            	alert("탈퇴 되었습니다.");
    	            /*
    	            	response.sendRedirect("/testt/logout");*/
    	            	/*window.location.href = "/testt/logout";*/
    	        		window.location.href = "index.jsp";
    	        		/*이동/로그아웃이 안됨..*/
    	            }else{
    	            	alert("탈퇴에 실패하였습니다.");
    	            }
    	         },
    	         error: function(jqXHR, textStatus, errorThrown){
    	              console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
    	          }
    	      });
      }else{
			alert("탈퇴를 취소하였습니다.");
			window.location.href = "UserUpdateView.jsp";
      }
   }else{
      alert("탈퇴 약관에 동의해 주십시오.");
   }
});

// 회원탈퇴 -----------------------

var uPwdNow = {
   input: $('#upwdNow'),
   fo: $('#upwdNow-focus')
};
var uPwdNew = {
   input: $('#upwdNew'),
   fo: $('#upwdNew-focus')
};
var uPwdNewchk = {
   input: $('#upwdNewchk'),
   fo: $('#upwdNewchk-focus')
};

uPwdNow.input.on('focus', function(){focusOn(uPwdNow);});
uPwdNew.input.on('focus', function(){focusOn(uPwdNew);});
uPwdNewchk.input.on('focus', function(){focusOn(uPwdNewchk);});

uPwdNow.input.on('blur', function(){blurOn(uPwdNow);});
uPwdNew.input.on('blur', function(){blurOn(uPwdNew);});
uPwdNewchk.input.on('blur', function(){blurOn(uPwdNewchk);});

function focusOn(inputType){
    if(inputType.input.val() == ""){
        defaultInput(inputType);
        inputType.input.keyup(function(){
            userPwdValidation(inputType);    
        });
    }else{
        inputValidation(inputType);
    }
}

function blurOn(inputType){
    if(inputType.input.val() == ""){
        blurInput(inputType);
    }else{
        userPwdValidation(inputType);
    }
}

function userPwdValidation(inputType){
   if(inputType.input.is($('#upwdNow'))){
      if(isValidPwd(inputType.input.val())){
         effectBlue(inputType);
      }else{
         effectRed(inputType);
      }
   }else if(inputType.input.is($('#upwdNew'))){
      
      if(isValidPwd(inputType.input.val())){
         effectBlue(inputType);
      }else{
         effectRed(inputType);
      }
   }else{
      if(inputType.input.val() == $('#upwdNew').val()){
         effectBlue(inputType);
      }else{
         effectRed(inputType);
      }
   }
}

function defaultInput(inputType){
   inputType.fo.css({
        visibility: 'visible',
        color: '#898989'
    });
   inputType.input.css('border-bottom', '2px solid #00a8ff');
    if(inputType.input.is($('#upwdNow'))){
        inputType.fo.text("사용중인 비밀번호를 입력해주세요");
    }else if(inputType.input.is($('#upwdNew'))){
        inputType.fo.text("새 비밀번호를 입력해주세요");
    }else{
       inputType.fo.text("새 비밀번호를 한 번 더 입력해주세요");
    }
}

function blurInput(inputType){
   inputType.fo.css('visibility', 'hidden');
    inputType.input.css('border-bottom', '1px solid #000');
}

function effectBlue(inputType){
   inputType.input.css('border-bottom', '2px solid #00a8ff');
    inputType.fo.css('color', '#00a8ff');
    inputType.fo.text("　");
}

function effectRed(inputType){
   inputType.input.css('border-bottom', '2px solid #e84118');
    inputType.fo.css('color', '#e84118');
    if(inputType.input.is($('#upwdNow'))){
        inputType.fo.text("사용중인 비밀번호를 입력해주세요");
    }else if(inputType.input.is($('#upwdNew'))){
        inputType.fo.text("6자 이상, 20자 미만으로 숫자나 특수문자를 포함해주세요");
    }else{
       inputType.fo.text("입력한 새 비밀번호와 동일하게 입력해주세요");
    }
}

$('.newPwdBtn').on('click', function(){
   var pwdSame = "1";
   if(!isValidPwd(uPwdNow.input.val())){
      uPwdNow.input.focus();
      event.preventDefault();
      return false;
   }
   
   if(!isValidPwd(uPwdNew.input.val())){
      uPwdNew.input.focus();
      event.preventDefault();
      return false;
   }
   
   if(uPwdNew.input.val() != uPwdNewchk.input.val()){
      uPwdNewchk.input.focus();
      event.preventDefault();
      return false;
   }
   
   $.ajax({
      url: "/testt/pwd.do",
      async: false,
      data: {upwd: uPwdNow.input.val(), uemail: $('#user-email').val()},
      type: "post",
      success: function(data){
         if(data == "1"){
            pwdSame = "0";
         }
      },
      error: function(jqXHR, textStatus, errorThrown){
           console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
       }
   });
   
   if(pwdSame == "0"){
      uPwdNow.input.focus();
      effectRed(uPwdNow);
      uPwdNow.fo.text("비밀번호가 틀렸습니다.");
      return false;
   }
   
   var r = confirm("비밀번호를 바꾸시겠습니까?");
   if(r){
      $.ajax({
         url: "/testt/pwdnew.ed",
         async: false,
         data: {upwd: uPwdNew.input.val(), uemail: $('#user-email').val()},
         type: "post",
         success: function(data){
            if(data == "1"){
               alert("비밀번호를 변경하였습니다.");
            }else{
               alert("비밀번호 변경에 실패하였습니다.");
            }
         },
         error: function(jqXHR, textStatus, errorThrown){
              console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
          }
      });
   }else{
      alert("비밀번호 변경을 취소하였습니다.");
      window.location.href = "UserUpdateView.jsp";
   }
});


