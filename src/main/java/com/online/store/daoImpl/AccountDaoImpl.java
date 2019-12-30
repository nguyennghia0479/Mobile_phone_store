package com.online.store.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.online.store.dao.AccountDao;
import com.online.store.entity.Account;
import com.online.store.entity.Role;
import com.online.store.model.AccountInfo;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public AccountInfo findByUsername(String username) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<AccountInfo> query = builder.createQuery(AccountInfo.class);
		Root<Account> rootAccount = query.from(Account.class);
		Path<Long> accountId = rootAccount.get("accountId");
		Path<String> fullName = rootAccount.get("fullName");
		Path<String> phoneNumber = rootAccount.get("phoneNumber");
		Path<String> email = rootAccount.get("email");
		Path<String> userName = rootAccount.get("username");
		Path<String> password = rootAccount.get("password");
		query.multiselect(accountId, fullName, phoneNumber, email, userName, password);
		query.where(builder.or(builder.like(userName, username), builder.like(email, username)));
		List<AccountInfo> accounts = this.entityManager.createQuery(query).getResultList();
		if(accounts.isEmpty()) {
			return null;
		}
		AccountInfo accountInfo = accounts.get(0);
		return accountInfo;
	}

	@Override
	public List<String> getAccountRoles(String username) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<String> query = builder.createQuery(String.class);
		Root<Account> accountRoot = query.from(Account.class);
		Join<Account, Role> roles = accountRoot.join("roles");
		Path<String> userName = accountRoot.get("username");
		Path<String> email = accountRoot.get("email");
		query.select(roles.get("roleType"));
		query.where(builder.or(builder.like(userName, username)), builder.like(email, username));
		List<String> list = this.entityManager.createQuery(query).getResultList();
		return list;
	}

	@Override
	public AccountInfo findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAccount(AccountInfo accountInfo) {
		Account account = new Account();
		account.setFullName(accountInfo.getFullName());
		account.setPhoneNumber(accountInfo.getPhoneNumber());
		account.setEmail(accountInfo.getEmail());
		account.setUsername(accountInfo.getUsername());
		account.setPassword(this.passwordEncoder.encode(accountInfo.getPassword()));
		account.setRoles(accountInfo.getRoles());
		this.entityManager.persist(account);
		this.entityManager.flush();
	}

}
