package com.service.gnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.gnt.domain.account.Account;
import com.service.gnt.domain.account.MileageHistory;
import com.service.gnt.model.service.AccountService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@ApiOperation(value="createAcc", notes="계좌 생성")
	@PostMapping("/createAcc.do")
	public Account createAcc(@RequestParam int userId,@RequestParam int accPassword,@RequestParam String userNameEng,
			@RequestParam String address, @RequestParam String phone, Model model) {
		try {
		return accountService.createAcc(userId, accPassword, userNameEng, address, phone);
		} catch(Exception e) {
			model.addAttribute("title", "Error - Occured");
			model.addAttribute("message", "Error Occured :"+e.getMessage());
			System.out.println("Error :"+e.getMessage()+e.toString());
			return null;
		}
	}
	
	@ApiOperation(value="createAccTest", notes="계좌 생성")
	@PostMapping("/createAccTest.do")
	public Account createAcc(@RequestParam int accPassword, Model model) {
		try {
			System.out.println("createAcc Contr");
		return accountService.createAccTest(accPassword);
		} catch(Exception e) {
			model.addAttribute("title", "Error - Occured");
			model.addAttribute("message", "Error Occured :"+e.getMessage());
			System.out.println("Error :"+e.getMessage()+e.toString());
			return null;
		}
	}

	@ApiOperation(value="checkUserAcc", notes="계좌 존재유무 확인")
	@PostMapping("/checkUserAcc.do")
	public String checkUserAcc(int userId) {
		try {
			return accountService.checkUserAcc(userId);
		} catch(Exception e) {
	//		model.addAttribute("title", "Error - Occured");
	//		model.addAttribute("message", "Error Occured :"+e.getMessage());
			System.out.println("Error :"+e.getMessage()+e.toString());
			return null;
		}
	}
	
	@ApiOperation(value="getAccount", notes="계좌 정보 확인")
	@PostMapping("/getAccount.do")
	public Account getAccount(int userId) {
		try {
			return accountService.getAccountByUserId(userId);
		} catch(Exception e) {
	//		model.addAttribute("title", "Error - Occured");
	//		model.addAttribute("message", "Error Occured :"+e.getMessage());
			System.out.println("Error :"+e.getMessage()+e.toString());
			return null;
		}
	}
	
	@ApiOperation(value="depositAcc", notes="계좌 입금") //WIP
	@PostMapping("/depositAcc.do")
	public void depositAcc(int userId, int amount) {
		try {
		accountService.depositAcc(userId, amount);
		} catch(Exception e) {
//		model.addAttribute("title", "Error - Occured");
//		model.addAttribute("message", "Error Occured :"+e.getMessage());
		System.out.println("Error :"+e.getMessage()+e.toString());
//		return null;
		}
	}
	
	@ApiOperation(value="sendAcc", notes="송금") //WIP
	@PostMapping("/sendAcc.do")
	public void sendAcc(int userId, int amount, String accId) {
		try {
		accountService.sendAcc(userId, amount, accId);
		} catch(Exception e) {
//		model.addAttribute("title", "Error - Occured");
//		model.addAttribute("message", "Error Occured :"+e.getMessage());
		System.out.println("Error :"+e.getMessage()+e.toString());
//		return null;
		}
	}
	
	@ApiOperation(value="createMile", notes="마일리지 생성") //WIP
	@PostMapping("/createMile.do")
	public String createMile(int userId) {
		try {
			String status = "fail"; //아직 작성중
			if(accountService.createMile(userId)>0) status="success";
			return status;
		} catch(Exception e) {
//		model.addAttribute("title", "Error - Occured");
//		model.addAttribute("message", "Error Occured :"+e.getMessage());
		System.out.println("Error :"+e.getMessage()+e.toString());
			return null;
		}
	}
	
	@ApiOperation(value="getMileBalance", notes="마일리지 잔액 확인") //WIP
	@PostMapping("/getMileBalance.do")
	public int getMileBalance(int mileagePk) {
		try {
			return accountService.getMileBalance(mileagePk);
		} catch(Exception e) {
//		model.addAttribute("title", "Error - Occured");
//		model.addAttribute("message", "Error Occured :"+e.getMessage());
		System.out.println("Error :"+e.getMessage()+e.toString());
			return 0;
		}
	}
	
	@ApiOperation(value="getMileHistory", notes="마일리지 내역 확인") //WIP
	@PostMapping("/getMileHistory.do")
	public List<MileageHistory> getMileHistory(int userId) {
		try {
			List<MileageHistory> list = accountService.getMileHistory(userId);
			for(MileageHistory mi : list) System.out.println(mi);
			return list;
		} catch(Exception e) {
	//		model.addAttribute("title", "Error - Occured");
	//		model.addAttribute("message", "Error Occured :"+e.getMessage());
			System.out.println("Error :"+e.getMessage()+e.toString());
			return null;
		}
	}
	
	@ApiOperation(value="addMile", notes="마일리지 충전") //WIP
	@GetMapping("/addMile.do")
	public String addMile(int amount, int userId) {
		try {
			String status = "";
			accountService.addMile(amount, userId);
			return status;
		} catch(Exception e) {
	//		model.addAttribute("title", "Error - Occured");
	//		model.addAttribute("message", "Error Occured :"+e.getMessage());
			System.out.println("Error :"+e.getMessage()+e.toString());
			return null;
		}
	}
	
	@ApiOperation(value="getMilePk", notes="마일리지 PK 확인") //WIP
	@PostMapping("/getMilePk.do")
	public int getMilePk(int userId) {
		try {
				return accountService.getMilePk(userId);
		} catch(Exception e) {
		//		model.addAttribute("title", "Error - Occured");
		//		model.addAttribute("message", "Error Occured :"+e.getMessage());
				System.out.println("Error :"+e.getMessage()+e.toString());
				return 0;
		}
	}
}
