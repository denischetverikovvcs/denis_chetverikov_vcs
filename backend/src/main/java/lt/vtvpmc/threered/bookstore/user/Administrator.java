package lt.vtvpmc.threered.bookstore.user;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Administrator extends User {
	@NotNull
	private String email;

	public Administrator() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}