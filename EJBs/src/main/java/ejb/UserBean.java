package ejb;

import com.model.User;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
public class UserBean implements UserBeanRemote {

	@PersistenceContext(unitName = "CrudJPA")
	private EntityManager manager;

	@Override
	public User getUser(String username, String password) {

		User user = null;

		/*
		 * Query query = manager.unwrap(Session.class).getNamedQuery("GET_USER");
		 * query.setParameter("username", username); query.setParameter("password",
		 * password); user = (User) query.uniqueResult();
		 */

		// TypedQuery<User> query = manager.createQuery("select u from User u where
		// u.username = :username and u.password = :password", User.class);
		TypedQuery<User> query = manager.createNamedQuery("GET_USER", User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		user = query.getSingleResult();

		return user;
	}

	/*
	 * 
	 * @Override public List<Contatto> Contacts(User user) { List<Contatto> conts =
	 * null;
	 * 
	 * User us = this.getUser(user.getUsername(), user.getPassword());
	 * TypedQuery<Contatto> query = manager.createNamedQuery("GET_CONTACT",
	 * Contatto.class); query.setParameter("refuser", us); conts =
	 * query.getResultList();
	 * 
	 * return conts;
	 * 
	 * }
	 */

	@Override
	public void Register(User user) {

		manager.persist(user);

	}

	public UserBean() {

	}

}
