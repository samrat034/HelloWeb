package cs.mum.edu.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import cs.mum.edu.domain.Category;
import cs.mum.edu.repository.IcategoryRepository;

@Repository
public class CategoryRepoImpl implements IcategoryRepository{

	private static EntityManagerFactory emf;
	
	static{
		try{
			emf= Persistence.createEntityManagerFactory("testing");
		}catch(Throwable t){
			t.printStackTrace();
		}
	}
	
//	 public CategoryRepoImpl() {
//		
//		 categories = new ArrayList<Category>();
//		 Category cat1 = new Category(1, "Food");
//		 Category cat2 = new Category(2, "Clothing");
//		 Category cat3 = new Category(3, "Housing");
//		 
//		 categories.add(cat1);
//		 categories.add(cat2);
//		 categories.add(cat3);
//	}
	
	@Override
	public void addCategory(Category category) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(category);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Category getCategory(int id) {
//		for(Category cat : categories){
//			if (cat.getId() == id){
//				return cat;
//			}
//		}
//		return null;
		
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Category cat = em.find( Category.class, id );
		em.getTransaction().commit();  
		em.close();
		return cat;
	}

	@Override
	public List<Category> allCategories() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from Category");
		List<Category> cat=query.getResultList();
		em.close();
		return cat;
	}

	@Override
	public void deleteCategory(Category category) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(category);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Category> categoriesByName(String name) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from Category a where a.name="+"'"+name+"'");
		List<Category> cat=query.getResultList();
		em.close();
		return cat;
	}

}
