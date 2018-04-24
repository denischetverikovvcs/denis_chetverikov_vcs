package lt.vtvpmc.threered.bookstore.book;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import lt.vtvpmc.threered.bookstore.author.Author;
import lt.vtvpmc.threered.bookstore.category.Category;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToMany
	@JoinTable(name = "category_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<Category>();
	@NotNull
	private String photoPath;
	@NotNull
	private String title;
	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<Author>();
	@Length(min=4, max=4)
	private String year;
	@Length(min=10, max=13)
	private String isbn;
	@Digits(integer = 5 , fraction = 2)
	private BigDecimal price;
	private String description;
	@NotNull
	private int noOfUnits;
	@NotNull
	boolean available;

	// ratings
	// comments

	public Book() {

	}

	public Book(Set<Category> categories, @NotNull String photoPath, @NotNull String title, Set<Author> authors,
			@Length(min = 4, max = 4) String year, @Length(min = 10, max = 13) String isbn,
			@Digits(integer = 5, fraction = 2) BigDecimal price, String description, @NotNull int noOfUnits,
			@NotNull boolean available) {
		this.categories = categories;
		this.photoPath = photoPath;
		this.title = title;
		this.authors = authors;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		this.description = description;
		this.noOfUnits = noOfUnits;
		this.available = available;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNoOfUnits() {
		return noOfUnits;
	}

	public void setNoOfUnits(int noOfUnits) {
		this.noOfUnits = noOfUnits;
	}

}
