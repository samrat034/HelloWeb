package cs.mum.edu.service;

import java.util.List;

import cs.mum.edu.domain.Category;

public interface IcategoryService {

	void addCategory(Category category);
	Category getCategory(int id);
	List<Category> allCategories();
	void deleteCategory(Category category);
}
