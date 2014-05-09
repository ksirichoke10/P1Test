package edu.gatech;

import java.util.ArrayList;

public class Student {

	//Class variables
	private String name;
	private String id;
	private String email;
	private int attendance;
	
	private ArrayList<Team> teams = null;
	
	//Constructors
	public Student() {
		this.name = null;
		this.id = null;
		this.email = null;
		this.attendance = 0;
		this.teams = new ArrayList<Team>();
	}
	
	public Student(String name, String id, String email, int attendance, ArrayList<Team> teams) {
		this.name = name;
		this.id = id;
		this.email = email;
		this.attendance = attendance;
		this.teams = teams;
	}
	
	//Returns the name of the student
	public String getName(){
		return name;
	}
	
	//Sets the name of the student
	public void setName(String name){
		this.name = name;
	}
	
	//Returns the id of the student
	public String getGtid() {
		return this.id;
	}
	
	//Sets the id of the student
	public void setGtid(String id){
		this.id = id;
	}
	
	//Returns the email of the student
	public String getEmail(){
		return email;
	}
	
	//Sets the email of the student
	public void setEmail(String email){
		this.email=email;
	}
	
	//Returns the attendance of the student
	public int getAttendance(){
		return attendance;
	}
	
	//Sets the attendance of the student
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	
	//Returns list of teams
	public ArrayList<Team> getTeams() {
		return this.teams;
	}
	
	//Sets the list of teams
	public void setTeams(ArrayList<Team> teams){
		this.teams = teams;
	}
	
	//Returns student's toString 
	public String toString(){
		
		String output = this.getName();
		return output;				
	
	}
	
}// end of Student class
