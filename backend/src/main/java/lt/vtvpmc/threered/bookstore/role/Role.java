package lt.vtvpmc.threered.bookstore.role;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lt.vtvpmc.threered.bookstore.user.User;


@Entity
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	    private String name;
	    @OneToMany(mappedBy = "role")
	    private List<User> users;
	    
	    public Role() {
	    	
	    }
	    public Role(String name) {
	    	this.name = name;
	    	
	    }

	    
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	   @JsonIgnore
	    public List<User> getUsers() {
	        return users;
	    }

	    public void setUsers(List<User> users) {
	        this.users = users;
	    }
	}
