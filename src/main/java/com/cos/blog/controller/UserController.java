package com.cos.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
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
	public @ResponseBody CommonRespDto<?> joinProc(@RequestBody User user) { // key=valu 데이터만 받을 수 있는데 @RequestBody를 적으면
																				// web.xml에 spring
		userService.회원가입(user);
		return new CommonRespDto<String>(1, "회원가입 결과 : ");
	}

	@PostMapping("/auth/loginProc")
	public @ResponseBody CommonRespDto<?> loginProc(@RequestBody User user, HttpSession session) { // DI하는 방법 2번. 1번은
																									// 전역에 @AutoWired하기
		User persistUser = userService.로그인(user);

		if (ObjectUtils.isEmpty(persistUser)) { // 스프링이 들고 있는 ObjectUtils객체가 있음.
			System.out.println("없음");
			return new CommonRespDto<String>(-1, "로그인 결과 실패");
		} else {
			System.out.println("있음");
			// 세션 등록해야 함.
			session.setAttribute("principal", persistUser);
			return new CommonRespDto<String>(1, "로그인 결과 성공");
		}
	}
}
