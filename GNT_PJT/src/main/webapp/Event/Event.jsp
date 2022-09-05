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
			@import url("css/Event.css?ver=1");
		</style>
		<script>
			$(window).on('load', function() {
				$('#donation').addClass('loaded');
			});
			
			$(function() {
				$('body').css('height', '100%').css('background-color', '#cedbef4f')
				
				$('.event-card').click(function() {
					var userInfo = JSON.parse(localStorage.getItem('user'));
					if ($(this).attr('value') == '1') {
						$.ajax({
							type: 'get',
							url: '../checkedQuiz.do',
							data: {
								'userId': userInfo.userId,
							},
							success: function(res) {
								if(res.message=='yes') {
									location.href = 'Quiz.jsp'
								} else {
									swal({
										title: "퀴즈 불가!",
										text: "내일 다시 만나요!",
										icon: "info",
										button: true,
									})
								}
							},
							error: function(err) {
								console.log(err)
							}
						})
						
					} else if ($(this).attr('value') == '2') {
						$.ajax({
							type: 'get',
							url: '../checkedRoulette.do',
							data: {
								'userId': userInfo.userId,
							},
							success: function(res) {
								if(res.message=='yes') {
									location.href = 'Roulette.jsp'
								} else {
									swal({
										title: "추첨 불가!",
										text: "내일 다시 만나요!",
										icon: "info",
										button: true,
									})
								}
							},
							error: function(err) {
								console.log(err)
							}
						})
						
					} else {
						location.href = 'Game.jsp'
					}
				})
				
			})
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
			
			<div class="container">
				<h2 class="title">이벤트</h2>
				<div class="d-flex justify-content-around event-list">
					<div class="event-card" value="1">
						<div class="event-background">
							<div class="event-content d-flex align-items-center">
								<img src="img/no1.png">					
							</div>
						</div>
					</div>
					<div class="event-card" value="2">
						<div class="event-background">
							<div class="event-content d-flex align-items-center">
								<img src="img/no2.png">							
							</div>
						</div>		
					</div>
					<div class="event-card" value="3">
						<div class="event-background">
							<div class="event-content d-flex align-items-center">
								<img src="img/no3.png">							
							</div>
						</div>		
					</div>
				</div>
			</div>
			
		</div>
	</body>
</html>