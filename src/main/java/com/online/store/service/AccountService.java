package com.online.store.service;

import java.util.List;

import com.online.store.model.AccountInfo;

public interface AccountService {
	AccountInfo findByUsername(String username);

	List<String> getAccountRoles(String username);
	
	AccountInfo findByEmail(String email);
	
	void saveAccount(AccountInfo accountInfo);
}
