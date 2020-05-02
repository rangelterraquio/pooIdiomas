package pooIdiomas.Entites;

import exceptions.EmptyArgumentException;

public class Word {

	private String content; // the word
	private String translation; 
	private String exampleUse;
	
	
	
	
	public Word(String content, String translation, String exampleUse) {
		super();
		setContent(content);
		setTranslation(translation);
		setExampleUse(exampleUse);
	}
	
	//Getters and Setters
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		if (content.isBlank()) {
			throw new EmptyArgumentException("Word can not be empty");
		}
		this.content = content;
	}
	public String getTranslation() {
		return translation;
	}
	public void setTranslation(String translation) {
		if (translation.isBlank()) {
			throw new EmptyArgumentException("Translation can not be empty");
		}
		this.translation = translation;
	}
	public String getExampleUse() {
		return exampleUse;
	}
	public void setExampleUse(String exampleUse) {
		if (translation.isBlank()) {
			throw new EmptyArgumentException("Example can not be empty");
		}
		this.exampleUse = exampleUse;
	}
	
	
	@Override
	public String toString() {
		return "Word:  " + this.getContent() + ", Translation: " + this.getTranslation() + ", Exemplo: " + this.exampleUse; 
	}

}
