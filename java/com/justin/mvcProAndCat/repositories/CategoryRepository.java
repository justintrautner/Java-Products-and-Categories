package com.justin.mvcProAndCat.repositories;



import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justin.mvcProAndCat.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

	List<Category> findByIdNotIn(ArrayList<Long> catsId);



	
}
