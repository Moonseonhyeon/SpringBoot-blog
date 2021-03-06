package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.controller.dto.PostDetailRespDto;
import com.cos.blog.model.Post;
import com.cos.blog.repository.PostRepository;

//Controller(Distpatcher Servlet이 띄워줌), Repository(MyBatis가 스캔해줌), Configuration(설정파일), Service(트랜젝션이 시작), Component
//RestController(데이터를 리턴하게 해줌), Bean(메서드에 거는 것임)

@Service//IoC
public class PostService {

		@Autowired 
		PostRepository postRepository; //DI
		
		@Transactional
		public void 글쓰기(Post post) {	
			postRepository.save(post);				
		}
		
		@Transactional(readOnly = true)
		public List<Post> 목록보기() {	
			return postRepository.findAll();				
		}
		
		@Transactional(readOnly = true)
		public PostDetailRespDto 상세보기(int id) {	
			return postRepository.findById(id);		
		}
		
		@Transactional(readOnly = true)
		public void 삭제하기(int id) {	
			postRepository.delete(id);	
		}
		
		@Transactional
		public void 수정하기(Post post) {	
			postRepository.update(post);	
		}
		
		
		
			
}
