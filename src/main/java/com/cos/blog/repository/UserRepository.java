package com.cos.blog.repository;

import com.cos.blog.model.User;
//영속성, 자바 오브젝트를 꽉 잡고 있음.
public interface UserRepository {
	public void save(User user);
	
}
