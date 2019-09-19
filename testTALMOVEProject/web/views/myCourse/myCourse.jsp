<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="course.model.vo.Course, java.util.ArrayList"%>
<%
	ArrayList<Course> list = (ArrayList<Course>)request.getAttribute("list");
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%>
<!DOCTYPE html>
<html>

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta http-equiv="X-UA-Compatible" content="ie=edge">

   <link rel="stylesheet" href="/testt/vendors/css/normalize.css">
   <link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
   <link rel="stylesheet" href="/testt/vendors/css/bootstrap.css">
   <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
   <link rel="stylesheet" href="/testt/resources/css/style.css">
   <link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
   <link rel="stylesheet" href="/testt/resources/css/common/footer.css">
   <link rel="stylesheet" href="/testt/resources/css/queries.css">
   <link rel="stylesheet" href="/testt/views/myCourse/css/myCourse.css">

   <title>탈무브 | 내 강좌</title>
</head>

<body>
   <%@ include file="../common/gnb.jsp"%>
   <div class="jumbotron jumbotron-fluid">
      <div class="container">
         <h1 class="display-7">강의 듣기</h1>
         <h2 class="display-7">내 강좌</h2>
      </div>
   </div>

   <div class="container">
      <!-- 첫째줄4개 -->
     
      <div class="row">
       <% for(Course course : list){ %>
         <div class="col-sm-6 col-md-4 col-lg-3 mt-4">
            <div class="card">
               <a href="/testt/views/coursePlay/coursePlay.jsp"> <img class="card-img-top"
                     src="https://picsum.photos/200/150/?random">
               </a>
               <div class="card-block">
                  <a href="/testt/views/coursePlay/coursePlay.jsp">
                     <h4 class="card-title"><%= course.getCourseName() %></h4>
                  </a>
                  <div class="meta">
                     <span id="name">장관익</span>
                  </div>
               </div>
               <div class="card-footer bg-white">
                  <div class="progress" style="height: 10px;">
							<div class=" progress-bar" role="progressbar" style="width: 40%;" aria-valuenow="25" aria-valuemin="0"
                     aria-valuemax="100">
                  </div>
               </div>
               <div class='small course-progress-percentage'>
                  <span class='percentage'>40%</span> 완료 <span class='float-right rating'>★★★★★</span>
               </div>
               <div class="meta" id="open-review-box" style="text-align: right;" data-toggle="modal"
                  data-target="#exampleModal">
                  <a href="#">등급 남기기</a>
               </div>
            </div>
         </div>
      </div>
       <%} %>
   </div>
   </div>
   <!-- /첫쨰줄 4개 -->

   <!-- 둘쨰줄 4개 
   <div class="row mb-5">
      <div class="col-sm-6 col-md-4 col-lg-3 mt-4">
         <div class="card">
            <a href="/testt/views/coursePlay/coursePlay.jsp"> <img class="card-img-top"
                  src="https://picsum.photos/200/150/?random">
            </a>
            <div class="card-block">
               <a href="/testt/views/coursePlay/coursePlay.jsp">
                  <h4 class="card-title">자바 java 8 프로그래밍 중고급 배우기[2단계] 강좌</h4>
               </a>
               <div class="meta">
                  <span id="name">장관익</span>
               </div>
            </div>
            <div class="card-footer bg-white">
               <div class="progress" style="height: 10px;"">
							<div class=" progress-bar" role="progressbar" style="width: 40%;" aria-valuenow="25" aria-valuemin="0"
                  aria-valuemax="100">
               </div>
            </div>
            <div class='small course-progress-percentage'>
               <span class='percentage'>40%</span> 완료 <span class='float-right rating'>★★★★★</span>
            </div>
            <div class="meta" id="open-review-box" style="text-align: right;" data-toggle="modal"
               data-target="#exampleModal">
               <a href="#">등급 남기기</a>
            </div>
         </div>
      </div>
   </div>
   </div>
   -->

   <br>
   <!-- 페이징 처리 -->
   <div style="text-align: center; margin-top: 20px; margin-bottom: 50px;">
     
      <!-- 현재 페이지가 포함된 그룹의 페이지 숫자 출력 -->
      <% for(int p = startPage; p <= endPage; p++){ 
		if(p == currentPage){%>
      <font size="4" color="red"><b>[<%= p %>]</b></font>
      <% }else{ %>
      <a href="/testt/mclist?page=<%= p %>"><%= p %></a>
      <% }} %>

   </div>

   <!-- 리뷰 모달 -->
   <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
      aria-hidden="true">
      <div class="modal-dialog modal-lg" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">×</span>
               </button>
            </div>
            <div class="modal-body">
               <div>
                  <h4 align="center">이 과정을 어떻게 평가합니까?</h4>
               </div>
               <!-- 리뷰 폼  -->
               <form action="/testt/creview" method="post" name="reviewform">

                  <div id=rating align=center style="margin-top: 10px;">
                     <span>
                        <img id=image1 onmouseover=show(1) onclick=mark(1) onmouseout=noshow(1)
                           src="testt/resources/img/star-off.png">
                        <img id=image2 onmouseover=show(2) onclick=mark(2) onmouseout=noshow(2)
                           src="testt/resources/img/star-off.png">
                        <img id=image3 onmouseover=show(3) onclick=mark(3) onmouseout=noshow(3)
                           src="testt/resources/img/star-off.png">
                        <img id=image4 onmouseover=show(4) onclick=mark(4) onmouseout=noshow(4)
                           src="testt/resources/img/star-off.png">
                        <img id=image5 onmouseover=show(5) onclick=mark(5) onmouseout=noshow(5)
                           src="testt/resources/img/star-off.png">
                     </span>
                     <div style="margin-top: 10px;">
                        <span id="startext" style="margin : 0, 20px;">평가하기</span>
                     </div>
                  </div>

                  <div class="text-center" style="margin-top: 10px;">
                     <div>
                        <textarea class="review-form" id="review-form" cols="50" rows="8"
                           placeholder="리뷰를 입력해 주세요."></textarea>
                     </div>
                     <div>
                        <button class="btn btn-primary save" type="submit" style="margin-top: 10px;">저장 및 종료</button>
                     </div>

                  </div>
               </form>
               <!-- /리뷰 폼  -->
            </div>
         </div>
      </div>
      <!-- /리뷰 모달 -->
   </div>

   <%@ include file="../common/footer.jsp"%>
   <script src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
   <script src="/testt/vendors/js/bootstrap.min.js"></script>
   <script src="https://kit.fontawesome.com/08d0951667.js"></script>
   <script src="/testt/resources/js/main.js"></script>
   <script type="text/javascript">
      var locked = 0;

      function show(star) {
         if (locked)
            return;
         var i;
         var image;
         var el;
         var e = document.getElementById('startext');
         var stateMsg;

         for (i = 1; i <= star; i++) {
            image = 'image' + i;
            el = document.getElementById(image);
            el.src = "/testt/resources/img/star-on.png";
         }

         switch (star) {
            case 1:
               stateMsg = "괜히봤어요";
               break;
            case 2:
               stateMsg = "기대하진 말아요";
               break;
            case 3:
               stateMsg = "무난했어요";
               break;
            case 4:
               stateMsg = "기대해도 좋아요!";
               break;
            case 5:
               stateMsg = "기대 이상의 너무 멋진 강의었어요!";
               break;
            default:
               stateMsg = "";
         }
         e.innerHTML = stateMsg;
      }

      function noshow(star) {
         if (locked)
            return;
         var i;
         var image;
         var el;

         for (i = 1; i <= star; i++) {
            image = 'image' + i;
            el = document.getElementById(image);
            el.src = "/testt/resources/img/star-off.png";
         }
      }

      function lock(star) {
         show(star);
         locked = 1;
      }

      function mark(star) {
         lock(star);
         document.reviewform.star.value = star;
      }
   </script>
</body>

</html>