package ejb;

import com.model.Contatto;
import com.model.User;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Session Bean implementation class ContattoBean
 */
@Stateless
public class ContattoBean implements ContattoBeanRemote {

	@PersistenceContext(unitName = "CrudJPA")
	private EntityManager manager;

	public void saveContact(Contatto contatto) {

		manager.persist(contatto);

	}

	public void deleteContact(String numero, User user) {

		// Query query = manager.unwrap(Session.class).getNamedQuery("ERASE_CONTACT");
		Query query = manager.createNamedQuery("ERASE_CONTACT");
		query.setParameter("numero", numero);
		query.setParameter("refuser", user);
		query.executeUpdate();

	}

	public ContattoBean() {

	}

}
