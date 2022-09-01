package com.service.gnt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.gnt.domain.donation.Donation;
import com.service.gnt.domain.users.Users;
import com.service.gnt.model.service.DonationService;

@RestController
public class DonationController {

	@Autowired
	private DonationService donationService;
	
	
	@GetMapping("ask.do") //기부 페이지 조회 최신 20개
	public Map<String,Object> donationindex(Model model) {
		
		String message = "No";
		Map<String,Object> maps = new HashMap<String,Object>();
		
		try {
			List<Donation> list = donationService.select1();
//			model.addAttribute("title", "기부 목록 조회");
//			model.addAttribute("donations", list);
			System.out.println(list);
			System.out.println(list.get(0));
			for(int i = 0 ; i<list.size() ; i++) {
				
				maps.put(Integer.toString(i+1),list.get(i));

			}
				message = "Yes";
				maps.put("message",message);
				
			return maps;
			
		}catch(Exception e) {
			
			maps.put("message",message);
			return maps;
		}
	}
	
	
	@GetMapping("pageAsk.do") //페이지별 기부 내역 조회
	public Map<String,Object> pagination(int k , Model model) {
		
		String message = "No";
		Map<String,Object> maps = new HashMap<String,Object>();
		
		try {
			List<Donation> list = donationService.select2_1(k);
//			model.addAttribute("title", "기부 목록 조회");
//			model.addAttribute("donations", list);
			System.out.println(list);
			System.out.println(list.get(0));
			for(int i = 0 ; i<list.size() ; i++) {
				
				maps.put(Integer.toString(i+1),list.get(i));

			}
				message = "Yes";
			
			maps.put("message",message);
			return maps;
			
		} catch (Exception e) {
			// TODO: handle exception
			
			maps.put("message",message);
			return maps;
		}
		
	}
	
	
	@GetMapping("category.do")//카테고리별 모든 기부 목록 조회
	public Map<String,Object> Category(Donation donation, Model model) {
		String message = "No";
		Map<String,Object> maps = new HashMap<String,Object>();
		
		try {
			List<Donation> list = donationService.select2(donation.getCategoryId());
			System.out.println(list);
			System.out.println(list.get(0));
			for(int i = 0 ; i<list.size() ; i++) {
				
				maps.put(Integer.toString(i+1),list.get(i));

				}
				message = "Yes";
				maps.put("message",message);
				
			return maps;
			
		} catch (Exception e) {
			
			maps.put("message", message);
			return maps;
		}
	}
	
	
	@GetMapping("detailDonation.do") //상세 기부 페이지
	public Map<String,Object> detailPage(Donation donation, Model model) {
		String message = "No";
		Map<String,Object> maps = new HashMap<String,Object>();
		
		try {
			Donation detail = donationService.select3(donation.getDonationId());
			System.out.println(detail);
			maps.put("donation", detail);
			message = "Yes";
			maps.put("message", message);
			return maps;
			
		} catch (Exception e) {
			
			maps.put("message", message);
			return maps;
		}
	}
	
	
	
	// [Donation history테이블]에서 해당하는 donation_id insert, [donation 테이블]에서 donation_amount 필드 업데이트, 
	// user_id에 해당하는 User의 마일리지 차감 --> [Account 테이블]의 마일리지 필드 차감...
/*	@PostMapping("donate.do") //기부하기
	public Map<String,Object> donate(Donation donation, Users user, Model model) {
		String message = "No";
		Map<String,Object> maps = new HashMap<String,Object>();
		Donation donation1 = new Donation();
		Donate donate1 = new Donate();
		
		try {
			donation1.setDonationId(donation.getDonationId());
			donation1.setDonationAmount(donation.getDonationAmount());
			donate1.setDonationId(donation.getDonationId());
			donate1.setDonationAmount(donation.getDonationAmount());
			donate1.setUserId(user.getUserId());
			
			donationService.update1(donation);
			donationService.update2(donate1);
			donationService.insert1(donate1);
			message = "Yes";
			maps.put("message", message);
			
			return maps;
		} catch (Exception e) {
			
			
			maps.put("message", message);
			return maps;
		}
	}		*/
}

