package lt.vtvpmc.threered.bookstore.user;

import java.util.List;

public interface UserService {

	List<User> findAllUsers();

	User findById(long id);

	void deleteUserById(long id);

	//boolean isUserExist(User user);

	void addUser(UserCreate user);
	void updateUser(Long id, UserCreate user);
}