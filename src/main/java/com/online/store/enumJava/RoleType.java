package com.online.store.enumJava;

public enum RoleType {
	ADMIN("ADMIN"), USER("USER");

	private String roleType;

	private RoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getRoleType() {
		return roleType;
	}
}
