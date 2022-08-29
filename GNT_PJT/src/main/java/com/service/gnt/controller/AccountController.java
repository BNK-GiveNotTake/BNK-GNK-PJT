package com.service.gnt.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.gnt.domain.account.MileageHistory;
import com.service.gnt.model.service.AccountService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@ApiOperation(value="createAcc", notes="계좌 생성")
	@GetMapping("/createAcc.do")
	public void createAcc(HttpServletResponse response, int userId, int accPassword, String userEmail, String userEngName,
			String address, String userPhone) throws Exception {
		accountService.createAcc(userId, accPassword, userEmail, userEngName, address, userPhone);

	}
	
	@ApiOperation(value="depositAcc", notes="계좌 입금")
	@GetMapping("/depositAcc.do")
	public void depositAcc(int userId, int amount) {
		accountService.depositAcc(userId, amount);
	}
	@ApiOperation(value="sendAcc", notes="송금")
	@GetMapping("/sendAcc.do")
	public void sendAcc(int userId, int amount, String accId) {
		accountService.sendAcc(userId, amount, accId);
	}
	@ApiOperation(value="createMile", notes="마일리지 생성")
	@GetMapping("/createMile.do")
	public void createMile(int userId) {
		accountService.createMile(userId);
	}
	@ApiOperation(value="getMileBalance", notes="마일리지 잔액 확인")
	@GetMapping("/getMileBalance.do")
	public int getMileBalance(int mileagePk) {
		return accountService.getMileBalance(mileagePk);
	}
	@ApiOperation(value="getMileHistory", notes="마일리지 내역 확인")
	@GetMapping("/getMileHistory.do")
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
	@GetMapping("/getMilePk.do")
	public int getMilePk(int userId) {
		return accountService.getMilePk(userId);
	}
}
