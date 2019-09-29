<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width:device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="vendors/css/normalize.css">
    <link rel="stylesheet" href="vendors/css/bootstrap-grid.css">
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/common/gnb.css">
    <link rel="stylesheet" href="resources/css/common/footer.css">
    <link rel="stylesheet" href="resources/css/queries.css">
    <link rel="shortcut icon" type="image/x-icon" href="/testt/resources/img/titlelogo.png">
    <title>탈무브 | 당신의 재능을 공유해주세요</title>
    <script src="https://kit.fontawesome.com/08d0951667.js"></script>
</head>
<body>
    <%@ include file="views/common/gnb.jsp" %>
    
    <div class="carousel">
        <div class="carousel-inner">
            <input class="carousel-open" type="radio" id="carousel-1" name="carousel" aria-hidden="true" hidden="" checked="checked">
            <div class="carousel-item">
                <img src="resources/img/carousel_1.jpg">
            </div>
            <input class="carousel-open" type="radio" id="carousel-2" name="carousel" aria-hidden="true" hidden="">
            <div class="carousel-item">
                <img src="resources/img/carousel_2.jpg">
            </div>
            <input class="carousel-open" type="radio" id="carousel-3" name="carousel" aria-hidden="true" hidden="">
            <div class="carousel-item">
                <img src="resources/img/carousel_3.jpg">
            </div>
            <label for="carousel-3" class="carousel-control prev control-1">‹</label>
            <label for="carousel-2" class="carousel-control next control-1">›</label>
            <label for="carousel-1" class="carousel-control prev control-2">‹</label>
            <label for="carousel-3" class="carousel-control next control-2">›</label>
            <label for="carousel-2" class="carousel-control prev control-3">‹</label>
            <label for="carousel-1" class="carousel-control next control-3">›</label>
            <ol class="carousel-indicators">
                <li>
                    <label for="carousel-1" class="carousel-bullet">•</label>
                </li>
                <li>
                    <label for="carousel-2" class="carousel-bullet">•</label>
                </li>
                <li>
                    <label for="carousel-3" class="carousel-bullet">•</label>
                </li>
            </ol>
        </div>
    </div>
    
    <section class="card-section">
        <div class="container">
            <div class="row mt-3">
                <h2><span class="card-category-sbj">프로그래밍</span> 분야의 인기 강좌</h2>
            </div>
            <div class="row">
                <div class="col-sm lecture-main">
                    <a href="#"><img class="thumbnail" src="resources/img/sample%20thumbnail.jpg" alt=""></a>
                    <div class="row lecture-header">
                       <h4>Java 기초부터 심화까지<br><br></h4>
                       <span>By 이학열</span>
                    </div>
                    <div class="row lecture-footer">
                        <span class="starpoint">★☆☆☆☆</span>
                        <span class="point">1.0(12)</span>
                        <span class="price">￦14,000</span>
                    </div>
                </div>
                <div class="col-sm lecture-main">
                    <a href="#"><img class="thumbnail" src="resources/img/sample_thumbnail2.jpg" alt=""></a>
                    <div class="row lecture-header">
                       <h4>1시간 만에 사이트 만들기<br><br></h4>
                       <span>By 허태규</span>
                    </div>
                    <div class="row lecture-footer">
                        <span class="starpoint">★☆☆☆☆</span>
                        <span class="point">1.0(12)</span>
                        <span class="price">￦14,000</span>
                    </div>
                </div>
                <div class="col-sm lecture-main">
                    <a href="#"><img class="thumbnail" src="resources/img/sample_thumbnail3.jpg" alt=""></a>
                    <div class="row lecture-header">
                       <h4>10분만에 웹페이지 선물하기<br><br></h4>
                       <span>By 박건우</span>
                    </div>
                    <div class="row lecture-footer">
                        <span class="starpoint">★☆☆☆☆</span>
                        <span class="point">1.0(12)</span>
                        <span class="price">￦14,000</span>
                    </div>
                </div>
                <div class="col-sm lecture-main">
                    <a href="#"><img class="thumbnail" src="resources/img/sample_thumbnail4.jpg" alt=""></a>
                    <div class="row lecture-header">
                       <h4>모두를 위한 딥러닝 - Reinforcement Learning</h4>
                       <span>By JiWoo Hwang</span>
                    </div>
                    <div class="row lecture-footer">
                        <span class="starpoint">★☆☆☆☆</span>
                        <span class="point">1.0(12)</span>
                        <span class="price">￦14,000</span>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="container">
            <div class="row mt-3">
                <h2><span class="card-category-sbj">금융</span> 분야의 신규 강좌</h2>
            </div>
            <div class="row">
                <div class="col-sm lecture-main">
                    <a href="#"><img class="thumbnail" src="resources/img/sample%20thumbnail.jpg" alt=""></a>
                    <div class="row lecture-header">
                       <h4>쉽게 배우는 해운 시황의 이해</h4>
                       <span>By 이학열</span>
                    </div>
                    <div class="row lecture-footer">
                        <span class="starpoint">★☆☆☆☆</span>
                        <span class="point">1.0(12)</span>
                        <span class="price">￦14,000</span>
                    </div>
                </div>
                <div class="col-sm lecture-main">
                    <a href="#"><img class="thumbnail" src="resources/img/sample%20thumbnail.jpg" alt=""></a>
                    <div class="row lecture-header">
                       <h4>쉽게 배우는 해운 시황의 이해</h4>
                       <span>By 이학열</span>
                    </div>
                    <div class="row lecture-footer">
                        <span class="starpoint">★☆☆☆☆</span>
                        <span class="point">1.0(12)</span>
                        <span class="price">￦14,000</span>
                    </div>
                </div>
                <div class="col-sm lecture-main">
                    <a href="#"><img class="thumbnail" src="resources/img/sample%20thumbnail.jpg" alt=""></a>
                    <div class="row lecture-header">
                       <h4>쉽게 배우는 해운 시황의 이해</h4>
                       <span>By 이학열</span>
                    </div>
                    <div class="row lecture-footer">
                        <span class="starpoint">★☆☆☆☆</span>
                        <span class="point">1.0(12)</span>
                        <span class="price">￦14,000</span>
                    </div>
                </div>
                <div class="col-sm lecture-main">
                    <a href="#"><img class="thumbnail" src="resources/img/sample%20thumbnail.jpg" alt=""></a>
                    <div class="row lecture-header">
                       <h4>쉽게 배우는 해운 시황의 이해</h4>
                       <span>By 이학열</span>
                    </div>
                    <div class="row lecture-footer">
                        <span class="starpoint">★☆☆☆☆</span>
                        <span class="point">1.0(12)</span>
                        <span class="price">￦14,000</span>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="container">
            <div class="row mt-3">
                <h2><span class="card-category-sbj">금융</span> 분야의 최근 수강된 강좌</h2>
            </div>
            <div class="row">
                <div class="col-sm lecture-main">
                    <a href="#"><img class="thumbnail" src="resources/img/sample%20thumbnail.jpg" alt=""></a>
                    <div class="row lecture-header">
                       <h4>쉽게 배우는 해운 시황의 이해</h4>
                       <span>By 이학열</span>
                    </div>
                    <div class="row lecture-footer">
                        <span class="starpoint">★☆☆☆☆</span>
                        <span class="point">1.0(12)</span>
                        <span class="price">￦14,000</span>
                    </div>
                </div>
                <div class="col-sm lecture-main">
                    <a href="#"><img class="thumbnail" src="resources/img/sample%20thumbnail.jpg" alt=""></a>
                    <div class="row lecture-header">
                       <h4>쉽게 배우는 해운 시황의 이해</h4>
                       <span>By 이학열</span>
                    </div>
                    <div class="row lecture-footer">
                        <span class="starpoint">★☆☆☆☆</span>
                        <span class="point">1.0(12)</span>
                        <span class="price">￦14,000</span>
                    </div>
                </div>
                <div class="col-sm lecture-main">
                    <a href="#"><img class="thumbnail" src="resources/img/sample%20thumbnail.jpg" alt=""></a>
                    <div class="row lecture-header">
                       <h4>쉽게 배우는 해운 시황의 이해</h4>
                       <span>By 이학열</span>
                    </div>
                    <div class="row lecture-footer">
                        <span class="starpoint">★☆☆☆☆</span>
                        <span class="point">1.0(12)</span>
                        <span class="price">￦14,000</span>
                    </div>
                </div>
                <div class="col-sm lecture-main">
                    <a href="#"><img class="thumbnail" src="resources/img/sample%20thumbnail.jpg" alt=""></a>
                    <div class="row lecture-header">
                       <h4>쉽게 배우는 해운 시황의 이해</h4>
                       <span>By 이학열</span>
                    </div>
                    <div class="row lecture-footer">
                        <span class="starpoint">★☆☆☆☆</span>
                        <span class="point">1.0(12)</span>
                        <span class="price">￦14,000</span>
                    </div>
                </div>
            </div>
        </div>
	</section>
	
	<section class="section-interview">
        <div class="row">
            <h2>수강생 인터뷰</h2>
        </div>
        <div class="row">
            <div class="col-sm">
                <blockquote>
                    탈무브를 통해 저의 새로운 적성을 탐색하는데 도움을 받을 수 있었습니다. 또 다른 강좌가 개설된다면 기꺼이 수강할 의향이 있습니다! 항상 노력하는 강사분과 탈무브에 감사합니다!
                    <cite><img src="resources/img/customer-1.jpg">Lee Hack Yeol</cite>
                </blockquote>
            </div>
            <div class="col-sm">
                <blockquote>
                    유튜브에서 보던 유사 콘텐츠들보다 더 자세하고 체계적으로 설명해주셔서 따라가기 좋았어요. 단순한 기능 따라 하기가 아니라 적절한 비유에 따른 설명으로 이해가 너무 수월했습니다!
                    <cite><img src="resources/img/customer-2.jpg">Hwang Ji Woo</cite>
                </blockquote>
            </div>
            <div class="col-sm">
                <blockquote>
                    마흔 중반이 넘어서야 경제와 주식 공부를 하고 있습니다. 저 같은 사람에게는 사막의 오아시스와 같은 단비가 되는 것 같습니다. 이렇게 좋은 강의 기획 해주신 강사분들에게 감사를 표합니다.
                    <cite><img src="resources/img/customer-3.jpg">Michael Cho</cite>
                </blockquote>
            </div>
        </div>
	</section>
	
	<%@ include file="views/common/footer.jsp" %>
	
    <script type="text/javascript" src="vendors/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="resources/js/main.js"></script>
</body>
</html>