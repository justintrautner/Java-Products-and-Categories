package com.justin.mvcProAndCat.repositories;



import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.justin.mvcProAndCat.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	List<Product> findByIdNotIn(ArrayList<Long> prosId);

	
	
	
}
