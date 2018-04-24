package lt.vtvpmc.threered.bookstore.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationRestController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "/login/", method = RequestMethod.POST)
 public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest
	 loginRequest) {

	 Authentication authentication = authenticationManager.authenticate(
	 new UsernamePasswordAuthenticationToken(
	 loginRequest.getUsernameOrEmail(),
	 loginRequest.getPassword()
	 )
	 );

	 SecurityContextHolder.getContext().setAuthentication(authentication);

	 return new ResponseEntity<String>(loginRequest.getUsernameOrEmail(),
	 HttpStatus.OK);

	}
}