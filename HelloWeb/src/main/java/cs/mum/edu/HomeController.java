package cs.mum.edu;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
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
		model.addAttribute("cat",  icategoryRepository.allCategories());
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String form() {

		return "formInsert";
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String insert(Model  model, @ModelAttribute Category cat){
		icategoryRepository.addCategory(cat);
		return "redirect:/insert";
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public String insert(Model  model){
		model.addAttribute("cat", icategoryRepository.allCategories());
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/searchForm", method = RequestMethod.GET)
	public String formSearch() {

		return "formSearch";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	public String search(Model model,@RequestParam("id") String searchString){
		
		       model.addAttribute("cat",  icategoryRepository.getCategory(Integer.parseInt(searchString)));
		       return "searcheditem";
		   
	}
	
	@RequestMapping(value="/search/{name}/", method = RequestMethod.GET)
	public String searchName(Model model,@PathVariable("name") String searchString){
		
		       model.addAttribute("cat",  icategoryRepository.categoriesByName(searchString));
		       return "catbyname";
		   
	}
	
	@RequestMapping(value="/searchRest/{name}/", method = RequestMethod.GET)
	public @ResponseBody List<Category> searchNameRest(Model model,@PathVariable("name") String searchString){
		
		return icategoryRepository.categoriesByName(searchString);
		   
	}

}
