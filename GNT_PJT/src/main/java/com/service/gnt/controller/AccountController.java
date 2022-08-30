package com.service.gnt.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.account.MileageHistory;
import com.service.gnt.model.dao.AccountDAO;
import com.service.gnt.model.service.AccountService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@ApiOperation(value="createAcc", notes="계좌 생성")
	@PostMapping("/createAcc.do")
	public Account createAcc(@RequestParam int userId,@RequestParam int accPassword,@RequestParam String userEmail,@RequestParam String userNameEng,
			@RequestParam String address, @RequestParam String Phone, Model model) {
		try {
		return accountService.createAcc(userId, accPassword, userEmail, userNameEng, address, Phone);
		} catch(Exception e) {
			/*
			model.addAttribute("title", "Error - Occured");
			model.addAttribute("message", "Error Occured :"+e.getMessage());
			System.out.println("Error :"+e.getMessage()+e.toString());
			*/
			return null;
		}
	}
	
	@ApiOperation(value="createAccTest", notes="계좌 생성")
	@PostMapping("/createAccTest.do")
	public String createAcc(@RequestParam int accPassword, Model model) {
		try {
			System.out.println("createAcc Contr");
			accountService.createAccTest(accPassword);
		return "";
		} catch(Exception e) {
			model.addAttribute("title", "Error - Occured");
			model.addAttribute("message", "Error Occured :"+e.getMessage());
			System.out.println("Error :"+e.getMessage()+e.toString());
			return "error";
		}
	}
	
	@ApiOperation(value="depositAcc", notes="계좌 입금")
	@PostMapping("/depositAcc.do")
	public void depositAcc(int userId, int amount) {
		accountService.depositAcc(userId, amount);
	}
	@ApiOperation(value="sendAcc", notes="송금")
	@PostMapping("/sendAcc.do")
	public void sendAcc(int userId, int amount, String accId) {
		accountService.sendAcc(userId, amount, accId);
	}
	@ApiOperation(value="createMile", notes="마일리지 생성")
	@PostMapping("/createMile.do")
	public void createMile(int userId) {
		accountService.createMile(userId);
	}
	@ApiOperation(value="getMileBalance", notes="마일리지 잔액 확인")
	@PostMapping("/getMileBalance.do")
	public int getMileBalance(int mileagePk) {
		return accountService.getMileBalance(mileagePk);
	}
	@ApiOperation(value="getMileHistory", notes="마일리지 내역 확인")
	@PostMapping("/getMileHistory.do")
	public void getMileHistory(int userId) {
		List<MileageHistory> list = accountService.getMileHistory(userId);
		for(MileageHistory mi : list) System.out.println(mi);
	}
	@ApiOperation(value="addMile", notes="마일리지 충전")
	@GetMapping("/addMile.do")
	public void addMile(int amount, int userId) {
		accountService.addMile(amount, userId);
	}
	@ApiOperation(value="getMilePk", notes="마일리지 PK 확인")
	@PostMapping("/getMilePk.do")
	public int getMilePk(int userId) {
		return accountService.getMilePk(userId);
	}
}
