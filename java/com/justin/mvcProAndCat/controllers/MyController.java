package com.justin.mvcProAndCat.controllers;


import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.justin.mvcProAndCat.models.Category;
import com.justin.mvcProAndCat.models.Product;
import com.justin.mvcProAndCat.service.MyService;

@Controller
public class MyController {

	private final MyService service;
	
	public MyController(MyService service) {
		this.service=service;
	}
	
//	NEW PRODUCT PAGE
	@GetMapping("/products")
	public String products(@ModelAttribute("newproduct") Product newproduct) {
		return "/views/products.jsp";
	}
//	CREATE NEW PRODUCT
	@PostMapping("/products")
	public String createP(@ModelAttribute("newproduct") Product newproduct, BindingResult result) {
		if(result.hasErrors()) {
			return "/views/products.jsp";
		}else {
			Product createdProduct=service.createProduct(newproduct);
			return "redirect:/products/"+createdProduct.getId();
		}
	}
//	PRODUCT DESCRIPTION PAGE
	@GetMapping("/products/{id}")
	public String showP(@PathVariable("id")Long id, Model model) {
		Product product = service.findProductById(id);
		model.addAttribute("product", product);
		//	LIST OF CATEGORY WHERE PRODUCTS DONT EXIST
		List <Category> otherCats =service.findCategoriesNotInProduct(id);
		model.addAttribute("otherCats", otherCats);
		return "/views/propage.jsp";
	}

	//	NEW CATEGORY PAGE
	@GetMapping("/categories")
	public String categories(@ModelAttribute("newcategory") Category newcategory) {
		return "/views/categories.jsp";	
	}
//	CREATE NEW CATEGORY
	@PostMapping("/categories")
	public String showC(@ModelAttribute("newcategory") Category newcategory, BindingResult result) {
		if(result.hasErrors()) {
			return "/views/categories.jsp";
		}else {
			Category createdCategory= service.createCategory(newcategory);
			return "redirect:/categories/"+createdCategory.getId();
		}
	}
//	CATEGORY DESCRIPTION PAGE
	@GetMapping("/categories/{id}")
	public String showC(@PathVariable("id") Long id, Model model) {
		Category category= service.findCategoryById(id);
		model.addAttribute("category", category);
		//	LIST OF PRODUCTS WHERE CATEGORIES DONT EXIST
		List <Product> otherProducts = service.findProductsNotInCategory(id);
		model.addAttribute("otherProducts", otherProducts);
		System.out.println(otherProducts);
		return "/views/catpage.jsp";
	}
//	ADD CATEGORY TO PRODUCT
	@PostMapping("/products/{id}/add")
	public String addCat(@PathVariable("id") Long id, @RequestParam("newCategory") Long catId) {
		Product product = service.findProductById(id);
		Category category = service.findCategoryById(catId);
		List <Category> catList = product.getCategories();
		catList.add(category);
		product.setCategories(catList);
		service.updateProduct(product);
		System.out.println(product.getName());
		System.out.println(category.getName());
		return "redirect:/products/"+id;
	}
//	ADD PRODUCT TO CATEGORY
	@PostMapping("/categories/{id}/add")
	public String addPro(@PathVariable("id") Long id, @RequestParam("newProduct")Long proId) {
		Category category = service.findCategoryById(id);
		Product product = service.findProductById(proId);
		List <Product> proList = category.getProducts();
		proList.add(product);
		category.setProducts(proList);
		service.updateCategory(category);
		return "redirect:/categories/"+id;
	}
	
	
	
	
	
	
	
	
	
}
