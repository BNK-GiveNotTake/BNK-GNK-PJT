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
			getDonationBasic()
			getRecent()
			
			$('.next-page').click(function() {
				getDonationPage()
			})
			
			$('.donation-list').on('click', '.card ', function() {
				localStorage.setItem('DonationDetailId', $(this).attr('id'))
				console.log($(this))
				location.href="DonationDetail.jsp"
			});
			
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
		
		function removeSelected() {
			var btnList = $('.donation-btn')
			btnList.removeClass('selected')
		}
		
		function getRecent() {
			var recentList = localStorage.getItem("recentList")
			recentList = JSON.parse(recentList)
			$('.recent-items').empty()
			$.each(recentList, function(index, item) {
				$('.recent-items').append('<div class=recent-item><img src='+item.imageUri+'></div>')
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
					$('.donation-list').empty();
					$.each(Donation, function(index, item) {
						donationPercent = Math.round((item.donationAmount/item.donationLimit)*100)
						backgroundColor = checkBackgroundColor(donationPercent)
						$('.donation-list').append(
							'<section class="cards col-3 mb-5">' +
								'<article class="card card--1" id='+item.donationId+'>' +
								'<div class="card__img" style=background-image:url('+item.imageUri+')></div>' +
								'<a href="#" class="card_link">' +
									'<div class="card__img--hover" style=background-image:url('+item.imageUri+')></div>' +
								'</a>' +
								'<div class="card__info">' +
									'<h3 class="card__title">'+item.title+'</h3>' +
									'<span class="card__by">' +
										'<img class="card__logo" src=https://happybean-phinf.pstatic.net/20200116_34/1579150184219Bj6oe_JPEG/%C6%C4%BA%F1%C4%DC.jpg?type=w180>' +
										'<a href="#" class="card__author" title="author">'+item.organization+'</a>' +
									'</span>' +
									'<div class="container-fluid">' +
										'<div class="Loading">' +
											'<div class="Loading-after" style=width:'+donationPercent+'%;background-color:'+backgroundColor+';></div>' +
										'</div>' +
										'<span class="progress-span">'+donationPercent+'%</span>' +
							'</div></div></article></section>'
						);
					})
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
					'pagenum': page,
				},
				success: function(res) {
					Donation = res.Donation
					console.log(Donation)
					$.each(Donation, function(index, item) {
						donationPercent = Math.round((item.donationAmount/item.donationLimit)*100)
						backgroundColor = checkBackgroundColor(donationPercent)
						$('.donation-list').append(
							'<section class="cards col-3 mb-5">' +
								'<article class="card card--1" id='+item.donationId+'>' +
								'<div class="card__img" style=background-image:url('+item.imageUri+')></div>' +
								'<a href="#" class="card_link">' +
									'<div class="card__img--hover" style=background-image:url('+item.imageUri+')></div>' +
								'</a>' +
								'<div class="card__info">' +
									'<h3 class="card__title">'+item.title+'</h3>' +
									'<span class="card__by">' +
										'<img class="card__logo" src=https://happybean-phinf.pstatic.net/20200116_34/1579150184219Bj6oe_JPEG/%C6%C4%BA%F1%C4%DC.jpg?type=w180>' +
										'<a href="#" class="card__author" title="author">'+item.organization+'</a>' +
									'</span>' +
									'<div class="container-fluid">' +
										'<div class="Loading">' +
											'<div class="Loading-after" style=width:'+donationPercent+'%;background-color:'+backgroundColor+';></div>' +
										'</div>' +
										'<span class="progress-span">'+donationPercent+'%</span>' +
							'</div></div></article></section>'
						);
					})
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
					Donation = res.Donation
					$('.donation-list').empty();
					$.each(Donation, function(index, item) {
						donationPercent = Math.round((item.donationAmount/item.donationLimit)*100)
						backgroundColor = checkBackgroundColor(donationPercent)
						$('.donation-list').append(
							'<section class="cards col-3 mb-5">' +
								'<article class="card card--1" id='+item.donationId+'>' +
								'<div class="card__img" style=background-image:url('+item.imageUri+')></div>' +
								'<a href="#" class="card_link">' +
									'<div class="card__img--hover" style=background-image:url('+item.imageUri+')></div>' +
								'</a>' +
								'<div class="card__info">' +
									'<h3 class="card__title">'+item.title+'</h3>' +
									'<span class="card__by">' +
										'<img class="card__logo" src=https://happybean-phinf.pstatic.net/20200116_34/1579150184219Bj6oe_JPEG/%C6%C4%BA%F1%C4%DC.jpg?type=w180>' +
										'<a href="#" class="card__author" title="author">'+item.organization+'</a>' +
									'</span>' +
									'<div class="container-fluid">' +
										'<div class="Loading">' +
											'<div class="Loading-after" style=width:'+donationPercent+'%;background-color:'+backgroundColor+';></div>' +
										'</div>' +
										'<span class="progress-span">'+donationPercent+'%</span>' +
							'</div></div></article></section>'
						);
					})
				},
				error: function(err) {
					console.log(err)
				}
			})
		}
		
		function checkBackgroundColor(donationPercent) {
			backgroundColor = ""
			if (donationPercent < 10) {
				backgroundColor = "rgb(0,110,110,0.1)";
			} else if (donationPercent>=10 && donationPercent<20) {
				backgroundColor = "rgb(0,125,125,0.2)";
			} else if (donationPercent>=20 && donationPercent<30) {
				backgroundColor = "rgb(0,140,140,0.3)";
			} else if (donationPercent>=30 && donationPercent<40) {
				backgroundColor = "rgb(0,155,155,0.4)";
			} else if (donationPercent>=40 && donationPercent<50) {
				backgroundColor = "rgb(0,170,170,0.5)";
			} else if (donationPercent>=50 && donationPercent<60) {
				backgroundColor = "rgb(0,185,185,0.6)";
			} else if (donationPercent>=60 && donationPercent<70) {
				backgroundColor = "rgb(0,200,200,0.7)";
			} else if (donationPercent>=70 && donationPercent<80) {
				backgroundColor = "rgb(0,215,215,0.8)";
			} else if (donationPercent>=80 && donationPercent<90) {
				backgroundColor = "rgb(0,240,240,0.9)";
			} else {
				backgroundColor = "rgb(0,255,255,1)";
			}
			return backgroundColor
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
				<div class="donation-list row" style="margin-left: 1rem;">
					
				</div>
				
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