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
		@import url("css/Donation.css?ver=1");
	</style>
	<script>
		$(window).on('load', function() {
			$('#donation').addClass('loaded');
		});
		$(function() {
			$('.cards').on('click', 'screen__view_part', changeRecent())
		})
		
		function changeRecent() {
			var recentList = localStorage.getItem("recentList")
			if (recentList==null) {
				recentList = ["https://happybean-phinf.pstatic.net/20220819_67/1660868531689IgY4X_JPEG/메인이미지01jpg?type=w720"]
				recentList = JSON.stringify(recentList)
				localStorage.setItem("recentList", recentList)
			} else {
				recentList = JSON.parse(recentList)
				console.log(recentList.length)
				if (recentList.length == 3) {
					recentList.shift();
				}
				recentList.push("https://happybean-phinf.pstatic.net/20220819_67/1660868531689IgY4X_JPEG/메인이미지01jpg?type=w720");
				recentList = JSON.stringify(recentList)
				localStorage.removeItem("recentList")
				localStorage.setItem("recentList", recentList)
			}
			recentList = JSON.parse(recentList)
			$('.screen__view_part').empty()
			$.each(recentList, function(index, item) {
				$('.screen__view_part').append('<div class=recent-item><img src='+item+'></div>')
			})	
		}
		
	</script>
</head>
<body>
	<div id="donation">
		<div id="loader-wrapper">            
			<div id="loader"></div>
			<div class="loader-section section-left"></div>
			<div class="loader-section section-right"></div>
		</div>
		<%@ include file="../Common/Nav.jsp" %><br>
		<div class="row" style="width: 99vw;">
			<div class="col-10 row" style="border-right: 1px solid #c4c5c4; padding-left: 3rem; padding-right: 0rem;">
				<div class="donation-category">
					<button class="donation-btn">아동•청소년</button>
					<button class="donation-btn">어르신</button>
					<button class="donation-btn">장애인</button>
					<button class="donation-btn">다문화</button>
					<button class="donation-btn">지구촌</button>
					<button class="donation-btn">가족•여성</button>
					<button class="donation-btn">동물</button>
					<button class="donation-btn">환경</button>
				</div>
				
				<c:forEach var="i" begin="0" end="5">
					<section class="cards col-3 mb-5">
						<article class="card card--1">
						  <div class="card__img" style="background-image: url('<c:out value="https://happybean-phinf.pstatic.net/20220819_67/1660868531689IgY4X_JPEG/메인이미지01jpg?type=w720" />')"></div>
						  <a href="#" class="card_link">
						     <div class="card__img--hover" style="background-image: url('<c:out value="https://happybean-phinf.pstatic.net/20220819_67/1660868531689IgY4X_JPEG/메인이미지01jpg?type=w720" />')"></div>
						   </a>
						  <div class="card__info">
						    <h3 class="card__title">밥 한끼조차 챙기기 어려운 연아</h3>
						    <span class="card__by">
						    	<img class="card__logo" src="https://happybean-phinf.pstatic.net/20200116_34/1579150184219Bj6oe_JPEG/%C6%C4%BA%F1%C4%DC.jpg?type=w180">
						    	<a href="#" class="card__author" title="author">세이브더칠드런</a>
						    </span>
						    <div class="container-fluid">
							    <div class="Loading">
							    	<div
							    		class="Loading-after"
							    		style="width: <c:out value='70%' />;
							    		background-color:
							    			<c:if test="${i==0}"><c:out value="black" /></c:if>
							    			<c:if test="${i==1}"><c:out value="yellow" /></c:if>
							    			<c:if test="${i==2}"><c:out value="blue" /></c:if>
							    			<c:if test="${i==3}"><c:out value="crimson" /></c:if>
							    			<c:if test="${i==4}"><c:out value="pink" /></c:if>
							    			<c:if test="${i==5}"><c:out value="red" /></c:if>
							    		;"
							    	>
							    	</div>
							    </div>
							    
							    <span class="progress-span">70%</span>
							    <span>
							    	<c:if test="${i} = 0">aaaa</c:if>
							    </span>
							</div>
						  </div>
						</article>
						 
					</section>
				</c:forEach>
				
				<div class="mb-5 col-12">
					<ul class="pagination justify-content-center">
						<li><a href="#0">&lt;</a></li>
						<li><a class="active" href="#0">1</a></li>
						<li><a href="#0">2</a></li>
						<li><a href="#0">3</a></li>
						<li><a href="#0">4</a></li>
						<li><a href="#0">&gt;</a></li>
					</ul>
				</div>
			</div>
			<div class="col-2">
				<div class="recent">
					<div class="iphonex">
						<div class="front">
							<div class="screen">
								<div class="screen__view">
									<div style="pt-5">최근에 본 목록</div>
									<div class="screen__view_part">
									
									</div>
									<div style="margin-top: 0.5rem;">TOP</div>
								</div>
								<div class="screen__front">
									<div class="screen__front-speaker"></div>
									<div class="screen__front-camera"></div>
								</div>
							</div>
							<div class="front__line"></div>
							<div class="front__line front__line-second"></div>
						</div>
						<div class="phoneButtons phoneButtons-right"></div>
						<div class="phoneButtons phoneButtons-left"></div>
						<div class="phoneButtons phoneButtons-left2"></div>
						<div class="phoneButtons phoneButtons-left3"></div>
						<div class="back"></div>
					</div>
					<div align="center" class="recent-items">
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>