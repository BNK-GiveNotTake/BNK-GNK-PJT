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
		System.out.println("#######");
		return "login_success";
		
	}
	
	@PostMapping("login.do")
	public String doLogin(Users user, Model model, HttpSession session) {
		try {
			System.out.println("로그인을 시도중...");
			
			Users selected = commonService.select(user);
			if(selected!=null) {
				session.setAttribute("loginUser", selected);
				return "index.jsp";
				
			}else {
				return "login";
			}
		}catch (Exception e){
			model.addAttribute("title", "로그인 에러");
			model.addAttribute("message", "로그인 중 에러 발생");
			
			return "Error";
			
			
		}
		
	}
	
	@GetMapping("regUser.do")
	public String getRegUser(Model model) {
		
		model.addAttribute("title", "회원 가입");
		
		return "UserReg";
	}
	
//	@PostMapping("saveUser.do")
//	public Users doRegUser(Users user, Model model) {
//		try {
//			// 성공페이지
//			System.out.println(user.toString());
//			commonService.insert(user);
//			model.addAttribute("title", "회원 가입 성공");
//			model.addAttribute("user", user);
//			return user;
//		}catch(Exception e) {
//			// 에러페이지
//			model.addAttribute("title", "회원 가입 실패");
//			System.out.println("********************");
//			return new Users();
//		}
//	}
		
		
		
		@PostMapping("saveUser.do")
		public Map<String,Users> doRegUser(Users user, Model model) {
			try {
				// 성공페이지
				Map<String,Users> maps = new HashMap<String,Users>();
				Users user1 = new Users();
				commonService.insert(user);
				model.addAttribute("title", "회원 가입 성공");
				model.addAttribute("user", user);
				user1.setUserEmail(user.getUserEmail());
				user1.setUserName(user.getUserName());
				user1.setUserPassword(user.getUserPassword());
				
				maps.put("1",user1);
				
				
				return maps ;
				
			}catch(Exception e) {
				// 에러페이지
				Map<String,Users> maps = new HashMap<String,Users>();
				model.addAttribute("title", "회원 가입 실패");
				Users user1 = new Users();
				user1.setUserEmail("로그인실패");
				user1.setUserName("로그인실패");
				user1.setUserPassword("로그인실패");
				maps.put("1",user1);
				
				return maps;
			}
		}
		
		@PostMapping("userinfo.do")
		public Map<String,Users> userinfo(int userId, Model model){
			try {
				Map<String,Users> maps = new HashMap<String,Users>();
				System.out.println("1111111^&*^&*!@@%$#&*");
				Users user1 = commonService.getUserById(userId);
				System.out.println(user1);
				model.addAttribute("title", "고객 정보 조회");
				maps.put("1",user1);
				
				System.out.println("#$%^$%^%");
				return maps;
			}catch(Exception e){
				
				Map<String,Users> maps = new HashMap<String,Users>();
				model.addAttribute("title", "고객 정보 조회 실패");
				Users user1 = new Users();
				user1.setUserEmail("로그인실패");
				user1.setUserName("로그인실패");
				user1.setUserPassword("로그인실패");
				maps.put("1",user1);
				
				return maps;
			}		
		}
	
	
	
	
	
}
