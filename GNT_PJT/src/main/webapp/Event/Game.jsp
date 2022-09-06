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
			
			var diceValue = 0;
			var present = 0;
			var presentTop = 0;
			var presentLeft = 0;
			
			$(function() {
				$('body').css('height', '100%').css('background-color', '#cedbef4f')
				
				
				
			})
			
			
			function moveIcon() {
				leftVal = $('.game-img').offset().left
				if (present >= 0 && present < 7) {
					topVal = $('.game-img').offset().top
					leftVal = $('.game-img').offset().left
					if (present+diceValue >= 0 && present+diceValue < 7) {
						$('.game-img').css('left', (leftVal+diceValue*125)+'px');
						present = present+diceValue
					} else if (present+diceValue >= 7 && present+diceValue < 11) {
						$('.game-img').css('left', (leftVal+(7-present)*125)+'px');
						setTimeout(() => {
							$('.game-img').css('top', (topVal+(present+diceValue-7)*100)+'px');
							present = present+diceValue
						}, 1000);
						
					} else if (present+diceValue >= 11 && present+diceValue < 18) {
						$('.game-img').css('left', (leftVal+(7-present)*125)+'px');
						setTimeout(() => {
							$('.game-img').css('top', (topVal+400)+'px');
						}, 1000);
						setTimeout(() => {
							$('.game-img').css('left', (leftVal-(present+diceValue-12)*125)+'px');
							present = present+diceValue
						}, 2000);
					}
					
				} else if (present >= 7 && present < 11) {
					topVal = $('.game-img').offset().top
					leftVal = $('.game-img').offset().left
					if (present+diceValue >= 7 && present+diceValue < 11) {
						$('.game-img').css('top', (topVal+diceValue*100)+'px');
						present = present+diceValue
					} else if (present+diceValue >= 11 && present+diceValue < 18) {
						$('.game-img').css('top', (topVal+(11-present)*100)+'px');
						setTimeout(() => {
							$('.game-img').css('left', (leftVal-(present+diceValue-11)*125)+'px');
							present = present+diceValue
						}, 1000);
					}
				} else if (present >= 11 && present < 18) {
					topVal = $('.game-img').offset().top
					leftVal = $('.game-img').offset().left
					console.log(present)
					console.log(diceValue)
					if (present+diceValue >= 11 && present+diceValue < 18) {
						$('.game-img').css('left', leftVal-diceValue*125+'px');
						present = present+diceValue
					} else if (present+diceValue >= 18 && present+diceValue <= 21) {
						$('.game-img').css('left', (leftVal-(18-present)*125)+'px');
						setTimeout(() => {
							$('.game-img').css('top', (topVal-(present+diceValue-18)*100)+'px');
							present = present+diceValue
						}, 1000);
					} else if (present+diceValue >= 22) {
						$('.game-img').css('left', (leftVal-(18-present)*125)+'px');
						setTimeout(() => {
							$('.game-img').css('top', (topVal-400)+'px');
						}, 1000);
						setTimeout(() => {
							$('.game-img').css('left', (leftVal+(present+diceValue-23)*125)+'px');
							if (present+diceValue==22) {
								present = 0
							} else if (present+diceValue==23) {
								present = 1
							}
						}, 2000);
					}
				} else if (present >= 18 && present <= 21) {
					topVal = $('.game-img').offset().top
					leftVal = $('.game-img').offset().left
					if (present+diceValue >= 18 && present+diceValue <= 21) {
						$('.game-img').css('top', topVal-(diceValue*100)+'px');
						present = present+diceValue
					} else if (present+diceValue >= 22) {
						$('.game-img').css('top', topVal-(22-present)*100+'px');
						setTimeout(() => {
							$('.game-img').css('left', leftVal+(present+diceValue-22)*125+'px');
							present = present+diceValue-22
						}, 1000);
					}
				}
			}
			
			
			/* Dice 관련 */
			$(function() {
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
					setTimeout(() => {
						moveIcon()
					}, 100);
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
					<img class="game-img" src="img/Gbangul.png">
					<div class="d-flex justify-content-center">
						<div class="game-box top_left">도착</div>
						<div class="game-box top">꽝</div>
						<div class="game-box top">1MP</div>
						<div class="game-box top">꽝</div>
						<div class="game-box top">1원</div>
						<div class="game-box top">꽝</div>
						<div class="game-box top">2MP</div>
						<div class="game-box top_right">한 번 더!</div>
					</div>
					<div class="d-flex justify-content-between" style="padding-left: 55px; padding-right: 55px;">
						<div>
							<div class="game-box left">꽝</div>
							<div class="game-box left">2MP</div>
							<div class="game-box left">꽝</div>
						</div>
						<div>
							<div class="dice-title">클릭해서 주사위를 돌려봐요!</div>
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
							<div class="game-box right">꽝</div>
							<div class="game-box right">1MP</div>
							<div class="game-box right">꽝</div>
						</div>
					</div>
					<div class="d-flex justify-content-center">
						<div class="game-box bottom_left">내일 휴가</div>
						<div class="game-box bottom">꽝</div>
						<div class="game-box bottom">1원</div>
						<div class="game-box bottom">꽝</div>
						<div class="game-box bottom">1MP</div>
						<div class="game-box bottom">꽝</div>
						<div class="game-box bottom">1원</div>
						<div class="game-box bottom_right">처음으로</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>