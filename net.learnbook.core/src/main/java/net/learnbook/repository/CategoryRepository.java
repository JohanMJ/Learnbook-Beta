package net.learnbook.repository;

import org.springframework.stereotype.Repository;

import net.learnbook.entity.Category;

@Repository
public class CategoryRepository extends AbstractRepository<Category> {

	public CategoryRepository() {
		super(Category.class);
	}

}
