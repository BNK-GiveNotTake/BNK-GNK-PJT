package com.service.gnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.gnt.domain.notice.Notice;
import com.service.gnt.model.service.NoticeService;

import io.swagger.annotations.ApiOperation;

@RestController
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ApiOperation(value="getNoticeList", notes="공지사항 목록")
	@RequestMapping("/getNoticeList.do")
	public List<Notice> getNoticeList() {
		try {
			System.out.println("NoticeList");
			List<Notice> list = noticeService.getNoticeList();
			for(Notice c : list) {
				System.out.println(c);
			}
		return list;
		} catch(Exception e) {
			System.out.println("Error :"+e.getMessage()+e.toString());
			return null;
		}
	}
	
	@ApiOperation(value="getNoticeDetail", notes="공지사항 목록")
	@RequestMapping("/getNoticeDetail.do")
	public Notice getNoticeDetail(int noticeId) {
		try {
			System.out.println("Notice");
			return noticeService.getNoticeDetail(noticeId);
		} catch(Exception e) {
			System.out.println("Error :"+e.getMessage()+e.toString());
			return null;
		}
	}
}
