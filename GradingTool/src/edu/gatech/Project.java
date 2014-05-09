package edu.gatech;

import java.util.ArrayList;


public class Project {
	
	//Class variables
	private String number;  // project name
	private String description; // project description
	private double avgGrade; // average project grade
	private ArrayList<Team> teams = null; // list of teams for project
	
	//Constructors
	public Project(){
		this.number = null;
		this.description = null;
		this.avgGrade = 0;
		this.teams = new ArrayList<Team>();
	}
	
	public Project (String number, String description, double avgGrade, ArrayList<Team> teams){
		this.number = number;
		this.description = description;
		this.avgGrade = avgGrade;
		this.teams = teams;
	}
	
	
	//Returns project number
	public String getNumber(){
		return this.number;
	}
	
	//Sets project number
	public void setNumber(String num) {
		this.number = num;
	}
	
	//Returns project's description
	public String getDescription() {
		return this.description;
	}
	
	//Sets project's description
	public void setDescription(String description) {
		this.description = description;
	}
	
	//Returns the project's average grade
	public double getAvgGrade(){
		return this.avgGrade;
	}
	
	//Sets the project's average grade
	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}
	
	//Returns the project team with the given team number
	public Team getTeam(String teamNumber) {
		for (int i = 0;i<this.teams.size();i++) {
			if (this.teams.get(i).getTeamNumber().equals(teamNumber)){
				return this.teams.get(i);
			}
		}
		return null;
	}
	
	//Sets list of teams for the project
	public void setTeam(ArrayList<Team>team){
		this.teams=team;
	}
	
	//Returns the Team of the student if he/she is working on this project
	//If the student is not working on the project this will return null
	public Team getStudentTeam(String name) {
		
		//Go through the list of teams for the project. If the student's name is on the team, return the team
		for (Team t : this.teams){
			if (t.checkStudent(name)>=0){
				return t;
			}
		}	
		
		return null;
	}

	//Returns a string of the project details for the student with the passed in name
	public String toString(String studentName){
		
		//Get the team the student belongs to for the project
		Team t = this.getStudentTeam(studentName);		
		String output = "Project Number: " + this.getNumber()+"\n" + 
						t.getTeamNumber()+" Grade: "+ t.getTeamGrade() + "\n" +
						"Average Grade: " + this.getAvgGrade() + "\n" + 
						"Average Contribution: " + t.getStudentContribution(studentName);
		
		return output;
	}
	
}
