package lt.vtvpmc.threered.bookstore.book;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.vtvpmc.threered.bookstore.db.DBService;

@CrossOrigin
@RestController
@Api(value = "book")
@RequestMapping(value = "api/books/")
public class BookController {
	private DBService service;
	
	
	@Autowired
	public BookController(DBService service) {
		this.service = service;
	}

	@GetMapping
	@ApiOperation(value = "Get books", notes = "Returns all books in the BookStore")
	public List<Book> getBooks(){
		return service.getAllBooks();
	}

	@GetMapping(path = "{id}")
	@ApiOperation(value = "Get book", notes = "Returns books in the BookStore by id")
	public Optional<Book> getBook(@PathVariable final Long id){
		return service.getBook(id);
	}

	@PostMapping
	@ApiOperation(value = "Add book", notes = "Adds new book to the BookStore")
	public void addBook(@ApiParam @RequestBody @Valid Book book) {
		if (book.getId() > 0) {
			service.updateBook(book);
		} else {
			service.addBook(book);
		}
	}
	
	@PutMapping(path = "{id}")
	@ApiOperation(value = "Update or add book", notes = "Updates or adds new book to the BookStore")
	public void addBook(@PathVariable final Long id, @ApiParam @RequestBody @Valid Book book) {
		if (id > 0) book.setId(id);
		service.updateBook(book);
	}
	
	/* Apdoros užklausas: DELETE /api/books/:id */
	@DeleteMapping(path = "{id}")
	@ApiOperation(value="Delete book", notes="Deletes book by id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBook(@PathVariable final Long id) {
		service.deleteBook(id);
	}
}
