package com.cos.blog.repository;


import com.cos.blog.model.Account;

public interface AccountRepository {
	//가장 기본적인 로직이 들어간다.
	//CRUD를 조합하는게 Service가 된다.
	public void update(Account account);
	public java.util.List<Account> findAll();
	public Account findByAccountNumber(String accountNumber);
	// return 되는 타입을 Persistence 꽉 쥐고 있다.
}
