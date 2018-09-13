package net.learnbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.learnbook.entity.Category;
import net.learnbook.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void insert(Category category) {
		categoryRepository.save(category);
	}
	
	@Override
	public List<Category> listAll() {

		return categoryRepository.list("Category");
	}


	@Override
	public CategoryRepository getRepository() {
		return categoryRepository;
	}
	
	

}
