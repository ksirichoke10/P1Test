package edu.gatech;

import java.util.HashMap;

public class Assignment {
	
	//Class variables
	private String number;
	private String description;
	private double averageGrade;
	private HashMap<String, Integer> grades = null;
	
	//Constructors	
	public Assignment(){
		this.number = null;
		this.description = null;
		this.averageGrade = 0;
		this.grades = new HashMap<String, Integer>();
	}
	
	public Assignment (String number, String description, double avgGrade){
		this.number = number;
		this.description = description;
		this.averageGrade = avgGrade;
		this.grades = new HashMap<String, Integer>();
	}
	
	//Returns assignment number
	public String getNumber(){
		return this.number;
	}
	
	//Sets assignment number
	public void setNumber(String num){
		this.number = num;
	}
	
	//Returns assignment's description
	public String getDescription() {
		return description;
	}
	
	//Sets assignment's description
	public void setDescription(String description){
		this.description = description;
	}
	
	//Returns the assignment's average grade
	public double getAvgGrade() {
		return this.averageGrade;
	}
	
	//Sets the assignment's average grade
	public void setAvgGrade(double grade){
		this.averageGrade = grade;
	}
	
	//Adds the student's grade to the grades HashMap
	public void addStudentGrade(String studentName, int grade) {
		this.grades.put(studentName, new Integer(grade));
	}
	
	//Returns the student's grade
	public Integer getStudentGrade(String studentName) {
		return this.grades.get(studentName);
	}
	
	//Returns a string with the assignment number, student's grade, and average class grade
	public String toString(String studentName) {
		String output = "Assignment Number: " + this.getNumber() + "\n"  + "Student Grade: " + this.getStudentGrade(studentName) + "\n" + "Average Class Grade: " + this.getAvgGrade();
		return output;
	}
	

} // end of Assignment class
