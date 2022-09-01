package com.service.gnt.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.gnt.domain.users.Users;
import com.service.gnt.model.service.CommonService;

import io.swagger.annotations.ApiOperation;


@RestController
public class CommonController {
	
	@Autowired
	private CommonService commonService;
	String uri ="";
	/*
	@GetMapping("/")
	public String index() {
		return "redirect:index.jsp";
		
	}*/
	
	@ApiOperation(value="index page", notes="Start 페이지로 이동")
	@GetMapping("/")
	public void index(HttpServletResponse response) throws Exception {
		uri = "Main/Start.html";
		response.sendRedirect(uri);
	}
	
	@ApiOperation(value="Swagger", notes="Swagger-ui page로 이동")
	@GetMapping("/swagger")
	public void swagger(HttpServletResponse response) throws Exception {
		uri = "swagger-ui.html";
		response.sendRedirect(uri);
	}
	
	@GetMapping("login.do")
	public String getLoginForm() {
		return "login_success";
	}
	
	@PostMapping("login.do")
	public Map<String,Object> doLogin(Users user, Model model, HttpSession session) {
		Map<String,Object> maps = new HashMap<String,Object>();
		String message = "no";
		try {
			System.out.println("로그인을 시도중...");
			
			Users selected = commonService.select(user);
			if(selected!=null) {
				maps.put("userinfo", selected);
				message = "yes";
				maps.put("message", message);
				return maps;
				
			}else {
				maps.put("message", message);
				return maps;
			}
		}catch (Exception e){
			model.addAttribute("title", "로그인 에러");
//			model.addAttribute("message", "로그인 중 에러 발생");
			maps.put("message", message);
			return maps;
			
		}
	}
	
	@PostMapping("overlapCheck.do")
	public Map<String,Object> Check(Users user, Model model) {
		String message = "no";
		Users find = commonService.select01(user);
		Map<String,Object> maps = new HashMap<String,Object>();
		if(find!=null) {
//			maps.put("1", find);
			maps.put("message", message);
			return maps;
			
		}else {
			if(user.getUserEmail()=="") {
				maps.put("message", message);
				return maps;
				
			}
				message = "yes";
				maps.put("message", message);
				return maps;
		}
	}
//	@GetMapping("regUser.do")
//	public String getRegUser(Model model) {
//		
//		model.addAttribute("title", "회원 가입");
//		
//		return "UserReg";
//	}
	

	@PostMapping("saveUser.do")
	public Map<String,Object> doRegUser(Users user, Model model) {
		String message = "no";
		try {
			// 성공페이지
			Map<String,Object> maps = new HashMap<String,Object>();
			Users user1 = new Users();
			Users find = commonService.select01(user);
			if(find!=null) {
				maps.put("1", find);
				message = "no";
				maps.put("message", message);
				return maps;
				
			}
			
			else {
			commonService.insert(user);
			
			user1.setUserEmail(user.getUserEmail());
			user1.setUserName(user.getUserName());
			user1.setUserPassword(user.getUserPassword());
			message = "yes";
			maps.put("userinfo", user1);
			maps.put("message", message);
			System.out.println(user1);
			return maps ;
			}
			
		}catch(Exception e) {
			// 에러페이지
			Map<String,Object> maps = new HashMap<String,Object>();
			model.addAttribute("title", "회원 가입 실패");
			Users user1 = new Users();
			user1.setUserEmail("회원 가입 실패");
			user1.setUserName("회원 가입 실패");
			user1.setUserPassword("회원 가입 실패");
			maps.put("1",user1);
			maps.put("message", message);
			
			return maps;
		}
	}
		
		@PostMapping("userinfo.do")
		public Map<String,Object> userinfo(int userId, Model model){
			String message="no";
			try {
				Map<String,Object> maps = new HashMap<String,Object>();
				Users user1 = commonService.getUserById(userId);
				System.out.println(user1);
				model.addAttribute("title", "고객 정보 조회");
				message="yes";
				maps.put("getUserbyId",user1);
				maps.put("message", message);
				return maps;
			}catch(Exception e){
				
				Map<String,Object> maps = new HashMap<String,Object>();
				model.addAttribute("title", "고객 정보 조회 실패");
				Users user1 = new Users();
				user1.setUserEmail("조회 실패");
				user1.setUserName("조회 실패");
				user1.setUserPassword("조회 실패");
				maps.put("1",user1);
				maps.put("message", message);
				
				return maps;
			}		
		}
	
	
	
	
	
}
