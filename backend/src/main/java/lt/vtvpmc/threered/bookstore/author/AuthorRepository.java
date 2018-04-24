package lt.vtvpmc.threered.bookstore.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lt.vtvpmc.threered.bookstore.book.Book;


public interface AuthorRepository extends JpaRepository<Author, Long> {
	
	@Query("Select a from Author a where a.firstName = ?1 and a.lastName = ?2")
	Author findAuthorByFirstNameAndLastName(String firstName, String  lastName);
	
	@Query("Select a from Author a inner join a.books b where b = (Select b from Book b where b.id = ?1)")
	Author findAuthorByBook(Long bookId);

}
