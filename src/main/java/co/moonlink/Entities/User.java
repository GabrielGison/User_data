package co.moonlink.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import co.moonlink.Emuns.Type;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

	public User(String username, String email, String pass, Type type) {
		this.username = username;
		this.email = email;
		this.pass = pass;
		this.type = type;
	}
	
	public User() {this.username = "Guest" + this.id; }
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int id;
	
	@Column(name = "username", nullable = true)
	String username;
	
	@Column(name = "email", nullable = true)
	String email; 
	
	@Column(name = "pass", nullable = true)
	String pass;
	
	@Column(name = "type", nullable = true)
	Type type;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
