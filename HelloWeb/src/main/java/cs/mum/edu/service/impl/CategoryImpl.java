package cs.mum.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.mum.edu.domain.Category;
import cs.mum.edu.repository.IcategoryRepository;
import cs.mum.edu.repository.impl.CategoryRepoImpl;
import cs.mum.edu.service.IcategoryService;


@Service
public class CategoryImpl implements IcategoryService{

	@Autowired
	private IcategoryRepository categoryRepoImpl;
	
	 
	
	@Override
	public void addCategory(Category category) {
		categoryRepoImpl.addCategory(category);
		
	}

	@Override
	public Category getCategory(int id) {
		
		return categoryRepoImpl.getCategory(id);
	}

	@Override
	public List<Category> allCategories() {
		return categoryRepoImpl.allCategories();
	}

	@Override
	public void deleteCategory(Category category) {
		categoryRepoImpl.deleteCategory(category);
		
	}

}
