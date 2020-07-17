package com.cos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.dto.WithdrawRequestDto;
import com.cos.blog.dto.SendRequestDto;
import com.cos.blog.model.Account;
import com.cos.blog.repository.AccountRepository;

@Service
public class AccountService {

	//DI
	@Autowired
	private AccountRepository accountRepository;
	
	//스프링이 들고 있는 트랜젝션
	//밑에 줄중에 하나가 실패하면 rollback, 둘다 성공하면 commit
	@Transactional
	public void 송금(SendRequestDto dto) {
		//보내는 사람 업데이트
			Account 홍길동 = accountRepository.findByAccountNumber(dto.getSenderAccountNumber());
				홍길동.setMoney(홍길동.getMoney() - dto.getMoney());
				accountRepository.update(홍길동);
				
		//받는 사람 업데이트
				Account 장보고 = accountRepository.findByAccountNumber(dto.getReceiverAccountNumber());
				장보고.setMoney(장보고.getMoney() + dto.getMoney());
				accountRepository.update(장보고);
				
	}
	
	@Transactional
	public void 인출(WithdrawRequestDto dto) {
		Account 홍길동
		= accountRepository.findByAccountNumber(dto.getAccountNumber());//DB랑 동기화 되어있는 있는 것이 Persistance
		홍길동.setMoney(홍길동.getMoney() - dto.getMoney());	
		accountRepository.update(홍길동);
	}
	
	// 트랜잭션을 타게하는 이유: isolation때문에 데이터의 정확성 때문. 중요하다.
	@Transactional(readOnly = true) 
public List<Account> 계좌정보보기(){
	return accountRepository.findAll();
}
	//서비스 종료시 commit된다.

}
