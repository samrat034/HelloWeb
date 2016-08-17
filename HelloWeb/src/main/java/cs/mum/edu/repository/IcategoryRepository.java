package cs.mum.edu.repository;

import java.util.List;

import cs.mum.edu.domain.Category;

public interface IcategoryRepository {
	void addCategory(Category category);
	Category getCategory(int id);
	List<Category> allCategories();
	void deleteCategory(Category category);
	List<Category> categoriesByName(String name);
	
}
