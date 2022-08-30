package com.service.gnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.gnt.domain.donation.Donation;
import com.service.gnt.model.service.DonationService;

@RestController
public class DonationController {

	@Autowired
	private DonationService donationService;
	
	
	@GetMapping("ask.do")
	public String donationindex(Model model) {
		
		try {
			List<Donation> list = donationService.select1();
			model.addAttribute("title", "기부 목록 조회");
			model.addAttribute("donations", list);
			
			System.out.println(list);
			
			return "DonationList";
			
		}catch(Exception e) {
			model.addAttribute("title", "기부 목록 조회중 에러");
			model.addAttribute("message", "문제 내용 - 기부 목록 조회중 에러 발생..");
			
			return "Error";
		}
	}
	
	
	
}
