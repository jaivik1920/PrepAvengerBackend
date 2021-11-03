package com.prepavenger.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Greedy_problems")
public class GreedyClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private String problemDescription;
	@Column(nullable = false)
	private String example;
	@Column(nullable = false)
	private String difficulty;
	private String title;
	
	
	private String input;
	private String output;
	private String inputnote;
	
	public GreedyClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public GreedyClass(int id, String problemDescription, String example, String difficulty, String title, String input,
			String output, String inputnote) {
		super();
		this.id = id;
		this.problemDescription = problemDescription;
		this.example = example;
		this.difficulty = difficulty;
		this.title = title;
		this.input = input;
		this.output = output;
		this.inputnote = inputnote;
	}

	


	public GreedyClass(String problemDescription, String example, String difficulty, String title, String input,
			String output, String inputnote) {
		super();
		this.problemDescription = problemDescription;
		this.example = example;
		this.difficulty = difficulty;
		this.title = title;
		this.input = input;
		this.output = output;
		this.inputnote = inputnote;
	}


	

	public String getInputnote() {
		return inputnote;
	}




	public void setInputnote(String inputnote) {
		this.inputnote = inputnote;
	}




	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProblemDescription() {
		return problemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}




	@Override
	public String toString() {
		return "GreedyClass [id=" + id + ", problemDescription=" + problemDescription + ", example=" + example
				+ ", difficulty=" + difficulty + ", title=" + title + ", input=" + input + ", output=" + output
				+ ", inputnote=" + inputnote + "]";
	}

	
	

}
