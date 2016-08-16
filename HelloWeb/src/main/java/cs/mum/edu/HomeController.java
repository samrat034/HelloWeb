package cs.mum.edu;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs.mum.edu.domain.Category;
import cs.mum.edu.repository.IcategoryRepository;
import cs.mum.edu.service.IcategoryService;
import cs.mum.edu.service.impl.CategoryImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
//	@Autowired
//	private IcategoryService icategoryService;
	
	@Autowired
	private IcategoryRepository icategoryRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		//List<Category> allCategories = icategoryService.allCategories();	
		
		
//		Category category= new Category();
//		//category.setId(4);
//		category.setName("Samrat");
//		icategoryRepository.addCategory(category);
		
		
//		icategoryService.deleteCategory(category);
//		for(Category cat : allCategories){
//			System.out.println(cat.getName());
//		}
		model.addAttribute("cat", icategoryRepository.getCategory(2));
		return "home";
	}

}
