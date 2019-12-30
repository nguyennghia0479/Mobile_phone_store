package com.online.store.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.store.dao.AccountDao;
import com.online.store.model.AccountInfo;
import com.online.store.service.AccountService;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Override
	public AccountInfo findByUsername(String username) {
		return this.accountDao.findByUsername(username);
	}

	@Override
	public List<String> getAccountRoles(String username) {
		return this.accountDao.getAccountRoles(username);
	}

	@Override
	public AccountInfo findByEmail(String email) {
		return this.accountDao.findByEmail(email);
	}

	@Override
	public void saveAccount(AccountInfo accountInfo) {
		this.accountDao.saveAccount(accountInfo);
	}
}
