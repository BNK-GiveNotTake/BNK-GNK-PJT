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
import org.springframework.web.bind.annotation.RestController;

import com.service.gnt.domain.users.Users;
import com.service.gnt.model.service.CommonService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class CommonController {
	
	@Autowired
	private CommonService commonService;
	
	/*
	 * @Autowired private GntService gntService;
	 
	String uri ="";
	@ApiOperation(value="index page", notes="Start 페이지로 이동")
	@GetMapping("/")
	public void index(HttpServletResponse response) throws Exception {
		//uri = "Main/Start.html";
		uri = "swagger-ui.html"; //임시로 스웨거로 연결했음.
		response.sendRedirect(uri);
	}
	
	@ApiOperation(value="Swagger", notes="Swagger-ui page로 이동")
	
	@GetMapping("/swagger")
	public void swagger(HttpServletResponse response) throws Exception {
		uri = "swagger-ui.html";
		response.sendRedirect(uri);
	}
	*/
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
	public String doRegUser(@RequestBody Users user, Model model) {
		try {
			// 성공페이지
			System.out.println(user.toString());
			commonService.insert(user);
			System.out.println("---------------------------user이후");
			model.addAttribute("title", "회원 가입 성공");
			
			return "Result";
		}catch(Exception e) {
			// 에러페이지
			model.addAttribute("title", "회원 가입 실패");
			System.out.println("********************");
			return "Error";
		}
		
		
	}
	
	
	
	
	
	
}
