package kr.green.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.AccountDao;
import kr.green.springtest.vo.AccountVo;

@Service
public class AccountServiceImp implements AccountService{
	@Autowired
	AccountDao accountDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public AccountVo signin(AccountVo loginInfo) {
		AccountVo user = accountDao.getAccount(loginInfo.getId()); // 비밀번호가 암호화 되어있기 때문에 id로 확인.
		if(user != null && passwordEncoder.matches(loginInfo.getPw(), user.getPw()))
			return user;
		return null;
	}

	@Override
	public boolean signup(AccountVo userInfo) {
		if(accountDao.getAccount(userInfo.getId()) != null) 
			return false;
		String encPw = passwordEncoder.encode(userInfo.getPw());
		userInfo.setPw(encPw);
		accountDao.setAccount(userInfo);
		return true;	
		
	}

	@Override
	public boolean isDuplicated(String id) {
		if(accountDao.getAccount(id) != null)
			return true;
		return false;
	}
	
	
}
