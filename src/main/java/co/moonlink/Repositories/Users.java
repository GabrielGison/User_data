package co.moonlink.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.moonlink.Emuns.Type;
import co.moonlink.Entities.User;

@Repository
public interface Users extends JpaRepository<User, Integer>{

	List<User> findByType(Type type);
	List<User> findByUsername(String username);
	List<User> findByEmail(String email);
}
