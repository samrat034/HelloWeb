import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import cs.mum.edu.domain.Category;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testing");
		Category category = new Category();
		//category.setId(100);
		category.setName("Bimal");
		EntityManager em = emf.createEntityManager();
		
		 em.getTransaction().begin();
		    if (!em.contains(category)) {
		        // persist object - add to entity manager
		        em.persist(category);
		        // flush em - save to DB
		        em.flush();
		    }
		    // commit transaction at all
		    em.getTransaction().commit();
		
		Category cat = em.find(Category.class, 1);
		System.out.println(cat.getId());

	}
}
