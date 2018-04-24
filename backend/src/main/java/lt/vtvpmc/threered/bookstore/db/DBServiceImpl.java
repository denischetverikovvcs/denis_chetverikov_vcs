package lt.vtvpmc.threered.bookstore.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.vtvpmc.threered.bookstore.author.Author;
import lt.vtvpmc.threered.bookstore.author.AuthorRepository;
import lt.vtvpmc.threered.bookstore.book.Book;
import lt.vtvpmc.threered.bookstore.book.BookRepository;
import lt.vtvpmc.threered.bookstore.category.Category;
import lt.vtvpmc.threered.bookstore.category.CategoryRepository;

@Service
public class DBServiceImpl implements DBService {
	private BookRepository bookRepo;
	private AuthorRepository authorRepo;
	private CategoryRepository categoryRepo;

	@Autowired
	public DBServiceImpl(BookRepository bookRepo, AuthorRepository authorRepo, CategoryRepository categoryRepo) {
		this.bookRepo = bookRepo;
		this.authorRepo = authorRepo;
		this.categoryRepo = categoryRepo;
	}

	@Transactional
	@Override
	public void addBook(Book book) {
		if (!bookRepo.existsByIsbn(book.getIsbn())) {
			for (Category c : book.getCategories()) {
				this.addCategory(c);
				book.getCategories().add(c);
			}
			for (Author a : book.getAuthors()) {
				this.addAuthor(a);
				book.getAuthors().add(a);
			}
		}
		bookRepo.save(book);
	}
	
	@Transactional
	@Override
	public void updateBook(Book book) {
		for (Category c : book.getCategories()) {
			this.addCategory(c);
			book.getCategories().add(c);
		}
		for (Author a : book.getAuthors()) {
			this.addAuthor(a);
			book.getAuthors().add(a);
		}
		bookRepo.save(book);
	}


	@Transactional
	@Override
	public Optional<Book> getBook(Long id) {
		return bookRepo.findById(id);
	}
	
	@Transactional
	@Override
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@Transactional
	@Override
	public void addAuthor(Author author) {
		Author existant = authorRepo.findAuthorByFirstNameAndLastName(author.getFirstName(), author.getLastName());
		if (existant == null) {
			authorRepo.save(author);
		} else {
			author.setId(existant.getId());
			authorRepo.save(author);
		}
	}

	@Transactional(readOnly = true)
	@Override
	public List<Author> getAllAuthors() {
		return authorRepo.findAll();
	}

	@Transactional
	@Override
	public void addCategory(Category category) {
		Category existant = categoryRepo.findCategoryByName(category.getName());
		if (existant == null) {
			categoryRepo.save(category);
		} else {
			category.setId(existant.getId());
			categoryRepo.save(category);
		}
	}

	@Transactional(readOnly = true)
	@Override
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Author findAuthorByBook(Long bookId) {
		return authorRepo.findAuthorByBook(bookId);
	}

}
