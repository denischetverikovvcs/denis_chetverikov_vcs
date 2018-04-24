package lt.vtvpmc.threered.bookstore.db;

import java.util.List;
import java.util.Optional;

import lt.vtvpmc.threered.bookstore.author.Author;
import lt.vtvpmc.threered.bookstore.book.Book;
import lt.vtvpmc.threered.bookstore.category.Category;

public interface DBService {
	void addBook(Book book);
	void updateBook(Book book);
	Optional<Book> getBook(Long id);
	void deleteBook(Long id);
	List<Book> getAllBooks();
	
	void addAuthor(Author author);
	List<Author> getAllAuthors();
	
	void addCategory(Category category);
	List<Category> getAllCategories();
	
	Author findAuthorByBook(Long bookId);
	
	
}
