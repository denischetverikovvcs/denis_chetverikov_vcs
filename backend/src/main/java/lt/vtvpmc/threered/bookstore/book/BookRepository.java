package lt.vtvpmc.threered.bookstore.book;


import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
	//@Query("Select b from Book b where b.isbn = ?1")
	Book findByIsbn(String isbn);

	boolean existsByIsbn(String isbn);
}
