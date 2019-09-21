<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.model.vo.User" %>
<%
	User loginUser = (User)session.getAttribute("loginUser");
	String message = (String)session.getAttribute("message");
	if(message != null){
%>
	<script type="text/javascript">alert("<%= message %>")</script>
<%
	session.removeAttribute("message");}
%>
<!DOCTYPE html>
<header>
        <nav>
           <div id="menuToggle">
                <input type="checkbox" id="togglechk">
                <div class="toggle-back"></div>
                <span></span>
                <span></span>
                <span></span>

                <ul id="menu">
                	<% if(loginUser == null){ %>
                    <a href="/testt/views/loginEnroll/login.jsp"><li>로그인</li></a>
                    <a href="#"><li>회원가입</li></a>
                    <a href="/testt/views/courseOpen/courseOpen.jsp"><li>강좌개설</li></a>
                    <% }else{ %>
                    <a href="/testt/views/mypage/UserUpdateView.jsp"><li><%= loginUser.getUserName() %></li></a>
                    <a href="/testt/mclist?userNo=<%= loginUser.getUserNo()%>"><li>내강좌</li></a>
                    <a href="#"><li>장바구니</li></a>
                    <% if(loginUser.getTeacherNo() == 0){ %>
                    <a href="/testt/views/courseOpen/courseOpen.jsp"><li>강좌개설</li></a> 
                    <% }else{ %>
                    <a href="/testt/views/teacherPage/teacherPageDetail.jsp"><li>강사</li></a>
                    <% } %>
                   
                    <a href="/testt/logout"><li>로그아웃</li></a>
                    <% } %>
                    <hr>
                    <li>카테고리</li>
                    <a onclick="setTimeout(toggleList('business'),200);"><li>비즈니스<i id="business-list" class="fa fa-chevron-down list-down"></i></li></a>
                    <ul class="toggle-business">
                        <a href="/testt/views/category/categoryDetail.jsp?category='비즈니스'"><li>비즈니스 전체보기</li></a>
                        <a href="/testt/views/category/categoryDetail.jsp?category='커뮤니케이션'"><li>커뮤니케이션</li></a>
                        <a href="/testt/views/category/categoryDetail.jsp?category='경영'"><li>경영</li></a>
                        <a href="/testt/views/category/categoryDetail.jsp?category='판매'"><li>판매</li></a>
                        <a href="/testt/views/category/categoryDetail.jsp?category='전략'"><li>전략</li></a>
                        <a href="/testt/views/category/categoryDetail.jsp?category='운영'"><li>운영</li></a>
                    </ul>
                    <a onclick="toggleList('programming');"><li>프로그래밍<i id ="programming-list" class="fa fa-chevron-down list-down"></i></li></a>
                    <ul class="toggle-programming">
                        <a href="/testt/views/category/categoryDetail.jsp?category='프로그래밍'"><li>프로그래밍 전체보기</li></a>
                        <a href="/testt/views/category/categoryDetail.jsp?category='프로그래밍 이론'"><li>프로그래밍 이론</li></a>
                        <a href="/testt/views/category/categoryDetail.jsp?category='프로그래밍 언어'"><li>프로그래밍 언어</li></a>
                        <a href="/testt/views/category/categoryDetail.jsp?category='웹'"><li>웹</li></a>
                        <a href="/testt/views/category/categoryDetail.jsp?category='모바일'"><li>모바일</li></a>
                        <a href="/testt/views/category/categoryDetail.jsp?category='게임'"><li>게임</li></a>
                        <a href="/testt/views/category/categoryDetail.jsp?category='DB'"><li>DB</li></a>
                        <a href="/testt/views/category/categoryDetail.jsp?category='데이터과학'"><li>데이터과학</li></a>
                    </ul>
                </ul>
            </div>
            <div class="row">
                <div class="gnb-logo">
                    <p class="logo-text"><a href="/testt/index.jsp">TALMOVE</a></p>
                    <div class="dropdown">
                        <p class="category dropbtn">카테고리</p>
                        <div class="dropdown-content">
                            <a id="business" href="#">비즈니스</a>
                            <a id="programming" href="#">프로그래밍</a>
                            <div class="dropdown-contentSub">
                                <div class="is-visible drop-business">
                                    <a href="/testt/views/category/categoryDetail.jsp?category='비즈니스'">비즈니스 전체보기</a>
			                        <a href="/testt/views/category/categoryDetail.jsp?category='커뮤니케이션'">커뮤니케이션</a>
			                        <a href="/testt/views/category/categoryDetail.jsp?category='경영'">경영</a>
			                        <a href="/testt/views/category/categoryDetail.jsp?category='판매'">판매</a>
			                        <a href="/testt/views/category/categoryDetail.jsp?category='전략'">전략</a>
			                        <a href="/testt/views/category/categoryDetail.jsp?category='운영'">운영</a>    
                                </div>
                                <div class="drop-programming">
                                    <a href="/testt/views/category/categoryDetail.jsp?category='프로그래밍'">프로그래밍 전체보기</a>
			                        <a href="/testt/views/category/categoryDetail.jsp?category='프로그래밍 이론'">프로그래밍 이론</a>
			                        <a href="/testt/views/category/categoryDetail.jsp?category='프로그래밍 언어'">프로그래밍 언어</a>
			                        <a href="/testt/views/category/categoryDetail.jsp?category='웹'">웹</a>
			                        <a href="/testt/views/category/categoryDetail.jsp?category='모바일'">모바일</a>
			                        <a href="/testt/views/category/categoryDetail.jsp?category='게임'">게임</a>
			                        <a href="/testt/views/category/categoryDetail.jsp?category='DB'">DB</a>
			                        <a href="/testt/views/category/categoryDetail.jsp?category='데이터과학'">데이터과학</a> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="gnb-search">
                    <form action="">
                        <input type="search" placeholder="검색" maxlength="30">
                        <button><i class="fas fa-search"></i></button>
                    </form>
                </div>
                <div class="gnb-unlogin-nav">
                <% if(loginUser == null){ %>
                	<ul class="unlogin-nav">
                        <li><button onclick="location.href='/testt/views/courseOpen/courseOpen.jsp'">강좌개설</button></li>
                        <li><button id="login-btn">로그인</button></li>
                        <li><button id="signup-btn">회원가입</button></li>
                    </ul>
                <% }else{ %>
                	<ul class="unlogin-nav">
                		<% if(loginUser.getTeacherNo() == 0){ %>
                        <li><button onclick="location.href='/testt/views/courseOpen/courseOpen.jsp'">강좌개설</button></li>
                        <% }else{ %>
                        <li><button onclick="location.href='/testt/views/teacherPage/teacherPageDetail.jsp'">강사</button></li>
                        <% } %>
                        <li><button onclick="location.href='/testt/mclist?userNo=<%= loginUser.getUserNo()%>">내강좌</button></li>
                        <li><button>장바구니</button></li>
                        <div class="mydrop">
                            <li><button><%= loginUser.getUserName() %></button></li>
                            <div class="mydrop-content">
                                <a href="/testt/views/mypage/UserUpdateView.jsp"><i class="fas fa-user-circle"></i>프로필</a>
                                <a href="/testt/views/mypage/MessageListView.jsp"><i class="far fa-envelope"></i>메시지</a>
                                <a href="#"><i class="far fa-credit-card"></i>결제내역</a>
                                <hr>
                                <a href="/testt/logout"><i class="fa fa-sign-out-alt"></i>로그아웃</a>
                            </div>
                        </div>
                        
                    </ul>
                <% } %>
                </div>        
            </div>
        </nav>
        <div id="enroll-form" class="modal-form">
            <div class="modal-form-content">
                <div class="form-nav">
                   <button id="login-tab" class="form-tab" onclick="changeTab('form-login', 'login-tab')">로그인</button>
                   <button id="signup-tab" class="form-tab" onclick="changeTab('form-signup', 'signup-tab')">회원가입</button>
                </div>

                <div class="form-content" id="form-login">
                    <button id="api-login"><img src="/testt/resources/img/google_logo.png" alt="">Google로 로그인</button>
                    <hr><p id="center-word">또는</p><hr>
                    
                    <form action="/testt/login.ed" method="post" id="login-form">
                        <p class="placeholder" id="login-email-placeholder">이메일</p>
                        <input type="text" id="login-email" name="uemail" autocomplete=off required>
                        <p class="guide" id="login-email-focus">등록한 이메일 주소를 입력해주세요</p>

                        <p class="placeholder" id="login-pwd-placeholder">비밀번호</p>
                        <input type="password" id="login-pwd" name="upwd" required>
                        <p class="guide" id="login-pwd-focus">6자 이상, 20자 미만으로 입력해주세요</p>

                        <button class="form-btn login-btn" type="submit">이메일로 로그인</button>
                    </form>
                    <a href="/testt/views/findpwd/findpwd.jsp">비밀번호를 잊어버렸어요.</a>
                </div>
                <div class="form-content" id="form-signup" style="display: none">
                    <form action="/testt/enroll.ed" method="post">
                        <p class="placeholder" id="email-placeholder">이메일</p>
                        <input type="text" name="uemail" id="signup-email" autocomplete=off required>
                        <p class="guide" id="email-focus">　</p>

                        <p class="placeholder" id="pwd-placeholder">비밀번호</p>
                        <input type="password" name="upwd" id="signup-pwd" required>
                        <p class="guide" id="pwd-focus">　</p>

                        <p class="placeholder" id="pwdchk-placeholder">비밀번호 확인</p>
                        <input type="password" id="signup-pwdchk" required>
                        <p class="guide" id="pwdchk-focus">　</p>

                        <p class="placeholder" id="name-placeholder">이름(실명)</p>
                        <input type="text" name="uname" id="signup-name" autocomplete=off required>
                        <p class="guide" id="name-focus">　</p>

                        <button class="form-btn enroll-btn" type="submit">이메일로 회원가입</button>
                        <p>회원가입 시, <a href="#">탈무브 이용약관</a>, <a href="#">개인정보 취급방침</a> 및 <a href="#">개인정보 3자 제공</a>에 동의하게 됩니다.</p>
                    </form>
                </div>
            </div>
        </div>
    </header>