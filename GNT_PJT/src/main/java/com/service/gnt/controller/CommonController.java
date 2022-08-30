package com.service.gnt.controller;

import java.io.IOException;

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


@RestController
public class CommonController {
	
	@Autowired
	private CommonService commonService;
  
	@GetMapping("/")
	public String index() {
		return "redirect:index.jsp";
		
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
	
	@PostMapping("saveUser.do")
	@ResponseBody
	public String doRegUser(Users user,Model model) {
		System.out.println("$#%$%%%%%%%%");
		try {
			// 성공페이지
			System.out.println("$#%$%%%%%%%%");
			System.out.println(user.toString());
			commonService.insert(user);
			System.out.println("---------------------------user이후");
			model.addAttribute("title", "회원 가입 성공");
			model.addAttribute("user", user);
			return "";
		}catch(Exception e) {
			// 에러페이지
			model.addAttribute("title", "회원 가입 실패");
			System.out.println("********************");
			return "Error";
		}
		
		
	}
	
	
	
	
	
	
}
