package lt.vtvpmc.threered.bookstore.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lt.vtvpmc.threered.bookstore.role.Role;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	@NotNull
	@Length(max = 40)
	private String username;
	@NotNull
	//@Length(min = 8, max = 30)
	private String password;
    //@NotNull
	@Transient
	private String passwordConfirm;
	@ManyToOne
	private Role role;
	@NotNull
	//@Length(min = 2, max = 30)
	private String firstName;
	@NotNull
	@Length(min = 2, max = 40)
	private String lastName;
	@NotNull
	//@Pattern(regexp = "^\\+?(\\d+)")
	private String phoneNo;
	
    //@NotNull
    private String email;
   
  // @NotNull
    private Boolean enabled;

 
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
private List<Authority> authorities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	 public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	}
	    public List<Authority> getAuthorities() {
	        return authorities;
	    }

	    public void setAuthorities(List<Authority> authorities) {
	        this.authorities = authorities;
	}
	  public Boolean getEnabled() {
	       return enabled;
	  }

	   public void setEnabled(Boolean enabled) {
	        this.enabled = enabled;
	   }

	   

	    

}
