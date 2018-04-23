package lt.vtvpmc.threered.bookstore;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lt.vtvpmc.threered.bookstore.author.Author;
import lt.vtvpmc.threered.bookstore.book.Book;
import lt.vtvpmc.threered.bookstore.category.Category;
import lt.vtvpmc.threered.bookstore.db.DBService;
import lt.vtvpmc.threered.bookstore.role.Role;
import lt.vtvpmc.threered.bookstore.role.RoleRepository;
//import lt.vtvpmc.threered.bookstore.user.UserService;

@Component
public class DataInput implements CommandLineRunner {
	@Autowired
	private DBService bookService;
	@Autowired
	private RoleRepository roleRepo;
	
//	@Autowired 
//	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		
		//Initial role set up
		Role adminRole = new Role("Admin");
		roleRepo.save(adminRole);
		Role sellerRole = new Role("Seller");
		roleRepo.save(sellerRole);
		
		//End of role set up
		
//		UserCreate seller1 = new UserCreate();
//		seller1.setUserType(UserType.SELLER);
//		seller1.setUsername("pepe");
//		seller1.setPassword("abcdefgh");
//		seller1.setPasswordConfirm("abcdefgh");
//		seller1.setFirstName("Petras");
//		seller1.setLastName("Petraitis");
//		seller1.setPhoneNo("868686866");
//		seller1.setEmail("pepe@gmail.com");	
//		userService.addUser(seller1);
//
//		UserCreate seller2 = new UserCreate();
//		seller1.setUserType(UserType.SELLER);
//		seller1.setUsername("jojo");
//		seller1.setPassword("bcdefghi");
//		seller1.setPasswordConfirm("bcdefghi");
//		seller1.setFirstName("Jonas");
//		seller1.setLastName("Jonaitis");
//		seller1.setPhoneNo("868686822");
//		seller1.setEmail("jojo@gmail.com");	
//		userService.addUser(seller2);


		Author oliver = new Author("Jamie", "Oliver");
		Set<Author> authors = new HashSet<Author>();
		authors.add(oliver);
		Author beata = new Author("Beata", "Nicholson");
		Set<Author> authors2 = new HashSet<Author>();
		authors2.add(beata);

		Category cuisine = new Category("cuisine");
		Category drama = new Category("drama");
		Set<Category> categories = new HashSet<Category>();
		categories.add(cuisine);
		categories.add(drama);

		Category cuisine2 = new Category("cuisine");
		Category detective = new Category("detective");
		Set<Category> categories2 = new HashSet<Category>();
		categories2.add(cuisine2);
		categories2.add(detective);

		Book cooking = new Book(categories, "https://book", "Cooking", authors, "2016", "9781401301958",
				new BigDecimal("20"), "Cooking book", 4, true);
		bookService.addBook(cooking);
		Book cooking2 = new Book(categories2, "https://book", "Taste Lithuania", authors2, "2008", "9781250146250",
				new BigDecimal("13"), "Cooking book", 4, true);
		bookService.addBook(cooking2);
		

	}

}
