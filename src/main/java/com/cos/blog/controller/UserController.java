package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/auth/joinProc")
	public @ResponseBody CommonRespDto<?> joinProc(@RequestBody User user) { //key=valu 데이터만 받을 수 있는데 @RequestBody를 적으면 web.xml에 spring 
		userService.회원가입(user);
		return new CommonRespDto<String>(1, "회원가입 완료"); 
	}
}
