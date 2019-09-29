//카드버튼 클릭시 색 고정
function changeColor() {
  var text = document.getElementById("card_button");
  card_button.style.backgroundColor = "#3f9fff";
  text.style.color = "white";
}

var change = document.getElementById("btn_group");
change.addEventListener("click", changeColor, false);

// /카드버튼클릭시 색고정

//헬... 모달 로 내용바꾸기 ..

var span = document.getElementsByClassName("closeYc")[0];

$(document).ready(function() {
  $("#popupButton1").click(function() {
    $("#myModal").css("display", "block");
    goPopUp1();
  });
  $("#popupButton2").click(function() {
    $("#myModal").css("display", "block");
    goPopUp2();
  });
  $("#popupButton3").click(function() {
    $("#myModal").css("display", "block");
    goPopUp3();
  });
});

var goPopUp1 = function() {
  $("#mcontent")
    .html(` <h3><strong><center>개인정보 판매자(제3자) 제공에 대한 동의</center></strong></h3><br>
  <p><strong>개인정보 판매자(제3자) 제공에 대한 동의 제공받는 자:</strong> TALVOME<br>
  <strong>이용목적:</strong> 상품 배송, 고객상담, 고객 불만처리<br>
  <strong>제공 항목:</strong> 성명, 주소, 연락처 <br>
  <strong>보유 및 이용기간:</strong> 제공정보는 이용목적으로만 사용됩니다.
      회원님께서는 위 내용에 대하여 동의를 거부하실 수 있으며, 거부시 서비스가 제한될 수 있습니다.</p>`);
};
var goPopUp2 = function() {
  $("#mcontent").html(` 
  <h3><strong><center>개인정보 수집 및 이용동의</center></strong></h3><br>
  <p><strong>수집목적:</strong> 대금결제 및 환불서비스 제공, 주문/배송/거래내역 조회 서비스 제공, 
  전자 상거래법 준수 등<br>
  <strong>수집항목:</strong> 거래정보, 주문/배송/거래내역<br>
  <strong>보유기간:</strong> 회원탈퇴 시까지. 단, 관계법령의 규정에 따라 보존할 의무가 있으면 
  해당 기간동안 보존·결제 수단에 따른 개인정보 수집 및 이용 항목이 
  상이할 수 있음.</p>`);
};
var goPopUp3 = function() {
  $("#mcontent").html(`
  <h3><strong><center>주문정보에 동의</center></strong></h3><br>
  <p >주문 강좌 및 상품, 가격, 배송정보에 동의합니다.`);
};

// x누르면 close
span.onclick = function() {
  $("#myModal").css("display", "none");
};

// 어디를 누르던지 close됨
window.onclick = function(event) {
  if (event.target == myModal) {
    $("#myModal").css("display", "none");
  }
};

// 모달 끝...

//checkbox event
$("#ckBox[id='ckBox']").change(function(){
    var checked = $(this).prop('checked');
    if(checked){
        $("#ckBox input[type='checkbox']").each(function(){
            $(this).prop('checked', true);
        });
        $('.to-nextBtn').addClass('active-button');
    }else{
        $("#ckBox input[type='checkbox']").each(function(){
            $(this).prop('checked', false);
        });
        $('.to-nextBtn').removeClass('active-button');
    }
});





