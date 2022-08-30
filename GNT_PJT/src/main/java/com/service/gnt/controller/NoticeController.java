package com.service.gnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.gnt.domain.notice.Notice;
import com.service.gnt.model.service.NoticeService;

import io.swagger.annotations.ApiOperation;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	/*
	@ApiOperation(value="createAcc", notes="계좌 생성")
	@PostMapping("/createAcc.do")
	public List<Notice> createAcc(@RequestParam int userId,@RequestParam int accPassword,@RequestParam String userEmail,@RequestParam String userNameEng,
			@RequestParam String address, @RequestParam String Phone, Model model) {
		try {
		return noticeService.createAcc(userId, accPassword, userEmail, userNameEng, address, Phone);
		} catch(Exception e) {
			
			model.addAttribute("title", "Error - Occured");
			model.addAttribute("message", "Error Occured :"+e.getMessage());
			System.out.println("Error :"+e.getMessage()+e.toString());
			
			return null;
		}
	}*/
}
