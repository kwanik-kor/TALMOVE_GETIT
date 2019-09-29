<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, course.model.vo.Course, lecture.model.vo.Lecture, section.model.vo.Section" %>
<%
	Course course = (Course)request.getAttribute("course");
	ArrayList<Section> slist = (ArrayList<Section>)request.getAttribute("slist");
	ArrayList<Lecture> llist = (ArrayList<Lecture>)request.getAttribute("llist");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/testt/vendors/css/bootstrap.min.css">
	<link rel="stylesheet" href="/testt/views/coursePlay/css/coursePlay.css">
	<script src="/testt/vendors/js/jquery-3.4.1.min.js"></script>
	<script src="/testt/vendors/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/08d0951667.js"></script>
	<title>강의 보기</title>
</head>
<body>
  <div class="d-flex" id="wrapper">

    <!-- Page Content -->
    <div id="page-content-wrapper">
      <!-- 내비게이션 -->
      <nav class="navbar navbar-expand-lg navbar-light bg-dark text-light border-bottom">
        <div class="talmove"> <a href="/testt/index.jsp"> TALMOVE </a></div>

        <button class="btn btn-primary" id="menu-toggle">Toggle</button>

        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link text-light" href="#"><i class="fas fa-arrow-left"></i>&nbsp 이전강의</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-light" href="#">완료후 다음강의 &nbsp; <i class="fas fa-arrow-right"></i></a>
          </li>
        </ul>
      </nav>

      <div class="boxes">
        <!-- 사이드바 -->
        <div class=" border-right" id="sidebar-wrapper">
          <div class="bg-light course-title">
            <h5 align="center" class="lecture-name" style="font-weight: bold">지옥에서 온 git</h2>
              <div class="progress" style="height:10px;"">
                <div class=" progress-bar" role="progressbar" style="width: 40%;" aria-valuenow="25" aria-valuemin="0"
                aria-valuemax="100">
              </div>
          </div>
          <div class='small course-progress-percentage'>
            <span class='percentage'>
              40%
            </span>
          	  완료
          </div>
          <!--  Start Sidebar -->
          <aside id="sidebar-wrapper" class="bg-white">
            <ul class="sidebar-nav">
              <li class="active"> <a href="#quate">Quote </a>
              </li>
              <li> <a href="#broker"></i>Broker </a>
              </li>
              <li class="treeview">
                <a data-target="#location" data-toggle="collapse" class="" aria-expanded="true">
                  <span class="ul-item">Location</span><i class="fas fa-chevron-down"></i>
                </a>
                <ul class="treeview-menu collapse" id="location" aria-expanded="true" style="">
                  <li><a href="#">Solapur </a></li>
                  <li><a href="#">Pune</a></li>
                  <li><a href="#">Nashik</a></li>
                </ul>
              </li>
              <li class="treeview">
                <a data-target="#address" data-toggle="collapse" class="" aria-expanded="true">
                  <span class="ul-item">Address1</span><i class="fas fa-chevron-down"></i>
                </a>
                <ul class="treeview-menu collapse" id="address" aria-expanded="true" style="">
                  <li><a href="#">Statara Parisar </a></li>
                  <li><a href="#">Warje</a></li>
                  <li><a href="#">Baner</a></li>
                  <li><a href="#">Shivaji Nagar</a></li>
                </ul>
              </li>
            </ul>
          </aside>
          <!--  End Sidebar -->
        </div>
      </div>
      <!-- /사이드바 -->

      <!-- 본문 -->
      <div class="container-fluid">
        <h5 class="mt-4" style="font-weight:bold">1강 제목 </h1>
          <p>The starting state of the menu will appear collapsed on smaller screens, and will appear non-collapsed on
            larger screens. When toggled using the button below, the menu will change.</p>
          <p>Make sure to keep all page content within the <code>#page-content-wrapper</code>. The top navbar is
            optional, and just for demonstration. Just create an element with the <code>#menu-toggle</code> ID which
            will toggle the menu when clicked.</p>


          <!-- 댓글 -->
          <fieldset class="col-md-12">
            <legend>discussion</legend>

            <h6 class="comment-heading" style="font-size: 16px; padding: 0px 30px">댓글달기</h6>

            <!-- 댓글 작성 폼 -->
            <div class="comment-insert-form comment-form">
              <figure class="float-left img">
                <img src="http://bootdey.com/img/Content/user_1.jpg" class="img-responsive profile"
                  alt="user profile image">
              </figure>
              <div class="row">
                <div class="col-12">
                  <div class="card card-white post">

                    <div class="post-heading">
                      <div class="float-left meta">
                        <div class="title h5">
                          <span class="comment-user"><b>이학열</b></span> &nbsp;
                          <time class="comment-date" datetime="16-12-2014 01:05"><i class="fa fa-clock-o"></i> 9/16,
                            2019</time>
                        </div>
                      </div>
                    </div>

                    <div class="post-description">
                      <form>
                        <textarea class="form-control" id="message" rows="3" placeholder="답글을 입력해 주세요."></textarea>
                        <button type="submit" class="btn btn-primary">답글 달기</button>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- /댓글 작성 폼 -->

            <h6 class="comment-heading" style="font-size: 16px; padding: 0px 30px">3 개의 댓글</h6>

            <!-- 내가 쓴 댓글 -->
            <div class="comment-form ">
              <figure class="float-left img">
                <img src="http://bootdey.com/img/Content/user_1.jpg" class="img-responsive profile"
                  alt="user profile image">
              </figure>
              <div class="row">
                <div class="col-12">
                  <div class="card card-white post">
                    <div class="post-heading">

                      <div class="float-left meta">
                        <div class="title h5">
                          <span class="comment-user"><b>이학열</b></span> &nbsp;
                          <time class="comment-date" datetime="16-12-2014 01:05"><i class="fa fa-clock-o"></i> 9/16,
                            2019</time>
                        </div>
                      </div>
                      <div class="float-right btn-menu">
                        <button type="button" class="btn btn-default btn-reply" data-toggle="tooltip"
                          data-placement="bottom" title="답글달기">
                          <i class="fa fa-reply"></i>
                        </button>
                        <button type="button" class="btn btn-default btn-edit" data-toggle="tooltip"
                          data-placement="bottom" title="수정하기">
                          <i class="fa fa-pen"></i>
                        </button>
                        <span data-toggle="modal" data-target="#deleteModal">
                          <button type="button" class="btn btn-default btn-delete" data-toggle="tooltip"
                            data-placement="bottom" title="삭제하기">
                            <i class="fa fa-times"></i>
                          </button>
                        </span>
                      </div>
                    </div>
                    <div class="post-description">
                      <p>Bootdey is a gallery of free snippets resources templates and utilities for bootstrap css
                        hmtl
                        js
                        framework. Codes for developers and web designers</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- /내가 쓴 댓글 -->

            <!--내가 쓴 답글 -->
            <div class="reply-form">
              <figure class="float-left img">
                <img src="http://bootdey.com/img/Content/user_1.jpg" class="img-responsive profile"
                  alt="user profile image">
              </figure>
              <div class="row">
                <div class="col-11">
                  <div class="card card-white post">
                    <div class="post-heading">

                      <div class="float-left meta">
                        <div class="title h5">
                          <span class="comment-user"><b>이학열</b></span> &nbsp;
                          <time class="comment-date" datetime="16-12-2014 01:05"><i class="fa fa-clock-o"></i> 9/16,
                            2019</time>
                        </div>
                      </div>
                      <div class="float-right btn-menu">
                        <button type="button" class="btn btn-default btn-reply" data-toggle="tooltip"
                          data-placement="bottom" title="답글달기">
                          <i class="fa fa-reply"></i>
                        </button>
                        <button type="button" class="btn btn-default btn-edit" data-toggle="tooltip"
                          data-placement="bottom" title="수정하기">
                          <i class="fa fa-pen"></i>
                        </button>
                        <span data-toggle="modal" data-target="#deleteModal">
                          <button type="button" class="btn btn-default btn-delete" data-toggle="tooltip"
                            data-placement="bottom" title="삭제하기">
                            <i class="fa fa-times"></i>
                          </button>
                        </span>
                      </div>
                    </div>

                    <div class="post-description">
                      <p>Bootdey is a gallery of free snippets resources templates and utilities for bootstrap css
                        hmtl
                        js
                        framework. Codes for developers and web designers</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- /내가 쓴 답글 -->

            <!-- 남이 쓴 댓글 -->
            <div class="comment-form ">
              <figure class="float-left img">
                <img src="http://bootdey.com/img/Content/user_1.jpg" class="img-responsive profile"
                  alt="user profile image">
              </figure>
              <div class="row">
                <div class="col-12">
                  <div class="card card-white post">
                    <div class="post-heading">

                      <div class="float-left meta">
                        <div class="title h5">
                          <span class="comment-user"><b>관익</b></span> &nbsp;
                          <time class="comment-date" datetime="16-12-2014 01:05"><i class="fa fa-clock-o"></i> 9/16,
                            2019</time>
                        </div>
                      </div>
                      <div class="float-right btn-menu">
                        <button type="button" class="btn btn-default btn-reply" data-toggle="tooltip"
                          data-placement="bottom" title="답글달기">
                          <i class="fa fa-reply"></i>
                        </button>
                      </div>
                    </div>
                    <div class="post-description">
                      <p>Bootdey is a gallery of free snippets resources templates and utilities for bootstrap css
                        hmtl
                        js
                        framework. Codes for developers and web designers</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- /내가 쓴 댓글 -->

            <!--남이 쓴 답글-->
            <div class="reply-form">
              <figure class="float-left img">
                <img src="http://bootdey.com/img/Content/user_1.jpg" class="img-responsive profile"
                  alt="user profile image">
                <figcaption class="text-center instructor">강사</figcaption>
              </figure>
              <div class="row">
                <div class="col-11">
                  <div class="card card-white post">
                    <div class="post-heading">

                      <div class="float-left meta">
                        <div class="title h5">
                          <span class="comment-user"><b>건우</b></span> &nbsp;
                          <time class="comment-date" datetime="16-12-2014 01:05"><i class="fa fa-clock-o"></i> 9/16,
                            2019</time>
                        </div>
                      </div>
                      <div class="float-right btn-menu">
                        <button type="button" class="btn btn-default btn-reply" data-toggle="tooltip"
                          data-placement="bottom" title="답글달기">
                          <i class="fa fa-reply"></i>
                        </button>
                      </div>
                    </div>

                    <div class="post-description">
                      <p>Bootdey is a gallery of free snippets resources templates and utilities for bootstrap css
                        hmtl
                        js
                        framework. Codes for developers and web designers</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- /남이 쓴 답글-->

            <!--답글 작성 폼-->
            <div class="reply-insert-form reply-form">
              <div class="float-left image">
                <img src="http://bootdey.com/img/Content/user_1.jpg" class="img-circle profile"
                  alt="user profile image">
              </div>
              <div class="row">
                <div class="col-11">
                  <div class="card card-white post">
                    <div class="post-heading">

                      <div class="float-left meta">
                        <div class="title h5">
                          <span class="comment-user"><b>이학열</b></span> &nbsp;
                          <time class="comment-date" datetime="16-12-2014 01:05"><i class="fa fa-clock-o"></i> 9/16,
                            2019</time>
                        </div>
                      </div>
                    </div>

                    <div class="post-description">
                      <form>
                        <textarea class="form-control" id="message" rows="3" placeholder="답글을 입력해 주세요."></textarea>
                        <button type="submit" class="btn btn-primary">답글 달기</button>
                      </form>
                    </div>

                  </div>
                </div>
              </div>
            </div>
            <!-- /답글 작성 폼-->

            <!-- 삭제 모달 창 -->
            <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
              aria-hidden="true">
              <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">×</span>
                    </button>
                  </div>
                  <div class="modal-body text-center">
            	        댓글을 삭제하시겠습니까?
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-outline-danger">네</button>
                    <button type="button" class="btn btn-outline-primary" data-dismiss="modal">아니오</button>
                  </div>
                </div>
              </div>
            </div>
            <!-- /삭제 모달 창 -->
          </fieldset>
          <!-- /댓글 -->
      </div>
      <!-- /본문 -->
      <!-- /#page-content-wrapper -->
    </div>
  </div>
  </div>


  <!-- Menu Toggle Script -->
  <script>

    // 사이드바 토글
    $("#wrapper").hide();
    $("#menu-toggle").click(function (e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });

    // 답글 토글
    $(".reply-insert-form").hide();

    $(".btn-reply").click(function (e) {
      $(".reply-insert-form").slideToggle("fast");
    });

    // 툴팁
    $(function () {
      $('[data-toggle="tooltip"]').tooltip()
    })
  </script>

</body>
</html>