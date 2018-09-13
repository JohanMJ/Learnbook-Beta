package net.learnbook.service;

import java.util.List;

import net.learnbook.entity.Category;
import net.learnbook.repository.CategoryRepository;

public interface CategoryService {

	public void insert(Category category);
	
	public List<Category> listAll();
	
	public CategoryRepository getRepository();
}
