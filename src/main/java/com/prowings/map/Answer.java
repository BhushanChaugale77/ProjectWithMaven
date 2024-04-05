package com.prowings.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
 
@Entity
public class Answer {

	@Id
	@Column(name = "answer_id")
	private int answerId;
	private String answer;
	
	@ManyToOne
	private Question question;
	
	public Answer() {
		super();
	}
	
	public Answer(int answerId, String answer) {
		this.answerId = answerId;
		this.answer = answer;
	//	this.question = question;
	}
	
	public int getAnswerId() {
		return answerId;
	}
	
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void SetAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}
	 
	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
