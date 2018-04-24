package lt.vtvpmc.threered.bookstore.category;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
	@Table(name = "category")
	public class Category {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String name;
//		@ManyToMany(mappedBy = "categories")
//		private Set<Book> books = new HashSet<Book>();
		
		public Category() {
			
		}

		public Category(String name) {
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

//		public Set<Book> getBooks() {
//			return books;
//		}
//
//		public void setBooks(Set<Book> books) {
//			this.books = books;
//		}
		
	}

