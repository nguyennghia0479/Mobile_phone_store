package com.online.store.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.online.store.entity.Role;
import com.online.store.model.AccountInfo;
import com.online.store.service.AccountService;
import com.online.store.service.RoleService;
import com.online.store.service.SecurityService;

@Controller
public class LoginController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private RoleService roleService;

	@GetMapping("/admin/")
	private String adminPage() {
		return "admin";
	}

	@GetMapping("/login")
	private ModelAndView getLoginPage() {
		ModelAndView mv = new ModelAndView();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		if (username.equals("anonymousUser")) {
			mv.addObject("account", new AccountInfo());
			mv.setViewName("login");
		} else {
			mv.setViewName("home");
		}
		return mv;
	}

	@GetMapping("/logoutSuccessful")
	private String logout() {
		return "redirect:/home";
	}

	@GetMapping("/403")
	private ModelAndView accessDenied(Principal principal) {
		ModelAndView mv = new ModelAndView("403");
		if (principal != null) {
			mv.addObject("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			mv.addObject("message", "<br> You do not have permission to access this page!");
		}
		return mv;
	}

	@PostMapping("/register")
	private String registerAccount(@ModelAttribute("account") AccountInfo account) {
		Role role = this.roleService.findByRoleType("USER");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		account.setRoles(roles);
		this.accountService.saveAccount(account);
		this.securityService.autoLogin(account.getUsername(), account.getPassword());
		return "redirect:/home";
	}
}
