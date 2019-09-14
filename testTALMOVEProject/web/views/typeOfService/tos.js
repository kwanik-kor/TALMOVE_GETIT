$('.tos-title i').on('click', function(){
    var idx = $(".tos-title i").index(this);
    if($(this).hasClass('fa-chevron-down')){
        $(this).removeClass('fa-chevron-down');
        $(this).addClass('fa-chevron-up');
        $('.tos-title .details-'+idx).addClass('visible-details');
    }else{
        $(this).removeClass('fa-chevron-up');
        $(this).addClass('fa-chevron-down');
        $('.tos-title .details-'+idx).removeClass('visible-details');
    }
});

$("input[id='agreeAll'").change(function(){
    var checked = $(this).prop('checked');
    if(checked){
        $(".tos-title input[type='checkbox']").each(function(){
            $(this).prop('checked', true);
        });
        $('.to-nextBtn').addClass('active-button');
    }else{
        $(".tos-title input[type='checkbox']").each(function(){
            $(this).prop('checked', false);
        });
        $('.to-nextBtn').removeClass('active-button');
    }
});

$(".tos-title input[type='checkbox']").each(function(){
    $(this).change(function(){
        if($(".tos-title input[type='checkbox']:checked").length == 4){
            $("input[id='agreeAll']").prop('checked', true);
            $('.to-nextBtn').addClass('active-button');
        }else{
            $("input[id='agreeAll']").prop('checked', false);
            $('.to-nextBtn').removeClass('active-button');
        }
    });
});

$('.to-nextBtn').on('click', function(){
    if($(this).hasClass('active-button')){
        window.location.href = "#";
    }else{
        alert("약관에 동의해 주세요.");
        return false;
    }
});