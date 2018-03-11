package lt.vtvpmc.threered.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import lt.vtvpmc.threered.bookstore.model.Author;
import lt.vtvpmc.threered.bookstore.model.Book;
import lt.vtvpmc.threered.bookstore.model.Category;
import lt.vtvpmc.threered.bookstore.repository.AuthorRepository;
import lt.vtvpmc.threered.bookstore.repository.BookRepository;
import lt.vtvpmc.threered.bookstore.repository.CategoryRepository;

@Service
public class BookStoreServiceImpl implements BookStoreService {
	private BookRepository bookRepo;
	private AuthorRepository authorRepo;
	private CategoryRepository categoryRepo;
	

	@Autowired
	public BookStoreServiceImpl(BookRepository bookRepo, AuthorRepository authorRepo, CategoryRepository categoryRepo) {
		this.bookRepo = bookRepo;
		this.authorRepo = authorRepo;
		this.categoryRepo = categoryRepo;
	}

	@Transactional
	@Override
	public void addBook(@RequestBody Book book) {
		bookRepo.save(book);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
	@Transactional
	@Override
	public void addAuthor(Author author) {
		authorRepo.save(author);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Author> getAllAuthors(){
		return authorRepo.findAll();
	}
	
	@Transactional
	@Override
	public void addCategory(Category category) {
		categoryRepo.save(category);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Category> getAllCategories(){
		return categoryRepo.findAll();
	}

}
