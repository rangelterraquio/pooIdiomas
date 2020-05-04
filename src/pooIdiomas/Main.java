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

		ArrayList<User> users = new ArrayList<User>();
		
		String mainMenu = "1 - Sign in\n2 - Sign Up\n3 - Quit";
		
		int option = -1;
		
		
		//Essa função serve apenas para pré setar alguns dados para falicitar a testagem do programa
		
		//Email: teste@gmail.com
		//Senha: 123456
		users = addData();
	        
		do {
			
			try {
				option = View.exibirInputNumero("Wellcome", mainMenu);
			}catch(NumberFormatException e) {
				View.showErrorMsg("Main Menu", "Input not valid");
			}
			
			switch (option) {
				case 1: {
					User currentUser = Utils.validateUser(users);
					if(currentUser != null) {
						languagesMenu(currentUser);
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
		
		String msg = "1 - Add new language\n2 - Select a Language\n3 - Language Report\n4 - Quit";  
		
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
				case 3:{
					try {
						Language language = Utils.selectLanguage(currentUser.getLanguages());
						View.exibirMsg("Language", language.toString());
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
			
			
			
			
		}while(option != 4);
		
	}
	
	
	//Menu word groups
		static void wordGroupsMenu(Language language) {
			
			  
			
			int option = -1;
			
			do {
				
				try {
					String msg = language.listWordGroups() + "\n1 - Add new Word Group\n2 - Manage Words\n3 - Pratice\n 4 - Quit";
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
				
				
				
				
			}while(option != 4);
			
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
									Word newWord = Utils.createNewWord();
									group.deleteWord(word);
									group.addNewWord(newWord);
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
				
				
				//add Default datas for testing
				static ArrayList<User> addData(){
					
					
					 ArrayList<User> users = new ArrayList<User>();
					 User user = new User("João Douglasß", "teste@gmail.com", "123456");
					 Language english = new Language("English");
					 WordGroup colors = new WordGroup("Colors", english);
					 english.addNewWordGroup(colors);
					 colors.addNewWord(new Word("azul", "blue", "Sky is blue"));
					 colors.addNewWord(new Word("vermelho", "red", "strawberries are red"));
					 colors.addNewWord(new Word("Amarelo", "yellow", "Sun is yellow"));
					 colors.addNewWord(new Word("Marrom", "brown", "I have a beautiful brown coat."));
					 colors.addNewWord(new Word("Preto", "black", "My favorite color is black."));
					 colors.addNewWord(new Word("Cinza", "Gray", "My macbook is gray."));
					 colors.addNewWord(new Word("Roxo", "Purple", "My favorite color is black"));
					 colors.addNewWord(new Word("Laranja", "Orange", "Grapes ares purple."));
					 
					 WordGroup people = new WordGroup("People", english);
					 english.addNewWordGroup(people);
					 people.addNewWord(new Word("Pai", "Father", "I watch football with my father."));
					 people.addNewWord(new Word("Mãe", "Mother", "My mother cooks very well"));
					 people.addNewWord(new Word("Irmã", "Sister", "My sister is 30 years old"));
					 people.addNewWord(new Word("Irmão", "Brother", "My brother is João."));
					 people.addNewWord(new Word("Marido", "Husband", "My husband is from USA."));
					 people.addNewWord(new Word("Esposa", "Wife", "My wife is russian."));
					 people.addNewWord(new Word("Pessoa", "Person", "I think there is a person out there."));
					 people.addNewWord(new Word("Primo(a)", "Cousin", "I have a lot of cousins."));
					 
					
					 
					 user.addNewLanguage(english);
					 users.add(user);
					 return users;
				}
				
				


}
