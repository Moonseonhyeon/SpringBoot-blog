package com.cos.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping({"","/"})
	public String index() {
		return "redirect:/posts";
	}
	
	@GetMapping("/auth/joinForm")
	public String joinFrom() {
		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginFrom() {
		return "user/loginForm";
	}
	
	@GetMapping("/auth/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/"; //index적지말고 index로 가는 함수있으니까 거기로 재요청
	}
}
