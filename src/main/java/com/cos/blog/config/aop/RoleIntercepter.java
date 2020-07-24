package com.cos.blog.config.aop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cos.blog.config.handler.exception.MyRoleException;
import com.cos.blog.config.handler.exception.MySessionException;
import com.cos.blog.model.User;

// 로그인 뿐만 아니라 권한만 관리 /메모리에 띄울 필요없어. 내가 직접 new할거라서.
public class RoleIntercepter extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User principal = (User)session.getAttribute("principal");
		if(principal == null) {
			System.out.println("RoleIntercepter : 인증이 안됨");
			throw new MySessionException();
		} else {
			if(!principal.getRole().equals("ROLE_ADMIN")) {
				System.out.println("RoleIntercepter : 권한이 없어요");
				throw new MyRoleException();
			}
		}
		
		return true;
	}
}
