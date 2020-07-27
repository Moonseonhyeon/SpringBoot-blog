package com.cos.blog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.config.handler.exception.MyRoleException;
import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.model.Post;
import com.cos.blog.model.User;
import com.cos.blog.repository.PostRepository;
import com.cos.blog.repository.UserRepository;
import com.cos.blog.service.PostService;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {

	private final PostService postService; // 이게 AutoWired다!
	private final PostRepository postRepository;

	/*
	 * public PostController(PostService postService) { this.postService =
	 * postService; }
	 */

	@GetMapping("/post/saveForm")
	public String saveForm() {
		return "post/saveForm";
	}

	@PostMapping("/post")
	public @ResponseBody CommonRespDto<?> postProc(@RequestBody Post post) {
		System.out.println("컨트롤러");
		postService.글쓰기(post);
		return new CommonRespDto<String>(1, "글쓰기 성공");
	}

	// 인증 필요없음 //post관련된 건 전부다 인증 필요하게!
	@GetMapping("/posts")
	public String getPosts(Model model) { // Model은 request객체처럼 여기 데이터 담아두면 view까지 끌고간다.
		model.addAttribute("posts", postService.목록보기());
		return "index";
	}

	// ?뒤에주소 -> 쿼리스트링 받는 것
	// /post/{id} -> 파라메터를 받는 것
	@GetMapping("/post/{id}")
	public String getPost(@PathVariable int id, Model model) { // Model은 request객체처럼 여기 데이터 담아두면 view까지 끌고간다.
		model.addAttribute("postDetailRespDto", postService.상세보기(id));
		return "post/detail";
	}
	
	@DeleteMapping("/post/{id}")
	public @ResponseBody CommonRespDto<?> deleteById(@PathVariable int id, HttpSession session) throws MyRoleException {
		//세션 값 확인, 글의 주인
		Post postEntity = postRepository.findOne(id);
		User principal = (User)session.getAttribute("principal");
		if(principal.getId() != postEntity.getUserId()) {
			throw new MyRoleException();
			/* return new CommonRespDto<String>(-1, "권한이 없습니다."); */
							}
		postService.삭제하기(id);
		return new CommonRespDto<String>(1, "삭제 성공");
	}
	
	@PutMapping("/post/{id}")
	public @ResponseBody CommonRespDto<?> update(@RequestBody Post post) {
		postService.수정하기(post);
		return new CommonRespDto<String>(1, "수정 성공");
	}

}
