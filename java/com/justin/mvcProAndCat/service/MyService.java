package com.justin.mvcProAndCat.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.mvcProAndCat.models.Category;
import com.justin.mvcProAndCat.models.Product;
import com.justin.mvcProAndCat.repositories.CategoryRepository;
import com.justin.mvcProAndCat.repositories.ProductRepository;

@Service
public class MyService {

	private final CategoryRepository catRepo;
	private final ProductRepository proRepo;

	public MyService(CategoryRepository catRepo, ProductRepository proRepo) {
		this.catRepo = catRepo;
		this.proRepo = proRepo;
	}

//	CREATE PRODUCT
	public Product createProduct(Product product) {
		return proRepo.save(product);
	}

//	FIND PRODUCT BY ID
	public Product findProductById(Long id) {
		Optional<Product> product = proRepo.findById(id);
		if (product.isPresent()) {
			return product.get();
		} else {
			return null;
		}
	}

//	CREATE CATEGORY
	public Category createCategory(Category category) {
		return catRepo.save(category);
	}

//	FIND CATEGORY BY ID
	public Category findCategoryById(Long id) {
		Optional<Category> cat = catRepo.findById(id);
		if (cat.isPresent()) {
			return cat.get();
		} else {
			return null;
		}
	}

//	FIND CATEGORIES EXCLUDING THE PRODUCT CATEGORIES
	public List<Category> findCategoriesNotInProduct(Long id) {
		Optional<Product> optionalProduct = proRepo.findById(id);
		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			ArrayList<Long> catsId = new ArrayList<>();
			for (Category cat : product.getCategories()) {
				catsId.add(cat.getId());
			}
			return catRepo.findByIdNotIn(catsId);
		} else {
			return null;
		}
	}
//  FIND PRODUCTS NOT IN CATEGORY
	public List<Product> findProductsNotInCategory(Long id) {
		Optional <Category> optionalCategory = catRepo.findById(id);
		if(optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			ArrayList<Long> prosId = new ArrayList<>();
			for (Product pro : category.getProducts()) {
				prosId.add(pro.getId());
			}
			return proRepo.findByIdNotIn(prosId);
		}else {
			return null;
		}	
	}
//	UPDATE PRODUCT
	public void updateProduct(Product product) {
		proRepo.save(product);
	}
//	UPDATE CATEGORY
	public void updateCategory(Category category) {
		catRepo.save(category);
	}

}
