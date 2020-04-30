package pooIdiomas;

import java.util.ArrayList;

public class Utils {
	
	//Show sign in view
	static Boolean validateUser(ArrayList<User> users) {
		
		String email = View.showInputText("Email", "Type your email");
		String password = View.showInputText("Password", "Type your Password");
		
		if (users.isEmpty()) {return false;}
		
		for (User user : users) {
			if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
				return true;
			}
		}
		
		return false;
		
	}
	
	//Create a new user
	static User createNewUser() {
		
		String name = View.showInputText("Name", "Type your Name");
		String email = View.showInputText("Email", "Type your email");
		String password = View.showInputText("Password", "Type your Password");
		
		return new User(name,email,password);
		
	}
	

}
