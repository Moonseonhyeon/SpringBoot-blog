package com.cos.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping
	public String TestIndex() {
		System.out.println("안녕");
		return "index";
	}
}
