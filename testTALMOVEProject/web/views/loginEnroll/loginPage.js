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
    	if(isValidPwdchk(inputType.input.val())){
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
    var regExp = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/;
    return regExp.test(password);
}
function isValidPwdchk(pwdchk){
    var pwd = $('#signup-pwd').val();
    if(pwdchk == pwd){
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
    		inputType.fo.text("6자 이상, 20자 미만으로 숫자나 특수문자를 하나 포함해주세요")
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

$('.one').on('click', function(){
    $(this).removeClass('login-inactive');
    $('.two').removeClass('signup-active');
    $('.enrollFooter').css('display', 'none');
    $('.two form').css('margin-bottom', '25px');
    $('.two .form-message').css('display', 'block');
    $('.one .form-message').css('display', 'none');
});
$('.two').on('click', function(){
    $(this).addClass('signup-active');
    $('.one').addClass('login-inactive');
    $('.enrollFooter').css('display', 'block');
    $('.two form').css('margin-bottom', 'none');
    $('.two .form-message').css('display', 'none');
    $('.one .form-message').css('display', 'block');
});



