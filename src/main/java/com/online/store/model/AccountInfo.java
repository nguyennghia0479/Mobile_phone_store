package com.online.store.model;

import java.util.HashSet;
import java.util.Set;

import com.online.store.entity.Role;

public class AccountInfo {
	private Long accountId;
	private String fullName;
	private String phoneNumber;
	private String email;
	private String username;
	private String password;
	private Set<Role> roles = new HashSet<>();

	public AccountInfo() {
	}

	public AccountInfo(Long accountId, String fullName, String phoneNumber, String email, String username,
			String password) {
		this.accountId = accountId;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
