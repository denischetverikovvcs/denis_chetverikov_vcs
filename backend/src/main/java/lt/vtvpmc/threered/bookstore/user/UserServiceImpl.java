package lt.vtvpmc.threered.bookstore.user;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lt.vtvpmc.threered.bookstore.role.RoleRepository;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;
    
    @Override
	public List<User> findAllUsers() {
       return userRepository.findAll();
    }
        
    @Override
	public User findById(long id) {
      return userRepository.findById(id).get();
    }
     
     
    @Transactional
	@Override
	public void addUser(UserCreate user)  {
		if (userRepository.findByUsername(user.getUsername()) != null) {
			throw new IllegalArgumentException("Such username already exists");
		} else {
			switch (user.getUserType()) {
			case ADMIN:
				User admin = new Administrator();
				admin.setFirstName(user.getFirstName());
				admin.setLastName(user.getLastName());
				admin.setPhoneNo(user.getPhoneNo());
				admin.setEmail(user.getEmail());
				admin.setPassword(passwordEncoder.encode(user.getPassword()));
				admin.setUsername(user.getUsername());
				
				admin.setRole(roleRepository.findRoleByName("Admin"));
				userRepository.save(admin);
				break;
			case SELLER:
				User seller = new Seller();
				seller.setFirstName(user.getFirstName());
				seller.setLastName(user.getLastName());
				seller.setPassword(passwordEncoder.encode(user.getPassword()));
				seller.setPhoneNo(user.getPhoneNo());
				seller.setEmail(user.getEmail());
				seller.setUsername(user.getUsername());
				seller.setRole(roleRepository.findRoleByName("Seller"));
				userRepository.save(seller);
				break;
			}
		}
		}
  
    @Override
	public void deleteUserById(long id) {
         
    	userRepository.deleteById(id);
    }
    @Transactional
	@Override
	public void updateUser(Long id, UserCreate user) {
		User exist = userRepository.findById(id).get();
		
			exist.setId(id);
			exist.setFirstName(user.getFirstName());
			exist.setLastName(user.getLastName());
			exist.setPhoneNo(user.getPhoneNo());
			exist.setEmail(user.getEmail());
			exist.setPassword(user.getPassword());
			exist.setUsername(user.getUsername());			
			
			userRepository.save(exist);
}
   
    //@Override
	//public boolean isUserExist(User user) {
      //  return findByName(user.getFirstName())!=null;
   // }
   
 
}