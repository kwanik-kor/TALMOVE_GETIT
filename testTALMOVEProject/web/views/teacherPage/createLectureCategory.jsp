<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teacher.model.vo.Teacher" %>
<%
	Teacher loginTeacher = (Teacher)session.getAttribute("loginTeacher");
	String lectureName = request.getParameter("lectureName");
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>탈무브 | 새 강좌</title>
    <meta name="viewport" content="width:device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/testt/vendors/css/normalize.css">
    <link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/testt/resources/css/style.css">
    <link rel="stylesheet" href="/testt/resources/css/common/footer.css">
    <link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
    <link rel="stylesheet" href="/testt/resources/css/queries.css">
    <link type="text/css" rel="stylesheet" href="css/createCommon.css">
    <link type="text/css" rel="stylesheet" href="css/createLectureCategory.css">

</head>

<body>
    <%@ include file="../common/gnb.jsp" %>
    <section id="left-top">
        <div class="tos-top">
            <p><span><%= loginTeacher.getTeacherName() %></span> 님의 새로운 수업</p>
            <p>당신의 재능을 나눠보세요!</p>
        </div>
    </section>
    <section id="center">
        <div id="center-box">
            <div>
                <span id="lectureName"><%= lectureName %></span>은(는) 어떤 수업인가요?
            </div>
            <div id="category">
                <div class="choice-category">
                    <select class="1stC" name="bank" style="text-align: center;" required>
                        <option value="">1차 카테고리</option>
                        <option value="비즈니스">비즈니스</option>
                        <option value="프로그래밍">프로그래밍</option>
                    </select>
                </div>
                <div class="choice-category">
                    <select class="2ndC" name="bank" style="text-align: center;" required>
                        <option value="">2차 카테고리</option>
                    </select>
                </div>
            </div>
            <button id="next-btn">다음으로</button>
        </div>
    </section>

    <%@ include file="../common/footer.jsp" %>
    <script type="text/javascript" src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
    	$('.1stC').on('change', function(){
    		if($(this).val() != ""){
    			var cateName = $(this).val();
    			$.ajax({
    				url: "/testt/gcateli.ed",
    				data: {categoryName: cateName},
    				type: "get",
    				dataType: "json",
    				async: false,
    				success: function(data){
    					var jsonStr = JSON.stringify(data);
    					var json = JSON.parse(jsonStr);
    					var values = "<option value=''>2차 카테고리</option>";
    					for(var i in json.clist){
    						values += "<option value='" + json.clist[i].cNo + "'>" + decodeURIComponent(json.clist[i].cName).replace(/\+/gi, " ") + "</option>";
    					}
    					$('.2ndC').html(values);
    				},
    				error: function(jqXHR, textStatus, errorThrown){
    			        console.log("error : " + jqXHR + ", " + textStatus + ", " + errorThrown);
    			    }
    			});	
    		}
    	});
    	
    	
    	$('#next-btn').on('click', function(){
    		if($('.1stC').val() == "" || $('.2ndC').val() == ""){
    			alert("카테고리를 선택해 주세요!");
    			return false;
    		}else{
    			var categoryNo = $('.2ndC').val();
    			location.href="createLectureTag.jsp?lectureName=<%= lectureName %>&categoryNo="+categoryNo;
    		}
    	});
    </script>
</body>

</html>