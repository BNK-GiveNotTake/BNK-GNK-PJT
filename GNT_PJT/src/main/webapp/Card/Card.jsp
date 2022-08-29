<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<style scoped>
		@import url("css/Card.css?ver=1");
	</style>

	<script>
		$(function() {
			$('#draggable3').click(function() {
				console.log($("containment-wrapper"))
			})
		})
	
		$(function() {
		    $("#draggable3").draggable({ containment: "#containment-wrapper", scroll: false });
		});
		
		$(window).on('load', function() {
			$('#card').addClass('loaded');
		});
		
		$(function() {	
			
			$('.font__color-black').click(function() {
				$('.back .card__ccv').css("color", "black");
				$('.back .card__owner').css("color", "black");
				$('.back .card__expiry-date').css("color", "black");
				$('.back .card__number').css("color", "black");
				$('.front .card__content').css("color", "black");
			});
			
			$('.font__color-white').click(function() {
				$('.back .card__ccv').css("color", "white");
				$('.back .card__owner').css("color", "white");
				$('.back .card__expiry-date').css("color", "white");
				$('.back .card__number').css("color", "white");
				$('.front .card__content').css("color", "white");
			});
			
			$('#tab3').click(function() {
				$('#card__content').focus();
			})
			
			$('#card__content').click(function() {
				$('#card__content').focus();
			})
			
		});
	</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="card">
		<div id="loader-wrapper">            
			<div id="loader"></div>
			<div class="loader-section section-left"></div>
			<div class="loader-section section-right"></div>
		</div>
		<%@ include file="../Common/Nav.jsp" %><br>
		<div class="container">
			<div>
				<div class="d-flex justify-content-between align-items-end" style="border-bottom: 1px solid beige; margin-bottom: 2rem;">
					<h2 class="title">카드 발급</h2>
					<div class="d-flex">
						<div class="font__color-black">
							Black
						</div>
						<div class="font__color-white" style="margin-left: 2rem;">
							White
						</div>
					</div>
				</div>
				<div class="d-flex justify-content-around">
					<div class="front">
						<div class="card card--front">
							<div class="row" style="height: 100vh;">
								<div class="col-4 d-flex flex-column justify-content-between">
									<img class="card__logo--front" src="img/bnk_logo.png">
									<div style="margin-left: 10px; margin-bottom: 10px;">
										<span class="card__content">남유진과 아이들</span>
									</div>
								</div>
								<div class="col-8">
									<div id="containment-wrapper" style="border: none; height: 100%; padding-right: 30px;">
									  <div id="draggable3" class="draggable ui-widget-content" style="border: none; width: 40%;">
									    <img src="img/MrB.png" class="emo" style="width: 140%;">
									  </div>
									</div>
								</div>
							</div>
						</div>
						<h5 class="front__hover" style="color: #898989;"><b>앞면</b></h5>
					</div>
					<div class="back">
						<div class="card card--back">
							<div class="card__strip"></div>
							<div>
								<div class="card__signature"></div>
								<div class="card__ccv">303</div>							
							</div>
							<div class="card__number">4111 1111 1111 1111</div>
							<div class="card__expiry-date">10/17</div>
							<div>
								<div class="card__owner">
									yudingg
									<img class="card__logo--back" src="img/bnk_logo.png">							
								</div>
							</div>
						</div>
						<h5 class="back__hover" style="color: #898989;"><b>뒷면</b></h5>
					</div>
				</div>
				<div class="tabs">
				  <input type="radio" id="tab1" name="tab-control" checked>
				  <input type="radio" id="tab2" name="tab-control">
				  <input type="radio" id="tab3" name="tab-control">  
				  <ul>
				    <li title="Features"><label for="tab1" role="button"><br><span>배경색</span></label></li>
				    <li title="Delivery Contents"><label for="tab2" role="button"><br><span>이모티콘</span></label></li>
				    <li title="Shipping"><label for="tab3" role="button"><br><span>문구 넣기</span></label></li>
				  </ul>
				  
				  <div class="slider"><div class="indicator"></div></div>
				  <div class="content">
				    <section>
						<h2>Features</h2>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ea dolorem sequi, quo tempore in eum obcaecati atque quibusdam officiis est dolorum minima deleniti ratione molestias numquam. Voluptas voluptates quibusdam cum?
			      	</section>
			        <section>
						<h2>Delivery Contents</h2>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit. Autem quas adipisci a accusantium eius ut voluptatibus ad impedit nulla, ipsa qui. Quasi temporibus eos commodi aliquid impedit amet, similique nulla.
		          	</section>
			        <section>
						<h2>Shipping</h2>
		          	</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>