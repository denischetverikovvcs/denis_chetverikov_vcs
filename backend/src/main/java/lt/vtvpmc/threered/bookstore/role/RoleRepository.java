package lt.vtvpmc.threered.bookstore.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface RoleRepository extends JpaRepository<Role, Long>{
	@Query("Select r from Role r where r.name = ?1")
	Role findRoleByName(String name);
	
}
