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
		@import url("css/Notice.css?ver=1");
	</style>
	
	<script>
		$(window).on('load', function() {
			$('#notice').addClass('loaded');
		});
		
		var notices = {
			8: {
				noticeId: "8",
				noticeTitle: "전자금융 사기(파밍) 주의 안내",
				noticeContent: "최근 올바른 홈페이지 주소를 입력하여도 가짜 홈페이지로 유도하는 파밍(Pharming) 수법의 사건이 지속적으로 발생하고 있습니다. 유의사항을 숙지하시어 예방에 만전을 기하여 주시기 바랍니다.최근 올바른 홈페이지 주소를 입력하여도 가짜 홈페이지로 유도하는 파밍(Pharming) 수법의 사건이 지속적으로 발생하고 있습니다. 유의사항을 숙지하시어 예방에 만전을 기하여 주시기 바랍니다.최근 올바른 홈페이지 주소를 입력하여도 가짜 홈페이지로 유도하는 파밍(Pharming) 수법의 사건이 지속적으로 발생하고 있습니다. 유의사항을 숙지하시어 예방에 만전을 기하여 주시기 바랍니다.",
				createTime: "2022-08-01",
				viewCnt: "123"
			},
			9: {
				noticeId: "9",
				noticeTitle: "[학습] 7기 실습코치 모집공고",
				noticeContent: "안녕하세요. SSAFY 사무국입니다. 어느덧 약 1년간의 SSAFY 마침표를 찍을 때가 되었네요. 마침표가 물음표로 남아 있는 분도 있고, 느낌표로 마무리 되시는 분들이 있을 것입니다. 어떤 마침표로 끝나던 1년간 고생 많았습니다. SSAFY 7기 코치를 모집합니다. 실습코치는 교육생 경험과 SW 개발 역량을 바탕으로 프로젝트 품질 향상시키고, 교육생의 햑습 효과성을 높이는 역할입니다. 모집 절차 등은 아래 내용을 확인해주시고, SSAFY 7기 실습 코치에 관심 있으신 분들은 많이 지원해주세요.",
				createTime: "2021-12-11",
				viewCnt: "645"
			},
			10: {
				noticeId: "10",
				noticeTitle: "What is Lorem Ipsum?",
				noticeContent: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
				createTime: "2021-02-25",
				viewCnt: "1530"
			}
		}
		
		var presentNoticeId = "";
		
		$(function() {
			getNotices()
			
			$('.table-body').on('click', '.table-row', function() {
				if ("table-list"+$(this).children().eq(0).text()==presentNoticeId) {
					$('#notice-content').remove();
				} else {
					$('#notice-content').remove();
					$(this).after('<div class=col-12 id=notice-content>'+notices[$(this).children().eq(0).text()].noticeContent+'</div>')
					presentNoticeId = "table-list"+$(this).children().eq(0).text()
				}
				
			})
		})
		
		function getNotices() {
			$.each(notices, function(index, item) {
				$('.table-body').append("<li class=table-row id=table-list"+item.noticeId+"><div class=col-2 data-label=noticeId>"+
										item.noticeId+"</div><div class=col-6 data-label=noticeTitle>"+
										item.noticeTitle+"</div><div class=col-2 data-label=createTime>"+
										item.createTime+"</div><div class=col-2 data-label=viewCnt>"+item.viewCnt+"</div></li>"
				);
			})
		}
	</script>
	</head>
	
	
	<body>
		<div id="notice">
			<div id="loader-wrapper">            
				<div id="loader"></div>
				<div class="loader-section section-left"></div>
				<div class="loader-section section-right"></div>
			</div>
		    <%@ include file="../Common/Nav.jsp" %>
		    <div class="container">
		    	<div>
		    		<h2 class="title">공지사항</h2>
		    		<ul class="responsive-table" style="margin-bottom: 5rem;">
					    <li class="table-header">
					      <div class="col col-2">공지 번호</div>
					      <div class="col col-6">공지 제목</div>
					      <div class="col col-2" align="end">생성 날짜</div>
					      <div class="col col-2" align="end">조회수</div>
					    </li>
					    <div class="table-body">
						</div>
					</ul>
		    	</div>
		    </div>
		</div>
	</body>
</html>