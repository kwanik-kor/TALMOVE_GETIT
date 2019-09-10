var fpemail = {
    input: $('#find-pwd'),
    ph: $('#find-pwd-placeholder'),
    fo: $('#find-pwd-focus')
};

var fpPwd = {
	input: $('#new-pwd'),
	ph: $('#new-pwd-placeholder'),
	fo: $('#new-pwd-focus')
};
var fpPwdchk = {
	input: $('#new-pwdchk'),
	ph: $('#new-pwdchk-placeholder'),
	fo: $('#new-pwdchk-focus')
};

fpemail.input.on('focus', function(){onFocus(fpemail);});
fpemail.input.on('blur', function(){onBlur(fpemail);});
fpPwd.input.on('focus', function(){onFocus(fpPwd);});
fpPwd.input.on('blur', function(){onBlur(fpPwd);});
fpPwdchk.input.on('focus', function(){onFocus(fpPwdchk);});
fpPwdchk.input.on('blur', function(){onBlur(fpPwdchk);});

var doubleSubmitFlag = false;
function doubleSubmitCheck(){
    if(doubleSubmitFlag){
        return doubleSubmitFlag;
    }else{
        doubleSubmitFlag = true;
        return false;
    }
}

$('.sendmail').on('click', function(){
	if(doubleSubmitCheck()) return false;
	
	var emailExist = "1";
	if(!isValidEmail(fpemail.input.val())){
		fpemail.input.focus();
		event.preventDefault();
		return false;
	}
	
	$.ajax({
		url: "/testt/eduple.do",
		async: false,
		data: {uemail: fpemail.input.val()},
		type: "get",
		success: function(data){
			if(data == "1"){ //등록되어있는 이메일이 없는 경우
				emailExist = "0";
			}
		},
		error: function(jqXHR, textStatus, errorThrown){
	        console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
	    }
	});
	
	if(emailExist == "0"){
		fpemail.input.focus();
		redEffect(fpemail);
		fpemail.fo.text("등록되지 않은 이메일입니다. 회원가입을 먼저 진행해주세요");
		return false;
	}
	return true;
});

$('.sendpwd').on('click', function(){
	if(!isValidPwd(fpPwd.input.val())){
		fpPwd.input.focus();
		event.preventDefault();
		return false;
	}
	
	if(!isValidPwdchk(fpPwd.input.val(), fpPwdchk.input.val())){
		fpPwdchk.input.focus();
		event.preventDefault();
		return false;
	}
	return true;
});