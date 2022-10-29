package co.moonlink.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.moonlink.Entities.User;
import co.moonlink.Repositories.Users;

@Service
@Transactional
public class UserService {

	@Autowired
	Users users;
	
	public List<User> userList(){
		return users.findAll();
	}
	
	public User getUser(Integer id) {
		return users.findById(id).get();
	}
	
	public void saveUser(User user) {
		users.save(user);
	}
	
	public void deleteUser(Integer id) {
		users.deleteById(id);
	}
	
}
