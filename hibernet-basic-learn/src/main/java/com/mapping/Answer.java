package com.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String answer;

	@OneToOne(mappedBy = "answer") // it will not create question_id column in this table it will ignore
	private Question question; // this is the one-to-one mapping if we create in Question.java then no need here or if we write here then no need in Question table

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(int id, String answer, Question question) {
		super();
		this.id = id;
		this.answer = answer;
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + "]";
	}

}
