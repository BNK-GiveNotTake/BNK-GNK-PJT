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
			
			<div class="container my-5">
				<div class="d-flex justify-content-around event-list">
					<div class="event-card">
						<div class="event-background">
							<div class="event-content">
								<h3>No.1</h3>
								<h1>퀴즈 Quiz</h1>							
							</div>
						</div>
					</div>
					<div class="event-card">
						<div class="event-background">
							<div class="event-content">
								<h3>No.2</h3>
								<h1>Not Yet</h1>							
							</div>
						</div>		
					</div>
					<div class="event-card">
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