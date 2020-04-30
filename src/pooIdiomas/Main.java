package pooIdiomas;

import java.util.ArrayList;

import exceptions.EmptyArgumentException;
import exceptions.InvalidFormatArgumentException;
import exceptions.MyCustonException;

public class Main {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> users = new ArrayList<User>();
		
		String mainMenu = "1 - Sign in\n2 - Sign Up\n3 - Quit";
		
		int option = -1;
		
		do {
			
			try {
				option = View.exibirInputNumero("Wellcome", mainMenu);
			}catch(NumberFormatException e) {
				View.showErrorMsg("Main Menu", "Input not valid");
			}
			
			switch (option) {
				case 1: {
					
					if( Utils.validateUser(users)) {
						//mostro outro menu
						View.showErrorMsg("Error", "Parabens");
					}else {
						View.showErrorMsg("Error", "Invalid user or do not exist users");
					}
					break;
					
				}
				case 2:{
					
					try {
						users.add(Utils.createNewUser());
					} catch (EmptyArgumentException e) {
						View.showErrorMsg("Error", e.getMessage());
					}catch (InvalidFormatArgumentException e) {
						View.showErrorMsg("Error", e.getMessage());
					}
					
					break;
				}
				default:
					
				}
			
			
			
			
		}while(option != 3);
		
		
	}

}
