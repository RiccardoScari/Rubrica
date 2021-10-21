package ejb;

import com.model.User;

import jakarta.ejb.Remote;

@Remote
public interface UserBeanRemote {
	public User getUser(String username, String password);
	//public List<Contatto> Contacts(User user);
	public void Register(User user);

}
