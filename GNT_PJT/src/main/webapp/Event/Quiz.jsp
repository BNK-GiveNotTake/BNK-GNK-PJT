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
			@import url("css/Quiz.css?ver=1");
		</style>
		<script>
			$(window).on('load', function() {
				$('#quiz').addClass('loaded');
			});
			
			$(function() {
				$('body').css('height', '100%').css('background-color', '#cedbef4f');
				
				
				
			})
		</script>
	</head>
	
	<body>
		<div id="quiz">
			<div id="loader-wrapper">            
				<div id="loader"></div>
				<div class="loader-section section-left"></div>
				<div class="loader-section section-right"></div>
			</div>
			<%@ include file="../Common/Nav.jsp" %><br>
			<div class="container">
				<h2 class="title">퀴즈</h2>
			</div>
		</div>
	</body>
</html>