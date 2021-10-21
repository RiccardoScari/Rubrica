package ejb;

import com.model.Contatto;
import com.model.User;

import jakarta.ejb.Remote;

@Remote
public interface ContattoBeanRemote {
	public void saveContact(Contatto contatto);
	public void deleteContact(String numero, User user);
}
