<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teacher.model.vo.Teacher" %>
<%
	Teacher loginTeacher = (Teacher)session.getAttribute("loginTeacher");
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>탈무브 | 강사페이지</title>
    <meta name="viewport" content="width:device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/testt/vendors/css/normalize.css">
    <link rel="stylesheet" href="/testt/vendors/css/bootstrap-grid.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/testt/resources/css/style.css">
    <link rel="stylesheet" href="/testt/resources/css/common/footer.css">
    <link rel="stylesheet" href="/testt/resources/css/common/gnb.css">
    <link rel="stylesheet" href="/testt/resources/css/queries.css">
    <link type="text/css" rel="stylesheet" href="css/common.css">
    <link type="text/css" rel="stylesheet" href="css/teacherIncomeDetail.css">
</head>

<body>
    <%@ include file="../common/gnb.jsp" %>
    <section class="section-top">
        <div class="row" id="pannel">
            <div id="pfpreview">
            	<% if(loginTeacher.getTeacherRimageName() != null){ %>
            	<img class="pfimg" src="/testt/resources/tprofile_upfiles/<%= loginTeacher.getTeacherRimageName() %>">
            	<% }else{ %>
                <img class="pfimg" src="../../resources/img/defaultUser.jpg">
                <% } %>
            </div>
            <h2 id="teacher-name"><span><%= loginTeacher.getTeacherName() %></span> 선생님 정보</h2>
        </div>
    </section>
    <section class="section-middle clearfix">
        <div class="left-side">
            <ul class="tmenu">
                <li><a href="teacherPageDetail.jsp">강사정보</a></li>
                <li><a href="/testt/gtcourse">강좌관리</a></li>
                <li><a href="teacherReferenceData.jsp">수강생정보</a></li>
                <li><a class="active-menu" href="teacherIncomeDetail.jsp">수익내역</a></li>
                <li><a href="teacherComment.jsp">댓글</a></li>
            </ul>
        </div>
        <div class="right-side">
            <h2>수익내역</h2>
            <div class="block">
                    <p>수익현황</p>
                    <div class="income-attr">
                        <p>미확정 수입</p>
                        <p>00000￦</p>
                        <div class="description">
                            환불이 가능한 수입이라
                            지급될 수 없는 수입입니다.
                            환불 가능 시간이 지나면
                            확정수입으로 변환됩니다.
                        </div>
                    </div>
                    <div class="symbols">+</div>
                    <div class="income-attr">
                        <p>확정 수입</p>
                        <p>00000￦</p>
                        <div class="description">
                            세금계산이 끝나지 않은 금액입니다.
                        </div>
                    </div>
                    <div class="symbols">=</div>
                    <div class="income-attr">
                        <p>예치금</p>
                        <p>00000￦</p>
                        <div class="description">
                            매 월 20일, 지정 계좌로 입금 될 금액입니다.
                        </div>
                    </div>
                </div>
                <form>
                <div class="block">
                    <p>등록 계좌</p>
                    <div id="bank-select">
                        <select name="bank" style="text-align: center;">
                            <option value='' selected>─은행 선택─</option>
                            <option value="신한은행">신한은행</option>
                            <option value="농협은행">농협은행 </option>
                            <option value="우리은행">우리은행</option>
                            <option value="KB국민은행">KB국민은행</option>
                            <option value="KEB하나은행">KEB하나은행 </option>
                            <option value="IBK기업은행"> IBK기업은행</option>
                            <option value="K뱅크">K뱅크</option>
                            <option value="카카오뱅크">카카오뱅크</option>
                        </select>
                    </div>
              
                        <div id="account">
                            <input type="text" placeholder=":  '-'를 제외한 계좌번호" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" />

                        </div>
                    <button id="save-btn" type="submit">SAVE</button>
                </div>
                </form>
                <div class="block">
                    <p>출금 내역</p>
                    <div id="withdraw">
                        <table cellspacing="0px" cellpadding="5px">
                            <tr>
                                <th>출금일시</th>
                                <th>출금액</th>
                                <th>출금 계좌</th>
                            </tr>
                            <tr>
                                <td>20190720</td>
                                <td>20000￦</td>
                                <td>110333******</td>
                            </tr>
                            <tr>
                                <td>20190820</td>
                                <td>20000￦</td>
                                <td>113222******</td>
                            </tr>
                            <tr>
                                <td>20180920</td>
                                <td>20000￦</td>
                                <td>123733******</td>
                            </tr>
                        </table>
                    </div>
                </div>
            
            
        </div>
    </section>
    <%@ include file="../common/footer.jsp" %>
</body>

</html>