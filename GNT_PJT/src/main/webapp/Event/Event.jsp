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
					if ($(this).attr('value') == '1') {
						location.href = 'Quiz.jsp'
					} else if ($(this).attr('value') == '2') {
						location.href = 'Roulette.jsp'
					} else {
						location.href = 'Fortune.jsp'
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
							<div class="event-content">
								<h3>No.1</h3>
								<h1>퀴즈</h1>							
							</div>
						</div>
					</div>
					<div class="event-card" value="2">
						<div class="event-background">
							<div class="event-content">
								<h3>No.2</h3>
								<h1>Not Yet</h1>							
							</div>
						</div>		
					</div>
					<div class="event-card" value="3">
						<div class="event-background">
							<div class="event-content">
								<h3>No.3</h3>
								<h1>오늘의 운세</h1>							
							</div>
						</div>		
					</div>
				</div>
			</div>
			
		</div>
	</body>
</html>