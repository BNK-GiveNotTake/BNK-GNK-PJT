<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<style scoped>
		@import url("css/Main.css?ver=1");
	</style>
	<script>
		$(window).on('load', function() {
			$('#main').addClass('loaded');
		});
		
	</script>
</head>
<body>
	<div id="main">
		<div id="loader-wrapper">            
			<div id="loader"></div>
			<div class="loader-section section-left"></div>
			<div class="loader-section section-right"></div>
		</div>
	    <%@ include file="../Common/Nav.jsp" %>
	    
	    <div class="container pb-4" style="margin-top: 5rem;">
	    	<div class="row">
	            <div class="col-7 d-flex align-items-center">
	                <div class="about-text">
	                    <h5 class="small-text">환영합니다 정재호 고객님</h5>
	                    <h1 class="animated animated-text">
	                        <span class="mr-2">잔액 조회</span>
	                            <div class="animated-info">
	                                <span class="animated-item">연동 계좌 : 6,400,000원</span>
	                                <span class="animated-item">마일리지 : 500,000원</span>
	                            </div>
	                    </h1>
						<br>
	                    <p>Building a successful product is a challenge.</p>
	                    <p>I am highly energetic in user experience design, interfaces and web development.</p>
	                    <br><br>
	                    <div class="d-flex justify-content-around">
	                      <button class="btn-slide-line" style="width: 90%;">계좌 관리</button>
	                      <!-- <button class="btn-slide-line">마일리지 구매</button>
	                      <button class="btn-slide-line">마일리지 내역</button> -->
	                    </div>
	                </div>
	            </div>
				<br><br>
	            <div class="col-5">
	                <div class="about-image svg">
	                    <img src="img/undraw_software_engineer_lvl5.svg" class="img-fluid" alt="svg image">
	                </div>
	            </div>
	        </div>
	    </div>
	    <div class="container mileage-shop" style="margin-top: 5rem;">
       		<h3 class="mileage-h3">마일리지 구매</h3>
       		<div class="d-flex justify-content-around">
       			<figure class="snip1390">
					<button class="mileage-shopbtn">구매하기</button>
					<figcaption>
					    <h2>10,000원</h2>
					    <blockquote>Dad buried in landslide! Jubilant throngs fill streets! Stunned father inconsolable - demands recount!</blockquote>
				  	</figcaption>
				</figure>
				<figure class="snip1390 hover">
					<img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/331810/profile-sample5.jpg" alt="profile-sample5" class="profile" />
				  	<figcaption>
					    <h2>Gordon Norman</h2>
					    <h4>Accountant</h4>
					    <blockquote>Wormwood : Calvin, how about you? Calvin : Hard to say ma'am. I think my cerebellum has just fused. </blockquote>
				  	</figcaption>
				</figure>
				<figure class="snip1390">
					<img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/331810/profile-sample6.jpg" alt="profile-sample6" class="profile" />
					<figcaption>
					    <h2>Sue Shei</h2>
					    <h4>Public Relations</h4>
					    <blockquote>The strength to change what I can, the inability to accept what I can't and the incapacity to tell the difference.</blockquote>
				  	</figcaption>
				</figure>
				<figure class="snip1390">
					<img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/331810/profile-sample6.jpg" alt="profile-sample6" class="profile" />
					<figcaption>
					    <h2>Sue Shei</h2>
					    <h4>Public Relations</h4>
					    <blockquote>The strength to change what I can, the inability to accept what I can't and the incapacity to tell the difference.</blockquote>
				  	</figcaption>
				</figure>
       		</div>
       		
	    </div>
	    <div class="container mileage-history" style="margin-top: 5rem;">
	    </div>
	</div>
</body>
</html>