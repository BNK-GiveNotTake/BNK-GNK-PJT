<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<style scoped>
		@import url("css/DonationDetail.css?ver=1");
	</style>
	
	<script>
		$(window).on('load', function() {
			$('#donation-detail').addClass('loaded');
		});
		
		$(function() {
			getDonationDetail()			
			
		})
		
		const categoryList = ['아동·청소년', '어르신', '장애인', '다문화', '지구촌', '가족·여성', '동물', '환경'];
		
		function getDonationDetail() {
			donationId = localStorage.getItem('DonationDetailId')
			Donation = {}
			
			$.ajax({
				type: 'get',
				url: '../detailDonation.do',
				data: {
					'donationId': donationId
				},
				success: function(res) {
					Donation = res.Donation[1]
					
					donationPercent = Math.round((Donation.donationAmount/Donation.donationLimit)*100)
					backgroundColor = checkBackgroundColor(donationPercent)
					
					changeRecentItems(Donation)
					$('.donation_detail_title').empty()
					$('.donation_detail_title').html(Donation.title)
					$('.example > .block > .side').css("background-image", "url("+Donation.imageUri+")")
					$('.donation_detail_content').empty()
					if (Donation.section1!=null) {
						$('.donation_detail_content').append('<h4 class=content-title>'+Donation.section1Title+'</h4>')
						$('.donation_detail_content').append('<p class=content-content>'+Donation.section1+'</p>')
						if (Donation.section2!=null) {
							$('.donation_detail_content').append('<h4 class=content-title>'+Donation.section2Title+'</h4>')
							$('.donation_detail_content').append('<p class=content-content>'+Donation.section2+'</p>')
							if (Donation.section3!=null) {
								$('.donation_detail_content').append('<h4 class=content-title>'+Donation.section3Title+'</h4>')
								$('.donation_detail_content').append('<p class=content-content>'+Donation.section3+'</p>')
								if (Donation.section4!=null) {
									$('.donation_detail_content').append('<h4 class=content-title>'+Donation.section4Title+'</h4>')
									$('.donation_detail_content').append('<p class=content-content>'+Donation.section4+'</p>')
									if (Donation.section5!=null) {
										$('.donation_detail_content').append('<h4 class=content-title>'+Donation.section5Title+'</h4>')
										$('.donation_detail_content').append('<p class=content-content>'+Donation.section5+'</p>')
									}
								}
							}
						}
					}
					$('.donation_detail_category').empty()
					$('.donation_detail_category').html(categoryList[Donation.categoryId-1])
					$('.donation_detail_organization').empty()
					$('.donation_detail_organization').html(Donation.organization+'<img class="card__logo" src=https://happybean-phinf.pstatic.net/20200116_34/1579150184219Bj6oe_JPEG/%C6%C4%BA%F1%C4%DC.jpg?type=w180>')
					$('.Loading-after').css('width', donationPercent+'%').css('background-color', backgroundColor)
					$('.progress-span').html(donationPercent+'%')
					$('.donation_detail_start').empty()
					$('.donation_detail_start').html(Donation.createTime.slice(0, 10))
					$('.donation_detail_end').empty()
					$('.donation_detail_end').html(Donation.endTime.slice(0, 10))
					$('.donation_detail_amount').empty()
					$('.donation_detail_amount').html(Donation.donationAmount)
					$('.donation_detail_limit').empty()
					$('.donation_detail_limit').html(Donation.donationLimit)
					
				},
				error: function(err) {
					console.log(err)
				}
			})
		}
		
		function changeRecentItems(Donation) {
			recentList = JSON.parse(localStorage.getItem('recentList'))
			if(recentList==null) {
				recentList = []
				recentList.push(Donation)
			} else if (recentList.length == 3) {
				recentList.shift()
				recentList.push(Donation)
			} else {
				recentList.push(Donation)
			}
			localStorage.setItem('recentList', JSON.stringify(recentList))
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
	<body>
		<div id="donation-detail">
			<div id="loader-wrapper">            
				<div id="loader"></div>
				<div class="loader-section section-left"></div>
				<div class="loader-section section-right"></div>
			</div>
			<%@ include file="../Common/Nav.jsp" %><br>
			
			<div class="container">
				<div class="d-flex justify-content-between">
					<h3 class="donation_detail_title"></h3>
					<h3 class="donation_detail_category"></h3>
				</div>
				<div class="row">
					<div class="col-6">
						<div class="example">
							<div class="block">
								<div class="side -main"></div>
								<div class="side -left"></div>
							</div>
						</div>
						<div class="d-flex justify-content-center donation_detail_date">
							<div class="donation_detail_start">
							
							</div>
							<span>&nbsp;&nbsp;~&nbsp;&nbsp;</span>
							<div class="donation_detail_end">
							
							</div>
						</div>
						<div class="container-fluid">
							<div class="Loading">
								<div class="Loading-after"></div>
							</div>
							<span class="progress-span"></span>
						</div>
						<div>
							<div class="donation_detail_amount">
							
							</div>
							->
							<div class="donation_detail_limit">
							
							</div>
						</div>
					</div>
					<div class="col-6" style="max-height: 75vh; padding-left: 3rem;">
						<div class="donation_detail_organization d-flex justify-content-end align-items-center">
							
						</div>
						<div class="donation_detail_content">
						
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</body>
</html>

