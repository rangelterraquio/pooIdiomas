package pooIdiomas;


import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import exceptions.EmptyArgumentException;
import pooIdiomas.Entites.Language;
import pooIdiomas.Entites.User;
import pooIdiomas.Entites.Word;
import pooIdiomas.Entites.WordGroup;

public class Utils{
	
	//Show sign in view
	static User validateUser(ArrayList<User> users) {
		
		String email = View.showInputText("Email", "Type your email");
		String password = View.showInputPassword("Type your Password");
		
		if (users.isEmpty()) {return null;}
		
		for (User user : users) {
			if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
			
				return user;
			}
		}
		
		return null;
		
	}
	
	//Create a new user
	static User createNewUser() {
		
		String name = View.showInputText("Name", "Type your Name");
		String email = View.showInputText("Email", "Type your email");
		String password = View.showInputPassword("Type your Password");
		
		return new User(name,email,password);
		
	}
	
	
	//Create new Language
	static Language createNewLanguge() {
		String name = View.showInputText("Name", "Type the language name");
		return new Language(name);
	}
	
	//Select a language
	static Language selectLanguage(ArrayList<Language> languages) {
		
		if (languages.isEmpty()) {
			throw new EmptyArgumentException("There is not registered language.");
		}
		String msg = "Select one Language: \n";
		
		for (int i =0; i < languages.size(); i++) {
			msg += i+1 + " - " + languages.get(i).getName() + "\n"; 
		}
		Integer input = View.exibirInputNumero("Languages", msg);
		
		return languages.get(input-1);
		
	}
	
	//Select word group
	static WordGroup selectWordGroup(ArrayList<WordGroup> wordGroup) {
		
		if (wordGroup.isEmpty()) {
			throw new EmptyArgumentException("There is not registered word groups.");
		}
		String msg = "Select one Word Group: \n";
		
		for (int i =0; i < wordGroup.size(); i++) {
			msg += i+1 + " - " + wordGroup.get(i).getName() + "\n"; 
		}
		Integer input = View.exibirInputNumero("Languages", msg);
		
		return wordGroup.get(input-1);
		
	}
	
	
	//Create new Word Group
		static WordGroup createNewWordGroup(Language language) {
			String name = View.showInputText("Name", "Type the language name");
			return new WordGroup(name, language);
		}
		
	//Select word 
		static Word selectWord(ArrayList<Word> words) {
			
			if (words.isEmpty()) {
				throw new EmptyArgumentException("There is not registered word.");
			}
			String msg = "Select one Word: \n";
			
			for (int i =0; i < words.size(); i++) {
				msg += i+1 + " - " + words.get(i).getContent() + "\n"; 
			}
			Integer input = View.exibirInputNumero("Languages", msg);
			
			return words.get(input-1);
			
		}
		
	//Add new word
	static Word createNewWord() {
		
		String word = View.showInputText("Word", "Type the word");
		String translation = View.showInputText("Translation", "Type the translation");
		String example = View.showInputText("Exemple", "Type a example use");
		
		return new Word(word, translation, example);
	}
	
	
	static void pratice(ArrayList<Word> words, Difficult difficult) {
		
		if (words.isEmpty()) {
			throw new EmptyArgumentException("There is not words in the system");
		}
	
		PraticeView praticeView = new PraticeView(words, difficult);
		
		JOptionPane.showOptionDialog(praticeView, praticeView.getPanel(), "Pratice Time", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, new JButton[]{praticeView.getOk()}, praticeView.getOk());
	
		View.exibirMsg("Result", "You got " + verifyPeformace(words, praticeView.getAnswers()) + " right words.");
		
	}
	
	//this method verify how many words the user did right
	  private static int verifyPeformace(ArrayList<Word> words, ArrayList<String> awnsers) {
		  int correct = 0;
		 
		  for(int i = 0; i < awnsers.size(); i++) {
			  if(words.get(i).getTranslation().equalsIgnoreCase(awnsers.get(i))) {
				  correct++;
			  }
		  }
		  return correct;
	  }
	  
}
