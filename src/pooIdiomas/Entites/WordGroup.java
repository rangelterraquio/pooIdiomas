package pooIdiomas.Entites;

import java.util.ArrayList;

import exceptions.EmptyArgumentException;
import exceptions.InvalidFormatArgumentException;

public class WordGroup {

	private String name;
	private ArrayList<Word> words;
	private Language fromLanguage;
	
	public WordGroup(String name, Language fromLanguage) {
		setName(name);
		setFromLanguage(fromLanguage);
		words = new ArrayList<Word>();
	}

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

	public Language getFromLanguage() {
		return fromLanguage;
	}

	public void setFromLanguage(Language fromLanguage) {
		//validate fromLanguage logic
		if (fromLanguage == null) {
			throw new InvalidFormatArgumentException("Language Invalid");
		}
		this.fromLanguage = fromLanguage;
	}

	
	public void addNewWord(Word newWord) {
		if(!this.words.contains(newWord)) {
			this.words.add(newWord);
		}
	}
	
	public void deleteWord(Word word) {
		this.words.remove(word);
	}
	
	public ArrayList<Word> getWords(){
		return this.words;
	}
	
	@Override
	public String toString() {
		return "Word group: " + this.getName().toUpperCase() + ", Amount of words: " + this.getWords().size();
	}
	
}
