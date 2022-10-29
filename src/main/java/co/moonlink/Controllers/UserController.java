package co.moonlink.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.moonlink.Emuns.Type;
import co.moonlink.Entities.User;
import co.moonlink.Repositories.Users;
import co.moonlink.Services.UserService;


@RestController
public class UserController {
	
	@Autowired 
	UserService userService;
	
	@Autowired
	Users userR;
	
	//GET WITH ID

	@GetMapping("/ri/{id}")
	public User getOne(@PathVariable Integer id) {
		return userService.getUser(id);
	}
	
	//GET ALL
	
	@GetMapping("/ra")
	public List<User> getAll(){
		return userService.userList();
	}
	
	//GET WITH USERNAME
	
	@GetMapping("/rn")
	public List<User> getByName(@RequestParam(name="username",required = true) 
								String username){
		return userR.findByUsername(username);
	}
	
	//GET WITH EMAIL
	
	@GetMapping("/re")
	public List<User> getByEmail(@RequestParam(name="email",required = true) 
								String email){
		return userR.findByEmail(email);
	}
	
	//GET WITH TYPE
	
		@GetMapping("/rt")
		public List<User> getByType(@RequestParam(name="type",required = true) 
									Type type){
			return userR.findByType(type);
		}
	
	//POST NEW
		
	@PostMapping("/c")
	public User postOne(@RequestParam(name = "username", required = false) String username,
						@RequestParam(required = false) String email,
						@RequestParam(required = false) String pass
						) {
		
		
		User newUser = new User(username,email,pass,Type.User); 
		if (newUser.getEmail() != null) { newUser.setType(Type.User); }if (newUser.getEmail() == null) {newUser.setType(Type.Guest);}
		userService.saveUser(newUser);
		return userService.getUser(newUser.getId());
	}
	
	//UPDATE USERNAME
	
	@PutMapping("/un/{id}")
	public User updateName(@PathVariable Integer id,
							@RequestParam(required = true) String username) {
		userService.getUser(id).setUsername(username);
		return userService.getUser(id);
	}
	
	//UPDATE EMAIL
	
	@PutMapping("/ue/{id}")
	public User updateEmail(@PathVariable Integer id,
							@RequestParam(required = true) String email) {
		userService.getUser(id).setEmail(email);
		return userService.getUser(id);
	}
	
	//UPDATE PASSWORD
	
		@PutMapping("/up/{id}")
		public User updatePass(@PathVariable Integer id,
								@RequestParam(required = true) String pass) {
			userService.getUser(id).setPass(pass);
			return userService.getUser(id);
		}
		
	//DELETE ONE
		
	@DeleteMapping("/di/{id}")
	public String deleteOne(@PathVariable Integer id) {
		User delUser = userService.getUser(id);
		String delUsername = delUser.getUsername();
		userService.deleteUser(id);
		return "The User " + delUsername + " is succesfully deleted!";
		
	}
	
	//DELETE ALL
	
	@DeleteMapping("/da")
	public String deleteAll() {
		userR.deleteAll();
		return "The list is now empty!";
	}
}
