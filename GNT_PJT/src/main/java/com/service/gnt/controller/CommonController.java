package com.service.gnt.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class CommonController {
	
	/*
	 * @Autowired private GntService gntService;
	 */
	String uri ="";
	@ApiOperation(value="index page", notes="Start 페이지로 이동")
	@GetMapping("/")
	public void index(HttpServletResponse response) throws Exception {
		uri = "Main/Start.html";
//		uri = "swagger-ui.html"; //임시로 스웨거로 연결했음.
		response.sendRedirect(uri);
	}
	
	@ApiOperation(value="Swagger", notes="Swagger-ui page로 이동")
	@GetMapping("/swagger")
	public void swagger(HttpServletResponse response) throws Exception {
		uri = "swagger-ui.html";
		response.sendRedirect(uri);
	}
}
