package pooIdiomas;

import java.util.ArrayList;


import exceptions.EmptyArgumentException;
import exceptions.InvalidFormatArgumentException;
import pooIdiomas.Entites.Language;
import pooIdiomas.Entites.User;
import pooIdiomas.Entites.Word;
import pooIdiomas.Entites.WordGroup;

public class Main {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> users = new ArrayList<User>();
		
		String mainMenu = "1 - Sign in\n2 - Sign Up\n3 - Quit";
		
		int option = -1;
		ArrayList<Word> words = new ArrayList<Word>();
		words.add(new Word("azul", "blue", "sasasdad"));
		words.add(new Word("vermelho", "red", "sasasdad"));
		words.add(new Word("amarelo", "yellow", "sasasdad"));
		words.add(new Word("marrom", "brown", "sasasdad"));
		words.add(new Word("preto", "black", "sasasdad"));
		
		do {
			Utils.pratice(words, Difficult.EASY);
			try {
				option = View.exibirInputNumero("Wellcome", mainMenu);
			}catch(NumberFormatException e) {
				View.showErrorMsg("Main Menu", "Input not valid");
			}
			
			switch (option) {
				case 1: {
					
					if( Utils.validateUser(users)) {
						languagesMenu(new User("Rangel", "rangel@fdsfs","sadfasdf"));
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
	
	
	
	
	//Menu Languages
	static void languagesMenu(User currentUser) {
		
		String msg = "1 - Add new language\n2 - Select a Language\n3 - Quit";  
		
		int option = -1;
		
		do {
			
			try {
				option = View.exibirInputNumero("Your Languages", msg);
			}catch(NumberFormatException e) {
				View.showErrorMsg("Your Languages", "Input not valid");
			}
			
			switch (option) {
				case 1: {
					try {
						currentUser.addNewLanguage(Utils.createNewLanguge());
					} catch (EmptyArgumentException e) {
						View.showErrorMsg("Error", e.getMessage());
					}
					break;
				}
				case 2:{
					try {
						Language language = Utils.selectLanguage(currentUser.getLanguages());
						wordGroupsMenu(language);
					} catch (NumberFormatException e) {
						View.showErrorMsg("Error", e.getMessage());
					}catch (IndexOutOfBoundsException e) {
						View.showErrorMsg("Error", "Option not Valid");
					}catch (EmptyArgumentException e) {
						View.showErrorMsg("Error", e.getMessage());
					}
					
					break;
				}
				default:
					
				}
			
			
			
			
		}while(option != 3);
		
	}
	
	
	//Menu word groups
		static void wordGroupsMenu(Language language) {
			
			String msg = language.listWordGroups() + "\n1 - Add new Word Group\n2 - Add New Word\n3 - Pratice\n 4 - Quit";  
			
			int option = -1;
			
			do {
				
				try {
					option = View.exibirInputNumero("Your Languages", msg);
				}catch(NumberFormatException e) {
					View.showErrorMsg("Your Languages", "Input not valid");
				}
				
				switch (option) {
					case 1: {
						try {
							language.addNewWordGroup(Utils.createNewWordGroup(language));
						} catch (EmptyArgumentException e) {
							View.showErrorMsg("Error", e.getMessage());
						} catch (InvalidFormatArgumentException e) {
							View.showErrorMsg("Error", e.getMessage());
						}
						break;
					}
					case 2:{
						
						try {
							WordGroup group = Utils.selectWordGroup(language.getWordGroups());
							AddWordMenu(group);
						} catch (NumberFormatException e) {
							View.showErrorMsg("Error", e.getMessage());
						}catch (IndexOutOfBoundsException e) {
							View.showErrorMsg("Error", "Option not Valid");
						}catch (EmptyArgumentException e) {
							View.showErrorMsg("Error", e.getMessage());
						}
						
						break;
					}
					case 3:{
						
						praticeWordMenu(language);
						
						break;
					}
					default:
						
					}
				
				
				
				
			}while(option != 3);
			
		}
	
		
			

			//Menu Languages
				static void AddWordMenu(WordGroup group) {
					
				String msg = "1 - Add new Word\n2 - Update Word \n3 - Delete Word\n4 - List Words\n5 - Quit";  
					
					int option = -1;
					
					do {
						
						try {
							option = View.exibirInputNumero("Words from " + group.getName(), msg);
						}catch(NumberFormatException e) {
							View.showErrorMsg("Words from " + group.getName(), "Input not valid");
						}
						
						switch (option) {
							case 1: {
								try {
									group.addNewWord(Utils.createNewWord());
								} catch (EmptyArgumentException e) {
									View.showErrorMsg("Error", e.getMessage());
								}
								break;
							}
							case 2:{
								
								try {
									Word word = Utils.selectWord(group.getWords());
									word = Utils.createNewWord();
								} catch (NumberFormatException e) {
									View.showErrorMsg("Error", e.getMessage());
								}catch (IndexOutOfBoundsException e) {
									View.showErrorMsg("Error", "Option not Valid");
								}catch (EmptyArgumentException e) {
									View.showErrorMsg("Error", e.getMessage());
								}
								
								break;
							}
							case 3:{
								
								try {
									Word word = Utils.selectWord(group.getWords());
									group.deleteWord(word);
								} catch (NumberFormatException e) {
									View.showErrorMsg("Error", e.getMessage());
								}catch (IndexOutOfBoundsException e) {
									View.showErrorMsg("Error", "Option not Valid");
								}catch (EmptyArgumentException e) {
									View.showErrorMsg("Error", e.getMessage());
								}
								
								break;
							}
							case 4:{
								View.exibirMsg("Words", group.getWords().toString());
								break;
							}
							
							default:
								
							}
						
						
						
						
					}while(option != 5);
					
				}
				
				
				
				//Menu Languages
				static void praticeWordMenu(Language language) {
					
					String msg = "1 - All Groups\n2 - Specific group \n3 - Quit";  
					String dificultMsg = "1 - Easy\n2 - Hard";
					int option = -1;
					
					do {
						
						try {
							option = View.exibirInputNumero("Pratice Time", msg);
						}catch(NumberFormatException e) {
							View.showErrorMsg("Pratice Time", "Input not valid");
						}
						
						switch (option) {
							case 1: {
								try {
									option = View.exibirInputNumero("Pratice Time", dificultMsg);
									 Difficult dif = option == 1 ? Difficult.EASY :  Difficult.HARD;
									 Utils.pratice(language.getAllWords(), dif);
								} catch (EmptyArgumentException e) {
									View.showErrorMsg("Error", e.getMessage());
								}catch(NumberFormatException e) {
									View.showErrorMsg("Pratice Time", "Input not valid");
								}
								break;
							}
							case 2:{
								
								try {
									WordGroup group = Utils.selectWordGroup(language.getWordGroups());
									option = View.exibirInputNumero("Pratice Time", dificultMsg);
									//ArrayList<Word> words = Collections.shuffle(group.getWords(), new Random()); 
									 Difficult dif = option == 1 ? Difficult.EASY :  Difficult.HARD;
									Utils.pratice( group.getWords(), dif);
								} catch (NumberFormatException e) {
									View.showErrorMsg("Error", e.getMessage());
								}catch (IndexOutOfBoundsException e) {
									View.showErrorMsg("Error", "Option not Valid");
								}catch (EmptyArgumentException e) {
									View.showErrorMsg("Error", e.getMessage());
								}
								
								break;
							}
							default:
								
							}
						
						
						
						
					}while(option != 3);
					
				}
				


}
