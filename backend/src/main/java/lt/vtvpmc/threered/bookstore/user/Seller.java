package lt.vtvpmc.threered.bookstore.user;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Seller extends User {
	@NotNull
	private String email;

	public Seller() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
