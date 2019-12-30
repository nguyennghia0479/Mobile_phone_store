package com.online.store.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.online.store.entity.Role;
import com.online.store.service.RoleService;

@Component
public class RoleConverter implements Converter<Object, Role> {
	
	@Autowired
	private RoleService roleService;

	@Override
	public Role convert(Object obj) {
		Integer roleId = Integer.parseInt((String) obj);
		Role role = this.roleService.findByRoleId(roleId);
		System.out.println("ROLE_CONVERTER: " + role.getRoleType());
		return role;
	}
}
