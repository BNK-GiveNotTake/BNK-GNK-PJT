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
			@import url("css/Game.css?ver=1");
		</style>
		<script>
			$(window).on('load', function() {
				$('#game').addClass('loaded');
			});
			
			$(function() {
				$('body').css('height', '100%').css('background-color', '#cedbef4f')
				
				var rollTimeout;
				
				function setVal(num, val) {
				  var dices = document.querySelectorAll('.dice');
				  var dice = dices.item(num - 1);
				  if (!dice) return;
				  dice.setAttribute('data-val', val);
				}
				
				function toggleRoll() {
				  setVal(1, 0);
				}
				
				function getRand() {
				  return Math.round(Math.random() * 5 + 1);
				}
				
				function setVals() {
					diceValue = getRand()
				  setVal(1, diceValue);
				  console.log(diceValue)
				}
				
				function rollDice() {
				  if (rollTimeout) clearTimeout(rollTimeout);
				  toggleRoll();
				  rollTimeout = setTimeout(function() {
				    setVals();
				  }, 1000);
				}
				
				window.onload = rollDice;
				
				window.addEventListener('click', rollDice);
			})
		</script>
	</head>
	
	<body>
		<div id="game">
			<div id="loader-wrapper">            
				<div id="loader"></div>
				<div class="loader-section section-left"></div>
				<div class="loader-section section-right"></div>
			</div>
			<%@ include file="../Common/Nav.jsp" %><br>
			<div class="container">
				<h2 class="title">오늘의 게임</h2>
				<div class="game-table">
					<div class="d-flex justify-content-center">
						<div class="game-box">꽝</div>
						<div class="game-box">꽝</div>
						<div class="game-box">꽝</div>
						<div class="game-box">꽝</div>
						<div class="game-box">꽝</div>
						<div class="game-box">꽝</div>
						<div class="game-box">꽝</div>
						<div class="game-box">꽝</div>
					</div>
					<div class="d-flex justify-content-between" style="padding-left: 55px; padding-right: 55px;">
						<div>
							<div class="game-box">꽝</div>
							<div class="game-box">꽝</div>
							<div class="game-box">꽝</div>
						</div>
						<div>
							<div class="dice-title">Click to roll the dice</div>
							<div class="container d-flex justify-content-center">
							  <div class="dice dice_1">
							    <div class="cube">
							      <div class="side side_1">
							        <span class="dot dot_5"></span>
							      </div>
							      <div class="side side_2">
							        <span class="dot dot_3"></span><span class="dot dot_7"></span>
							      </div>
							      <div class="side side_3">
							        <span class="dot dot_3"></span><span class="dot dot_5"></span><span class="dot dot_7"></span>
							      </div>
							      <div class="side side_4">
							        <span class="dot dot_1"></span><span class="dot dot_3"></span><span class="dot dot_7"></span><span class="dot dot_9"></span>
							      </div>
							      <div class="side side_5">
							        <span class="dot dot_1"></span><span class="dot dot_3"></span><span class="dot dot_5"></span><span class="dot dot_7"></span><span class="dot dot_9"></span>
							      </div>
							      <div class="side side_6">
							        <span class="dot dot_1"></span><span class="dot dot_4"></span><span class="dot dot_7"></span><span class="dot dot_3"></span><span class="dot dot_6"></span><span class="dot dot_9"></span>
							      </div>
							    </div>
							  </div>
							
							  
							</div>
						</div>
						<div>
							<div class="game-box">꽝</div>
							<div class="game-box">꽝</div>
							<div class="game-box">꽝</div>
						</div>
					</div>
					<div class="d-flex justify-content-center">
						<div class="game-box">꽝</div>
						<div class="game-box">꽝</div>
						<div class="game-box">꽝</div>
						<div class="game-box">꽝</div>
						<div class="game-box">꽝</div>
						<div class="game-box">꽝</div>
						<div class="game-box">꽝</div>
						<div class="game-box">꽝</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>