package com.prepavenger.entities;

public class Output{

	
	String outputString;
	String actualoutputString;
	
	
	
	public Output() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Output(String outputString, String actualoutputString) {
		super();
		this.outputString = outputString;
		this.actualoutputString = actualoutputString;
	}

	
	public String getOutputString() {
		return outputString;
	}


	public void setOutputString(String outputString) {
		this.outputString = outputString;
	}


	public String getActualoutputString() {
		return actualoutputString;
	}


	public void setActualoutputString(String actualoutputString) {
		this.actualoutputString = actualoutputString;
	}
	
	
	public int comapre(Output output) {
		if(output.actualoutputString.equalsIgnoreCase(output.outputString)) {
			return 0;
		}
		else {
			return 1;
		}
	}


	@Override
	public String toString() {
		return "Output [outputString=" + outputString + ", actualoutputString=" + actualoutputString + "]";
	}
	
	
}
