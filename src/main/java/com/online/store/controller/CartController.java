package com.online.store.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.online.store.model.AccountInfo;
import com.online.store.model.BillInfo;
import com.online.store.model.CartInfo;
import com.online.store.model.ProductInfo;
import com.online.store.service.AccountService;
import com.online.store.service.BillService;
import com.online.store.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private BillService billService;
	
	@Autowired
	private AccountService accountService;

	@PostMapping("/remove-item")
	private ModelAndView removeItem(@RequestParam Long productId, HttpSession session) {
		ModelAndView mv = new ModelAndView("cart");
		this.cartService.removeItemFromCart(productId);
		List<CartInfo> cartItems = this.cartService.getListItems();
		session.setAttribute("cartItems", cartItems);
		session.setAttribute("totalPrice", this.cartService.totalPriceItem());
		session.setAttribute("totalQuantity", this.cartService.totalQuantityItem());
		if(this.cartService.totalQuantityItem() == 0) {
			session.removeAttribute("totalQuantity");
		}
		return mv;
	}

	@PostMapping("/add-cart")
	private void addCart(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		Long productId = Long.valueOf(request.getParameter("productId"));
		this.cartService.addItemToCart(productId);
		session.setAttribute("totalQuantity", this.cartService.totalQuantityItem());
		response.getWriter().print(this.cartService.totalQuantityItem());
	}

	@PostMapping("/update-cart")
	private void updateCart(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		String quantityStr = request.getParameter("number");
		if (!quantityStr.equals("")) {
			Integer quantity = Integer.valueOf(quantityStr);
			if (quantity <= 0) {
				quantity = 1;
			}
			Long productId = Long.valueOf(request.getParameter("productId"));
			this.cartService.updateCart(productId, quantity);
		}
		Long totalPrice = this.cartService.totalPriceItem();
		NumberFormat formatter = new DecimalFormat("#,###,###,###");
		String number = formatter.format(totalPrice);
		session.setAttribute("totalPrice", totalPrice);
		session.setAttribute("totalQuantity", this.cartService.totalQuantityItem());
		response.getWriter().print(number + " VND");
	}

	@PostMapping("/buy-item")
	private String buyItem(@RequestParam Long productId, HttpSession session) {
		this.cartService.addItemToCart(productId);
		session.setAttribute("totalQuantity", this.cartService.totalQuantityItem());
		return "redirect:/cart";
	}

	@GetMapping("/cart")
	private ModelAndView getCartPage(HttpSession session) {
		ModelAndView mv = new ModelAndView("cart");
		List<CartInfo> cartItems = this.cartService.getListItems();
		session.setAttribute("cartItems", cartItems);
		session.setAttribute("totalPrice", this.cartService.totalPriceItem());
		return mv;
	}

	@GetMapping("/checkout")
	private ModelAndView getCheckOutPage(HttpSession session) {
		ModelAndView mv = new ModelAndView("checkout");
		BillInfo bill = new BillInfo();
		List<CartInfo> cartItems = this.cartService.getListItems();
		session.setAttribute("totalItems", cartItems.size());
		session.setAttribute("cartItems", cartItems);
		session.setAttribute("totalPrice", this.cartService.totalPriceItem());
		if(SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
			mv.addObject("billInfo", bill);
		} else {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			AccountInfo account = this.accountService.findByUsername(username);
			if(account != null) {
				bill.setFullName(account.getFullName());
				bill.setPhoneNumber(account.getPhoneNumber());
				bill.setEmail(account.getEmail());
				mv.addObject("billInfo", bill);
				mv.addObject("account", true);
			} else {
				mv.addObject("billInfo", bill);
			}
		}
		return mv;
	}

	@PostMapping("/checkout")
	private ModelAndView doCheckout(@ModelAttribute("billInfo") BillInfo billInfo, HttpSession session) {
		ModelAndView mv = new ModelAndView("success");
		List<ProductInfo> productInfos = new ArrayList<>();
		List<CartInfo> cartItems = this.cartService.getListItems();
		for (CartInfo item : cartItems) {
			productInfos.add(item.getProductInfo());
		}
		billInfo.setTotalPrice(this.cartService.totalPriceItem());
		billInfo.setTotalQuantity(this.cartService.totalQuantityItem());
		billInfo.setProducts(productInfos);
		this.billService.saveBill(billInfo);
		this.cartService.removeAllItem();
		session.removeAttribute("totalQuantity");
		return mv;
	}
}
