package com.online.store.service;

import java.util.List;

import com.online.store.entity.Role;

public interface RoleService {
	List<Role> findAll();

	Role findByRoleId(Integer roleId);

	Role findByRoleType(String roleType);
}
