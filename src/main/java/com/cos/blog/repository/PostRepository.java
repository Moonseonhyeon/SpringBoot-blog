package com.cos.blog.repository;

import java.util.List;

import com.cos.blog.controller.dto.CommonRespDto;
import com.cos.blog.controller.dto.PostDetailRespDto;
import com.cos.blog.model.Post;
//영속성, 자바 오브젝트를 꽉 잡고 있음. mapping
public interface PostRepository {
	public void save(Post post);
	public List<Post> findAll();
	public PostDetailRespDto findById(int id);
	public Post findOne(int id);
	public void delete(int id);
	public void update(Post post);
	
}

//인터페이스니까 new 할 수 없고 내부적으로 익명클래스가 임플리먼트해가지고 만들어져 있을 거임.
