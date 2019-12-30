package com.online.store.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.store.entity.Role;
import com.online.store.repository.RoleRepository;
import com.online.store.service.RoleService;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return this.roleRepository.findAll();
	}

	@Override
	public Role findByRoleId(Integer roleId) {
		return this.roleRepository.findByRoleId(roleId);
	}

	@Override
	public Role findByRoleType(String roleType) {
		return this.roleRepository.findByRoleType(roleType);
	}
}
