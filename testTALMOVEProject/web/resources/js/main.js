/* navigation input */

$('.gnb-search input').on('focus', function(){
    $('.fa-search').css({
        color: '#0279b7',
        transition: 'color 0.2s'
    });
});

$('.gnb-search input').on('blur', function(){
    $('.fa-search').css('color', '#000'); 
});

/* 토글메뉴 오픈 시 스크롤 방지 */
$("input[id='togglechk']").change(function(){
    var checked = $(this).prop('checked');
    if(checked){
        $('html, body').css({'overflow': 'hidden', 'height': '100%'});
        $('#element').on('scroll touchmove mousewheel', function(event) {
          event.preventDefault();
          event.stopPropagation();
          return false;
        });
    }else{
        $('html, body').css({'overflow': 'auto'})
        $('#element').off('scroll touchmove mousewheel');
    }
});

$(window).click(function(e){
    if(e.target.className == 'toggle-back'){
        $('#togglechk').prop('checked', false);
        $('html, body').css({'overflow': 'auto'})
        $('#element').off('scroll touchmove mousewheel');
    }
});

/* 토글메뉴 리스트 펼치기 */
function toggleList(menuName){
    if(menuName == 'business'){
        if($('.toggle-business').css('display') != 'block'){
            $('.toggle-business').css({
                'display': 'block',
                'opacity': '1'
            });
            $('#business-list').removeClass('fa-chevron-down list-down');
            $('#business-list').addClass('fa-chevron-up list-up');
        }else{
            $('.toggle-business').css({
                'display': 'none',
                'opacity': '0'
            });
            $('#business-list').removeClass('fa-chevron-up list-up');
            $('#business-list').addClass('fa-chevron-down list-down');
        }
    }
    if(menuName == 'programming'){
        if($('.toggle-programming').css('display') != 'block'){
            $('.toggle-programming').css({
                'display': 'block',
                'opacity': '1'
            });
            $('#programming-list').removeClass('fa-chevron-down list-down');
            $('#programming-list').addClass('fa-chevron-up list-up');
        }else{
            $('.toggle-programming').css({
                'display': 'none',
                'opacity': '0'
            });
            $('#programming-list').removeClass('fa-chevron-up list-up');
            $('#programming-list').addClass('fa-chevron-down list-down');
        }
    }
}

/* Category */
$('#business').on('mouseover', function(){
    $('.drop-business').addClass('is-visible');
    $('.drop-programming').removeClass('is-visible');
});

$('#programming').on('mouseover', function(){
    $('.drop-programming').addClass('is-visible');
    $('.drop-business').removeClass('is-visible');
});

/* Modal Enroll Pop-up */

var modal = document.getElementById("enroll-form");
var loginBtn = document.getElementById("login-btn");
var signupBtn = document.getElementById("signup-btn");

loginBtn.onclick = function(){
    $('.modal').addClass('is-visible');
    
    setTimeout(function () {
      $('.modal').addClass('is-open');
    }, 20);
    $('.modal').css('padding-top', '10%');
    document.getElementById('form-login').style.display = "block";
    document.getElementById('form-signup').style.display = "none";
    document.getElementById('login-tab').style.borderBottom = "2px solid #00a8ff";
    document.getElementById('signup-tab').style.borderBottom = "0";
}

signupBtn.onclick = function(){
    $('.modal').addClass('is-visible');
    
    setTimeout(function () {
      $('.modal').addClass('is-open');
    }, 20);
    $('.modal').css('padding-top', '5%');
    document.getElementById('form-login').style.display = "none";
    document.getElementById('form-signup').style.display = "block";
    document.getElementById('login-tab').style.borderBottom = "0";
    document.getElementById('signup-tab').style.borderBottom = "2px solid #00a8ff";
}

function changeTab(tabName, tabName2){
    var i;
    var x = document.getElementsByClassName("form-content");
    var y = document.getElementsByClassName("form-tab");
    for(i = 0; i < x.length; i++){
        x[i].style.display = "none";
        y[i].style.borderBottom = "0";
    }
    document.getElementById(tabName).style.display = "block";
    document.getElementById(tabName2).style.borderBottom = "2px solid #00a8ff";
    if(tabName == "form-login"){
    	$('.modal').css('padding-top', '10%');
    }else{
    	$('.modal').css('padding-top', '5%');
    }
}

window.onclick = function(event){
    if(event.target == modal){
        $('.modal').removeClass('is-open');
        $('.modal').removeClass('is-visible');
    }
}

/* on focus function */

var email = {
    input: $('#login-email'),
    ph: $('#login-email-placeholder'),
    fo: $('#login-email-focus')
};

var pwd = {
    input: $('#login-pwd'),
    ph: $('#login-pwd-placeholder'),
    fo: $('#login-pwd-focus')
};

var eEmail = {
	input: $('#signup-email'),
    ph: $('#email-placeholder'),
    fo: $('#email-focus')
};

var ePwd = {
	input: $('#signup-pwd'),
    ph: $('#pwd-placeholder'),
    fo: $('#pwd-focus')
};

var ePwdchk = {
	input: $('#signup-pwdchk'),
    ph: $('#pwdchk-placeholder'),
    fo: $('#pwdchk-focus')
};
var eName = {
	input: $('#signup-name'),
    ph: $('#name-placeholder'),
    fo: $('#name-focus')
};

//로그인 form 포커스 + 블러
email.input.on('focus', function(){onFocus(email);});
pwd.input.on('focus', function(){onFocus(pwd);});

email.input.on('blur', function(){onBlur(email);});
pwd.input.on('blur', function(){onBlur(pwd);});

//회원가입 form 포커스 + 블러
eEmail.input.on('focus', function(){onFocus(eEmail);});
ePwd.input.on('focus', function(){onFocus(ePwd);});
ePwdchk.input.on('focus', function(){onFocus(ePwdchk);});
eName.input.on('focus', function(){onFocus(eName);});

eEmail.input.on('blur', function(){onBlur(eEmail);});
ePwd.input.on('blur', function(){onBlur(ePwd);});
ePwdchk.input.on('blur', function(){onBlur(ePwdchk);});
eName.input.on('blur', function(){onBlur(eName);});

function onFocus(inputType){
    if(inputType.input.val() == ""){
        defaultStyle(inputType);
        inputType.input.keyup(function(){
            inputValidation(inputType);    
        });
    }else{
        inputValidation(inputType);
    }
}

function onBlur(inputType){
    if(inputType.input.val() == ""){
        blurStyle(inputType);
    }else{
    	inputType.ph.css('animation', 'none');
        inputValidation(inputType);
    }
}

function inputValidation(inputType){
    if(inputType.ph.text() == "이메일"){
        if(isValidEmail(inputType.input.val())){
            blueEffect(inputType);
        }else{
            redEffect(inputType);
        }
    }else if(inputType.ph.text() == "비밀번호"){
        if(isValidPwd(inputType.input.val())){
            blueEffect(inputType);
        }else{
            redEffect(inputType);
        }
    }else if(inputType.ph.text() == "비밀번호 확인"){
    	var comp = "";
    	if(inputType.input.is($('#signup-pwdchk'))){
    		comp = $('#signup-pwd').val();
    	}else{
    		comp = $('#new-pwd').val();
    	}
    	
    	if(isValidPwdchk(comp, inputType.input.val())){
            blueEffect(inputType);
        }else{
            redEffect(inputType);
        }
    }else{
    	if(isValidName(inputType.input.val())){
            blueEffect(inputType);
        }else{
            redEffect(inputType);
        }
    }
}

function isValidEmail(emailAddress){
    var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    return regExp.test(emailAddress);
}
function isValidPwd(password){
    /* 숫자 영문자 조합 6~20글자*/
    var regExp = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,19}$/;
    return regExp.test(password);
}
function isValidPwdchk(comp, pwdchk){
    if(pwdchk == comp){
        return true;
    }else{
        return false;
    }
}

function isValidName(name){
    var regExp = /^[가-힣]{2,}$/;
    return regExp.test(name);
}

function defaultStyle(inputType){
    inputType.fo.css({
        visibility: 'visible',
        color: '#898989'
    });
    inputType.ph.css({
        transform: 'translate(0,0)',
        fontSize: '0.6rem',
        color: '#00a8ff',
        animation: 'none'
    });
    inputType.input.css('border-bottom', '2px solid #00a8ff');
    if(inputType.ph.text() == "이메일"){
        inputType.fo.text("사용중인 이메일 주소를 입력해주세요");
    }else if(inputType.ph.text() == "비밀번호"){
        inputType.fo.text("6자 이상, 20자 미만으로 입력해주세요");
    }else if(inputType.ph.text() == "비밀번호 확인"){
    	inputType.fo.text("비밀번호를 한 번 더 입력해주세요");
    }else{
    	inputType.fo.text("2자 이상으로 작성해주세요");
    }
}

function blurStyle(inputType){
    inputType.ph.css({
        transform: 'translate(2px, 25px)',
        fontSize: '0.7rem',
        color: "#898989",
        animation: 'none'
    });
    inputType.fo.css('visibility', 'hidden');
    inputType.input.css('border-bottom', '1px solid #000');
}

function blueEffect(inputType){
    inputType.input.css('border-bottom', '2px solid #00a8ff');
    inputType.fo.css('color', '#00a8ff');
    inputType.fo.text("　");
    inputType.ph.css('color', '#00a8ff');
}

function redEffect(inputType){
    inputType.input.css('border-bottom', '2px solid #e84118');
    inputType.fo.css('color', '#e84118');
    inputType.ph.css({
        color: '#e84118',
        animation: 'shake 0.5s'
    });
    if(inputType.ph.text() == "이메일"){
        inputType.fo.text("이메일 양식에 맞게 입력해주세요");
    }else if(inputType.ph.text() == "비밀번호"){
    	if(inputType == ePwd){
    		inputType.fo.text("6자 이상, 20자 미만으로 숫자나 특수문자를 포함해주세요")
    	}else{
    		inputType.fo.text("6자 이상, 20자 미만으로 입력해주세요");
    	}
    }else if(inputType.ph.text() == "비밀번호 확인"){
    	inputType.fo.text("입력한 비밀번호와 동일하게 입력해주세요");
    }else{
    	inputType.fo.text("2자 이상으로 작성해주세요");
    }
}

//login 버튼 클릭 시 등록된 이메일인지 / 그렇다면 비밀번호는 맞는지 검사
$('.login-btn').on('click', function(){
	var emailExist = "1";
	var pwdExist = "1";
	
	if(!isValidEmail(email.input.val())){
		email.input.focus();
		event.preventDefault();
		return false;
	}
	if(!isValidPwd(pwd.input.val())){
		pwd.input.focus();
		event.preventDefault();
		return false;
	}
	
	$.ajax({
		url: "/testt/eduple.do",
		async: false,
		data: {uemail: email.input.val()},
		type: "get",
		success: function(data){
			if(data == "1"){
				emailExist = "0";
			}
		},
		error: function(jqXHR, textStatus, errorThrown){
	        console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
	    }
	});
	
	$.ajax({
		url: "/testt/pwd.do",
		async: false,
		data: {upwd: pwd.input.val(), uemail: email.input.val()},
		type: "get",
		success: function(data){
			if(data == "1"){
				pwdExist = "0";
			}
		},
		error: function(jqXHR, textStatus, errorThrown){
	        console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
	    }
	});
	if(emailExist == "0"){
		email.input.focus();
		redEffect(email);
		email.fo.text("등록되지 않은 이메일 입니다");
		return false;
	}
	if(emailExist == "1" && pwdExist == "0"){
		pwd.input.focus();
		redEffect(pwd);
		pwd.fo.text("잘못된 비밀번호 입니다");
		return false;
	}
	return true;
});

$('.enroll-btn').on('click', function(){
	var emailExist = "1";
	if(!isValidEmail(eEmail.input.val())){
		eEmail.input.focus();
		event.preventDefault();
		return false;
	}
	if(!isValidPwd(ePwd.input.val())){
		ePwd.input.focus();
		event.preventDefault();
		return false;
	}
	if(!isValidPwdchk(ePwd.input.val(), ePwdchk.input.val())){
		ePwdchk.input.focus();
		event.preventDefault();
		return false;
	}
	if(!isValidName(eName.input.val())){
		eName.input.focus();
		event.preventDefault();
		return false;
	}
	$.ajax({
		url: "/testt/eduple.do",
		async: false,
		data: {uemail: eEmail.input.val()},
		type: "get",
		success: function(data){
			if(data == "0"){
				emailExist = "0";
			}
		},
		error: function(jqXHR, textStatus, errorThrown){
	        console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
	    }
	});
	if(emailExist == "0"){
		eEmail.input.focus();
		redEffect(eEmail);
		eEmail.fo.text("이미 가입된 이메일입니다.");
		return false;
	}
	return true;
});

/* Scroll function */
window.onscroll = function() {scrollFunction()};

function scrollFunction(){
    if(document.body.scrollTop > 20 || document.documentElement.scrollTop > 20){
        document.getElementById('topBtn').style.display = 'block';
    } else{
        document.getElementById('topBtn').style.display = 'none';
    }
}

function topFunction(){
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}











