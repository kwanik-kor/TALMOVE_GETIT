/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.43
 * Generated at: 2019-09-16 17:28:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.typeOfService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import user.model.vo.User;

public final class tos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/typeOfService/../common/footer.jsp", Long.valueOf(1568176001819L));
    _jspx_dependants.put("/views/typeOfService/../common/gnb.jsp", Long.valueOf(1568653623588L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("user.model.vo.User");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width:device-width, initial-scale=1.0\">\r\n");
      out.write("    \r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/testt/vendors/css/normalize.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/testt/vendors/css/bootstrap-grid.css\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/testt/resources/css/style.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/testt/resources/css/common/footer.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/testt/resources/css/common/gnb.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/testt/resources/css/queries.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/testt/views/typeOfService/tos.css\">\r\n");
      out.write("\t<title>탈무브 | 당신의 재능을 공유해주세요</title>\r\n");
      out.write("\t<script src=\"https://kit.fontawesome.com/08d0951667.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");

	User loginUser = (User)session.getAttribute("loginUser");
	String message = (String)session.getAttribute("message");
	if(message != null){

      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">alert(\"");
      out.print( message );
      out.write("\")</script>\r\n");

	session.removeAttribute("message");}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<header>\r\n");
      out.write("        <nav>\r\n");
      out.write("           <div id=\"menuToggle\">\r\n");
      out.write("                <input type=\"checkbox\" id=\"togglechk\">\r\n");
      out.write("                <div class=\"toggle-back\"></div>\r\n");
      out.write("                <span></span>\r\n");
      out.write("                <span></span>\r\n");
      out.write("                <span></span>\r\n");
      out.write("\r\n");
      out.write("                <ul id=\"menu\">\r\n");
      out.write("                \t");
 if(loginUser == null){ 
      out.write("\r\n");
      out.write("                    <a href=\"/testt/views/loginEnroll/login.jsp\"><li>로그인</li></a>\r\n");
      out.write("                    <a href=\"#\"><li>회원가입</li></a>\r\n");
      out.write("                    <a href=\"/testt/views/courseOpen/courseOpen.jsp\"><li>강좌개설</li></a>\r\n");
      out.write("                    ");
 }else{ 
      out.write("\r\n");
      out.write("                    <a href=\"/testt/views/mypage/UserUpdateView.jsp\"><li>");
      out.print( loginUser.getUserName() );
      out.write("</li></a>\r\n");
      out.write("                    <a href=\"/testt/views/myCourse/myCourse.jsp\"><li>내강좌</li></a>\r\n");
      out.write("                    <a href=\"#\"><li>장바구니</li></a>\r\n");
      out.write("                    <a href=\"/testt/views/courseOpen/courseOpen.jsp\"><li>강좌개설</li></a>\r\n");
      out.write("                    <a href=\"/testt/logout\"><li>로그아웃</li></a>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("                    <hr>\r\n");
      out.write("                    <li>카테고리</li>\r\n");
      out.write("                    <a onclick=\"setTimeout(toggleList('business'),200);\"><li>비즈니스<i id=\"business-list\" class=\"fa fa-chevron-down list-down\"></i></li></a>\r\n");
      out.write("                    <ul class=\"toggle-business\">\r\n");
      out.write("                        <a href=\"/testt/views/category/categoryDetail.jsp?category='비즈니스'\"><li>비즈니스 전체보기</li></a>\r\n");
      out.write("                        <a href=\"/testt/views/category/categoryDetail.jsp?category='커뮤니케이션'\"><li>커뮤니케이션</li></a>\r\n");
      out.write("                        <a href=\"/testt/views/category/categoryDetail.jsp?category='경영'\"><li>경영</li></a>\r\n");
      out.write("                        <a href=\"/testt/views/category/categoryDetail.jsp?category='판매'\"><li>판매</li></a>\r\n");
      out.write("                        <a href=\"/testt/views/category/categoryDetail.jsp?category='전략'\"><li>전략</li></a>\r\n");
      out.write("                        <a href=\"/testt/views/category/categoryDetail.jsp?category='운영'\"><li>운영</li></a>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                    <a onclick=\"toggleList('programming');\"><li>프로그래밍<i id =\"programming-list\" class=\"fa fa-chevron-down list-down\"></i></li></a>\r\n");
      out.write("                    <ul class=\"toggle-programming\">\r\n");
      out.write("                        <a href=\"/testt/views/category/categoryDetail.jsp?category='프로그래밍'\"><li>프로그래밍 전체보기</li></a>\r\n");
      out.write("                        <a href=\"/testt/views/category/categoryDetail.jsp?category='프로그래밍 이론'\"><li>프로그래밍 이론</li></a>\r\n");
      out.write("                        <a href=\"/testt/views/category/categoryDetail.jsp?category='프로그래밍 언어'\"><li>프로그래밍 언어</li></a>\r\n");
      out.write("                        <a href=\"/testt/views/category/categoryDetail.jsp?category='웹'\"><li>웹</li></a>\r\n");
      out.write("                        <a href=\"/testt/views/category/categoryDetail.jsp?category='모바일'\"><li>모바일</li></a>\r\n");
      out.write("                        <a href=\"/testt/views/category/categoryDetail.jsp?category='게임'\"><li>게임</li></a>\r\n");
      out.write("                        <a href=\"/testt/views/category/categoryDetail.jsp?category='DB'\"><li>DB</li></a>\r\n");
      out.write("                        <a href=\"/testt/views/category/categoryDetail.jsp?category='데이터과학'\"><li>데이터과학</li></a>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"gnb-logo\">\r\n");
      out.write("                    <p class=\"logo-text\"><a href=\"/testt/index.jsp\">TALMOVE</a></p>\r\n");
      out.write("                    <div class=\"dropdown\">\r\n");
      out.write("                        <p class=\"category dropbtn\">카테고리</p>\r\n");
      out.write("                        <div class=\"dropdown-content\">\r\n");
      out.write("                            <a id=\"business\" href=\"#\">비즈니스</a>\r\n");
      out.write("                            <a id=\"programming\" href=\"#\">프로그래밍</a>\r\n");
      out.write("                            <div class=\"dropdown-contentSub\">\r\n");
      out.write("                                <div class=\"is-visible drop-business\">\r\n");
      out.write("                                    <a href=\"/testt/views/category/categoryDetail.jsp?category='비즈니스'\">비즈니스 전체보기</a>\r\n");
      out.write("\t\t\t                        <a href=\"/testt/views/category/categoryDetail.jsp?category='커뮤니케이션'\">커뮤니케이션</a>\r\n");
      out.write("\t\t\t                        <a href=\"/testt/views/category/categoryDetail.jsp?category='경영'\">경영</a>\r\n");
      out.write("\t\t\t                        <a href=\"/testt/views/category/categoryDetail.jsp?category='판매'\">판매</a>\r\n");
      out.write("\t\t\t                        <a href=\"/testt/views/category/categoryDetail.jsp?category='전략'\">전략</a>\r\n");
      out.write("\t\t\t                        <a href=\"/testt/views/category/categoryDetail.jsp?category='운영'\">운영</a>    \r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"drop-programming\">\r\n");
      out.write("                                    <a href=\"/testt/views/category/categoryDetail.jsp?category='프로그래밍'\">프로그래밍 전체보기</a>\r\n");
      out.write("\t\t\t                        <a href=\"/testt/views/category/categoryDetail.jsp?category='프로그래밍 이론'\">프로그래밍 이론</a>\r\n");
      out.write("\t\t\t                        <a href=\"/testt/views/category/categoryDetail.jsp?category='프로그래밍 언어'\">프로그래밍 언어</a>\r\n");
      out.write("\t\t\t                        <a href=\"/testt/views/category/categoryDetail.jsp?category='웹'\">웹</a>\r\n");
      out.write("\t\t\t                        <a href=\"/testt/views/category/categoryDetail.jsp?category='모바일'\">모바일</a>\r\n");
      out.write("\t\t\t                        <a href=\"/testt/views/category/categoryDetail.jsp?category='게임'\">게임</a>\r\n");
      out.write("\t\t\t                        <a href=\"/testt/views/category/categoryDetail.jsp?category='DB'\">DB</a>\r\n");
      out.write("\t\t\t                        <a href=\"/testt/views/category/categoryDetail.jsp?category='데이터과학'\">데이터과학</a> \r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"gnb-search\">\r\n");
      out.write("                    <form action=\"\">\r\n");
      out.write("                        <input type=\"search\" placeholder=\"검색\" maxlength=\"30\">\r\n");
      out.write("                        <button><i class=\"fas fa-search\"></i></button>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"gnb-unlogin-nav\">\r\n");
      out.write("                ");
 if(loginUser == null){ 
      out.write("\r\n");
      out.write("                \t<ul class=\"unlogin-nav\">\r\n");
      out.write("                        <li><button onclick=\"location.href='/testt/views/courseOpen/courseOpen.jsp'\">강좌개설</button></li>\r\n");
      out.write("                        <li><button id=\"login-btn\">로그인</button></li>\r\n");
      out.write("                        <li><button id=\"signup-btn\">회원가입</button></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                ");
 }else{ 
      out.write("\r\n");
      out.write("                \t<ul class=\"unlogin-nav\">\r\n");
      out.write("                        <li><button onclick=\"location.href='/testt/views/courseOpen/courseOpen.jsp'\">강좌개설</button></li>\r\n");
      out.write("                        <li><button onclick=\"location.href='/testt/views/myCourse/myCourse.jsp'\">내강좌</button></li>\r\n");
      out.write("                        <li><button>장바구니</button></li>\r\n");
      out.write("                        <div class=\"mydrop\">\r\n");
      out.write("                            <li><button>");
      out.print( loginUser.getUserName() );
      out.write("</button></li>\r\n");
      out.write("                            <div class=\"mydrop-content\">\r\n");
      out.write("                                <a href=\"/testt/views/mypage/UserUpdateView.jsp\"><i class=\"fas fa-user-circle\"></i>프로필</a>\r\n");
      out.write("                                <a href=\"/testt/views/mypage/MessageListView.jsp\"><i class=\"far fa-envelope\"></i>메시지</a>\r\n");
      out.write("                                <a href=\"#\"><i class=\"far fa-credit-card\"></i>결제내역</a>\r\n");
      out.write("                                <hr>\r\n");
      out.write("                                <a href=\"/testt/logout\"><i class=\"fa fa-sign-out-alt\"></i>로그아웃</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        \r\n");
      out.write("                    </ul>\r\n");
      out.write("                ");
 } 
      out.write("\r\n");
      out.write("                </div>        \r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <div id=\"enroll-form\" class=\"modal-form\">\r\n");
      out.write("            <div class=\"modal-form-content\">\r\n");
      out.write("                <div class=\"form-nav\">\r\n");
      out.write("                   <button id=\"login-tab\" class=\"form-tab\" onclick=\"changeTab('form-login', 'login-tab')\">로그인</button>\r\n");
      out.write("                   <button id=\"signup-tab\" class=\"form-tab\" onclick=\"changeTab('form-signup', 'signup-tab')\">회원가입</button>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"form-content\" id=\"form-login\">\r\n");
      out.write("                    <button id=\"api-login\"><img src=\"/testt/resources/img/google_logo.png\" alt=\"\">Google로 로그인</button>\r\n");
      out.write("                    <hr><p id=\"center-word\">또는</p><hr>\r\n");
      out.write("                    \r\n");
      out.write("                    <form action=\"/testt/login.ed\" method=\"post\" id=\"login-form\">\r\n");
      out.write("                        <p class=\"placeholder\" id=\"login-email-placeholder\">이메일</p>\r\n");
      out.write("                        <input type=\"text\" id=\"login-email\" name=\"uemail\" autocomplete=off required>\r\n");
      out.write("                        <p class=\"guide\" id=\"login-email-focus\">등록한 이메일 주소를 입력해주세요</p>\r\n");
      out.write("\r\n");
      out.write("                        <p class=\"placeholder\" id=\"login-pwd-placeholder\">비밀번호</p>\r\n");
      out.write("                        <input type=\"password\" id=\"login-pwd\" name=\"upwd\" required>\r\n");
      out.write("                        <p class=\"guide\" id=\"login-pwd-focus\">6자 이상, 20자 미만으로 입력해주세요</p>\r\n");
      out.write("\r\n");
      out.write("                        <button class=\"form-btn login-btn\" type=\"submit\">이메일로 로그인</button>\r\n");
      out.write("                    </form>\r\n");
      out.write("                    <a href=\"/testt/views/findpwd/findpwd.jsp\">비밀번호를 잊어버렸어요.</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"form-content\" id=\"form-signup\" style=\"display: none\">\r\n");
      out.write("                    <form action=\"/testt/enroll.ed\" method=\"post\">\r\n");
      out.write("                        <p class=\"placeholder\" id=\"email-placeholder\">이메일</p>\r\n");
      out.write("                        <input type=\"text\" name=\"uemail\" id=\"signup-email\" autocomplete=off required>\r\n");
      out.write("                        <p class=\"guide\" id=\"email-focus\">　</p>\r\n");
      out.write("\r\n");
      out.write("                        <p class=\"placeholder\" id=\"pwd-placeholder\">비밀번호</p>\r\n");
      out.write("                        <input type=\"password\" name=\"upwd\" id=\"signup-pwd\" required>\r\n");
      out.write("                        <p class=\"guide\" id=\"pwd-focus\">　</p>\r\n");
      out.write("\r\n");
      out.write("                        <p class=\"placeholder\" id=\"pwdchk-placeholder\">비밀번호 확인</p>\r\n");
      out.write("                        <input type=\"password\" id=\"signup-pwdchk\" required>\r\n");
      out.write("                        <p class=\"guide\" id=\"pwdchk-focus\">　</p>\r\n");
      out.write("\r\n");
      out.write("                        <p class=\"placeholder\" id=\"name-placeholder\">이름(실명)</p>\r\n");
      out.write("                        <input type=\"text\" name=\"uname\" id=\"signup-name\" autocomplete=off required>\r\n");
      out.write("                        <p class=\"guide\" id=\"name-focus\">　</p>\r\n");
      out.write("\r\n");
      out.write("                        <button class=\"form-btn enroll-btn\" type=\"submit\">이메일로 회원가입</button>\r\n");
      out.write("                        <p>회원가입 시, <a href=\"#\">탈무브 이용약관</a>, <a href=\"#\">개인정보 취급방침</a> 및 <a href=\"#\">개인정보 3자 제공</a>에 동의하게 됩니다.</p>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </header>");
      out.write("\r\n");
      out.write("\t<section class=\"section-tos\">\r\n");
      out.write("\t\t<div class=\"tos-top\">\r\n");
      out.write("\t\t    <p><span>");
      out.print( loginUser.getUserName() );
      out.write("</span> 님의 새로운 수업</p>\r\n");
      out.write("\t\t    <p>당신의 재능을 나눠보세요!</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"tos-content\">\r\n");
      out.write("\t\t    <div class=\"tos-content-top\">\r\n");
      out.write("\t\t        <h2>TALMOVE 강사 이용약관</h2>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t    <div class=\"tos-content-middle\">\r\n");
      out.write("\t\t        <div class=\"tos-title\">\r\n");
      out.write("\t\t            <input type=\"checkbox\" id=\"usingContents\">\r\n");
      out.write("\t\t            <label for=\"usingContents\">컨텐츠 이용에 대한 건</label>\r\n");
      out.write("\t\t            <i class=\"fas fa-chevron-down\"></i>\r\n");
      out.write("\t\t            <div class=\"tos-details details-0\">\r\n");
      out.write("\t\t                <p>콘텐츠 삭제 또는 가용성. 유료 서비스 내에서 이용할 수 있는 콘텐츠가 동 콘텐츠를 당사에 라이센스하여 주는 파트너가 부과한 제한, 또는 기타 법적 또는 정책상의 이유로 이용할 수 없게 될 수 있습니다.<br><br>TalMove는 그렇게 이용할 수 없게 된 것에 대하여 사용자에게 아무런 책임을 부담하지 않습니다. 비디오 대여 및 구매의 경우, 사용자의 대여 기간 또는 콘텐츠를 구매한 날로부터 처음 1년 동안에 이용할 수 없게 되는 경우, 사용자는 구매가의 환불을 요청하거나, 이용할 수 없게 된 대여 또는 구매 콘텐츠에 대하여 합리적인 대체물을 요청할 수 있습니다.</p>\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t\t        <div class=\"tos-title\">\r\n");
      out.write("\t\t            <input type=\"checkbox\" id=\"sellContents\">\r\n");
      out.write("\t\t            <label for=\"sellContents\">TALMOVE의 컨텐츠 접속판매의 건</label>\r\n");
      out.write("\t\t            <i class=\"fas fa-chevron-down\"></i>\r\n");
      out.write("\t\t            <div class=\"tos-details details-1\">\r\n");
      out.write("\t\t                <p>귀하는 TalMove의 사전 서면 승인을 얻은 경우를 제외하고 이하에 기재된 상업적 목적을 위하여 본 서비스를 이용하지 않을 것에 동의합니다<br><br>본 서비스에 대한 접속 판매<br>본 서비스 또는 콘텐츠 상에서 또는 그 안에 게시(placed)된 광고, 후원 또는 선전의 판매, 또는 본 서비스를 통하여 제공된 콘텐츠를 포함하는 광고가 가능한 블로그 또는 웹사이트의 페이지 상의 광고, 후원 또는 선전의 판매. 단, TalMove에서 획득하지 않은 다른 자료가 해당 페이지에 나타나고 위와 같은 판매의 근거로서 충분한 가치가 있는 경우는 제외합니다.</p>\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t\t        <div class=\"tos-title\">\r\n");
      out.write("\t\t            <input type=\"checkbox\" id=\"cantService\">\r\n");
      out.write("\t\t            <label for=\"cantService\">유료서비스 제공 불능에 대한 건</label>\r\n");
      out.write("\t\t            <i class=\"fas fa-chevron-down\"></i>\r\n");
      out.write("\t\t            <div class=\"tos-details details-2\">\r\n");
      out.write("\t\t               <p>귀하는 TalMove의 사전 서면 승인 없이는 본 서비스 또는 콘텐츠의 어느 부분이라도 그리고 이를 어떤 매체로도 배포하지 않을 것에 동의합니다. 단, TalMove가 본 서비스에서 제공된 기능(예를 들어, Embeddable Player)을 통하여 그러한 배포를 위한 수단을 제공하는 경우는 제외합니다.</p>\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t\t        <div class=\"tos-title\">\r\n");
      out.write("\t\t            <input type=\"checkbox\" id=\"outContents\">\r\n");
      out.write("\t\t            <label for=\"outContents\">컨텐츠의 임의 방출에 대한 건</label>\r\n");
      out.write("\t\t            <i class=\"fas fa-chevron-down\"></i>\r\n");
      out.write("\t\t            <div class=\"tos-details details-3\">\r\n");
      out.write("\t\t               <p>귀하는 TalMove의 사전 서면 승인 없이는 본 서비스 또는 콘텐츠의 어느 부분이라도 그리고 이를 어떤 매체로도 배포하지 않을 것에 동의합니다. 단, TalMove가 본 서비스에서 제공된 기능(예를 들어, Embeddable Player)을 통하여 그러한 배포를 위한 수단을 제공하는 경우는 제외합니다.</p>\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t\t        <input id=\"agreeAll\" type=\"checkbox\"><label for=\"agreeAll\">전체 약관에 동의합니다.</label>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t    <div class=\"tos-content-bottom\">\r\n");
      out.write("\t\t        <p>상단의 내용을 모두 확인하였습니다.</p>\r\n");
      out.write("\t\t        <button class=\"to-nextBtn\">다음으로.</button>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\t<footer>\r\n");
      out.write("\t    <div class=\"footer-container pt-2\">\r\n");
      out.write("\t        <div class=\"row footer-top\">\r\n");
      out.write("\t            <div class=\"col-12 col-md-6 footer-top-left\">\r\n");
      out.write("\t                <p class=\"logo-text\">TALMOVE</p>\r\n");
      out.write("\t            </div>\r\n");
      out.write("\t            <div class=\"col-6 col-md-6 footer-top-right\">\r\n");
      out.write("\t                <ul class=\"footer-nav mt-3\">\r\n");
      out.write("\t                    <li><a href=\"#\">회사소개</a></li>\r\n");
      out.write("\t                    <li><a href=\"#\">이용약관</a></li>\r\n");
      out.write("\t                    <li><a href=\"#\">개인정보처리방침</a></li>\r\n");
      out.write("\t                </ul>\r\n");
      out.write("\t            </div>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        <div class=\"row footer-middle mt-4\">\r\n");
      out.write("\t            <p class=\"col-sm-12\">서울특별시 강남구 테헤란로 14길 6 남도빌딩 2층, 3층, 4층<br>010-1234-5678</p>\r\n");
      out.write("\t            \r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        <div class=\"row footer-bottom\">\r\n");
      out.write("\t            <p class=\"col-sm-12\">Copyright &copy; 2019 by TALMOVE. All rights reserved.</p>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t</footer>\r\n");
      out.write("    \r\n");
      out.write("    <button onclick=\"setTimeout(topFunction(), 200);\" id=\"topBtn\" title=\"Go to Top\"><i class=\"fas fa-chevron-up\"></i></button>");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/testt/vendors/js/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/testt/resources/js/main.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/testt/views/typeOfService/tos.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
