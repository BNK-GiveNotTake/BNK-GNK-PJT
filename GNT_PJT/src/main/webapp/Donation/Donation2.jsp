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
		
		var page = 1
		var Donation = {}
		
		$(function() {
			
			
			$('.next-page').click(function() {
				getDonationPage()
			})
			
			/* $('.cards').on('click', '.card__img--hover', changeRecent()); */
			$('.card__img').click(changeRecent());
			
			var delay = 500;
			$('.top-btn').click(function() {
				$('html, body').stop().animate({scrollTop: 0}, delay);
			})
			
			$('#all').click(function() {
				removeSelected();
				$(this).addClass('selected')
				$('.next-page').css('display', 'block')
				getDonationBasic()
			})
			$('#child').click(function() {
				removeSelected();
				$(this).addClass('selected')
				$('.next-page').css('display', 'none')
				getDonationCategory(1)
			})
			$('#old').click(function() {
				removeSelected();
				$(this).addClass('selected')
				$('.next-page').css('display', 'none')
				getDonationCategory(2)
			})
			$('#disabled').click(function() {
				removeSelected();
				$(this).addClass('selected')
				$('.next-page').css('display', 'none')
				getDonationCategory(3)
			})
			$('#multiculture').click(function() {
				removeSelected();
				$(this).addClass('selected')
				$('.next-page').css('display', 'none')
				getDonationCategory(4)
			})
			$('#global').click(function() {
				removeSelected();
				$(this).addClass('selected')
				$('.next-page').css('display', 'none')
				getDonationCategory(5)
			})
			$('#family').click(function() {
				removeSelected();
				$(this).addClass('selected')
				$('.next-page').css('display', 'none')
				getDonationCategory(6)
			})
			$('#animal').click(function() {
				removeSelected();
				$(this).addClass('selected')
				$('.next-page').css('display', 'none')
				getDonationCategory(7)
			})
			$('#environ').click(function() {
				removeSelected();
				$(this).addClass('selected')
				$('.next-page').css('display', 'none')
				getDonationCategory(8)
			})
		})
		
		const removeSelected = function() {
			var btnList = $('.donation-btn')
			btnList.removeClass('selected')
		}
		
		const changeRecent = function() {
			console.log("실행되나????")
			var recentList = localStorage.getItem("recentList")
			if (recentList==null) {
				recentList = ["https://happybean-phinf.pstatic.net/20220819_67/1660868531689IgY4X_JPEG/메인이미지01jpg?type=w720"]
				recentList = JSON.stringify(recentList)
				localStorage.setItem("recentList", recentList)
			} else {
				recentList = JSON.parse(recentList)
				if (recentList.length == 3) {
					recentList.shift();
				}
				recentList.push("https://happybean-phinf.pstatic.net/20220819_67/1660868531689IgY4X_JPEG/메인이미지01jpg?type=w720");
				recentList = JSON.stringify(recentList)
				localStorage.removeItem("recentList")
				localStorage.setItem("recentList", recentList)
			}
			recentList = JSON.parse(recentList)
			$('.recent-items').empty()
			$.each(recentList, function(index, item) {
				$('.recent-items').append('<div class=recent-item><img src='+item+'></div>')
			})	
		}
		
		function getDonationBasic() {
			$.ajax({
				type: 'get',
				url: '../DonationAsk.do',
				data: {},
				success: function(res) {
					Donation = res.Donation
					console.log(Donation)
					/* $('.donation-list').append(
						'<section class="cards col-3 mb-5">' +
							'<article class="card card--1">' +
								'<div class="card__img" style="background-image: url("<c:out value=https://happybean-phinf.pstatic.net/20220819_67/1660868531689IgY4X_JPEG/메인이미지01jpg?type=w720 />")"></div>' +
						 		'<a href="#" class="card_link">' +
						     		'<div class="card__img--hover" style="background-image: url("<c:out value=https://happybean-phinf.pstatic.net/20220819_67/1660868531689IgY4X_JPEG/메인이미지01jpg?type=w720 />")"></div>' +
						   		'</a>' +
						  		'<div class="card__info">' +
						    	'<h3 class="card__title">밥 한끼조차 챙기기 어려운 연아</h3>' +
						    	'<span class="card__by">' +
							    	'<img class="card__logo" src="https://happybean-phinf.pstatic.net/20200116_34/1579150184219Bj6oe_JPEG/%C6%C4%BA%F1%C4%DC.jpg?type=w180">' +
							    	'<a href="#" class="card__author" title="author">세이브더칠드런</a>' +
						    	'</span>' +
						    	'<div class="container-fluid">' +
								    '<div class="Loading">' +
							    		'<div class=Loading-after>' +
							    	'</div>' +
							    '</div>' +
							    '<span class="progress-span">70%</span>' +
							    '<span>' +
							    	'<c:if test="${i} = 0">aaaa</c:if>' +
							    '</span>' +
							'</div>' +
						  '</div>' +
						'</article>' +
					'</section>' +
					); */
				},
				error: function(err) {
					console.log(err)
				}
			})
		}
		
		function getDonationPage() {
			page += 1
			$.ajax({
				type: 'get',
				url: '../pageAsk.do',
				data: {
					'k': page,
				},
				success: function(res) {
					console.log(res)
					$('.donation-check').append(res[1].categoryId + res[1].section1 + res[1].serction2)
				},
				error: function(err) {
					console.log(err)
				}
			})
		} 
		
		function getDonationCategory(categoryId) {
			$.ajax({
				type: 'get',
				url: '../category.do',
				data: {
					'categoryId': categoryId,
				},
				success: function(res) {
					console.log(res)
					$('.donation-check').html(res[1].categoryId + res[1].section1 + res[1].serction2)
				},
				error: function(err) {
					console.log(err)
				}
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
					<span>기부</span>
					<button class="donation-btn selected" id="all">전체</button>
					<button class="donation-btn" id="child">아동•청소년</button>
					<button class="donation-btn" id="old">어르신</button>
					<button class="donation-btn" id="disabled">장애인</button>
					<button class="donation-btn" id="multiculture">다문화</button>
					<button class="donation-btn" id="global">지구촌</button>
					<button class="donation-btn" id="family">가족•여성</button>
					<button class="donation-btn" id="animal">동물</button>
					<button class="donation-btn" id="environ">환경</button>
				</div>
				<div class="donation-list">
				
				</div>
				<%-- <c:forEach var="i" begin="0" end="5">
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
				</c:forEach> --%>
				<button class="next-page">더보기</button>
			</div>
			<div class="col-2">
				<div class="recent">
					<h4 align="center">최근 본 목록</h4>
					<div class="recent-items">
					
					</div>
					<button class="top-btn">TOP</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>