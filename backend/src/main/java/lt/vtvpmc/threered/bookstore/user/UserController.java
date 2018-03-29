package lt.vtvpmc.threered.bookstore.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping(value = "api/users")
@Api(value = "user")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<User> getUser(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		User user = userService.findById(id);
		if (user == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void addAdmin(@ApiParam @RequestBody @Valid UserCreate user) {
		userService.addUser(user);
	}

	
	// @Autowired
	// private SecurityService securityService;
	//
	// @Autowired
	// private UserValidator userValidator;

	// @RequestMapping(method = RequestMethod.GET)
	// public List<User> getAllUsers() {
	// return userService.getAllUsers();
	// }

	// @RequestMapping(method = RequestMethod.POST)
	// public void addAdmin(@ApiParam @RequestBody @Valid UserCreate user) {
	// userService.addUser(user);
	/// }

	// @RequestMapping(path = "/{username}", method = RequestMethod.DELETE)
	// public void deleteUser(@PathVariable String username) {
	// userService.deleteUser(username);
	// }
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.findAllUsers();
}

      //  if(users.isEmpty()){
         //   return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
       // }
   
	//@RequestMapping(value = "/user/", method = RequestMethod.POST)
  //  public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
       // System.out.println("Creating User " + user.getFirstName());
  
       // if (userService.isUserExist(user)) {
        //    System.out.println("A User with name " + user.getFirstName() + " already exist");
         //   return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    //    }
  
     //   userService.saveUser(user);
  
     //   HttpHeaders headers = new HttpHeaders();
       // headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
      //  return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    //}
}
