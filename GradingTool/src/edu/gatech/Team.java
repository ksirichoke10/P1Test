package edu.gatech;

import java.util.ArrayList;


public class Team {
	
	//Class variables
	private String teamNumber;
	private int teamGrade;	
	private ArrayList<String> names = null;
	private ArrayList<Double> contributions = null; 
	
	
	//Constructors
	public Team(){
		this.teamNumber = "";
		this.teamGrade = 0;
		this.names = new ArrayList<String>();
		this.contributions = new ArrayList<Double>();
	}
	
	public Team(String teamNumber, int teamGrade, ArrayList<String> names) {
		this.teamNumber = teamNumber;
		this.teamGrade = teamGrade;
		this.names = names;
		this.contributions = new ArrayList<Double>();
	}
	

	//Returns the team number
	public String getTeamNumber(){
		return this.teamNumber;
	}
	
	//Sets the team number
	public void setTeamNumber(String teamNumber) {
		this.teamNumber = teamNumber;
	}
	
	//Returns the team's grade
	public int getTeamGrade() {
		return teamGrade;
	}
	
	//Sets the team's grade
	public void setTeamGrade(int teamGrade) {
		this.teamGrade = teamGrade;
	}
	
	//Returns the list of names of students that belong on the team
	public ArrayList<String> getNames(){
		return this.names;
	}
	
	//Sets the list of student names
	public void setNames(ArrayList<String>names) {
		this.names = names;
	}
	
	//Returns the list of contributions
	public ArrayList<Double> getContributions(){
		return this.contributions;
	}
	
	//Sets the list of contributions
	public void setContributions(ArrayList<Double> contributions) {
		this.contributions = contributions;
	}
	
	//Searches through list of students
	//Returns index of student in the team list (>= 0) if the student is on this team
	//Returns -1 if the student is not on this teams
	public int checkStudent(String name) {
		
		for (int i=0; i<this.names.size();i++){
			if (name.equals(this.names.get(i))){
				return i;
			}
		}	
		
		return -1;
	}
	
	//Given the student name, returns the contribution of that student if he/she exists on this team
	//Returns contribution value as a double if the student exists
	//Returns -1 if the student 
	public double getStudentContribution(String name) {
		
		
		for (int i = 0; i<this.names.size();i++){
			if (name.equals(this.names.get(i))){
				return this.contributions.get(i);
			}
		}	
		
		return -1;
	}
	
	

	
	
	

}
