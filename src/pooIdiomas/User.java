package pooIdiomas;

import exceptions.EmptyArgumentException;
import exceptions.InvalidFormatArgumentException;

public class User {

	private String name;
	private String email;
	private String password;
	
	private Integer minPasswordSize = 3;
	
	//Constructor
	public User(String name, String email, String password) {
		super();
		setName(name);
		setEmail(email);
		setPassword(password);
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		//validate name logic
		if (name.isBlank()) {
			throw new EmptyArgumentException("Name can not be empty");
		}
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		
		//validate email logic
		if (email.isBlank()) {
			throw new EmptyArgumentException("Email can not be empty");
		}else if (!email.contains("@")) {
			throw new InvalidFormatArgumentException("Email Invalid.");	
		}
		
		this.email = email;
	}
	
	private void setPassword(String password) {
		
		//validate password logic
		if (password.isBlank()) {
			throw new EmptyArgumentException("Password can not be empty");
		}else if (password.length() <= minPasswordSize) {
			throw new InvalidFormatArgumentException("Password must be more than 3 letters");	
		}
		
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	

}
