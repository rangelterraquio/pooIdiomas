package pooIdiomas.Entites;

import java.util.ArrayList;

import exceptions.EmptyArgumentException;

public class Language {

	private String name;
	private ArrayList<WordGroup> wordGroups;
	
	
	//Init
	public Language(String name) {
		setName(name);
		wordGroups = new ArrayList<WordGroup>();
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
	public ArrayList<WordGroup> getWordGroups() {
		return wordGroups;
	}
	
	public void addNewWordGroup(WordGroup newWordGroup) {
		if(!this.wordGroups.contains(newWordGroup)) {
			this.wordGroups.add(newWordGroup);
		}
	}
	
	public String listWordGroups() {
		String msg = "Word Group: \n";
		
		for (int i =0; i < this.wordGroups.size(); i++) {
			msg += "- " + this.wordGroups.get(i).getName() + "\n"; 
		}
		return msg;
	}
	
	public ArrayList<Word> getAllWords(){
		 ArrayList<Word> words = new ArrayList<Word>();
		 
		for (WordGroup group : wordGroups) {
			words.addAll(group.getWords());
		}
		
		return words;
	}
	
	@Override
	public String toString() {
		
		return "Language: " + this.getName().toUpperCase() + ",\nWord groups: " + this.wordGroups.toString() + ".";
	}

}
