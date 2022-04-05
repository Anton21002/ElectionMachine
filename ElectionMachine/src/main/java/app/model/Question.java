package app.model;

import java.io.Serializable;

public class Question implements Serializable{
	private int id;
	private String question;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String toString() {
		return id+" "+question+"";
	}
}
