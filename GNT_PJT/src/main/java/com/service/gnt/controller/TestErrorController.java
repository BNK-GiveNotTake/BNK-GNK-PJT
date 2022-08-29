package com.service.gnt.controller;

import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@Component
@RequestMapping("my-error-controller")
@ApiIgnore 
public class TestErrorController extends BasicErrorController {

	public TestErrorController() {
		super(new DefaultErrorAttributes(), new ErrorProperties());
	}
   // basic constructor
}
