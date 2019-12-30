package com.online.store.controller;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.online.store.entity.Image;
import com.online.store.model.CommentInfo;
import com.online.store.model.ProductInfo;
import com.online.store.service.ProductService;

@Controller
public class MainController {

	@Autowired
	private ProductService productService;

	private void customPagedlistHolder(List<ProductInfo> products, HttpServletRequest request, Integer page) {
		PagedListHolder<ProductInfo> pagedListHolder = new PagedListHolder<>(products);
		pagedListHolder.setMaxLinkedPages(5);
		pagedListHolder.setPageSize(12);
		if (page == null) {
			pagedListHolder.setPage(0);
		} else {
			pagedListHolder.setPage(page);
		}
		request.getSession().setAttribute("pagedListHolder", pagedListHolder);
	}

	private String convertStringToUrl(String str) {
		try {
			String temp = Normalizer.normalize(str, Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			return pattern.matcher(temp).replaceAll("").toLowerCase().replace(" ", "-").replace("đ", "d");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@GetMapping({ "/home", "/" })
	private ModelAndView getHomePage(@RequestParam(required = false) Integer page, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("home");
		List<ProductInfo> products = this.productService.findAll();
		customPagedlistHolder(products, request, page);
		return mv;
	}

	@GetMapping("/{productName}")
	private ModelAndView getProductDetailsPage(@PathVariable(required = true) String productName) {
		ModelAndView mv = new ModelAndView("product_details");
		ProductInfo product = this.productService.getProductInfoByName(productName);
		Set<Image> images = new HashSet<>();
		List<Image> imagesSorted = null;
		Image image = null;
		for (Image img : product.getImages()) {
			image = new Image(img.getImageId(), img.getImage());
			images.add(image);
		}
		imagesSorted = new ArrayList<Image>(images);
		Collections.sort(imagesSorted);
		mv.addObject("product", product);
		mv.addObject("images", imagesSorted);
		mv.addObject("commentInfo", new CommentInfo());
		return mv;
	}

	@GetMapping("/search")
	private @ResponseBody List<ProductInfo> searchAutocomplete(HttpServletRequest request) {
		return this.productService.searchAutocomplete(request.getParameter("term"));
	}

	@PostMapping("/search-product")
	private String searchProduct(@RequestParam String keyword) {
		String url = convertStringToUrl(keyword);
		return "redirect:/search-product/" + url;
	}

	@GetMapping("/search-product/{keyword}")
	private ModelAndView getProductListBySearch(@PathVariable(required = true) String keyword,
			@RequestParam(required = false) Integer page, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("home");
		List<ProductInfo> products = this.productService.searchProductInfo(keyword);
		customPagedlistHolder(products, request, page);
		return mv;
	}

	@PostMapping("/sort-brand")
	private String searchProductByBrand(@RequestParam("brand") String brand) {
		return "redirect:/sort-brand/" + brand;
	}

	@GetMapping("/sort-brand/{brand}")
	private ModelAndView getProductListBySortBrand(@PathVariable(required = true) String brand,
			@RequestParam(required = false) Integer page, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("home");
		List<ProductInfo> products = this.productService.searchProductBySortBrand(brand);
		customPagedlistHolder(products, request, page);
		mv.addObject("brand", brand);
		return mv;
	}

	@PostMapping("/sort-price")
	private String searchProductByPrice(@RequestParam("priceType") String priceType) {
		return "redirect:/sort-price/" + priceType;
	}

	@GetMapping("/sort-price/{priceType}")
	private ModelAndView getProductListBySortPrice(@PathVariable(required = true) String priceType,
			@RequestParam(required = false) Integer page, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("home");
		List<ProductInfo> products = this.productService.searchProductBySortPrice(priceType);
		customPagedlistHolder(products, request, page);
		mv.addObject("priceType", priceType);
		return mv;
	}
	
	@PostMapping("/post-comment")
	private ModelAndView saveComment() {
		ModelAndView mv = new ModelAndView("product_details");
		return mv;
	}
}
