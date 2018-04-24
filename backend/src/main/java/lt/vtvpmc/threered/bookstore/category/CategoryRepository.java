package lt.vtvpmc.threered.bookstore.category;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query("Select c from Category c where c.name = ?1")
	Category findCategoryByName(String name);

}
