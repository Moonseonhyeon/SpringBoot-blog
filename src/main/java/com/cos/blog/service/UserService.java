package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

//Controller(Distpatcher Servlet이 띄워줌), Repository(MyBatis가 스캔해줌), Configuration(설정파일), Service(트랜젝션이 시작), Component
//RestController(데이터를 리턴하게 해줌), Bean(메서드에 거는 것임)

@Service//IoC
public class UserService {

		@Autowired 
		UserRepository userRepository; //DI
		
		@Transactional
		public void 회원가입(User user) {	
				user.setRole("ROLE_USER");
				userRepository.save(user);				
		}
		
		@Transactional(readOnly = true) //데이터 변경을 허용하지 않음 (혹시 이 트랜젝션이 끝나기 전에
		//다른 사용자가 데이터를 변경한 내용 때문에 엉키지않게 하려고)=> 정확성을 위해서
			public User 로그인(User user) {
			System.out.println(user);
				return userRepository.login(user);	
		}
			
}
